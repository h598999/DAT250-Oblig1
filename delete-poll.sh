# Delete the existing poll
echo "arg0: $1"
curl -X DELETE localhost:8080/api/v2/polls/0 | jq
echo "Deleted"

# Post a new poll
curl -X POST localhost:8080/api/v2/polls \
  -H "Content-Type: application/json" \
  -d '{
    "question": "Hva smaker best?",
    "validUntil": "2024-12-31T23:59:59Z",
    "creator": {
      "username": "Jonas",
      "email": "Jonas@email.com"
    },
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
  }' | jq
echo "POSTED"

# Get the list of polls and parse the JSON output with jq
curl -X GET localhost:8080/api/v2/polls | jq
echo "GOT"

