
# Parity Bit Simulator

This Java program simulates data transmission with a parity bit and checks for errors in the received data using simple simulation techniques.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Parity Bit Simulator is a basic Java application that demonstrates the use of a parity bit for error detection in digital data transmission. It allows users to input an 8-bit binary data sequence, adds a parity bit (even parity), simulates the transmission of data packets with acknowledgments, receives the data at the receiver end, and checks for errors using the parity bit.

## Features

- Generates an 8-bit binary data sequence.
- Calculates and adds a parity bit (even parity).
- Simulates data transmission with acknowledgment for each packet.
- Checks for errors in the received data using the parity bit.

## Installation

To run the Parity Bit Simulator locally on your machine, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/parity-bit-simulator.git
   cd parity-bit-simulator
   ```

2. **Compile and run the program**:
   Ensure you have Java Development Kit (JDK) installed.
   ```bash
   javac ParityBit.java
   java ParityBit
   ```

## Usage

1. **Input**: Enter an 8-bit binary data sequence without spaces when prompted.
2. **Output**: The program will display the original data with the parity bit, simulate the transmission of data packets with acknowledgment messages, and check for errors in the received data.
3. **Result**: It will indicate whether errors were detected using the parity bit.

## Contributing

Contributions are welcome! Here's how you can contribute to the project:

- Fork the repository.
- Create a new branch (`git checkout -b feature-new-idea`).
- Make your changes.
- Commit your changes (`git commit -am 'Add new feature'`).
- Push to the branch (`git push origin feature-new-idea`).
- Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

