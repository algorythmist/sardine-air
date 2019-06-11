#Prerequisites
- Install Rabbitmq https://www.rabbitmq.com/

#How to Run
1. Build the project "mvn clean install"
2. Start RabbitMQ server
3. Start the configuration server in sardine-config: java -jar target/sardine-config-1.0.0-SNAPSHOT.jar
4. Start the Eureka server in sardine-eureka: java -jar target/sardine-eureka-1.0.0-SNAPSHOT.jar
5. Start the microservices:
   java -jar target/sardine-fares-1.0.0-SNAPSHOT.jar
   java -jar target/sardine-search-1.0.0-SNAPSHOT.jar
   java -jar target/sardine-checkin-1.0.0-SNAPSHOT.jar
   java -jar target/sardine-booking-1.0.0-SNAPSHOT.jar
6. Test the UI at http://localhost:8001

   
   