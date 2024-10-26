# AES Encryption Utility

A **Java-based AES encryption and decryption tool** that can encrypt and decrypt text using AES (Advanced Encryption Standard) in **ECB mode**. The tool utilizes a **static key** defined directly in the code.

---

## Features
- **AES Encryption and Decryption** using a static key.
- **Command-line usage** to encrypt or decrypt text.

---

## Prerequisites
1. **JDK**: Java 8 or higher installed.
2. **Gradle**: Installed and configured in your environment.
3. **IntelliJ IDEA** (optional): To run and test the code directly from the IDE.

---

## Running the JAR File

You can run the JAR file from the command line using the following commands:

### 1. Encrypt a Text

To encrypt a plaintext string, use the following command:

```bash
java -jar build/libs/aes-encryption-tool.jar encrypt "YourPlainTextHere"
```

### 2. Decrypt a Text

To decrypt a ciphertext string, use the following command:

```bash
java -jar build/libs/aes-encryption-tool.jar decrypt "YourCiphertextHere"
```
