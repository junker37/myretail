#! /bin/bash

# cleanup child processes
trap "echo 'cleaning up'; trap - SIGTERM && kill -- -$$" SIGINT SIGTERM EXIT

# start dynamodb
./start_dynamodb.sh &
# give dynamodb some time to startup
sleep 5
# start webserver
./start_webserver.sh -Dpricing.api.classname=com.myretail.api.pricing.MyRetailPricingAPIDynamoDB -Daws.dynamodb.endpoint=http://localhost:8000 &

while :			# This is the same as "while true".
do
        sleep 10	# This script is not really doing anything.
done




