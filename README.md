# Spring Boot REST API

Spring Boot REST API use MySQL database, Spring JPA, and Swagger UI for API Documentation

#### :rocket:  Software Requirement
```bash

Maven

```


#### :rocket: URL
```bash
http://localhost:8030/customer/swagger-ui.html/
``` 

#### :rocket:  Add Api Customer

```bash

curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "address": "kaliurang ", \ 
   "birthDate": "2024-05-17T16:10:09.448Z", \ 
   "email": "alz%40gmail.com", \ 
   "fullName": "aloy", \ 
   "id": "1", \ 
   "status": "active" \ 
 }' 'http://localhost:8030/customer/customers'

```
#### :rocket:  Update Api Customer
```bash 
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "address": "jangkang", \ 
   "birthDate": "2024-05-17T16:10:09.449Z", \ 
   "email": "diego%40gmail.com", \ 
   "fullName": "diego", \ 
   "id": "402880eb8f872554018f8725e57a0000g", \ 
   "status": "active" \ 
 }' 'http://localhost:8030/customer/customers'

```
#### :rocket:  get all Api Customer
```bash 
curl -X GET --header 'Accept: application/json' 'http://localhost:8030/customer/customers/getallcust'

```
#### :rocket:  Find By  Api Customer
```bash 
curl -X GET --header 'Accept: application/json' 'http://localhost:8030/customer/customers/pagination?page=0&size=5&sortBy=fullName&direction=ASC&fullName=aloy'

```
