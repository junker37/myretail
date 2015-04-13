#! /bin/bash

# Starts the webserver, any arguments passed in are passed along to the java command

JAVA_PROPS=$@

if [ ! -e ../maven/webservices/target/webservices-0.0.1-SNAPSHOT.jar ];
then
  echo "Building..."
  cd ../maven
  mvn clean package
fi

echo "Starting webserver with java args $JAVA_PROPS"
java $JAVA_PROPS -cp ../maven/webservices/target/webservices-0.0.1-SNAPSHOT.jar com.myretail.api.app.MyRetailAPIApplication server
