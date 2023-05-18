FROM openjdk:17.0.2-jdk-slim-buster
COPY . /target
WORKDIR /target
COPY /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


