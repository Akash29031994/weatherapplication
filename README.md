# weatherapplication
Weather Application API

This project was generated as maven spring boot application using JDK version 1.8, Hibernate, JPA, AOP(for logging), Swagger(for API documentation) and JWT(for authentication). 

## Install Dependencies

To install the maven dependencies run `mvn clean install`.

## Development server

To run the API start this project as a spring boot application using `mvn spring-boot:run`.

## Build

Run `mvn package` to build the project. The build artifacts will be stored in the `target` directory.

## Running end to end application

All the application API end points are secured using JWT token user will be able to access the application API only if the request contains a valid JWT Token.
In order to run the end to end application please follow the steps below:

1. Run the Web Application API as a spring boot application using `mvn spring-boot:run`.
2. Provide API host url in `evironment.ts` file.
3. Provide Google map access key in `app.module.ts` file in place of merge field `<APIKEY>`.
3. Run the Angular application using `ng serve`.
4. Navigate to the sign up page using `Sign Up` button.
5. Create a user by filling in the mandatory details including API access key for external weather API (can use `06ed11f3cc0d294f57103663ba82daf0`).
6. Login with the user name and password provided on the sign up page.
7. Fill in the City, Country Code, From and To Date on weather application page and press `Get Weather Details` button.
8. Select an option to save the data in the database or download the information as PDF or plot the current weather information on Map.