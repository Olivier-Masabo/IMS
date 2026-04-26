# Use Java 17 (recommended for Spring Boot)
FROM openjdk:17-jdk-slim

# App name
ARG JAR_FILE=target/*.jar

# Copy jar
COPY ${JAR_FILE} app.jar

# Expose port
EXPOSE 8080

# Run app
ENTRYPOINT ["java","-jar","/app.jar"]
