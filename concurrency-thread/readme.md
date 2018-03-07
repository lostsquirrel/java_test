# java 并发相关测试代码

registry.cn-hangzhou.aliyuncs.com/lisong/java:8_jdk_i586
8_server-jre

docker run --rm -it -v $(pwd):/app registry.cn-hangzhou.aliyuncs.com/lisong/java:8_server-jre_builder bash

java -cp target/java_test-0.0.1-SNAPSHOT-jar-with-dependencies.jar PriorityDemo