echo "GET /polls \n"
curl -X GET localhost:8080/api/v2/polls | jq

echo "GET / \n"
curl -X GET localhost:8080/api/v2/ | jq



