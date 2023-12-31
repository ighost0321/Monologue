FROM eclipse-temurin:17-jdk-alpine
WORKDIR /usr/app
VOLUME /tmp
EXPOSE 8080
COPY target/*.jar ./app.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=k8s","/usr/app/app.jar"]