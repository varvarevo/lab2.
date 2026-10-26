#!/bin/sh
# Builds lab2.jar inside a Docker JDK container (no local JVM required).
# Pokemon.jar is not unpacked: lab2.jar finds it through Class-Path in MANIFEST.MF.
set -e
cd "$(dirname "$0")"
docker run --rm -v "$PWD":/work -w /work eclipse-temurin:21-jdk sh -c '
  rm -rf out lab2.jar &&
  mkdir -p out &&
  javac --release 8 -Xlint:-options -encoding UTF-8 -cp lib/Pokemon.jar -d out $(find src -name "*.java") &&
  jar cfm lab2.jar MANIFEST.MF -C out . &&
  rm -rf out
'
echo "Built lab2.jar"
