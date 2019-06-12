# Prerequisites
- Install Rabbitmq https://www.rabbitmq.com/

# How to Run
1. Build the project "mvn clean install" (optionally -DskipTests)
2. Start RabbitMQ server
3. Start the configuration server in sardine-config: java -jar target/sardine-config-1.0.0-SNAPSHOT.jar
4. Start the Eureka server in sardine-eureka: java -jar target/sardine-eureka-1.0.0-SNAPSHOT.jar
5. Start the microservices:
   java -jar target/sardine-fares-1.0.0-SNAPSHOT.jar
   java -jar target/sardine-search-1.0.0-SNAPSHOT.jar
   java -jar target/sardine-checkin-1.0.0-SNAPSHOT.jar
   java -jar target/sardine-booking-1.0.0-SNAPSHOT.jar


# Ports

- Config server: 8888
- Eureka server: 8761
- Fares: 8050
- Booking: 8060
- Checkin: 8070
- Search: 8090
- Website: 8001


# Testing the application

- Access actuator endoints: http://localhost:<port>/actuator/
- To see the the default configuration: http://localhost:8888/application/default/master
- To examine ms specific configurations: http://localhost:8888/booking-service/default/master

   
- Test the UI at http://localhost:8001