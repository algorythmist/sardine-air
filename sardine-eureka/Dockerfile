FROM openjdk:8
VOLUME /tmp
ADD target/sardine-eureka-1.0.0-SNAPSHOT.jar eureka.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka.jar"]
