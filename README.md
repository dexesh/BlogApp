BlogApp is a Spring Boot application designed to manage blog posts and users. It provides RESTful APIs for creating, retrieving, updating, and deleting blog entries and user information, and also provide summay of any blog.
I have used Gemini free LLM model to generate summary of blogs,

This is my project structure:
blogApp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/blogApp/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── BlogAppApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/blogApp/
│               └── BlogAppApplicationTests.java
├── pom.xml
└── README.md

I have tested all end points on postman
Here are the demostration of Api Endpoints:

1.To register a user-

Method:Post
http://localhost:8080/api/users
Request Body:
{
  "name": "Devesh Kumar Choubey",
  "email":"deveshchoubey4086@gmail.com",
  "password":"xxxxxxxxxx"
}

2.To add Blog-

Method:Post
http://localhost:8080/api/blogs/{id} // here id is blogid

RequestBody:
{
  "title":"Life is like a weather",
  "content":"Cirrus! That’s what our morning view was yesterday. My second eldest sister told me that’s what it is called when the clouds look like that.As I ponder, nature and people have never had a big difference. Life is like a cloud; it’s always changing its shapes and forms. It’s moving, creating amazing sightings. There’s no permanence.Sometimes, the day is foggy, stormy, and sunny, and it reflects on me, too. The sky is like my mind. Sometimes, it’s foggy when it is intensely used. It’s stormy when emotions do come, and it’s sunny when I walk and breathe with gratitude. That’s how life works.Yesterday, “myself” is like our weather. My day started clear and sound, and then it got stormy in the afternoon. It rained, and the beautiful sunset ended the day, reminding me that, yes, I (we) made it through.Stay hopeful, my amazing readers! Thank you so much for your love and support!Peace and love,"
}

3.To Update blog title and blog content-

Method:Put
http://localhost:8080/api/blogs/{id}

RequestBody:
{
  "title":"Life is wonderful",
  "content":"Cirrus! That’s what our morning view was yesterday. My second eldest sister told me that’s what it is called when the clouds look like that.As I ponder, nature and people have never had a big difference. Life is like a cloud; it’s always changing its shapes and forms. It’s moving, creating amazing sightings. There’s no permanence.Sometimes, the day is foggy, stormy, and sunny, and it reflects on me, too. The sky is like my mind. Sometimes, it’s foggy when it is intensely used. It’s stormy when emotions do come, and it’s sunny when I walk and breathe with gratitude. That’s how life works.Yesterday, “myself” is like our weather. My day started clear and sound, and then it got stormy in the afternoon. It rained, and the beautiful sunset ended the day, reminding me that, yes, I (we) made it through.Stay hopeful, my amazing readers! Thank you so much for your love and support!Peace and love,"
}

4.To delete blog
Method:Delete
http://localhost:8080/api/blogs/{id}

4.To fetch blog by author name with pagination
Method:Get
   http://localhost:8080/api/blogs/search/author?author=John Doe&page=0&size=5)

5.To fetch blog by title with pagination
Method:Get
http://localhost:8080/api/blogs/search/title?title=Enviroment&page=0&size=5

6.To fetch all blog with pagination
Method:Get
http://localhost:8080/api/blogs?page=0&size=5








