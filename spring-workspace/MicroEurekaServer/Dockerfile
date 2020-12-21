FROM openjdk:8

VOLUME /tpm

EXPOSE 8761

ADD ./target/MicroEurekaServer-0.0.1-SNAPSHOT.jar eureka-server.jar

ENTRYPOINT ["java", "-jar", "eureka-server.jar"]