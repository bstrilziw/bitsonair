package kt.digitalcommunicationsystem;

import java.util.Random;

public class Sender {
	
	private Random random;
	
	public Sender() {
		random = new Random();
	}
	
	// erstellt eine Bit-Folge mit n Element und einer Wahrscheinlichkeit von p, dass das Bit 1 ist
	public boolean[] source(int n, double p) {
		boolean[] bitsequence = new boolean[n];
		boolean bit;
		
		for (int i = 0; i < n; i++) {
			bit = false;
			
			if (this.random.nextDouble() < p) {
				bit = true;
			}
			
			bitsequence[i] = bit;
			
		}
		
		return bitsequence;
	}
	
	// kodiert die Bitsequenz, indem jedes Bit n-mal wiederholt wird
	public boolean[] repeatEncode(boolean[] bitsequence, int n) {
		boolean[] encodedBitsequence = new boolean[bitsequence.length * 3];
		
		for (int i = 0; i < encodedBitsequence.length; i++) {
			encodedBitsequence[i] = bitsequence[(int)Math.floor(i / 3)];
		}
		
		return encodedBitsequence;
	}
	
	// wandelt die Nachricht in einen Binär-String um
	public String stringToBinaryString(String message) {
		byte[] messageBytes = message.getBytes();
	    StringBuilder sb = new StringBuilder(messageBytes.length * Byte.SIZE);
	    
	    for(int i = 0; i < Byte.SIZE * messageBytes.length; i++) {
	        sb.append(((messageBytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1'));
	    }
	    
	    return sb.toString();
	}
	
	// wandelt einen Binär-String in ein boolean-Array um
	public boolean[] binaryStringToBooleanArray(String binaryString) {
		boolean[] booleanArray = new boolean[binaryString.length()];
		
		for (int i = 0; i < binaryString.length(); i++) {
			booleanArray[i] = (binaryString.charAt(i) == '1') ? true : false;
		}
		
		return booleanArray;
	}
	
}
