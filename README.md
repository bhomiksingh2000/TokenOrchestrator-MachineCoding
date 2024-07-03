Token Orchestrator

Overview

The Token Orchestrator server is designed to manage API keys, providing functionalities to generate, assign, manage, and delete keys with specific features. The server supports multiple endpoints for creating, retrieving, unblocking, deleting, and keeping keys alive.

Features

Generate Keys: Create new API keys with a default lifespan of 5 minutes.
Retrieve Keys: Obtain an available key, ensuring randomness and preventing reuse until the key is unblocked.
Unblock Keys: Make previously assigned keys available for reuse.
Delete Keys: Permanently remove a key from the system.
Keep Alive: Signal the server to keep a key alive, preventing its automatic deletion.
Automatic Key Release: Blocked keys are automatically released if not unblocked within 60 seconds.
Endpoints

POST /keys: Generate new keys.

Status: 201 Created
GET /keys: Retrieve an available key.

Status: 200 OK / 404 Not Found
Response: { "keyId": "<keyID>" } / {}
GET /keys/
: Provide information about a specific key.

Status: 200 OK / 404 Not Found
Response:
