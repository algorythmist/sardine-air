#!/bin/bash

nohup java -jar sardine-config/target/sardine-config-1.0.0-SNAPSHOT.jar &

nohup java -jar sardine-eureka/target/sardine-eureka-1.0.0-SNAPSHOT.jar &

nohup java -jar sardine-fares/target/sardine-fares-1.0.0-SNAPSHOT.jar &

nohup java -jar sardine-search/target/sardine-search-1.0.0-SNAPSHOT.jar &

nohup java -jar sardine-booking/target/sardine-booking-1.0.0-SNAPSHOT.jar &

nohup java -jar sardine-checkin/target/sardine-checkin-1.0.0-SNAPSHOT.jar &

nohup java -jar sardine-website/target/sardine-website-1.0.0-SNAPSHOT.jar &
