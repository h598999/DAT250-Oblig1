curl -X PUT http://localhost:8080/api/v2/users/0 \
-H "Content-Type: application/json" \
-d '{
  "email": "john@example.com"
}' | jq
