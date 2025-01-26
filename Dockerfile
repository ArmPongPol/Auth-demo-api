## stage-1 build artifact
#FROM amazoncorretto:17-alpine as builder
#WORKDIR /app
#ADD . .
#RUN ["./gradlew","bootJar"]
#
## stage-2 running image
#FROM gcr.io/distroless/java21:latest
#WORKDIR /app
#EXPOSE 8080
#COPY --from=builder /app/build/libs/auth-demo-0.0.1-SNAPSHOT.jar auth-demo-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "auth-demo-0.0.1-SNAPSHOT.jar"]

## Use Amazon Corretto 21 as the base image
#FROM amazoncorretto:21
#
## Set working directory inside the container
#WORKDIR /app
#
## Copy the Spring Boot application's JAR file into the container
#COPY build/libs/auth-demo-0.0.1-SNAPSHOT.jar auth-demo-0.0.1-SNAPSHOT.jar
#
## Expose the application port
#EXPOSE 8080
#
## Set the command to run the application
#ENTRYPOINT ["java", "-jar", "auth-demo-0.0.1-SNAPSHOT.jar"]

# Base image
FROM amazoncorretto:21

# Set working directory
WORKDIR /app

# Ensure the JAR file exists
ARG JAR_FILE=auth-demo-0.0.1-SNAPSHOT.jar

COPY build/libs/auth-demo-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]


