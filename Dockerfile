FROM openjdk:17

WORKDIR /app

COPY target/ProductService-0.0.1-SNAPSHOT.jar ProductService-0.0.1-SNAPSHOT.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "ProductService-0.0.1-SNAPSHOT.jar"]
