# myRetail
This code has a couple of endpoints.  One to get product info based on a product id, and another to updating pricing data for a product
GET /products/v{version}/{id} - Returns product information, name from an internal APIl, and pricing data from a key-value store (dynamodb in this case).
PUT /products/v{version}/{id} - Updates pricing data for the given product id.  Updates the data in the key-value store (dynamodb in this case).
## Testing
Run the tests using maven
```
cd maven
mvn clean test
```

## Running with DynamoDB
This script will start the local dynamodb process, build the webserver if necessary, and start the webserver
```
cd scripts
./start_webserver_with_dynamodb.sh
```
## Running with Cassandra
This script will start the local cassandra process, build the webserver if necessary, and start the webserver
```
cd scripts
./start_webserver_with_cassandra.sh
```

## Manual steps
### Building
Building using maven.  Once built, a jar with all of the dependencies will be in maven/webservices/target/webservices-0.0.1-SNAPSHOT.jar
```
cd maven
mvn clean package
```
### Running
```
cd maven
mvn clean package
java -Dpricing.api.classname=com.myretail.api.pricing.MyRetailPricingAPIDynamoDB -Daws.dynamodb.endpoint=http://localhost:8000 -cp webservices/target/webservices-0.0.1-SNAPSHOT.jar com.myretail.api.app.MyRetailAPIApplication server
```

### Interacting Using DynamoDB
This code uses DynamoDB as a NoSQL store and comes packaged with [local DynamoDB](http://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Tools.DynamoDBLocal.html) with some data already in the store.
Start local DynamoDB server
```
cd dynamodb-local
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar
```
Start webserver
```
cd maven
mvn clean package
java -Dpricing.api.classname=com.myretail.api.pricing.MyRetailPricingAPIDynamoDB -Daws.dynamodb.endpoint=http://localhost:8000 -cp webservices/target/webservices-0.0.1-SNAPSHOT.jar com.myretail.api.app.MyRetailAPIApplication server
```
Open a browser to http://localhost:8080/products/v1/13860428 or, use curl
```
curl http://localhost:8080/products/v1/13860428
```
Output
```
{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":13.49,"currency_code":"USD"}}
```

#### Updating Pricing Data
```
curl -H "Content-Type: application/json" -X PUT -d '{"value":12.99,"currency_code":"USD"}' http://localhost:8080/products/v1/13860428
curl http://localhost:8080/products/v1/13860428
```
Output
```
{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":12.99,"currency_code":"USD"}}
```

### Interacting Using Cassandra
This code uses Cassandra to store the pricing data.
Start cassandra
```
cd apache-cassandra-2.0.14/
bin/cassandra -f
```
Start webserver
```
cd maven
mvn clean package
java -Dpricing.api.classname=com.myretail.api.pricing.MyRetailPricingAPICassandra -cp webservices/target/webservices-0.0.1-SNAPSHOT.jar com.myretail.api.app.MyRetailAPIApplication server
```
Open a browser to http://localhost:8080/products/v1/13860428 or, use curl
```
curl http://localhost:8080/products/v1/13860428
```
Output
```
{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":13.49,"currency_code":"USD"}}
```
#### Updating Pricing Data
```
curl -H "Content-Type: application/json" -X PUT -d '{"value":12.99,"currency_code":"USD"}' http://localhost:8080/products/v1/13860428
curl http://localhost:8080/products/v1/13860428
```
Output
```
{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":12.99,"currency_code":"USD"}}
```
