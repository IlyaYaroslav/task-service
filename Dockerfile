FROM eclipse-temurin:17-jre-alpine

RUN addgroup -S taskservice && adduser -S taskservice -G taskservice

WORKDIR /app
COPY task-service.jar app.jar

USER taskservice

EXPOSE 8080

ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "/app/app.jar"]
