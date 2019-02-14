#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# TODO: add colored output
import os
import re
import sys
from collections import (
    OrderedDict,
)
from datetime import datetime
from datetime import timedelta

import argparse
import requests

SCRIPT_DIR = os.path.dirname(os.path.realpath(__file__))
MISYS_CRT_FILE = os.path.join(SCRIPT_DIR, 'ssl', 'nabla.crt')
WHITELISTED_TAGS = [
    '1721_1'
    '1720_8',
    '1720_11',
]


def is_whitelisted(tag):
    """
    Return true, if tag should never be removed.
    """
    return any([
        tag in whitelisted for whitelisted in WHITELISTED_TAGS
    ])


def is_daily(string):
    """
    Check if tag represents a daily image.
    """
    pattern = '[0-9]{8}-[0-9]+'           # match 8 digit data followed by "-" and build number
    prog = re.compile(pattern)
    if prog.match(string):
        return True


def is_stable(string):
    """
    Check if tag represents a stable image.
    """
    pattern = '[0-9]{4}_[0-9]+'           # match 4 digit data followed by "_" and stable build number number
    prog = re.compile(pattern)
    if prog.match(string):
        return True


def is_latest(string):
    """
    Check if tag represents the latest image.
    """
    pattern = '[0-9]{3}-latest.*'           # match 3 digit data followed by "-" and "latest" indicator
    prog = re.compile(pattern)
    if prog.match(string):
        return True


def is_database(string):
    """
    Check if tag represents a database-driven image.
    """
    pattern = '.*(?:sqlserver|oracle).*'           # match 3 digit data followed by "-" and "latest" indicator
    prog = re.compile(pattern)
    if prog.match(string):
        return True


def is_outdated(
    date,
    reference_date=datetime.now(),
):
    """
    Compare given date with a reference.
    """
    if date >= reference_date:
        return False
    else:
        return True


def list_the_available_tags_for_a_repository(
    url_prefix,
    namespace,
    repository,
    login,
    password,
    token,
):
    """
    (using registry API) list Docker image tags available for a given namespace/repo
    """
    url = url_prefix + 'repositories/' + namespace + \
        '/' + repository + '/tags?pageSize=99999'
    headers = {
        'Accept': 'application/json',
        'X-Csrf-Token': token,
    }
    login = {
        'name': login,
        'password': password,
    }

    response = requests.get(
        url, verify=MISYS_CRT_FILE, headers=headers, auth=(
            login['name'], login['password'],
        ),
    )
    if response.status_code != requests.codes.ok:
        response.raise_for_status()
    return response.json()


def list_the_available_manifests_for_a_repository(
    url_prefix,
    namespace,
    repository,
    login,
    password,
    token,
):
    """
    (using registry API) list Docker image manifests available for a given namespace/repo
    """
    url = url_prefix + 'repositories/' + namespace + \
        '/' + repository + '/manifests?pageSize=99999'
    headers = {
        'Accept': 'application/json',
        'X-Csrf-Token': token,
    }
    login = {
        'name': login,
        'password': password,
    }

    response = requests.get(
        url, verify=MISYS_CRT_FILE, headers=headers, auth=(
            login['name'], login['password'],
        ),
    )
    if response.status_code != requests.codes.ok:
        response.raise_for_status()
    return response.json()


def delete_a_tag_for_a_repository(
    url_prefix,
    namespace,
    repository,
    login,
    password,
    token,
    tag,
):
    """
    (using registry API) delete Docker image tag for a given namespace/repo
    """
    url = url_prefix + 'repositories/' + namespace + '/' + repository + '/tags/' + tag
    headers = {
        'Accept': 'application/json',
        'X-Csrf-Token': token,
    }
    login = {
        'name': login,
        'password': password,
    }

    # delete
    response = requests.delete(
        url, verify=MISYS_CRT_FILE, headers=headers, auth=(
            login['name'], login['password'],
        ),
    )
    if response.status_code != requests.codes.no_content:
        response.raise_for_status()
    # check if item does not exist - confirm deletion
    validate = requests.get(
        url, verify=MISYS_CRT_FILE, headers=headers, auth=(
            login['name'], login['password'],
        ),
    )
    if validate.status_code != 404:
        validate.raise_for_status()


