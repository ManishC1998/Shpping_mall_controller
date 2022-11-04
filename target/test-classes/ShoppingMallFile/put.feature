Feature: User is able to update the data by Performing put action
Scenario: User wants to update the data
  
Given user wants to update the existing the data
When User put the data using  an api "http://localhost:8080/mall?id=SATYA_SHOPPINGMALL_00059"
Then User Checks the status code is 200 
And User also checks the contentType 
