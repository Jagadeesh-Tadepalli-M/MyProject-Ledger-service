#!/bin/sh

echo "Starting Ledger Service..."
echo "Java Version:"
java -version

echo "Launching application..."

java \
-Xms512m \
-Xmx1024m \
-Dspring.profiles.active=dev \
-jar app.jar
