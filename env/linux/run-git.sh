#!/bin/bash
set -xv

#http://tutoriels.itaapy.com/wiki/tutoriel-git/

sudo apt-get install git-core git-doc git-email gitweb gitk

sudo gem install git-smart
#in order to use git smart-pull

#enhance prompt
curl https://raw.github.com/git/git/master/contrib/completion/git-prompt.sh -o ~/.git-prompt.sh
nano .bashrc
source ~/.git-prompt.sh
PS1='\[\e[1;32m\][\u\[\e[m\]@\[\e[1;33m\]\h\[\e[1;34m\] \w]\[\e[1;36m\] $(__git_ps1 " (%s)") \$\[\e[1;37m\] '

git config --global user.email "alban.andrieu@free.fr"
git config --global user.name "Andrieu, Alban"
git config --global core.autocrlf input
#git config --global credential.helper 'cache --timeout=86400' # 86400 seconds is 24 hours
#git config --global credential.helper 'cache --timeout=3600' # 1 hour
git config --unset credential.helper
git config --global credential.helper store

git config --global help.autocorrect 1
git config --global color.ui auto
git config --global branch.master.rebase true
git config --global branch.autosetuprebase always
#git mergetool --tool-help
#git config --global merge.tool kdiff3
git config --global merge.tool meld
#git config --global difftool.prompt false
git config --global push.default simple
git config --globa merge.renamelimit 10000
git config --global --list
#git config --global http.postBuffer 157286400
#See https://git-scm.com/book/en/v2/Customizing-Git-Git-Configuration#Formatting-and-Whitespace
#git config --global core.whitespace trailing-space,-space-before-tab,indent-with-non-tab,tab-in-indent,cr-at-eol
git config --global core.whitespace trailing-space,-space-before-tab,indent-with-non-tab,cr-at-eol

#for Windows
git config --global http.sslVerify false
git config --system core.longpaths true
git config --global pack.packsizelimit 2g
git config --system core.autocrlf false
#git config core.ignoreStat true
#git config core.fscache true

git config --local user.email "alban.andrieu@free.fr"
git config --local user.name "Andrieu, Alban"
git config --local -l

#for maven
git config --global maven-scm.maildomain nabla.mobi
git config --global maven-scm.forceUsername true

git remote --verbose

#list old branch
git gc
git fetch --tags
git remote prune origin
for branch in `git branch -r --merged | grep -v '\*\|master\|develop\|release'`; do echo -e `git show --format="%ci %cr %an" $branch | head -n 1` \\t$branch; done | sort -r
#Massive change in config.xml
#find /jenkins/jobs -type f -name "config.xml" -exec sed -i 's/<name>nabla.jenkins<\/name>/<name>nabla jenkins<\/name>/g' {} +
git tag -d LATEST_SUCCESSFULL
git push --delete origin LATEST_SUCCESSFULL

#See https://git-scm.com/book/en/v2/Git-Tools-Rewriting-History
#https://help.github.com/articles/changing-author-info/
#alban.andrieu@nabla.mobi
#root@localhost
git filter-branch -f --env-filter '
OLD_EMAIL="alban.andrieu@nabla.mobi"
CORRECT_NAME="Andrieu, Alban"
CORRECT_EMAIL="alban.andrieu@free.fr"
if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" -o "$GIT_COMMITTER_EMAIL" = "alban.andrieu@free.fr" -o "$GIT_COMMITTER_EMAIL" = "alban.andrieu@misys.com" -o "$GIT_COMMITTER_EMAIL" = "alban.andrieu@mysis.com" ]
then
    export GIT_COMMITTER_NAME="$CORRECT_NAME"
    export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
if [ "$GIT_AUTHOR_EMAIL" = "$OLD_EMAIL" ]
then
    export GIT_AUTHOR_NAME="$CORRECT_NAME"
    export GIT_AUTHOR_EMAIL="$CORRECT_EMAIL"
fi
' --tag-name-filter cat -- --branches --tags

#Apply changes
#git push --force --tags origin 'refs/heads/*'

#http://gitready.com/advanced/2009/02/10/squashing-commits-with-rebase.html
#https://github.com/ginatrapani/todo.txt-android/wiki/Squash-All-Commits-Related-to-a-Single-Issue-into-a-Single-Commit
git rebase -i HEAD~4
git push origin branch-name --force
git commit --amend --author="Andrieu, Alban <alban.andrieu@free.fr>"

#git config --global alias.squash '!f(){ git reset --soft HEAD~${1} && git commit --edit -m"$(git log --format=%B --reverse HEAD..HEAD@{1})"; };f'
#git squash 2

#fatal: Not a valid object name HEAD
#git symbolic-ref HEAD
#git symbolic-ref HEAD refs/heads/my-branch

#See hook https://dzone.com/articles/an-in-depth-look-at-git-hooks
cp hook/* .git/hooks
#chmod +x prepare-commit-msg

#disable meld
git diff --no-ext-diff

#JIRA
#https://pypi.python.org/pypi/jira/
#https://github.com/pycontribs/jira
#https://jira.readthedocs.io/en/master/examples.html#transitions

#See http://pre-commit.com/#advanced
sudo pip install pre-commit
sudo pip install pre-commit-hooks
#pre-commit install
pre-commit autoupdate

pre-commit run --all-files
#pre-commit run

