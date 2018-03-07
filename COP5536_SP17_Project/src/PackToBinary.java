/*

 This program reads from command line a file containing 
 a sequence of the ASCII characters '0' and '1', representing
 a sequence of bits.  It converts each character to a bit, 
 and packs the bits into bytes. The resulting packed bytes are 
 written to encoded.bin file.
 
 Also it reads the code table and generates a CodeTable.txt file

 */



import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class PackToBinary {

	public static void packToBinary(StringBuilder binaryString, ArrayList<Byte> arr) {
		arr.clear();
		int n = binaryString.length() % 8;
		arr.add((byte) n);
		int p = 1;
		for (int i = 0; i < binaryString.length(); i += 8) {
			byte m = 0;
			for (int k = 0; k < 8; k++) {
				m <<= 1;
				if (i + k < binaryString.length()) {
					char c = binaryString.charAt(i + k);
					if (c == '1')
						m |= 1;
					else if (c != '0')
						throw new RuntimeException(
								"pack: Invalid input character " + c);
				}
			}
			arr.add(m);
		}
	}

	public void encodeToBinary(String encodedMessage) throws IOException {
	
		ArrayList<Byte> array = new ArrayList<Byte>();
	
		StringBuilder encodedStrBuildMsg = new StringBuilder(encodedMessage);
	
		DataOutputStream out = new DataOutputStream(new FileOutputStream(
				"encoded.bin"));
	
		packToBinary(encodedStrBuildMsg, array);
	
		for (byte c : array) {
			out.write(c);
	
		}
	
		out.flush();
		out.close();
	}

	public void generateCodeTable(Map<Integer, String> codeMap)
			throws IOException {

		FileWriter f = new FileWriter(
				"code_table.txt");

		BufferedWriter out = new BufferedWriter(f);

		for (Entry<Integer, String> codeTable : codeMap.entrySet()) {
			String code = codeTable.getValue();

			int key = codeTable.getKey();

			String line = key + " " + code
					+ System.getProperty("line.separator");

			out.write(line);
		}
		out.flush();
		out.close();

	}
}
