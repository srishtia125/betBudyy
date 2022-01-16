# betBudyy
This assignment is designed on spring-boot framework.

Installation

Clone the source code

git clone https://github.com/srishtia125/betBudyy.git

Go to the checked out source code(where pom file exisits) and start the server locally (Server will start on port 8080 , make sure no other is using the same port)

```
mvn spring-boot:run
```
API to generate reports
http://localhost:8080/reports
curl command for generating reports
```
curl -X  POST "http://localhost:8080/reports"
```

Reports are generated in files folder in classpath of the project


