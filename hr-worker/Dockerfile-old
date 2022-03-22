FROM maven:3.8.4-openjdk-11-slim AS hr-worker-service
RUN mkdir /hr-worker-build
WORKDIR /hr-worker-build
COPY . .
RUN mvn clean install

FROM openjdk:11
RUN mkdir /hr-worker-run
WORKDIR /hr-worker-run
COPY --from=hr-worker-service /hr-worker-build/target/hr-worker-0.0.1.jar .
CMD ["java", "-jar", "hr-worker-0.0.1.jar"]