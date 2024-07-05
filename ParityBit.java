import java.util.Scanner;

public class ParityBit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input byte data
        System.out.println("Enter byte data (8 bits) without spaces:");
        String byteData = scanner.nextLine();

        // Check if input is valid
        // Must be 8 bits of binary data
        if (byteData.length() != 8 || !byteData.matches("[01]+")) {
            System.out.println("Invalid input. Please enter 8 bits of binary data.");
            return;
        }

        // Convert input to byte array
        // '0' -> 0, '1' -> 1
        byte[] data = new byte[8];
        for (int i = 0; i < 8; i++) {
            data[i] = (byte) (byteData.charAt(i) - '0');
        }

        // Add parity bit
        // Even parity: Add 1 if the count of 1s is odd, else add 0
        // Odd parity: Adding 1 if the count of 1s is even, else add 0

        byte parityBit = calculateParityBit(data);
        String dataWithParity = byteData + parityBit;
        System.out.println("Original data with parity bit: " + dataWithParity);

        // Simulate sending and receiving the data.

        System.out.println("Sender is sending data...");
        boolean[] receivedData = simulateTransmission(data, parityBit);

        // Print received data
        System.out.println("\nData received correctly by the receiver:");
        for (int i = 0; i < receivedData.length; i++) {
            System.out.println("Packet " + i + ": " + (receivedData[i] ? 1 : 0));
        }

        // Check for errors
        // Checking if the total count of 'true' (1s) is even (even parity)
        boolean hasError = checkForErrors(receivedData);
        if (hasError) {
            System.out.println("\nError detected in the received data.");
        } else {
            System.out.println("\nNo error detected in the received data.");
        }
    }

    // Calculating the parity bit based on the data bits
    // Even parity: Add 1 if the count of 1s is odd, else add 0
    // Odd parity: Adding 1 if the count of 1s is even, else add 0

    private static byte calculateParityBit(byte[] data) {
        int countOnes = 0;
        for (byte bit : data) {
            if (bit == 1) {
                countOnes++;
            }
        }
        // Return 1 if the count of 1s is odd (even parity), else return 0
        return (byte) (countOnes % 2 == 0 ? 0 : 1);
    }
    // Simulating the transmission of data packets and parity bit
    // Simulating successful transmission with 80% chance (example scenario)
    // Retransmitting the packet if acknowledgment is not received
    // Simulating receiving the parity bit
    // Returning an array of booleans representing the received data

    private static boolean[] simulateTransmission(byte[] data, byte parityBit) {
        boolean[] receivedData = new boolean[9]; // Extend array size to 9

        // Simulate sending and receiving data
        for (int i = 0; i < data.length; i++) {
            receivedData[i] = sendPacket(data[i], i);
            if (!receivedData[i]) {
                System.out.println("Acknowledgment not received for packet " + i + ". Retransmitting...");
                i--; // Retransmit the same packet
            } else {
                System.out.println("Acknowledgment received for packet " + i);
            }
        }

        // Simulate receiving the parity bit
        receivedData[8] = (parityBit == 1);

        return receivedData;
    }

    // Simulating the transmission of a single packet
    // Simulating successful transmission with 80% chance (example scenario)
    // Returning true if the packet was successfully transmitted, else false
    // Simulating the transmission of a single packet
    private static boolean sendPacket(byte data, int sequenceNumber) {
        // Simulate successful transmission with 80% chance (example scenario)
        double random = Math.random();
        return random < 0.8;
    }

    // Checking for errors in the received data
    // Checking if the total count of 'true' (1s) is even (even parity)
    // Returning true if an error is detected, else false
    // Checking for errors in the received data
    // Checking if the total count of 'true' (1s) is even (even parity)


    private static boolean checkForErrors(boolean[] receivedData) {
        // Check if the total count of 'true' (1s) is even (even parity)
        int countOnes = 0;
        for (int i = 0; i < 8; i++) { // Ensure loop runs 8 times for 8 data bits
            if (receivedData[i]) {
                countOnes++;
            }
        }
        return countOnes % 2 != 0;
    }
}
