FROM openjdk:8

VOLUME /tmp

ADD ./target/SecurityUserService-0.0.1-SNAPSHOT.jar user-service.jar

ENTRYPOINT ["java", "-jar", "user-service.jar"]