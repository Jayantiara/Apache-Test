# SecureGroupChat

A simple secure group chat application written in Java, implementing basic socket programming and encryption for message confidentiality.

## 📂 Project Structure

- `Client.java` – Connects to the server, sends user input, and receives messages.
- `Server.java` – Accepts multiple client connections and relays encrypted messages to all connected users.
- `CryptoUtil.java` – Contains encryption and decryption methods (e.g., using AES).
- `SecureGroupChat.java` – Optional main class for launching client/server or handling integration.

## 🚀 Getting Started

### 1. Compile all Java files

```bash
javac *.java
```

### 2. Run the Server

```bash
java Server
```

### 3. Run one or more Clients

```bash
java Client
```

> 💡 Make sure to run the server first before starting clients.

## 🔐 Security

This chat application uses symmetric encryption through the `CryptoUtil` class to secure messages between clients and the server.  
For demonstration purposes, the encryption key may be hardcoded. In production environments, use proper key exchange mechanisms and **never hardcode secrets**.

## 📦 Requirements

- Java Development Kit (JDK) 8 or above
- No external libraries required

## 📄 License

This project is licensed under the **Apache-2.0 License**.  
See the `LICENSE` file for more details.

## 📌 Disclaimer

This project was created for educational purposes only.  
Do not use it as-is for secure production messaging without proper auditing and enhancement.
