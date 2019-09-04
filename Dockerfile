FROM maven:3.6-jdk-8-alpine AS notification-consumer-builder

COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN cd /usr/src/app && mvn clean install

EXPOSE 8085
ENTRYPOINT ["java","-jar","/usr/src/app/target/notification-consumer-latest.jar"]

