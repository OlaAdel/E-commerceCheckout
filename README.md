# E-commerceCheckout
 

# REST-API that simulates an e-commerce checkout process.

**missing requirements**: -
-	Controller, and Service Layer Unit Testing

on application startup, "import.sql" file will be executed to insert some data for the testing purposes.

to run the unit tests 

>mvn clean
mvn test

to run the application 
>mvn spring-boot:run

you can use curl to interact with the services.

	to get basket details
		curl -X GET -i http://localhost:8080/baskets/{basket_id} 
	to do checkout
		curl -X POST -i http://localhost:8080/baskets/close-basket/{basket_id}
