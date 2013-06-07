package de.unistuttgart.treearray;

/**
 * Every tree node should confirm to this interface.
 * 
 * @param <T> type of the actual data saved in the node.
 */
public interface TreeNodeInterface<T> {

	public T getValue();
	public void setValue(T value);
	
	public TreeNodeInterface<T> getLeftChild();
	public TreeNodeInterface<T> getRightChild();
	public TreeNodeInterface<T> getParent();
	
	public boolean isRoot();
	public int getLevel();
}
