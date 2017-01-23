#http://tutoriels.itaapy.com/wiki/tutoriel-git/

sudo apt-get install git-core git-doc git-email gitweb gitk

sudo gem install git-smart
#in order to use git smart-pull

#enhance prompt
curl https://raw.github.com/git/git/master/contrib/completion/git-prompt.sh -o ~/.git-prompt.sh
nano .bashrc
source ~/.git-prompt.sh
PS1='\[\e[1;32m\][\u\[\e[m\]@\[\e[1;33m\]\h\[\e[1;34m\] \w]\[\e[1;36m\] $(__git_ps1 " (%s)") \$\[\e[1;37m\] '

git config --global user.email "alban.andrieu@misys.com"
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
#git config --global merge.tool kdiff3
git config --global merge.tool meld
git config --global push.default simple
git config --globa merge.renamelimit 10000
git config --global --list
#git config --global http.postBuffer 157286400

#for Windows
git config --global http.sslVerify false

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
git tag -d LATEST_SUCCESSFULL
git push --delete origin LATEST_SUCCESSFULL

#See https://git-scm.com/book/en/v2/Git-Tools-Rewriting-History
#https://help.github.com/articles/changing-author-info/
#alban.andrieu@free.fr
#root@localhost
git filter-branch --env-filter '
OLD_EMAIL="root@localhost"
CORRECT_NAME="Andrieu, Alban"
CORRECT_EMAIL="alban.andrieu@free.fr"
if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" ]
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

#git push --force --tags origin 'refs/heads/*'
