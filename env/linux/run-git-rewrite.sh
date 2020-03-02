#!/bin/bash
#set -xv

#list old branch
git gc
git fetch --tags
git remote prune origin
for branch in `git branch -r --merged | grep -v '\*\|master\|develop\|release'`; do echo -e `git show --format="%ci %cr %an" $branch | head -n 1` \\t$branch; done | sort -r

#git tag -d LATEST_SUCCESSFULL
#git push --delete origin LATEST_SUCCESSFULL

#See https://git-scm.com/book/en/v2/Git-Tools-Rewriting-History
#https://help.github.com/articles/changing-author-info/

git filter-branch -f --env-filter '
OLD_EMAIL="alban.andrieu@nabla.mobi"
#CORRECT_NAME="Andrieu, Alban"
CORRECT_NAME="AlbanAndrieu"
#CORRECT_EMAIL="alban.andrieu@finastra.com"
CORRECT_EMAIL="alban.andrieu@free.fr"
if [ "$GIT_COMMITTER_EMAIL" = "$OLD_EMAIL" -o "$GIT_COMMITTER_EMAIL" = "root@localhost" -o "$GIT_COMMITTER_EMAIL" = "alban.andrieu@free.fr" -o "$GIT_COMMITTER_EMAIL" = "alban.andrieu@misys.com" -o "$GIT_COMMITTER_EMAIL" = "alban.andrieu@mysis.com" -o "$GIT_COMMITTER_EMAIL" = "alban.andrieu@finastra.com" ]
then
    export GIT_COMMITTER_NAME="$CORRECT_NAME"
    export GIT_COMMITTER_EMAIL="$CORRECT_EMAIL"
fi
export GIT_AUTHOR_NAME="$GIT_COMMITTER_NAME"
export GIT_AUTHOR_EMAIL="$GIT_COMMITTER_EMAIL"
' --tag-name-filter cat -- --branches --tags

echo "git log --pretty=format:\"%h - %an, %ae : %s\""

echo "git log --pretty='%h, %ae - %s'  --author='Alban'  --before='2019-01-01' --no-merges --since='2008-01-01'"

#Apply changes
echo "git push --force --tags origin 'refs/heads/*'"

#http://gitready.com/advanced/2009/02/10/squashing-commits-with-rebase.html
#https://github.com/ginatrapani/todo.txt-android/wiki/Squash-All-Commits-Related-to-a-Single-Issue-into-a-Single-Commit
#git rebase -i HEAD~4
#git push origin branch-name --force
#git commit --amend --author="Andrieu, Alban <alban.andrieu@free.fr>"

#git config --global alias.squash '!f(){ git reset --soft HEAD~${1} && git commit --edit -m"$(git log --format=%B --reverse HEAD..HEAD@{1})"; };f'
#git squash 2

#fatal: Not a valid object name HEAD
#git symbolic-ref HEAD
#git symbolic-ref HEAD refs/heads/my-branch

exit 0
