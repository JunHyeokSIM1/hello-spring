FROM openjdk:11-jdk-alpine
ARG JAR_FILE=api_A_gradle-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} myboot.jar
ENTRYPOINT ["java","-jar","/myboot.jar"]