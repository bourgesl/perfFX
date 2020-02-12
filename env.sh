#!/bin/bash

export JAVA_HOME=/home/bourgesl/apps/jdk-11.0.6+10/

#export GRAALVM_HOME=/home/bourgesl/apps/graalvm-ce-java11-19.3.1/
export GRAALVM_HOME=/home/bourgesl/apps/graalvm-ee-java11-19.3.1/

echo "JAVA_HOME: $JAVA_HOME"
echo "GRAALVM_HOME: $GRAALVM_HOME"

$JAVA_HOME/bin/java -version

$GRAALVM_HOME/bin/java -version

