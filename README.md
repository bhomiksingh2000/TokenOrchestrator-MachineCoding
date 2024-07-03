
# Token Orchestrator

## Overview

The Token Orchestrator server is designed to manage API keys, providing functionalities to generate, assign, manage, and delete keys with specific features. The server supports multiple endpoints for creating, retrieving, unblocking, deleting, and keeping keys alive.

## Features

- **Generate Keys**: Create new API keys with a default lifespan of 5 minutes.
- **Retrieve Keys**: Obtain an available key, ensuring randomness and preventing reuse until the key is unblocked.
- **Unblock Keys**: Make previously assigned keys available for reuse.
- **Delete Keys**: Permanently remove a key from the system.
- **Keep Alive**: Signal the server to keep a key alive, preventing its automatic deletion.
- **Automatic Key Release**: Blocked keys are automatically released if not unblocked within 60 seconds.

## Endpoints

- **POST /keys**: Generate new keys.
  - **Status**: 201 Created

- **GET /keys**: Retrieve an available key.
  - **Status**: 200 OK / 404 Not Found
  - **Response**: `{ "keyId": "<keyID>" }` / `{}`

- **GET /keys/:id**: Provide information about a specific key.
  - **Status**: 200 OK / 404 Not Found
  - **Response**: 
    ```json
    {
      "isBlocked": "<true> / <false>",
      "blockedAt": "<blockedTime>",
      "createdAt": "<createdTime>"
    }
    ```
  
- **DELETE /keys/:id**: Remove a specific key.
  - **Status**: 200 OK / 404 Not Found

- **PUT /keys/:id**: Unblock a key.
  - **Status**: 200 OK / 404 Not Found

- **PUT /keepalive/:id**: Keep the specified key alive.
  - **Status**: 200 OK / 404 Not Found

## Design Principles

This project follows SOLID principles and is designed using object-oriented programming concepts. The design ensures modularity, extensibility, and readability. The key management operations are optimized for scalability and efficiency.

## How to Run

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/yourusername/token-orchestrator.git
   cd token-orchestrator
   ```

2. **Build the Project**:
   ```sh
   mvn clean install
   ```

3. **Run the Application**:
   ```sh
   mvn spring-boot:run
   ```

4. **Test the Endpoints**:
   Use tools like `curl`, `Postman`, or any other API testing tool to interact with the endpoints.

## Project Structure

- **`src/main/java`**: Contains the Java source files.
  - **controller**: Handles HTTP requests.
  - **service**: Contains business logic.
  - **model**: Contains data models.
  - **repository**: Manages in-memory data.
  - **config**: Contains configuration files.
- **`src/test/java`**: Contains test cases for the application.

## Future Improvements

- Add persistent storage using a database.
- Implement authentication and authorization.
- Enhance the keep-alive mechanism to support more flexible intervals.
- Add more comprehensive logging and monitoring.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request.

## License

This project is licensed under the MIT License.
