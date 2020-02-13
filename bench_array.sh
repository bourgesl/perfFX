#!/bin/bash

source env.sh

# build
mvn verify

# run Java benchmarks:
#$JAVA_HOME/bin/java -jar target/PerfFX-benchmarks.jar -jvm $JAVA_HOME/bin/java

# run GraalVM benchmarks:
$GRAALVM_HOME/bin/java -jar target/PerfFX-benchmarks.jar -jvm $GRAALVM_HOME/bin/java

