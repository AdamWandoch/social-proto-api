# Social App Prototype Project.

## Spring Boot server/RESTful API providing data persistence to PostgreSQL database and WebSocket server for Social App Prototype.

Deployed [here](https://social-proto-api.herokuapp.com/), (nothing set up on the main page, check endpoints below)

[Watch me work here](https://www.youtube.com/watch?v=cSd08rtIgss&list=PLDrCZWA1MVi4nDz274lXP5lB-XTC1h0Bk)

[Check ReactJS Client repository](https://github.com/AdamWandoch/social-prototype-client)

## Endpoints:

### User Entity:
GET: [/user/getall](https://social-proto-api.herokuapp.com/user/getall)

GET: [/user/{id}](https://social-proto-api.herokuapp.com/user/{id}) 

POST: [/user/post](https://social-proto-api.herokuapp.com/user/post) 
### Post Entity
GET: [/post/getall](https://social-proto-api.herokuapp.com/post/getall)

GET: [/post/{id}](https://social-proto-api.herokuapp.com/post/{id})

POST: [/post/post](https://social-proto-api.herokuapp.com/post/post)


### Like Entity
GET: [/like/get/{postId}](https://social-proto-api.herokuapp.com/like/get/{postId})

POST: [/like/save](https://social-proto-api.herokuapp.com/like/save)

POST: [/like/user-liked](https://social-proto-api.herokuapp.com/like/user-liked)


### Comment Entity
GET: [/comment/save](https://social-proto-api.herokuapp.com/comment/save)

POST: [/comment/{postId}](https://social-proto-api.herokuapp.com/comment/{postId})


### Clear all records
GET: [/clear](https://social-proto-api.herokuapp.com/clear)