def delete_a_manifest_for_a_repository(
    url_prefix,
    namespace,
    repository,
    login,
    password,
    token,
    digest,
):
    """
    (using registry API) delete Docker image tag for a given namespace/repo
    """
    url = url_prefix + 'repositories/' + namespace + '/' + \
        repository + '/manifests/' + digest.replace(':', '%3A', 1)
    headers = {
        'Accept': 'application/json',
        'X-Csrf-Token': token,
    }
    login = {
        'name': login,
        'password': password,
    }

    # delete
    response = requests.delete(
        url, verify=MISYS_CRT_FILE, headers=headers, auth=(
            login['name'], login['password'],
        ),
    )
    if response.status_code != requests.codes.no_content:
        response.raise_for_status()
    # check if item does not exist - confirm deletion
#    validate = requests.get(url,headers=headers,auth=(login['name'], login['password']))
#    if validate.status_code != 404:
#        validate.raise_for_status()


if __name__ == '__main__':
    # TODO: is this the best way to incorporate argparse??
    parser = argparse.ArgumentParser()
    parser.add_argument(
        '--url-prefix',
        '-u',
        action='store',
        type=str,
        default='https://stash/api/v0/',
        help='specify registry URL',
    )
    parser.add_argument(
        '--namespace',
        '-n',
        action='store',
        type=str,
        required=True,
        help='specify registry namespace',
    )
    parser.add_argument(
        '--repository',
        '-r',
        action='store',
        type=str,
        nargs='+',
        required=True,
        help='specify registry repository',
    )
    parser.add_argument(
        '--login',
        '-l',
        action='store',
        type=str,
        default='nabla',
        help='specify registry user login',
    )
    parser.add_argument(
        '--password',
        '-p',
        action='store',
        type=str,
        required=True,
        help='specify registry user password',
    )
    parser.add_argument(
        '--token',
        '-t',
        action='store',
        type=str,
        default='000',
        help='specify registry user token',
    )
    parser.add_argument(
        '--stable-spare-count',
        action='store',
        type=int,
        default=10,
        help='count of (most recent) stable images to be spared',
    )
    parser.add_argument(
        '--out-of-date',
        action='store',
        type=int,
        default=14,
        help='how old (in days) an image must be to be considered outdated',
    )
    parser.add_argument(
        '--dry-run',
        '-d',
        action='store_true',
        default=False,
        help='"dry run" mode',
    )
    parser.add_argument(
        '--verbose',
        '-v',
        action='store_true',
        default=False,
        help='increase output verbosity',
    )
    args = parser.parse_args()
    if args.verbose:
        print('verbosity is on')
    elif args.dry_run:
        print('"dry run" mode is on (list outdated Docker images instead of removing them)')

    for repository in args.repository:
        print(
            'Requesting data for ' + args.namespace + '/' +
            repository + ' from ' + args.url_prefix + '...',
        )
        tag_data_json = list_the_available_tags_for_a_repository(
            args.url_prefix, args.namespace, repository, args.login, args.password, args.token,
        )
        manifest_data_json = list_the_available_manifests_for_a_repository(
            args.url_prefix, args.namespace, repository, args.login, args.password, args.token,
        )
        assert tag_data_json != None
        assert manifest_data_json != None

        # TODO: tagged_docker_images: dict or list?
        tagged_docker_images = dict()
        for object in tag_data_json:
            if object['digest'] not in tagged_docker_images.keys():
                tagged_docker_images[object['digest']] = dict()
                tagged_docker_images[object['digest']]['tag'] = list()
                # tag
                tagged_docker_images[
                    object['digest']
                ]['tag'].append(object['name'])
                # updated at
                tagged_docker_images[
                    object['digest']
                ]['updated_at'] = object['updatedAt'][:10]
                # is outdated
                if is_outdated(datetime.strptime(tagged_docker_images[object['digest']]['updated_at'], '%Y-%m-%d'), datetime.now() - timedelta(days=args.out_of_date)):
                    tagged_docker_images[
                        object['digest']
                    ]['is_outdated'] = True
                else:
                    tagged_docker_images[
                        object['digest']
                    ]['is_outdated'] = False
            else:
                tagged_docker_images[
                    object['digest']
                ]['tag'].append(object['name'])
            # TODO: refactor
            # is daily
            if is_daily(object['name']):
                tagged_docker_images[object['digest']]['is_daily'] = True
            elif 'is_daily' not in tagged_docker_images[object['digest']]:
                tagged_docker_images[object['digest']]['is_daily'] = False
            # is stable
            if is_stable(object['name']):
                tagged_docker_images[object['digest']]['is_stable'] = True
            elif 'is_stable' not in tagged_docker_images[object['digest']]:
                tagged_docker_images[object['digest']]['is_stable'] = False
            # is latest
            if is_latest(object['name']):
                tagged_docker_images[object['digest']]['is_latest'] = True
            elif 'is_latest' not in tagged_docker_images[object['digest']]:
                tagged_docker_images[object['digest']]['is_latest'] = False
        # untagged Docker images
        untagged_docker_images = list()
        for object in manifest_data_json:
            if object['digest'] not in tagged_docker_images.keys():
                untagged_docker_images.append(object['digest'])

        # sort the dict using 'updated_at' as keys
        tagged_docker_images = OrderedDict(
            sorted(
                tagged_docker_images.items(),
                key=lambda image: image[1]['updated_at'],
                reverse=True,
            ),
        )

        stable_images_in_release = dict()
        images_to_delete = list()
        remaining = list()

        print('\nPreparing list of images to be removed')
        for sha256, image in tagged_docker_images.items():
            release = ''
            whitelisted = False
            if image['is_latest']:
                continue
            if image['is_stable']:
                for tag in image['tag']:
                    if is_stable(tag):
                        release = tag[:4]
                    if is_whitelisted(tag):
                        whitelisted = True
                if whitelisted:
                    remaining.append(image)
                    continue
                stable_images_in_release.setdefault(
                    release, args.stable_spare_count,
                )
                if stable_images_in_release[release] > 0:
                    remaining.append(image)
                    continue
                stable_images_in_release[release] -= 1
                images_to_delete.append(image)
                continue
            elif image['is_outdated']:
                images_to_delete.append(image)

        print('\nRemoving tagged Docker images:')
        for image in images_to_delete:
            if not args.dry_run:
                print('    ' + repository + ':' + str(image) + '...')
                for tag in image['tag']:
                    delete_a_tag_for_a_repository(
                        args.url_prefix, args.namespace, repository, args.login, args.password, args.token, tag,
                    )
                delete_a_manifest_for_a_repository(
                    args.url_prefix, args.namespace, repository, args.login, args.password, args.token, image,
                )
            else:
                print('    ' + repository + ':' + str(image))
                for n, p in tagged_docker_images[image].items():
                    print('        ' + str(n) + ': ' + str(p))

        print('\nRemoving untagged Docker images:')
        for image in untagged_docker_images:
            if not args.dry_run:
                print('    ' + repository + ':' + str(image) + '...')
                delete_a_manifest_for_a_repository(
                    args.url_prefix, args.namespace, repository, args.login, args.password, args.token, image,
                )
            else:
                print('    ' + repository + ':' + str(image))

        print('\nExisting stable images:')
        for r in remaining:
            print('    {}: {}'.format(repository, r['tag']))
