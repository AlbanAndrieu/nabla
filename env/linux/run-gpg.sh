#!/bin/bash
set -xv

gpg2 --gen-key

#Alban Andrieu <alban.andrieu@free.fr>

#/home/albandrieu/.gnupg/openpgp-revocs.d

#pub   rsa3072 2020-04-02 [SC] [expires: 2022-04-02]
#      62DA9DD0B9FBDA514B3E4CFCEA3851498F7EB90D
#uid                      Alban Andrieu <alban.andrieu@free.fr>
#sub   rsa3072 2020-04-02 [E] [expires: 2022-04-02]

sudo apt install pass   # Install Pass

# As jenkins user
# Issue is not ssh  (https://unix.stackexchange.com/questions/477445/www-data-user-cannot-generate-gpg-key)
#ssh -X jenkins@albandrieu
gpg2 --gen-key
# passphase is XenkinX1XX4
#80152EA5516E63F8023D581A27364DBFFDB85EF9

gpg2 --full-generate-key # Create public-private key
# passphase is XablXX23X
#35A6FBF1C59ECF2E3784818D05D23C3B33AC3AAF

# for "albandrieu"
# See https://git.zx2c4.com/password-store/about/#EXTENDED%20GIT%20EXAMPLE
pass git remote add origin git@github.com:AlbanAndrieu/pass-docker-credential-helpers.git
pass git push -u --all

# for "albandrieu"
pass init "35A6FBF1C59ECF2E3784818D05D23C3B33AC3AAF"
# for "jenkins"
pass init "80152EA5516E63F8023D581A27364DBFFDB85EF9"

sudo apt install golang-docker-credential-helpers
#ls -lrta /usr/bin/docker-credential-pass
#ls -lrta /usr/bin/docker-credential-secretservice

pass insert docker-credential-helpers/docker-pass-initialized-check
pass git push -u --all

gpg2 --list-keys
# for "albandrieu"
gpg2 --list-secret-keys
pass git init 35A6FBF1C59ECF2E3784818D05D23C3B33AC3AAF
gpg2 --edit-key 35A6FBF1C59ECF2E3784818D05D23C3B33AC3AAF
#then you have to trust your own key first (gpg --edit-key 64290B2D, trust, 5, save).

#nano ~/.docker/config.json
echo '{ "credsStore": "pass" }' > ~/.docker/config.json

docker logout
docker login
#...

pass

exit 0
