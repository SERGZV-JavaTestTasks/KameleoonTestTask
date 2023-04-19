FROM openjdk:11

COPY /target/classes/ /app

WORKDIR /app

EXPOSE 3000

CMD java project.Application
