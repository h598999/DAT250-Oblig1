curl -X PUT http://localhost:8080/api/v2/users/1 \
-H "Content-Type: application/json" \
-d '{
  "username:" "john doe",
  "email": "john@example.com"
}' | jq
