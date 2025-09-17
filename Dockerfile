FROM openjdk:21
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 80/udp
ENTRYPOINT ["java","-jar","/app.jar"]