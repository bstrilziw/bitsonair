package kt.digitalcommunicationsystem;

public class Helper {
	
	// ermittelt anhand der gesendeten und empfangenen Bits die Fehlerrate
	public static double getBitErrorRate(boolean bitsSent[], boolean bitsReceived[]) {
		double bitErrorRate = 0;
		int countBits = bitsSent.length;
		
		try {
			for (int i = 0; i < countBits; i ++) {
				bitErrorRate += (Math.abs(((bitsSent[i]) ? 1 : 0) - ((bitsReceived[i]) ? 1 : 0)) % 2);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		
		bitErrorRate /= countBits;
		
		return bitErrorRate;
	}
	
	/* 
	 * Ab hier Test-Methoden
	*/
	
	// zählt die 0er und 1er Bits
	public static int[] countBits(boolean[] bitsequence) {
		int countArray[] = new int[2];
		
		for (int i = 0; i < bitsequence.length; i++) {
			if (!bitsequence[i]) {
				countArray[0]++;
			} else {
				countArray[1]++;
			}
		}
		
		return countArray;
	}
	
	// gibt die Bit-Folge mit Index aus
	public static String printBits(String type, boolean[] bitsequence) {
		StringBuilder print = new StringBuilder();
		print.append(type + " \t");
		
		for (int i = 0; i < bitsequence.length; i++) {
			print.append((bitsequence[i]) ? 1 : 0);
		}
		
		return print.toString();
	}
	
}
