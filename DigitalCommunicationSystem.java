package kt.digitalcommunicationsystem;

public class DigitalCommunicationSystem {

	public static void main(String[] args) {
		int loopsize = 1;
		int n = 100; // Anzahl Bits
		double p = 0.4; // Wahrscheinlichkeit, dass Bit 1 ist
		double q = 0.2; // Störungswahrscheinlichkeit
		int numberOfBitsRepeated = 3; // Anzahl Wiederholungen pro Bit
//		String message = "HAW Hamburg";
		
		Sender[] sender = new Sender[loopsize];
		Channel[] channel = new Channel[loopsize];
		Receiver[] receiver = new Receiver[loopsize];
		
		for (int i = 0; i < loopsize; i++) {
			// Sender
			sender[i] = new Sender();
			boolean[] senderBitsequence = sender[i].source(n, p);
//			String messageAsBinary = sender[i].stringToBinaryString(message);
//			boolean[] senderBitsequence = sender[i].binaryStringToBooleanArray(messageAsBinary);
			boolean[] encodedSenderBitsequence = sender[i].repeatEncode(senderBitsequence, numberOfBitsRepeated);
			
			// Wie sieht die Bit-Sequenz aus?
			System.out.println(Helper.printBits("gesendet\t", senderBitsequence));
			System.out.println(Helper.printBits("nach der Kodierung", encodedSenderBitsequence));
			
			// Wie ist die Verteilung?
//			int[] bitCounter = Helper.countBits(senderBitsequence);
//			System.out.println("Verteilung:");
//			System.out.println("1: " + bitCounter[1] + "x");
//			System.out.println("0: " + bitCounter[0] + "x");
			
			// Kanal
			channel[i] = new Channel();
			boolean[] encodedChannelBitsequence = channel[i].noise(encodedSenderBitsequence, q);
			
			// Wie sieht die Bit-Sequenz jetzt aus?
			System.out.println(Helper.printBits("durch den Kanal", encodedChannelBitsequence));
			
			// Empfänger
			receiver[i] = new Receiver();
			boolean[] decodedChannelBitsequence = receiver[i].repeatDecode(encodedChannelBitsequence, numberOfBitsRepeated);
			
			// Wie sieht die Bit-Sequenz jetzt aus?
			System.out.println(Helper.printBits("nach der Dekodierung", decodedChannelBitsequence));

//			String booleanArrayAsBinaryString = receiver[i].booleanArrayToBinaryString(decodedChannelBitsequence);
//			String receivedMessage = receiver[i].binaryToString(booleanArrayAsBinaryString);
//			System.out.println("Dekodierte Nachricht:\t" + receivedMessage);

			double[] drained = receiver[i].drain(decodedChannelBitsequence);
			System.out.println("Mittelwert: " + drained[0]);
			System.out.println("Standardabweichung: " + drained[1]);
			System.out.println("Bitfehlerrate: " + Helper.getBitErrorRate(senderBitsequence, decodedChannelBitsequence));
			System.out.println("-------------------");
		}
	}
	
}
