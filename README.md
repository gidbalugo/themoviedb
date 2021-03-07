# themoviedb

Spring boot Coding Exercise - themoviedb API

## Make commands for the application
- `make build` to build jar of the application
- `make start` to build **and** run dockerized application
- `make stop` to stop container of the application
- `make logs` to show logs of the application

*Note* Application can still be run normally via IDE.

## Endpoints

`GET` http://localhost:9090/movie/{id}
- Fetching movie by Id
- `id` is type UUID. Refer to `src/main/resources/data.sql` for test data of Ids

Sample Response
```json
{
    "title": "Its okay to be not okay",
    "overview": "Ko Moon Young is heart",
    "poster": "IOTBNO test poster",
    "voteAverage": 95,
    "releaseDate": "2021-03-08T20:19:31.664"
}
```

`GET` http://localhost:9090/movie?sort=voteAverage,asc

Sample Response
```json
{
    "content": [
        {
            "title": "Its okay to be not okay",
            "overview": "Ko Moon Young is heart",
            "poster": "IOTBNO test poster",
            "voteAverage": 95,
            "releaseDate": "2021-03-08T20:19:31.664"
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 1,
        "pageSize": 1,
        "offset": 1,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalPages": 3,
    "totalElements": 3,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "numberOfElements": 1,
    "first": false,
    "size": 1,
    "number": 1,
    "empty": false
}
```

- request param `sort=voteAverage,asc` will fetch movies sorted in **ascending** order based on the record vote average of each movie
- request param `sort=voteAverage,desc` will fetch movies sorted in **descending** order based on the record vote average of each movie
- request param `page={value_here}` part of pagination setup of the fetch movies 
- request param `size={value_here}` part of pagination setup of the fetch movies

