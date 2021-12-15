FROM java:openjdk-8-jdk-alpine

ADD target/*.jar app.jar

#设置alpine系统时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime && echo ${TZ} > /etc/timezone

VOLUME /tmp

EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/app.jar" ]