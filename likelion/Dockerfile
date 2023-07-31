FROM openjdk:11-jdk
LABEL maintainer="ahc70032@gmail.com"
ARG JAR_FILE=build/libs/likelion-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} docker-springboot.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/docker-springboot.jar"]