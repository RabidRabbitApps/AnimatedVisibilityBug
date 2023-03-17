#!/bin/sh
source ~/.zshrc
git diff --diff-filter=d --name-only --cached -- '*.kt' '*.kts' | xargs -n1 -I {} sh -c 'ktlint -F {}; git add {}'
if [ $? -ne 0 ]; then exit 1; fi
