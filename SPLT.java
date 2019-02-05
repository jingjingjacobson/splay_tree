package SPLT_A4;
public class SPLT implements SPLT_Interface {
	private BST_Node root;

	int size;

	public SPLT(){
		size = 0;
		root = null;

	}

	@Override
	//used for testing, please leave as is
	public BST_Node getRoot(){
		return root;
	}

	private void reRoot() {
		while(root != null && root.parent != null) 
		{
			root = root.parent ;
		}
	}

	@Override
	public void insert(String s) { //It was me
		// TODO Auto-generated method stub
		if (empty()) {
			root = new BST_Node(s);
			size += 1;
			reRoot();
			return;
		}

		if (contains(s)) {
			return;
		} else {
			size += 1;
			root.insertNode(s);
			reRoot();
			return;
		}
	}

	@Override
	public void remove(String s) {  //DIO
		// TODO Auto-generated method stub
		if (!contains(s)) {
			return;
		} else {
			if (root.data.equals(s) && size == 1) {
				root = null;
				size -= 1;
				return;
			} 
			else if(root.left == null) {
				BST_Node right = root.right;
				right.parent = null;
				root = right;
				size -= 1;
				return;
			}
			else {
				BST_Node left = root.left;
				BST_Node right = root.right;
				if(right != null) right.parent = null;

				left.parent = null;
				left = left.findMax();

				left.right = right;
				
				if(right != null) right.parent = left;
				root = left;
				size -= 1;

				return;
			}
		}
	}

	@Override
	public String findMin() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			String rtn = root.findMin().data;
			reRoot();
			return rtn;
		}
	}

	@Override
	public String findMax() {
		// TODO Auto-generated method stub
		if (empty()) {
			return null;
		} else {
			String rtn = root.findMax().data;
			reRoot();
			return rtn;
		}
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(String s) {
		// TODO Auto-generated method stub
		if (empty()) {
			return false;
		}

		boolean rtn = root.containsNode(s);
		reRoot();
		return rtn;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		if (empty()) {
			return -1;
		} else {
			return root.getHeight();
		}
	}
}

/*
 * package SPLT_A4;

public class SPLT implements SPLT_Interface{
  private BST_Node root;
  private int size;

  public SPLT() {
    this.size = 0;
  } 

  public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
    return root;
  }  

}
 */