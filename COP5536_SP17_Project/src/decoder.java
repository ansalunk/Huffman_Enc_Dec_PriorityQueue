

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class decoder {

	static Unpack unpack;

	public static void main(String[] args) throws IOException {

		unpack = new Unpack();

		/* Encoded file */
		ArrayList<Byte> packed = new ArrayList<Byte>();
		StringBuilder codeBuilder = new StringBuilder();
		InputStream fis1 = new FileInputStream(new File(args[0]));

		BufferedReader reader1 = new BufferedReader(new InputStreamReader(fis1));

		int b = reader1.read();
		while (b >= 0) {
			packed.add((byte) b);
			b = reader1.read();
		}
		unpack.unpack(codeBuilder, packed);

		//System.out.print(codeBuilder);

		reader1.close();

		/* Code Table */
		InputStream fis2 = new FileInputStream(new File(args[1]));

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(fis2));
		StringBuilder out = new StringBuilder();
		String line;
		String[] input;

		Map<Integer, String> codeMap = new HashMap<Integer, String>();
		while ((line = reader2.readLine()) != null) {
			input = line.split(" ");
			int key = Integer.parseInt(input[0]);
			String code = input[1];
			codeMap.put(key	, code);
		}
		TreeNode root = unpack.buildDecodeTree(codeMap);
		//unpack.printTree(root);

		StringBuilder decodeString = unpack.generateDecodedFile(codeBuilder, root);
		//System.out.println(decodeString);
		
		String dString = decodeString.toString().trim();
		FileWriter f = new FileWriter(
				"decoded.txt");

		BufferedWriter out1 = new BufferedWriter(f);

		for (char c : dString.toCharArray()) {
			
			if(c=='\n')
				out1.write(System.getProperty("line.separator"));
			else{
			out1.write(c);
			}

					}
		
		System.out.println("Finish");
		out1.flush();
		out1.close();
		

		reader2.close();

	}
}