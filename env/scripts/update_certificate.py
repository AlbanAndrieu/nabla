# -*- coding: utf-8 -*-
<<<<<<< HEAD
import argparse
=======
>>>>>>> 9053cf3bd92d78dfb9f33cf5b39354fcbe34c705
import os
import subprocess
from time import sleep

<<<<<<< HEAD
=======
import argparse
>>>>>>> 9053cf3bd92d78dfb9f33cf5b39354fcbe34c705
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select

WORKING_DIRECTORY = os.path.dirname(os.path.realpath(__file__))


def submit(key_name, username=None, password=None):
    """
    Submits the certificate request (in csr format)  specified by key_name
    to Microsoft Active Directory Certificate Services  --  NABLA-CA
    Downloads generated key to cernew directory in current working directory
    """
    csr_request_file = f'{key_name}.csr'
    csr_request_content = read_content(csr_request_file)
    cer_output_name = f'{key_name}.cer'
    chain_output_name = f'{key_name}.p7b'
    browser_download_dir = f'{WORKING_DIRECTORY}/certnew'

    if not os.path.exists(browser_download_dir):
        os.mkdir(browser_download_dir)

    active_directory_certificate_services_url = f'http://albandri/certsrv/certrqxt.asp'

    # To prevent download dialog
    profile = webdriver.FirefoxProfile()
    profile.set_preference('browser.download.folderList', 2)  # custom location
    profile.set_preference('browser.download.manager.showWhenStarting', False)
    profile.set_preference('browser.download.dir', browser_download_dir)
    profile.set_preference(
        'browser.helperApps.neverAsk.saveToDisk',
        'application/x-pkcs7-certificates, application/pkix-cert, text/html',
    )

    browser = webdriver.Firefox(firefox_profile=profile)
    browser.get(active_directory_certificate_services_url)
    # may need to sleep before sending keys
    browser.switch_to.alert.send_keys(username + Keys.TAB + password)
    browser.switch_to.alert.accept()
    sleep(1)

    certificate_input_element = browser.find_element_by_id('locTaRequest')
    certificate_input_element.send_keys(csr_request_content)

    certificate_type_element = browser.find_element_by_id('lbCertTemplateID')
    Select(certificate_type_element).select_by_visible_text('Web Server')

    submit_button = browser.find_element_by_id('locSubmitAlign')
    submit_button.click()

    sleep(1)
    download_cert_button = browser.find_element_by_id('locDownloadCert3')
    download_chain_button = browser.find_element_by_id('locDownloadCertChain3')

    download_cert_button.click()
    download_chain_button.click()

    browser.close()

    os.rename(
        f'{browser_download_dir}/certnew.cer',
        f'{browser_download_dir}/{cer_output_name}',
    )
    os.rename(
        f'{browser_download_dir}/certnew.p7b',
        f'{browser_download_dir}/{chain_output_name}',
    )


def cert(key_name):
    openssl_conf_file = 'openssl.cnf'
    password = 'password'
    key_pem_format = f'{key_name}.pem'
    key_request_csr_format = f'{key_name}.csr'
    subprocess.run([
        'openssl', 'req', '-new',
        '-in', f'{key_pem_format}',
        '-out', f'{key_request_csr_format}',
        '-subj', '/C=FR/ST=IDF/L=Paris/O=Nabla/OU=Test/CN=albandri/emailAddress=alban.andrieu@free.fr/',
        '-config', f'{openssl_conf_file}',
        '-passin', f"pass:'{password}'",
        '-passout', f"pass:'{password}'",
    ])


def read_content(text_file):
    with open(text_file, 'r') as f_in:
        return f_in.read()


if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument(
        'actions',
        type=str,
        nargs='+',
        help='Action to perform [cert|browse] to generate certificate locally on disk or send request to AD CA',
    )
    parser.add_argument(
        '-u', '--username',
        type=str,
        action='store',
        default='test',
        help='Domain account username, which should be your short username (e.g. mamisiak) or generic user (e.g. test)',
    )
    parser.add_argument(
        '-p', '--password',
        type=str,
        action='store',
        required=True,
        help='Password for domain user',
    )
    parser.add_argument(
        '-n', '--name',
        type=str,
        action='store',
        default='albandri',
        help="Certificate name in .pem format. For example name 'albandri' will take 'albandri.pem' key to create and submit certificate request named 'albandri.csr'. \
        Generated certificate will be saved as 'albandri.cer' and chain will be saved as 'albandri.p7b'.",  # noqa: ignore=E501
    )
    args = parser.parse_args()

    for action in args.actions:
        if action == 'cert':
            cert(args.name)
        if action == 'submit':
            submit(args.name, username=args.username, password=args.password)
