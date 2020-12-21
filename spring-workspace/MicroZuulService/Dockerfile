FROM openjdk:8

VOLUME /tmp

EXPOSE 8765

ADD ./target/ZuulService-0.0.1-SNAPSHOT.jar zuul-server.jar

ENTRYPOINT ["java", "-jar", "zuul-server.jar"]