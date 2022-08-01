## catalog API

onlinebooks.com/api/userId

```json
{
  "id": "userId",
  "name": "Jon Snow",
  "books": [
    {
      "id": 1234,
      "title": "test1",
      "author": "author1",
      "rating": 5
    },
    {
      "id": 1234,
      "title": "test2",
      "author": "author2",
      "rating": 4
    }
  ]
}
```

## microservices

- [catalog](http://localhost:8081/catalog/userId) book-catalog-service
  The catalog relies on the other services to aggregate information for each user about their books and their ratings.

- [books](http://localhost:8082/books/bookId) book-info-service
  The book info service provides book info, and it is the main storage of the application

- [ratings](http://localhost:8083/ratings/users/userId) ratings-data-service
  The ratings data service handles the rating the user provides for books. 
