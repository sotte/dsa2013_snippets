package de.unistuttgart.treearray;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * This is a simple demo of how Junit is used to test your claesse.
 * 
 * It also verifies that my implementation is not total garbage :)
 */
@RunWith(JUnit4.class)
public class TestTreeNode {
	// tree is used throughout the unit test
	private TreeNode<Integer> tree = null;

	@Before
	public void setUp() {
		tree = new TreeNode<Integer>(DataFactory.createData());
	}

	@After
	public void tearDown() {
		tree = null;
	}

	// root stuff
	@Test
	public void rootShouldBeRoot() {
		assertEquals(true, tree.isRoot());
	}

	@Test
	public void notRoot() {
		assertEquals(false, tree.getLeftChild().isRoot());
		assertEquals(false, tree.getRightChild().isRoot());
	}

	// get values stuff
	@Test
	public void getValueOfRoot() {
		assertEquals(new Integer(0), tree.getValue());
	}

	// values of children stuff
	@Test
	public void getChildren() {
		// left
		TreeNodeInterface<Integer> left = tree.getLeftChild();
		assertEquals(new Integer(1), left.getValue());
		assertEquals(new Integer(3), left.getLeftChild().getValue());
		assertEquals(new Integer(4), left.getRightChild().getValue());
		// right
		TreeNodeInterface<Integer> right = tree.getRightChild();
		assertEquals(new Integer(2), right.getValue());
		assertEquals(new Integer(5), right.getLeftChild().getValue());
		assertEquals(new Integer(6), right.getRightChild().getValue());
	}

	@Test
	public void isRoot() {
		// the root should be root
		assertEquals(true, tree.isRoot());
		// the children should not be the root
		assertEquals(false, tree.getLeftChild().isRoot());
		assertEquals(false, tree.getRightChild().isRoot());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void getParentOfRoot() {
		tree.getParent();
	}

	@Test
	public void getParentOfFirstLevel() {
		assertEquals(tree.getValue(), tree.getLeftChild().getParent()
				.getValue());
		assertEquals(tree.getValue(), tree.getRightChild().getParent()
				.getValue());
	}

	@Test
	public void getParentOfSecondLevel() {
		TreeNodeInterface<Integer> left = tree.getLeftChild();
		TreeNodeInterface<Integer> leftLeft = left.getLeftChild();
		assertEquals(left.getValue(), leftLeft.getParent().getValue());
	}

	@Test
	public void getLevelOfRoot() {
		assertEquals(0, tree.getLevel());
	}

	@Test
	public void getLevelOfFirstLevel() {
		assertEquals(1, tree.getLeftChild().getLevel());
		assertEquals(1, tree.getRightChild().getLevel());
	}

	@Test
	public void getLevelOfSecondLevel() {
		// left
		TreeNodeInterface<Integer> l = tree.getLeftChild();
		assertEquals(2, l.getLeftChild().getLevel());
		assertEquals(2, l.getRightChild().getLevel());
		// right
		TreeNodeInterface<Integer> r = tree.getRightChild();
		assertEquals(2, r.getLeftChild().getLevel());
		assertEquals(2, r.getRightChild().getLevel());
	}
}
