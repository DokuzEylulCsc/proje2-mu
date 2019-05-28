#!/usr/bin/env bash

# Create executable jar including libraries:
#   Compiles all packages in src
#   Uses manifest file at bin/Manifest.txt
#   Uses libraries at bin/libraries
#
# Note: This script meant to be in $project_dir/bin, invoke from anywhere.

jarname="project.jar"
dir=$(dirname $0)

echo "*** Compiling source code..."
javac -d $dir -verbose $dir/../src/*/*.java $dir/../src/*/*/*.java

echo "*** Creating jarfile..."
jar cfmv $jarname $dir/Manifest.txt $dir/*/

rm -rf $dir/Project 
echo "*** Success, written jarfile at $dir/$jarname "

