## stage-1 build artifact
#FROM amazoncorretto:21.0.5-alpine3.19 AS builder
#WORKDIR /app
#ADD . .
#RUN ["./gradlew","build"]
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

# Use Amazon Corretto 21 as the base image
FROM amazoncorretto:21 AS builder

# Set working directory
WORKDIR /app

# Copy Gradle wrapper and source code
COPY . .

# Ensure Gradle wrapper has execute permissions
RUN chmod +x gradlew

# Build the JAR file
RUN ./gradlew clean build -x test

# Second stage: use a minimal image to run the app
FROM amazoncorretto:21
WORKDIR /app

# Copy only the built JAR file from the builder stage
COPY --from=builder /app/build/libs/auth-demo-0.0.1-SNAPSHOT.jar auth-demo.jar

# Expose the application port
EXPOSE 10000

# Run the application
ENTRYPOINT ["java", "-jar", "auth-demo.jar"]
