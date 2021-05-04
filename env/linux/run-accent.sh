#!/bin/sh
echo "keycode 115 = Multi_key" | xmodmap -

# See https://askubuntu.com/questions/358/how-can-i-type-accented-characters-like-%C3%AB

# https://forum.ubuntu-fr.org/viewtopic.php?id=6125
# Pour info, il peut être utile de vérifier si la touche de composition n'est pas désactivée. C'était le cas lors de mon installation d'Ubuntu 16.04.
# Pour cela, aller dans Clavier --> Saisie --> Touche de composition, et changer le Désactivé par autre chose (j'ai choisi Ctrl gauche).
##### Ubuntu 16.04 LTS
# Typing -> Compose Key -> Right Win

echo "Compose e ' = é"
echo "Compose E ' = É"
echo "Compose , c = ç"
echo "Compose ^ e = ê"
echo "..."
echo "echo "Compose o e = œ"
Compose s s  = ß"
echo "Compose ? ? = ¿"
echo "Compose << = «"

#On Ubuntu 18.04
sudo apt install gnome-tweaks

exit 0
