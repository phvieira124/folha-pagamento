FROM maven:3.8.4-openjdk-11-slim AS api-gatway-service
RUN mkdir /api-gatway-build
WORKDIR /api-gatway-build
COPY . .
RUN mvn clean install

FROM openjdk:11
RUN mkdir /api-gatway-run
WORKDIR /api-gatway-run
COPY --from=api-gatway-service /api-gatway-build/target/netflix-zuul-api-gateway-server-0.0.1.jar .
CMD ["java", "-jar", "netflix-zuul-api-gateway-server-0.0.1.jar"]