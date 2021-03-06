

import java.util.ArrayList;

public class PairingHeap {

	public PairNode min;

	public PairingHeap() {
		min = null;
	}

	public PairNode meld(PairNode tree1, PairNode tree2) {

		if (tree1.freq >= tree2.freq) {
			tree1.leftSib = tree2;
			if (tree2.firstChild != null) {
				tree2.firstChild.leftSib = tree1;
				tree1.rightSib = tree2.firstChild;

			}
			tree2.firstChild = tree1;
			if (min == tree1) {
				min = tree2;
			}
			return tree2;
		} else {
			tree2.leftSib = tree1;
			if (tree1.firstChild != null) {
				tree1.firstChild.leftSib = tree2;
				tree2.rightSib = tree1.firstChild;

			}
			tree1.firstChild = tree2;
			if (min == tree2) {
				min = tree1;
			}
			return tree1;
		}
	}

	public void insert(PairNode node) {
		if (min == null) {
			min = node;
		} else {
			meld(min, node);
		}
	}

	public PairNode removeMin() throws Exception {
		if (min == null) {
			throw new Exception("Heap empty...!");
		} else if (min.firstChild == null) {
			PairNode temp = min;
			min = null;
			return temp;
		} else {
			PairNode child = min.firstChild;
			ArrayList<PairNode> q = new ArrayList<PairNode>();
			while (child != null) {
				child.leftSib = null;
				PairNode rightMove = child.rightSib;
				child.rightSib = null;
				q.add(child);
				child = rightMove;
			}
			PairNode temp = min;

			min.firstChild.leftSib = null;
			temp.firstChild = null;
			min = null;

			while (q.size() > 1) {
				PairNode newNode = meld(q.remove(0), q.remove(0));
				q.add(newNode);
			}
			min = q.get(0);
			return temp;
		}
	}

	public PairNode huff() throws Exception {
		while (min.firstChild != null) {
			PairNode n1 = removeMin();
			PairNode n2 = removeMin();
			PairNode nw = new PairNode(-1, n1.freq + n2.freq, null, null, null,
					n1, n2);
			insert(nw);
		}
		return min;
	}

	public void printTree(PairNode root) {

		if (root != null)
			System.out.println(root.element + root.freq);
		if (root.firstChild != null)
			printTree(root.firstChild);
		if (root.leftSib != null) {
			printTree(root.leftSib);
			printTree(root.leftSib.leftChild);
			printTree(root.leftSib.rightChild);
		}
		if (root.rightSib != null) {
			printTree(root.rightSib);
			printTree(root.rightSib.leftChild);
			printTree(root.rightSib.rightChild);
		}
	}

}
