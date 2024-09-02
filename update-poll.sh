curl -X GET localhost:8080/api/v2/polls | jq

curl -X PUT localhost:8080/api/v2/polls/0 \
  -H "Content-Type: application/json" \
  -d '{
    "question": "Updated poll!",
    "validUntil": "2024-12-31T23:59:59Z",
    "creator": {
      "username": "Jonas",
      "email": "Jonas@email.com"
    }
  }' | jq

curl -X GET localhost:8080/api/v2/polls | jq

curl -X PUT localhost:8080/api/v2/polls/0 \
  -H "Content-Type: application/json" \
  -d '{
  "question": "Hva smaker best?",
  "publishedAt": "2024-09-02T17:48:45.241289135Z",
  "validUntil": "+1000000000-12-31T23:59:59.999999999Z",
  "votes": [],
  "options": [
  {
    "presentationOrder": 1,
    "caption": "Vann"
  },
  {
    "presentationOrder": 2,
    "caption": "Melk"
  }
  ]
}
}' | jq

curl -X GET localhost:8080/api/v2/polls | jq
