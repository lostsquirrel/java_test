# java 并发相关测试代码

registry.cn-hangzhou.aliyuncs.com/lisong/java:8_jdk_i586
8_server-jre

docker run --rm -it -v $(pwd):/app -v /home/lisong/.m2:/root/.m2 \
registry.cn-hangzhou.aliyuncs.com/lisong/maven:3.5.3-server-jre-8 \
mvn clean package -f /app

java -cp target/java_test-0.0.1-SNAPSHOT-jar-with-dependencies.jar demo.concurrency.thread03.priority.PriorityDemo

docker run --rm -it -v $(pwd):/app i386/openjdk:8u151-jdk-alpine3.7 \
java -cp /app/target/java_test-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
demo.concurrency.thread05.long32.Long32Demo