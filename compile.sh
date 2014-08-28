#!/bin/sh
set -e

echo "Compile"

mkdir -p target/classes target/test-classes

CLASSPATH="target/classes;target/test-classes"

for JARFILE in lib/*.jar; do
    CLASSPATH="$CLASSPATH;$JARFILE"
done

CLASSPATH_RUNTIME="$CLASSPATH"
[[ -d lib-runtime ]] && for JARFILE in lib-runtime/*.jar; do
    CLASSPATH_RUNTIME="$CLASSPATH_RUNTIME;$JARFILE"
done

CLASSPATH_TEST="$CLASSPATH_RUNTIME"
[[ -d lib-test ]] && for JARFILE in lib-test/*.jar; do
    CLASSPATH_TEST="$CLASSPATH_TEST;$JARFILE"
done

find src/main/java -type f -name \*.java | xargs javac -encoding "UTF-8" -d target/classes -classpath $CLASSPATH

find src/test/java -type f -name \*.java | xargs javac -encoding "UTF-8" -d target/test-classes -classpath $CLASSPATH_TEST

echo "Compile done"
