
# mvn install:install-file -Dfile=<chemin-du-fichier> -DgroupId=<group-id> \
#    -DartifactId=<artifact-id> -Dversion=<version>  -Dpackaging=<packaging> -DgeneratePom=true

mvn install:install-file -Dfile=./andromda-profile-seam-1.1-SNAPSHOT.xml.zip -DgroupId=org.andromda.profiles.emf.uml22 -DartifactId=andromda-seam -Dversion=1.1-SNAPSHOT -Dpackaging=profile.uml -DgeneratePom=true
