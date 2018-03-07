

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class Unpack {

	// change public later
	 TreeNode root, temp;

	public TreeNode buildDecodeTree(Map<Integer, String> codeMap) {

		root = new TreeNode();

		for (Entry<Integer, String> node : codeMap.entrySet()) {

			int key = node.getKey();
			String code = node.getValue();
			char[] codeChar = code.toCharArray();
			temp = root;

			for (int count = 0; count < codeChar.length; count++) {

				temp = insertNode(codeChar[count],
						count == (codeChar.length - 1), temp, key);

			}

		}

		return root;
	}

	public void printTree(TreeNode root) {

		if (root != null)
			System.out.println(root.getNode());
		if (root.left != null)
			printTree(root.left);
		if (root.right != null)
			printTree(root.right);

	}

	private TreeNode insertNode(char c, boolean isLeafNode, TreeNode temp,
			int key) {

		TreeNode newNode = new TreeNode();

		if (isLeafNode) {
			if (c == '0') {
				temp.left = newNode;
			} else {
				temp.right = newNode;
			}
			newNode.setNode(key);
		}

		else {
			if (c == '0') {
				if (temp.left != null)
					temp = temp.left;
				else {
					temp.left = newNode;
					temp = temp.left;
				}
			} else {
				if (temp.right != null)
					temp = temp.right;
				else {
					temp.right = newNode;
					temp = temp.right;
				}
			}
		}

		return temp;
	}
	
	
	
	 public static void unpack(StringBuilder b, ArrayList<Byte> arr){
		 
		 
	      int n = arr.get(0);
	      int len = 8*arr.size()-16+(n==0?8:n);
	      
	      for(int i=0; i<len; i++){
	         int index = i/8+1;
	         int bitpos = i%8;
	         int bit = (arr.get(index)>>(7-bitpos)) & 1;
	         b.append(bit==0?'0':'1');
	      }
	   }

	public StringBuilder generateDecodedFile(StringBuilder codeBuilder, TreeNode root) {
		// TODO Auto-generated method stub
		
		String binaryString = codeBuilder.toString();
			
		//System.out.println(binaryString);
		StringBuilder output = new StringBuilder();
		TreeNode base = root;
	 while (!binaryString.isEmpty()){
	    if (binaryString.charAt(0) == '1'){
	    	base = base.right;
	    	binaryString = binaryString.substring(1);
	    }
	    else {
	    	base = base.left;
	    	binaryString = binaryString.substring(1);
	    }
	    if (base.left == null && base.right == null){
	  		output.append(base.getNode()+ "\n");
	  		base = root;
	  	}

	  }
	
	 return output;
	}
		
}
