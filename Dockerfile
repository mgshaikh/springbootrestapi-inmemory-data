FROM eclipse-temurin:17-jre
WORKDIR /usr/share/app
COPY ./target/basic-rest-api-2.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
