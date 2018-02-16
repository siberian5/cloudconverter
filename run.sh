#!/bin/bash

#fix this!
infolder=~/tmp/NokiaContacts/Original/

#and this!
outfolder=~/Work/projects/cloudconverter/target/out/
      jar=~/Work/projects/cloudconverter/target/cloudconverter-1.0-SNAPSHOT.jar

mkdir $outfolder
java -jar $jar $infolder $outfolder
