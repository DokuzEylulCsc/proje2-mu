#!/usr/bin/env bash

# Create executable jar including libraries:
#   Compiles all packages in src
#   Uses manifest file at Manifest.txt
#   Uses libraries at lib
#   Writes jar file to bin
#
# Note: This script meant to be in $project_dir/res, invoke from anywhere.
jarname="Project.jar"

dir=$(dirname $0)
cd $dir # $project_dir/res

echo "*** Compiling source code..."
javac -d ../bin -verbose  ../src/*/*.java ../src/*/*/*.java

echo "*** Creating jarfile..."
cd ../bin
jar cfmv $jarname ../Manifest.txt ./*
cd ../lib
jar ufv ../bin/$jarname *

echo "*** Success, written jarfile at bin/$jarname "
