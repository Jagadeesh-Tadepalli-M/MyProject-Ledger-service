# MyProject

Since you want MySQL as a Docker container for your Ledger service, use this exact command.

Create MySQL container
docker run -d \
--name ledger-mysql \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=root123 \
-e MYSQL_DATABASE=ledgerdb \
-e MYSQL_USER=ledgeruser \
-e MYSQL_PASSWORD=ledgerpass \
-v ledger-mysql-data:/var/lib/mysql \
mysql:8.0

Verify container: docker ps

Connect into MySQL container: docker exec -it ledger-mysql mysql -u root -p

Enter: root123

Check database: SHOW DATABASES;


You should see:

ledgerdb
information_schema
mysql
performance_schema
sys

Now update your application.properties:

-------
spring.application.name=ledger-service

server.port=8081

spring.datasource.url=jdbc:mysql://localhost:3306/ledgerdb
spring.datasource.username=ledgeruser
spring.datasource.password=ledgerpass
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

-------

If later your Ledger service also runs inside Docker, localhost will not work. Then change:

-----
spring.datasource.url=jdbc:mysql://ledger-mysql:3306/ledgerdb
------

because containers communicate using the container name.

Then start your application:
----
mvn clean package
java -jar target/ledger-service-1.0.jar
----
