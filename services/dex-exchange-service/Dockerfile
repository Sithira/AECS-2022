FROM adoptopenjdk:11-jdk-hotspot

# Refer to Maven build -> finalName
ARG JAR_FILE=target/*.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
#COPY ../../assets/wait-for-it.sh wait-for-it.sh

EXPOSE "8080:8080"

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
