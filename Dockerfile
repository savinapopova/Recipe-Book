FROM amazoncorretto:17.0.6
LABEL maintainer="savinabg"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]