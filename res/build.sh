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

echo "*** Compiling source code..."
javac -d $dir/../bin -verbose $dir/../src/*/*.java $dir/../src/*/*/*.java

echo "*** Creating jarfile..."
jar cfmv $dir/../bin/$jarname $dir/../Manifest.txt $dir/../bin/*

echo "*** Success, written jarfile at bin/$jarname "

