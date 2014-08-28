#!/bin/sh

echo "Run test"

CLASSPATH="target/classes;target/test-classes"

for JARFILE in lib/*.jar; do
    CLASSPATH="$CLASSPATH;$JARFILE"
done

CLASSPATH_RUNTIME=$CLASSPATH
[[ -d lib-runtime ]] && for JARFILE in lib-runtime/*.jar; do
    CLASSPATH_RUNTIME="$CLASSPATH_RUNTIME;$JARFILE"
done

CLASSPATH_TEST=$CLASSPATH_RUNTIME
[[ -d lib-test ]] && for JARFILE in lib-test/*.jar; do
    CLASSPATH_TEST="$CLASSPATH_TEST;$JARFILE"
done

java -classpath $CLASSPATH_TEST com.baldurtech.unit.TestCase com.baldurtech
RETVAL=$?

echo "Test done."
exit $RETVAL