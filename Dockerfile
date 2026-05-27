# Use lightweight Java runtime
FROM eclipse-temurin:21-jre

# Application directory
WORKDIR /app

# Copy generated jar
COPY target/ledger-service-1.0.0.jar app.jar

# Expose application port
EXPOSE 8081

# Run startup script
COPY startup.sh startup.sh

RUN chmod +x startup.sh

ENTRYPOINT ["./startup.sh"]
