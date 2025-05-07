# Use OpenJDK 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy your JAR into the container
COPY target/onlineBankingSystem-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8085

# Start your Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
