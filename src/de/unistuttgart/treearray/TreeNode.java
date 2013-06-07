package de.unistuttgart.treearray;

import java.util.ArrayList;

/**
 * A TreeNode is basically a binary tree. The data is saved in an ArrayList<T>.
 * The interface of TreeNode is (almost) the same as a "normal" bin tree.
 * 
 * Note: not all edge cases are covered.
 * 
 * @param <T> type of the data which is saved.
 */
public class TreeNode <T> implements TreeNodeInterface<T>{

	private ArrayList<T> data;
	final private Integer index;

	/**
	 * Create a tree from the given data d.
	 * @param d the data in the tree.
	 */
	public TreeNode(ArrayList<T> d) {
		this(d, 0);
	}
	
	/**
	 * This private c'tor is used for returning/creating sub-nodes.
	 * @param d the data
	 * @param index the position of the node in the tree.
	 */
	private TreeNode(ArrayList<T> d, Integer index) {
		this.data = d;
		this.index = index;
	}

	@Override
	public T getValue() {
		return data.get(index);
	}

	@Override
	public TreeNodeInterface<T> getLeftChild() {
		int pos = (index + 1) * 2 - 1;
		return new TreeNode<T>(data, pos);
	}

	@Override
	public TreeNodeInterface<T> getRightChild() {
		int pos = (index + 1) * 2;
		return new TreeNode<T>(data, pos);
	}

	@Override
	public TreeNodeInterface<T> getParent() {
		if (isRoot()) {
			throw new IndexOutOfBoundsException();
		}
		return new TreeNode<T>(data, ((index - 1)/2));
	}

	@Override
	public boolean isRoot() {
		return index == 0;
	}

	@Override
	public int getLevel() {
		return (int) Math.floor(Math.log(index + 1) / Math.log(2));
	}

	@Override
	public void setValue(T value) {
		data.set(index, value);
	}

}
