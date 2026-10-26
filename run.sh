#!/bin/sh
# Runs lab2.jar inside a Docker JRE container (no local JVM required).
# Russian locale, like on helios, so battle messages come out in Russian.
cd "$(dirname "$0")"
docker run --rm -v "$PWD":/work -w /work eclipse-temurin:21-jre java -Duser.language=ru -Duser.country=RU -jar lab2.jar
