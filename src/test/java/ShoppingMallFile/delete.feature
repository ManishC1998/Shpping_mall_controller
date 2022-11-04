Feature: I am testing the delete Request for  City Api 
Scenario: Delete Request to delete a user details by using ID in the admin Database
When I hit the api with delete request and end point as "http://localhost:8080/mall?mallid=SATYA_SHOPPINGMALL_00058"
Then To checking  the status code as 200 and status line as  "HTTP/1.1 200 "
And To checks the body message as "Successful " And data is "deleted"