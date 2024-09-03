curl -X POST http://localhost:8080/api/v2/users \
-H "Content-Type: application/json" \
-d '{
  "username": "john_doe",
  "email": "john@example.com"
}' | jq

