FROM openjdk:8

VOLUME /tmp

EXPOSE 9411

ADD zipkin-server.jar zipkin-server.jar

ENTRYPOINT ["java", "-jar", "zipkin-server.jar"]