#! /bin/bash

function test_get {
  EXPECTED="$1"
  ACTUAL=`curl -s http://localhost:8080/products/v1/13860428`
  if [ "$EXPECTED" != "$ACTUAL" ]
  then
    echo "ERROR: '$EXPECTED' != '$ACTUAL'"
    exit
  fi
}

function test_put {
  NEWDATA="$1"
  curl -s -H "Content-Type: application/json" -X PUT -d ${NEWDATA} http://localhost:8080/products/v1/13860428
}

test_get '{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":13.49,"currency_code":"USD"}}'
test_put '{"value":12.99,"currency_code":"USD"}'
test_get '{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":12.99,"currency_code":"USD"}}'
# reverse the put
test_put '{"value":13.49,"currency_code":"USD"}'
test_get '{"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value":13.49,"currency_code":"USD"}}'

echo ""
echo "SUCCESS"
echo ""
