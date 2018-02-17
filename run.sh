#!/bin/bash

#fix this!
infolder=./testdata/

#and this!
outfolder=./target/out/
      jar=./target/cloudconverter-1.0-SNAPSHOT.jar

mkdir $outfolder
java -jar $jar $infolder $outfolder
