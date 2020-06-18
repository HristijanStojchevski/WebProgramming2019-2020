FROM openjdk:14.0.1-jdk-oracle
VOLUME /tmp
#EXPOSE 8081
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/rentscoot-0.0.1-SNAPSHOT.jar /app/spring-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "app/spring-app.jar"]