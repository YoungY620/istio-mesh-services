FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.war
COPY target/*.war app.war
ENTRYPOINT ["java","-jar","/app.war"]
