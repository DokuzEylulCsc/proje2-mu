#!/usr/bin/env bash

# Create executable jar including libraries:
#   Compiles all packages in src
#   Uses manifest file at Manifest.txt
#   Writes jar files to bin
#
# Note: This script meant to be in $project_dir/res, invoke from anywhere.

jarname="Project.jar"
dir=$(dirname $0) # $project_dir/res
cd $dir/..

echo "*** Compiling source code..."
javac -d bin -verbose  src/*/*.java src/*/*/*.java

echo "*** Creating jarfile..."
cd bin
jar cfmv $jarname ../Manifest.txt */
rm -rf */

echo "*** Success, written jarfile at bin/$jarname"

