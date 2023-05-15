FROM openjdk:11

MAINTAINER Sergey Zavyalov

COPY target/KameleoonTestTask.war /app/KameleoonTestTask.war

WORKDIR /app

EXPOSE 3000

ENTRYPOINT ["java", "-jar", "/app/KameleoonTestTask.war"]

