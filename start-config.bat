javaw -jar sardine-config/target/sardine-config-1.0.0-SNAPSHOT.jar &

javaw -jar -Dserver.port=8761 sardine-eureka/target/sardine-eureka-1.0.0-SNAPSHOT.jar &
javaw -jar -Dserver.port=8762 sardine-eureka/target/sardine-eureka-1.0.0-SNAPSHOT.jar &

javaw -jar sardine-booking/target/sardine-booking-1.0.0-SNAPSHOT.jar &

javaw -jar sardine-checkin/target/sardine-checkin-1.0.0-SNAPSHOT.jar &

javaw -jar -Dserver.port=8080 sardine-fares/target/sardine-fares-1.0.0-SNAPSHOT.jar &
javaw -jar -Dserver.port=8081 sardine-fares/target/sardine-fares-1.0.0-SNAPSHOT.jar &

javaw -jar sardine-search/target/sardine-search-1.0.0-SNAPSHOT.jar &

javaw -jar sardine-website/target/sardine-website-1.0.0-SNAPSHOT.jar &
