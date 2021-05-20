FROM openjdk:8-jdk-alpine
ARG WAR_FILE=dummy/target/*.war
COPY ${WAR_FILE} app.war
EXPOSE 8010:8080
ENTRYPOINT ["java","-jar","/app.war"]