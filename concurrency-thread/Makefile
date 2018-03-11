

build:
	docker run --rm -it -v $(pwd):/app -v /home/lisong/.m2:/root/.m2 \
	registry.cn-hangzhou.aliyuncs.com/lisong/maven:3.5.3-server-jre-8 \
	mvn clean package -f /app