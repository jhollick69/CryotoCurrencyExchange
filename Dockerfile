FROM openjdk:8
EXPOSE 8080
ADD target/exchangecopperservice.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
