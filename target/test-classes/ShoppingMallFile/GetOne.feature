
Feature: User is able to get the Singledata by using get mall Details
Scenario: User wants to get the Single Data by using mallid

When  User is able to get single data with the help of  using api is "http://localhost:8080/mall?mallid=SATYA_SHOPPINGMALL_00106" 
Then User should be  checks whether the status code is 200
 