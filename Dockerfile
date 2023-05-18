FROM openjdk:17.0.2-jdk-slim-buster
WORKDIR /usr/src/app
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


