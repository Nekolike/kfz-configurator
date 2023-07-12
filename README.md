# KFZ Configurator

This is a demo project which acts as the backend for a web application where users can create configurations for a car they would like
to purchase and also get a cost estimate for the given configuration.

This backend provides several endpoints to work with users and their configurations. You can check out all available endpoints via:
http://localhost:8080/swagger-ui/index.html#/ while running the application

## How to run the app 

1. Checkout the repository
2. run `./gradlew composeUp` inside the repository to boot up a postgres container if you don't want to set up the database locally
   1. you can manually connect to the db with -h localhost -p 5432 -U nekolike -d kfzconfigurator and pw=mercedes
3. Running the application will create the tables and test data to the db via flyway
4. The app is now ready and you can access the different endpoints with any tool which provides services to interact with REST endpoints (Postman)
