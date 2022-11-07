#
# Build stage
#
FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

FROM azul/zulu-openjdk:17-latest
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]