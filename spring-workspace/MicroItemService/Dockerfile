FROM openjdk:8

VOLUME /tmp

EXPOSE 8002 8005 8007

ADD ./target/ItemService-0.0.1-SNAPSHOT.jar item-service.jar

ENTRYPOINT ["java", "-jar", "item-service.jar"]