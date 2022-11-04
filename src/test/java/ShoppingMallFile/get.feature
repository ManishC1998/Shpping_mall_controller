Feature: User is able to get the all data by using getall mall details
Scenario: User wants to get the all data by using mallid

When  User is able to get all data by using api is "http://localhost:8080/allmall" 
Then User is checks whether the status code is 200
 