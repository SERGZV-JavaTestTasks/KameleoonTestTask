# KameleoonTestTask
Java backend test assignment for Kameleoon company

Project requirements:
  1) source code should be published on https://github.com/
  2) Docker image should be published on https://hub.docker.com/
  3) project should have docker-compose.yaml for local deploy, OR you can deploy it on a public hosting provider (Heroku, etc)
  4) use any in-memory database (Derby, H2, SQLite)
  5) use Java and Spring Boot

The API should allow:
  1) creation of a user account
  2) addition, view, modification, and deletion of quotes.
  3) voting on quotes (either upvote or downvote).
  4) view of the top 10 quotes, the details of each quote, and ideally a graph of the evolution of the votes over time.
  
  Not requested: frontend part, authentication mechanism, and account rights management

The full exercise can take about 6-8 hours (for a middle-level developer; longer for a junior) but the goal is not necessarily to do everything.
More to show your development skills, respect of best practices, understanding of the web development model (client, server),
ability to deliver your work to a production-like environment, and to evaluate your productivity.

-------------------------------------------------------------------------- Result --------------------------------------------------------------------------

I've done the assignment. However, a lot of time was spent on learning Linux, Docker, and deploying the application on a remote hosting. 
Therefore, I certainly did not finish the task on time, but I leave it as a project demonstrating my skills.
As a result, the project meets all the requirements.

Satisfied project requirements:
  1) The project is published here on GitHub 
  2) The project Image was packaged in a Docker container and uploaded to DockerHub https://hub.docker.com/repository/docker/sergzv/kameleoon/general
  3) 
    3.1 I created docker-compose.yaml for local work with a project using docker-compose
    3.2 I decided to do both options and deploy docker image on the server https://vds.selectel.ru at the address 45.8.249.143:7777
    3.3 I also decided to try to deploy the server on another hosting and without a Docker container to assess the difference in the complexity of deployment using docker and without.
        I have placed my war artifact on the hosting https://cp.jino.ru this time using the domain http://kameleon-test-task.ru:49329
        Work on both hosting servers was tested using Postman and everything worked fine. However, the hosting was paid for a month for training purposes. And after a month, the server will no longer
        work.
  4) In my project I used in-memory database H2
  5) Java and Spring Boot were used for the project

The project API allows you to:
  1) creation of a user account /user/createUser
  2) addition /user/createQuote, view /user/getQuote /user/getRandomQuote, modification /user/editQuote, deletion /user/deleteQuote of qotes.
  3) voting on quotes (either upvote or downvote) /voteForAQuote
  4) Review of any number of the top citations specified in the request /showSetOfQuotes (The model contains information on all quotes put into the model. Its display depends on the implementation of          frontend, which was not included in the task.)

