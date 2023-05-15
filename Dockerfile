FROM openjdk:11

MAINTAINER Sergey Zavyalov

COPY target/KameleoonTestTask.war /app/KameleoonTestTask.war

WORKDIR /app

EXPOSE 3000

ENTRYPOINT ["java", "-jar", "/app/KameleoonTestTask.war"]






#FROM openjdk:11
#
#MAINTAINER Sergey Zavyalov
#
#COPY out/artifacts/KameleoonTestTask_jar/KameleoonTestTask.jar /app/KameleoonTestTask.jar
##COPY /target/classes/ /app
#
#WORKDIR /app
#
#EXPOSE 3000
#
#ENTRYPOINT ["java", "-jar", "/app/KameleoonTestTask.jar"]
##CMD java project.Application
