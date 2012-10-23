#!/bin/sh -e

find . -regextype posix-extended -iregex '.*[.](h|cpp)' ! -iregex '.*/model/.*' | xargs ./cpplint.py --project=cormo --filter=+legal,+build,+readability,+runtime,+whitespace,-whitespace/blank_line,-runtime/printf
find . -regextype posix-extended -iregex '.*[.](h|cpp)' -iregex '.*/model/.*' ! -iregex '.*/generated/.*' | xargs ./cpplint.py --project=cormo --filter=-legal,+build,+readability,+runtime,+whitespace,-whitespace/blank_line,-runtime/printf
find . -regextype posix-extended -iregex '.*[.](h|cpp)' -iregex '.*/model/.*' -iregex '.*/generated/.*' | xargs ./cpplint.py --project=cormo --filter=-legal,+build,+readability,+runtime,+whitespace,-whitespace/blank_line,-whitespace/line_length,-runtime/printf

