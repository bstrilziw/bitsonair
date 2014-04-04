package kt.digitalcommunicationsystem;

public class Receiver {
	
	// errechnet Mittelwert (mu) und Standardabweichung (sigma)
	public double[] drain(boolean[] bitsequence) {
		double[] drain = new double[2];
		double mu = 0;
		double sigma = 0;
		int bitToInt = 0;
		
		for (int i = 0; i < bitsequence.length; i++) {
			bitToInt = (bitsequence[i]) ? 1 : 0;
			mu += bitToInt;
		}
		
		mu /= bitsequence.length;
		
		for (int i = 0; i < bitsequence.length; i++) {
			bitToInt = (bitsequence[i]) ? 1 : 0;
			sigma += Math.pow(bitToInt - mu, 2);
		}
		
		sigma = Math.sqrt(1/(double)(bitsequence.length-1) * sigma);
		
		drain[0] = mu;
		drain[1] = sigma;
		return drain;
	}
	
	// dekodiert die n-Mal wiederholte Bit-Folge wieder und gibt nach belegt nach Mehrheitsentscheidung jedes einzelne Bit
	public boolean[] repeatDecode(boolean[] bitsequence, int n) {
		boolean[] decodedBitsequence = new boolean[(int)Math.floor(bitsequence.length / n)];
		
		for (int i = 0; i < decodedBitsequence.length; i++) {
			int countTrue = 0;
			int countFalse = 0;
			
			for (int j = i*n; j < (i+1)*n; j++) {
				if (bitsequence[j]) {
					countTrue += 1;
				} else {
					countFalse += 1;
				}
			}
			
			decodedBitsequence[i] = (countTrue > countFalse) ? true : false;
		}
		
		return decodedBitsequence;
	}
	
	// wandelt einen Binär-String in einen String um
	public String binaryToString(String binaryString) {
		byte[] byteArray = new byte[binaryString.length() / 8];
		
		for (int i = 0; i < byteArray.length; i++) {
			StringBuilder byteString = new StringBuilder();
			
			for (int j = i * 8; j < (i+1) * 8; j++) {
				byteString.append(String.valueOf(binaryString.charAt(j)));
			}
			
			byteArray[i] = (byte) Integer.parseInt(byteString.toString(), 2);
		}
		
		return new String(byteArray);
	}
	
	// wandelt ein boolean-Array in einen Binär-String um
	public String booleanArrayToBinaryString(boolean[] booleanArray) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < booleanArray.length; i++) {
			sb.append((booleanArray[i]) ? "1" : "0");
		}
		
		return sb.toString();
	}
}
