#!/bin/sh
set -e
cd "$(dirname "$0")"
JUNIT=junit-platform-console-standalone-1.11.4.jar
docker run --rm -v "$PWD":/work -w /work eclipse-temurin:21-jdk sh -c "
  mkdir -p lib &&
  [ -f lib/$JUNIT ] || curl -sSfL -o lib/$JUNIT https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/$JUNIT &&
  rm -rf test-out && mkdir -p test-out &&
  javac -encoding UTF-8 -cp lib/Pokemon.jar:lib/$JUNIT -d test-out \$(find src test -name '*.java') &&
  java -jar lib/$JUNIT execute -cp test-out:lib/Pokemon.jar --select-package pokemons --select-package moves --details=tree; status=\$?; rm -rf test-out; exit \$status
"
