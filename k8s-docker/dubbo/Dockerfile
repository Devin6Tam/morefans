# 使用阿里maven镜像内置 maven源，可以加速打包
FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8
RUN mkdir /source
ADD dubbo-admin-0.2.0.tar /source
RUN ls /source/
WORKDIR /source/dubbo-admin-0.2.0
RUN mvn --batch-mode clean package -Dmaven.test.skip=true

FROM openjdk:8-jre
LABEL maintainer="dev@dubbo.apache.org"
COPY --from=0 /source/dubbo-admin-0.2.0/dubbo-admin-distribution/target/dubbo-admin-0.2.0.jar /app.jar
ENTRYPOINT ["java","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 8080