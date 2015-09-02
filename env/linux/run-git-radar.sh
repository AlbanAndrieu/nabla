#https://github.com/michaeldfallen/git-radar

#http://brew.sh/linuxbrew/

sudo apt-get install build-essential curl git m4 ruby texinfo libbz2-dev libcurl4-openssl-dev libexpat-dev libncurses-dev zlib1g-dev
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/linuxbrew/go/install)"

/workspace/users/albandri10/.linuxbrew/bin/brew doctor

echo 'export PATH="/workspace/users/albandri10/.linuxbrew/bin:$PATH"' >> ~/.bash_profile

/workspace/users/albandri10/.linuxbrew/bin/brew install michaeldfallen/formula/git-radar

export PS1="$PS1\$(git-radar --bash --fetch)"
