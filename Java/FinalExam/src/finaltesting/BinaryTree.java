package finaltesting;
class Node
{
	int key;
	Node left, right;
	Node(int item)
	{
		key=item;
		left=null;
		right=null;
	}
}
class BinaryTree 
{
	Node root;
	BinaryTree(int key)
	{
		root=new Node(key);
	}
	BinaryTree()
	{
		root=null;
	}
	
	void PreOrder(Node node)
	{
		if(node==null)
			return;
		System.out.print(node.key + " ");
		PreOrder(node.left);
		PreOrder(node.right);
	}
	
	void PostOrder(Node node)
	{
		if(node==null)
			return;
		PostOrder(node.left);
		PostOrder(node.right);
		System.out.print(node.key + " ");
	}

	
	void InOrder(Node node)
	{
		if(node==null)
			return;
		InOrder(node.left);
		System.out.print(node.key + " ");
		InOrder(node.right);
	}
	
	void InOrder() {InOrder(root);}
	void PreOrder() {PreOrder(root);}
	void PostOrder() {PostOrder(root);}
	
	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(44);
		
		tree.root.left = new Node(37);
		tree.root.right = new Node(94);
		tree.root.left.left = new Node(9);
		tree.root.left.right = new Node(9);
		tree.root.left.right = new Node(42);
		tree.root.left.left.right = new Node(31);
		tree.root.left.left.right.left = new Node(17);
		tree.root.left.left.right.right = new Node(36);
		
		tree.root.right.left= new Node(76);
		tree.root.right.left.left= new Node(70);
		
		System.out.println("Preorder traversal of binary tree is "); 
		tree.PreOrder(); 

		System.out.println("\nInorder traversal of binary tree is "); 
		tree.InOrder(); 

		System.out.println("\nPostorder traversal of binary tree is "); 
		tree.PostOrder(); 
		
	} 
} 