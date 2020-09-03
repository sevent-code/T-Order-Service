##
## MAVEN JAR BUILD
##
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/loan_submission_service/src
COPY pom.xml /home/app/loan_submission_service
RUN mvn -f /home/app/loan_submission_service/pom.xml clean package

##
## Compile App
##
FROM openjdk:8-jdk-alpine as builder
COPY --from=build /home/app/loan_submission_service/target/*.jar /usr/app/loan_submission_service.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/usr/app/loan_submission_service.jar"]
