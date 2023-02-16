#FROM tomcat:latest
FROM openjdk:11
LABEL maintainer="transaction.com"
EXPOSE 8080
COPY ./target/spring-boot-docker-youbooking.war spring-boot-docker-youbooking.war
ENTRYPOINT ["java","-jar" , "/spring-boot-docker-youbooking.war"]