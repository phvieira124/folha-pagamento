FROM maven:3.8.4-openjdk-11-slim AS eureka-build
RUN mkdir /eureka-server-build
WORKDIR /eureka-server-build
COPY . .
RUN mvn clean install

FROM openjdk:11
RUN mkdir /eureka-server
WORKDIR /eureka-server
EXPOSE 8761
COPY --from=eureka-build /eureka-server-build/target/hr-eureka-server-0.0.1.jar .
CMD ["java", "-jar", "hr-eureka-server-0.0.1.jar"]