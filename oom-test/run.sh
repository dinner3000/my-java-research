#!/bin/sh

java \
-Xms20m \
-Xmx20m \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=D:/Temp \
-jar ./target/oom-test-1.0-SNAPSHOT.jar

