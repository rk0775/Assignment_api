# installation and setup
* Get the code and once you update maven all the dependencies are added automatically.
* Once the project is setup, run the Java application.
* Open the postman appliation for testing the api.
* Then test the following apis to sign up and login with web token security.
  # Sign-up
  * Url : POST -> localhost:8080/signUp <br/>
  * And provide the user registration data in JSON formate like<br/>
  {<br/>
    "name" : "rohit",<br/>
    "email" : "rohit@gmail.com",<br/>
    "password" : "rohit"<br/>
  }<br/>
   
![Screenshot (17)](https://github.com/rk0775/Assignment_api/assets/118426413/445bb4a5-3f04-40f1-9a87-23f351ff1f19)
<hr/>

# Login
Url : POST -> localhost:8080/login <br/>
* If registration succefful then login with credentials.
* Provide JSON data<br/>
{<br/>
  "email" : "rohit@gmail.com",<br/>
  "password" : "rohit"<br/>
}<br/>

* If login with wrong credential then server give the invalid credential message.
![Screenshot (18)](https://github.com/rk0775/Assignment_api/assets/118426413/c4130e09-7ed1-4f3a-96f4-e1aa03ac6034)

* If login with correct credetial then server give one jwt token for security.
![Screenshot (19)](https://github.com/rk0775/Assignment_api/assets/118426413/16ac1c53-9ba0-4036-be00-63c2c15db2dc)

* Using this token we can access the protected urls.

# Security (demo)
Url : GET -> localhost:8080/securePage

* If you not add authorization header TOKEN then can access this page or url
<img width="960" alt="Screenshot (21)" src="https://github.com/rk0775/Assignment_api/assets/118426413/e23d19e7-2fa5-4398-a801-bc4888b7036b">

* set the login jwt token in to header section and access the page or url
![Screenshot (22)](https://github.com/rk0775/Assignment_api/assets/118426413/bf836a82-1509-4842-a227-5c42b376a314)



