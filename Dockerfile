FROM eclipse-temurin:21-jdk-jammy

ARG JAR_FILE=build/libs/*.jar

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]