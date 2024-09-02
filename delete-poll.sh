curl -X DELETE localhost:8080/api/v2/polls/0 | jq

curl -X POST localhost:8080/api/v2/polls \
  -H "Content-Type: application/json" \
  -d '{
    "question": "Hva smaker best?",
    "validUntil": "2024-12-31T23:59:59Z",
    "creator": {
      "username": "Jonas",
      "email": "Jonas@email.com"
    }
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
  }'

curl -X GET localhost:8080/api/v2/polls | jq
