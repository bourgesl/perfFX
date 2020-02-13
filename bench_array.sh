#!/bin/bash

source env.sh

# build
mvn verify

JAVA_OPTS="-Xms2g -Xmx2g -XX:+AlwaysPreTouch"

echo "JAVA_OPTS: $JAVA_OPTS"

# run Java benchmarks:
$JAVA_HOME/bin/java $JAVA_OPTS -jar target/PerfFX-benchmarks.jar -jvm $JAVA_HOME/bin/java

# run GraalVM benchmarks:
# CE
export GRAALVM_HOME=/home/bourgesl/apps/graalvm-ce-java11-19.3.1/
$GRAALVM_HOME/bin/java $JAVA_OPTS -jar target/PerfFX-benchmarks.jar -jvm $GRAALVM_HOME/bin/java

# EE
export GRAALVM_HOME=/home/bourgesl/apps/graalvm-ee-java11-19.3.1/
$GRAALVM_HOME/bin/java $JAVA_OPTS -jar target/PerfFX-benchmarks.jar -jvm $GRAALVM_HOME/bin/java

echo "done."
