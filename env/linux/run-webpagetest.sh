#https://developers.google.com/speed/pagespeed/?hl=fr

#Apache
wget https://dl-ssl.google.com/dl/linux/direct/mod-pagespeed-beta_current_amd64.deb
sudo dpkg -i mod-pagespeed-*.deb
sudo apt-get -f install

https://developers.google.com/speed/pagespeed/insights/
http://www.webpagetest.org/compare
http://www.webpagetest.org/result/141022_4D_c0bbc649aadc31c19ade19cc9e4940bc/

#http://www.cyberciti.biz/faq/linux-unix-optimize-lossless-png-images-with-optipng-command/
sudo apt-get install optipng
sudo apt-get install pngtools
sudo apt-get install imagemagick

cd /jenkins/userContent
pnginfo -t chronon-icon.png

ls -lh chronon-icon.png

#How do I optimize files in bulk?
#As jenkins user
mkdir optimized
## store optimized images in optimized directory ##
## Keep file system permission and make a backup of original PNG (see options below)  ##
for i in *.png; do optipng -o5 -quiet -keep -preserve -dir optimized -log optipng.log "$i"; done

#convert jpg to png
find . -name "*.jpg" -exec mogrify -format png {} \;

#convert png to jpg
convert image.png image.jpg
# compression
convert image.png -quality 95 image.jpg
#mogrify -format jpg *.png  

#http://www.howtogeek.com/109369/how-to-quickly-resize-convert-modify-images-from-the-linux-terminal/
convert image.png -resize 200x200 image.png
convert chronon-icon.png -resize 200x200 chronon-icon-200-200.png
