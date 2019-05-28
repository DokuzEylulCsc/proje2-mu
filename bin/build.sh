#!/usr/bin/env bash
jarname="project.jar"
dir=$(dirname $0)

echo "*** Compiling source code..."
javac -d $dir -verbose $dir/../src/Project/*.java $dir/../src/Project/*/*.java

echo "*** Creating jarfile..."
jar cfmv $jarname $dir/Manifest.txt $dir/Project $dir/libraries

rm -rf $dir/Project 
echo "*** Success, written jarfile at $dir/$jarname "

