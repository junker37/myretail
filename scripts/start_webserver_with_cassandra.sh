#! /bin/bash

# cleanup child processes
trap "echo 'cleaning up'; trap - SIGTERM && kill -- -$$" SIGINT SIGTERM EXIT

# start cassandra
./start_cassandra.sh &
# give cassandra some time to startup
sleep 15
# start webserver
./start_webserver.sh -Dpricing.api.classname=com.myretail.api.pricing.MyRetailPricingAPICassandra &

while :			# This is the same as "while true".
do
        sleep 10	# This script is not really doing anything.
done




