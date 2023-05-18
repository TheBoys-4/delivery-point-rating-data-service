FROM openjdk:17.0.2-jdk-slim-buster
ADD DeliveryPointRatingDataServiceApplication.java .
RUN javac DeliveryPointRatingDataServiceApplication.java
CMD ["java", "DeliveryPointRatingDataServiceApplication"]


