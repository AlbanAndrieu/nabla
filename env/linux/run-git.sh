#http://tutoriels.itaapy.com/wiki/tutoriel-git/

sudo apt-get install git-core git-doc git-email gitweb gitk

sudo gem install git-smart
#in order to use git smart-pull

#enhance prompt
curl https://raw.github.com/git/git/master/contrib/completion/git-prompt.sh -o ~/.git-prompt.sh
nano .bashrc
source ~/.git-prompt.sh
PS1='\[\e[1;32m\][\u\[\e[m\]@\[\e[1;33m\]\h\[\e[1;34m\] \w]\[\e[1;36m\] $(__git_ps1 " (%s)") \$\[\e[1;37m\] '
