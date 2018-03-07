

public class TreeNode {
	int freq;
	int node;
	public TreeNode left, right;

	TreeNode(int freq, TreeNode left, TreeNode right) {
		this.freq = freq;
		this.left = left;
		this.right = right;
	}

	public TreeNode() {
		super();
	}

	TreeNode(int freq) {
		this(freq, null, null);
	}

	public TreeNode(int node, int freq) {
		this.freq = freq;
		this.node = node;
		this.left = this.right = null;
	}

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

}