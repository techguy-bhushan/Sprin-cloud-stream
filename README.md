# Sprin-cloud-stream
Spring Cloud Stream is a framework for building message-driven microservices.


# Required setup:
* Java 8
* Maven 3 +
* RabbitMq

This Sample requires RabbitMq to be running on localhost.

DOCKER CONTAINER For RabbitMq :
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management

Here 2 Spring Boot microservices application first one name with producer and another one is a consumer, both use are using Spring Cloud Stream, 
producer microservice will generate the payload and consumer microservice will receive this payload and print on console.





