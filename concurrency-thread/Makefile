SHELL=/bin/bash

code:
	git pull

build:
	docker run --rm -it -v $(pwd):/app -v /home/lisong/.m2:/root/.m2 \
	registry.cn-hangzhou.aliyuncs.com/lisong/maven:3.5.3-server-jre-8 \
	mvn clean package -f /app
	
	
test: build
	docker run --rm -it -v $(shell pwd):/app i386/openjdk:8u151-jdk-alpine3.7 \
	java -cp /app/target/java_test-0.0.1-SNAPSHOT-jar-with-dependencies.jar \
	$(demo_name)