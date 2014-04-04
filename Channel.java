package kt.digitalcommunicationsystem;

import java.util.Random;

public class Channel {
	
	private Random random;
	
	public Channel() {
		random = new Random();
	}
	
	// fügt Fehler in die Bit-Folge ein (ändert mit der Wahrscheinlichkeit von q den Wert um)
	public boolean[] noise(boolean[] senderBitsequence, double q) {
		boolean[] channelBitsequence = new boolean[senderBitsequence.length];
		boolean bit = false;
		
		for (int i = 0; i < senderBitsequence.length; i++) {
			bit = senderBitsequence[i];
			
			if (this.random.nextDouble() < q) {
				bit = (senderBitsequence[i]) ? false : true;
			}
			
			channelBitsequence[i] = bit;
		}
		
		return channelBitsequence;
	}
	
}
