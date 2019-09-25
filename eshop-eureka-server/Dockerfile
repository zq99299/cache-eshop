# 从这个地址获取一个 doker 镜像
FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
# 使用 gradle build 打包好那个 jar
ADD eshop-eureka-server-1.0.0.jar app.jar
#RUN bash -c 'touch /app.jar'

# 运行这个 jar 包
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

# 暴露端口
EXPOSE 8761