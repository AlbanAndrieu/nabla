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
git config --global user.name "Alban Andrieu"
git config --global core.autocrlf input
git config --global credential.helper 'cache --timeout=86400' # 86400 seconds is 24 hours
#git config --global credential.helper 'cache --timeout=3600' # 1 hour
git config --global help.autocorrect 1
git config --global color.ui auto
git config --global branch.master.rebase true
git config --global branch.autosetuprebase always
#git config --global merge.tool kdiff3
git config --global merge.tool meld
git config --list

git config --local user.email "alban.andrieu@free.fr"
git config --local user.name "Alban Andrieu"
git config --local -l

git remote --verbose


