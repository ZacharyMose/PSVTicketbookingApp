# --- Build the application: compile and package
FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# --- Run the application
FROM eclipse-temurin:21-jdk
COPY --from=build /target/Ticketbooking-0.0.1-SNAPSHOT.jar Ticketbooking.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "Ticketbooking.jar"]
