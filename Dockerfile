#Define base docker image
FROM openjdk:17
LABEL maintainer="estore.net"
ADD target/e-store-docker.jar e-store-docker.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","e-store-docker.jar"]