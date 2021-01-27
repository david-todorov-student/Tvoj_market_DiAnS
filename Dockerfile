FROM openjdk:8
ADD target/tvoj-market.jar tvoj-market.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tvoj-market.jar"]