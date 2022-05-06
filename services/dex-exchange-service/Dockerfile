FROM --platform=linux/amd64 adoptopenjdk:11-jdk-hotspot

# Refer to Maven build -> finalName
ARG JAR_FILE=target/*.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
#COPY ../../assets/wait-for-it.sh wait-for-it.sh

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080
