

public class PairNode {

	public int element;
	public PairNode firstChild;
	public PairNode leftSib;
	public PairNode rightSib;
	public PairNode leftChild;
	public PairNode rightChild;
	public int freq;

	/* Constructor */
	public PairNode(int node, int freq, PairNode firstChild,
			PairNode leftSib, PairNode rightSib, PairNode leftChild,
			PairNode rightChild) {
		this.freq = freq;
		this.element = node;
		this.firstChild = firstChild;
		this.leftSib = leftSib;
		this.rightSib = rightSib;
		this.leftChild= leftChild;
		this.rightChild= rightChild;
	}

	public PairNode() {
		super();
	}

	public PairNode(Integer key, Integer value) {
		this(key, value, null, null, null, null, null);
	}
}
