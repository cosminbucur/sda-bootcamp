# rest template

TODO create a client to consume a rest API

## config

TODO configure rest template

    RestClientConfig
        RestTemplate

## rest service with rest template

TODO create a service that will use rest template to perform API calls

    PaperRequest
    PaperResponse
    PaperResponseList
    RestTemplateClientService  

## interceptors

TODO create a http interceptor that will add custom headers to all requests

    HeaderModifierInterceptor

## integration test

TODO test the rest template client

    RestTemplateClientServiceTest

## how to run

- start the server (spring-boot-rest/SpringBootRestApplication)
  [paper resource](http://localhost:8081/api/papers)
- run RestTemplateClientServiceTest
