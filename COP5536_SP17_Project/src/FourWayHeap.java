

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FourWayHeap {

	ArrayList<TreeNode> fHeap = new ArrayList<TreeNode>();
	static FourWayHeap fourWayHeap;

	public FourWayHeap() {
		fHeap.add(null);
		fHeap.add(null);
		fHeap.add(null);
	}

	public int getHeapSize() {
		return fHeap.size();
	}

	public void insert(TreeNode node) {

		fHeap.add(node);
		int currentSize = fHeap.size() - 1;
		int posParent = parent(currentSize);
		while (posParent != currentSize
				&& fHeap.get(posParent).getFreq() > fHeap.get(currentSize)
						.getFreq()) {
			TreeNode temp = fHeap.get(currentSize);
			fHeap.set(currentSize, fHeap.get(posParent));
			fHeap.set(posParent, temp);
			currentSize = posParent;
			posParent = parent(currentSize);
		}

	}

	/** Function to check if heap is empty **/
	public boolean isEmpty() {
		return fHeap.size() == 3;
	}

	/** Function to find least element **/
	public TreeNode findMin() {
		if (isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		return fHeap.get(3);
	}

	private int parent(int i) {
		return (int) Math.floor(((i - 4) / 4) + 3);
	}

	public void heapify(int posParent) {
		int childPos = 4 * (posParent - 3) + 3;
		int i = 1;
		int minValue = posParent;
		while (i < 5) {
			childPos++;
			if (childPos < fHeap.size()) {
				if (childPos < fHeap.size()
						&& fHeap.get(childPos).getFreq() < fHeap.get(minValue)
								.getFreq()) {
					minValue = childPos;
				}
			}
			i++;
		}
		if (minValue != posParent) {
			TreeNode temp = fHeap.get(posParent);
			fHeap.set(posParent, fHeap.get(minValue));
			fHeap.set(minValue, temp);
			heapify(minValue);
		}

	}

	/** Function to delete min value from heap **/

	public TreeNode deleteMin() {

		if (fHeap.size() <= 3)
			throw new NoSuchElementException();
		if (fHeap.size() == 4)
			return fHeap.remove(3);
		else {
			TreeNode temp = fHeap.get(3);
			int swapPos = fHeap.size() - 1;
			fHeap.set(3, fHeap.get(swapPos));
			fHeap.set(swapPos, temp);
			TreeNode minNode = fHeap.remove(swapPos);
			heapify(3);
			return minNode;
		}

	}

	/** Function to print heap **/
	public void printHeap() {
		System.out.print("\nHeap = ");
		for (int i = 3; i < fHeap.size(); i++)
			System.out.println(fHeap.get(i).getNode() + " .. "
					+ fHeap.get(i).getFreq());

		System.out.println();
	}

}