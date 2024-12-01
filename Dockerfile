FROM openjdk:17

COPY ./target/user-processor-0.0.1-SNAPSHOT.jar /user-processor-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/user-processor-0.0.1-SNAPSHOT.jar"]