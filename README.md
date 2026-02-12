# Column Cipher

A Java implementation of the Column Cipher encryption and decryption algorithm.

## Overview

This project implements the **Column Cipher** (also known as Columnar Transposition Cipher), a classical encryption technique that rearranges plaintext characters based on a numeric or alphanumeric key.

## Features

- **Encryption**: Converts plaintext to ciphertext using column transposition
- **Decryption**: Recovers the original plaintext from ciphertext
- **Flexible Key Support**: 
  - Single numeric key (specifies number of columns)
  - Alphanumeric key (derives column order from character values)
- **Padding**: Automatically pads incomplete rows with '#' character

## How it Works

### Encryption Process
1. User provides plaintext and an encryption key
2. Text is arranged in a 2D array with dimensions determined by key length
3. Columns are read sequentially based on key ordering
4. Output is the rearranged ciphertext

### Decryption Process
1. User provides ciphertext and the decryption key
2. Text is reconstructed into a 2D array
3. Columns are reordered based on key values
4. Output is the original plaintext (with padding removed)

## Usage

Run the program and select an option:

```
Enter the choice
1-Encrypt
2-Decrypt
```

### Example: Encryption with Numeric Key
- **Plaintext**: "HELLO"
- **Key**: "3" (3 columns)
- **Process**: Text arranged in columns, then read column by column

### Example: Encryption with Alphanumeric Key
- **Plaintext**: "SECRETMESSAGE"
- **Key**: "321" (determines column order)
- **Process**: Text arranged, columns reordered based on numeric values of characters

## Code Structure

- `read(String s1)`: Reads plaintext/ciphertext and key from user input
- `encrypt()`: Encrypts plaintext using column transposition
- `decrypt()`: Decrypts ciphertext back to plaintext
- `main(String[] argv)`: Handles user menu and program flow

## Requirements

- Java 8 or higher
- No external dependencies

## Compilation and Execution

```bash
javac ColumnCipher.java
java ColumnCipher
```

## Notes

- Incomplete rows are padded with '#' character during encryption
- Padding is automatically removed during decryption
- Key can be a single digit (1-9) or an alphanumeric string

## License

This project is part of the Cybersecurity repository.