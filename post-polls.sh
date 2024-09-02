curl -X POST localhost:8080/api/v2/polls \
  -H "Content-Type: application/json" \
  -d '{
    "question": "What is your favorite programming language?",
    "validUntil": "2024-12-31T23:59:59Z",
    "creator": {
      "username": "Jonas",
      "email": "Jonas@email.com"
    }
  }'

