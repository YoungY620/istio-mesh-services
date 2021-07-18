FROM openjdk:8-jdk-alpine
<<<<<<< HEAD
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
=======
# ARG JAR_FILE=target/*.jar
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} /app.war

ENTRYPOINT ["java","-jar","/app.war"]
>>>>>>> 3072bad... adjast config in vm
