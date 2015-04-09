# myRetail
## Testing
Run the tests using maven
```
cd maven
mvn clean test
```

## Building
Building using maven.  Once built, a jar with all of the dependencies will be in maven/webservices/target/webservices-0.0.1-SNAPSHOT.jar
```
cd maven
mvn clean package
```
## Running
```
cd maven
mvn clean package
java -cp webservices/target/webservices-0.0.1-SNAPSHOT.jar com.myretail.api.app.MyRetailAPIApplication server
```

## Interacting
This code uses DynamoDB as a key value store and comes packaged with [local DynamoDB](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Tools.DynamoDBLocal.html) with some data already in the store.
Start local DynamoDB server
```
cd dynamodb-local
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar
```
Start webserver
```
cd maven
mvn clean package
java -cp webservices/target/webservices-0.0.1-SNAPSHOT.jar com.myretail.api.app.MyRetailAPIApplication server
```
Open a browser to http://localhost:8080/products/v1/13860428 or, use curl
```
curl http://localhost:8080/products/v1/13860428
```
Output
```
{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":13.49,"currency_code":"USD"}}
```

### Updating Pricing Data
```
curl -H "Content-Type: application/json" -X PUT -d '{"value":12.99,"currency_code":"USD"}' http://localhost:8080/products/v1/13860428
curl http://localhost:8080/products/v1/13860428
```
Output
```
{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":12.99,"currency_code":"USD"}}
```