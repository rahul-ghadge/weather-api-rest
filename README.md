# Weather API Rest

This project we are consuming **Open Weather API** for future forecast.
In this app we are using Spring, RestTemplate, .     

Deployed this application on heroku server, endpoint is available on:
## [https://https://weather-api-rest.herokuapp.com/](https://https://weather-api-rest.herokuapp.com/)

If running on local machine then endpoint is available on:
## [http://localhost:8080](http://localhost:8080)



## Prerequisites 
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)
- [Open Weather API](https://openweathermap.org/api)
- [Open API Swagger Documentation]


## Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)


## API Endpoints

- #### Weather forecast for New York
    > **GET Mapping** http://localhost:8080/10001  - Get weather forecast for 10001 zipcode 
                                       
                                      
    Output:: 
    ```
    {
      "2020-11-12 03:00:00": 291.7,
      "2020-11-12 09:00:00": 291.57,
      "2020-11-12 15:00:00": 286.94,
      "2020-11-12 18:00:00": 285.99,
      "2020-11-12 12:00:00": 289.25,
      "2020-11-11 21:00:00": 294.28,
      "2020-11-12 00:00:00": 293.01,
      "2020-11-12 06:00:00": 291.99
    }
    ```