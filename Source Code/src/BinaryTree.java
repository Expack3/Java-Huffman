import java.io.*;
import java.util.*;

public class BinaryTree<T>
{
	private BTreeNode<T> root;
	private BTreeNode<T> current;
	private int size;
	private StringBuffer encoding = new StringBuffer();

	public static enum Relative
	{
		leftChild, rightChild, parent, root
	};

	public BinaryTree() throws IOException {
		root = null;
		current = null;
		size = 0;
	}

	public void Destroy(BTreeNode<T> n) {
		if (n != null)
		{
			Destroy(n.getLeft());
			Destroy(n.getRight());
			n = null;
			size--;
		}
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean isLeaf() {
		boolean isLeaf = false;

		isLeaf = (current.getLeft() == null && current.getRight() == null);

		return isLeaf;
	}

	public int getSize() {
		return size;
	}

	public T getCurrent() {
		return current.getElement();
	}

	private BTreeNode<T> findParent(BTreeNode<T> n) {
		Stack<BTreeNode<T>> s = new Stack<BTreeNode<T>>();
		n = root;
		while (n.getLeft() != current && n.getRight() != current)
		{
			if (n.getRight() != null)
				s.push(n.getRight());

			if (n.getLeft() != null)
				n = n.getLeft();
			else
				n = s.pop();
		}
		s.clear();
		return n;
	}

	public boolean moveTo(Relative rel) {
		boolean found = false;

		switch (rel)
		{
		case leftChild:
			if (current.getLeft() != null)
			{
				current = current.getLeft();
				found = true;
			}
			break;
		case rightChild:
			if (current.getRight() != null)
			{
				current = current.getRight();
				found = true;
			}
			break;
		case parent:
			if (current != root)
			{
				current = findParent(current);
				found = true;
			}
			break;
		case root:
			if (root != null)
			{
				current = root;
				found = true;
			}
			break;
		} // end Switch relative

		return found;
	}

	public BTreeNode<T> getRoot() {
		return root;
	}

	public void Update(T el) {
		current.setElement(el);
	}

	public boolean insert(BinaryTree<T> value, Relative rel)
	{
		boolean inserted = true;

		if ((rel == BinaryTree.Relative.leftChild && current.getLeft() != null)
				|| (rel == BinaryTree.Relative.rightChild && current.getRight() != null))
		{
			inserted = false;
		} else
		{

			switch (rel)
			{
			case leftChild:
				current.setLeft(value.getRoot());
				break;
			case rightChild:
				current.setRight(value.getRoot());
				break;
			case root:
				if (root == null)
					root = value.getRoot();
				current = root;
				break;
			}
		}

		size++;

		return inserted;
	}

	public boolean insert(T value, Relative rel) {
		boolean inserted = true;

		BTreeNode<T> node = null;

		if ((rel == BinaryTree.Relative.leftChild && current.getLeft() != null)
				|| (rel == BinaryTree.Relative.rightChild && current.getRight() != null))
		{
			inserted = false;
		} else
		{

			node = new BTreeNode<T>(value);

			switch (rel)
			{
			case leftChild:
				current.setLeft(node);
				break;
			case rightChild:
				current.setRight(node);
				break;
			case root:
				if (root == null)
					root = node;
				current = root;
				break;
			}
		}

		size++;

		return inserted;
	}


	public void inOrder(BTreeNode<T> p) {
		if (p != null)
		{
			encoding.append("0");
			inOrder(p.getLeft());
			encoding.deleteCharAt(encoding.length() - 1);
			

			if(p.isLeaf() == true)
			{
				System.out.print(((CharacterFrequency)p.getElement()).getCharacter() + "@*");
				System.out.print(encoding);
				System.out.println();
			}
			
			encoding.append("1");
			inOrder(p.getRight());
			encoding.deleteCharAt(encoding.length() - 1);
		}
	}
	
	public Vector<String[]> createEncodingTable(BTreeNode<T> p, Vector<String[]> vectorString) throws IOException {
		
		if (p != null)
		{
			encoding.append("0");
			createEncodingTable(p.getLeft(), vectorString);
			encoding.deleteCharAt(encoding.length() - 1);
			

			if(p.isLeaf() == true)
			{
				System.out.print(((CharacterFrequency)p.getElement()).getCharacter() + "(" + (int)(((CharacterFrequency)p.getElement()).getCharacter()) + ") ");
				System.out.print(encoding);
				System.out.println();
				String[] temp = {Character.toString((((CharacterFrequency)p.getElement()).getCharacter())), encoding.toString()};
				vectorString.add(temp);
			}
			
			//encoding.deleteCharAt(encoding.length() - 1);
			encoding.append("1");
			createEncodingTable(p.getRight(), vectorString);
			encoding.deleteCharAt(encoding.length() - 1);
		}
		return vectorString;
	}

	public void preOrder(BTreeNode<T> p) {
		if (p != null)
		{
			System.out.print(p.getElement().toString());
			preOrder(p.getLeft());
			preOrder(p.getRight());
		}
	}

	public void postOrder(BTreeNode<T> p) {
		if (p != null)
		{
			postOrder(p.getLeft());
			postOrder(p.getRight());
			System.out.print(p.getElement().toString());
		}
	}

}
