# EOBALY web crawler

PDS Proj 2018

author: David Kozak

contact: dkozak94@gmail.com

Dependencies:
* java 8 runtime
* maven
* mysql database

Setup
1) provide credentials to access database in /src/main/resources/application.properties
2) run with mvn  spring-boot:run
3) open your browser and go to localhost:8080
4) login with credentials user user
    
## Known issues
* parsing single product does not persist the product with all dependencies
* parsing fails for a couple of products - see Log
* no pagination
* cannot limit number of threads to use for the parsing
* problems with Czech encoding     