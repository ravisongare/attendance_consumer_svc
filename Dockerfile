FROM openjdk:17-jdk-alpine
MAINTAINER ravi.songare
COPY target/attendance-consumer-svc-1.0.0.jar attendance-consumer-svc-1.0.0.jar
ENTRYPOINT ["java","-jar","/attendance-consumer-svc-1.0.0.jar"]