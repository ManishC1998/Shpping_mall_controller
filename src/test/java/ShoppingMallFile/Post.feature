Feature: User is able to post the data in the database
Scenario: User wants to create or post the data

Given user wants to provide the data 
When User post the data by using the api is "http://localhost:8080/mall"
Then User checks the Status code is 200 