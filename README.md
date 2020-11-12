# Weather API Rest

This project we are consuming **Open Weather API** for future forecast.
In this app we are using Spring boot, RestTemplate, Junit and Mockito.     

Deployed this application on heroku server, endpoint is available on:
## [https://weather-api-rest.herokuapp.com/](https://weather-api-rest.herokuapp.com/)

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
- Any browser


## API Endpoints

- #### Weather forecast for New York
    > **GET Mapping** http://localhost:8080/10001  - Get weather forecast for 10001 zipcode 
                                       
                                      
    Output:: 
    ```
    {
      "cityName": "New York",
      "country": "US",
      "zipcode": 10001,
      "tomorrowsForecast": {
        "2020-11-13 21:00:00": 286.19,
        "2020-11-13 12:00:00": 284.32,
        "2020-11-13 18:00:00": 285.22,
        "2020-11-13 06:00:00": 284.29,
        "2020-11-13 03:00:00": 284.68,
        "2020-11-13 09:00:00": 284.31,
        "2020-11-13 00:00:00": 284.63,
        "2020-11-13 15:00:00": 285.61
      }
    }
    ```
