public class Node{

	int val;
	Node left;
	Node right;
	int ht;
}


public Node insert(Node root, int newVal){

	if(newVal != root.val){
		
		if(newVal > root.val){

			if(root.right == null){

				Node n  = new Node();
				n.val = root.val;
				n.ht = root.ht + 1;
				root.right = n;

			}else{

				root = insert(root.right,int);

			}

		}else{

			if(root.left == null){

				Node n  = new Node();
				n.val = root.val;
				n.ht = root.ht + 1;
				root.left = n;

			}else{

				root = insert(root.left,int);

			}



		}
	}

	int leftHt = height(root.left);
	int rightHt = height(root.right);

	int factor = (leftHt - rightHt);

	if(factor < -1){ //right unbalanced
		rotateLeft(root);
	}else if(factor > 1){ //left unbalanced
		rotateRight(root);
	}

	return root;
}

public int height(Node node){
	if(node == null)
		return -1;
	else
		return 1 + Math.max(height(node.left),height(node.right));
}

public Node rotateRight(Node node){
	if(getHeight(node.right) > getHeight(node.left)){ //left right case
		node.left = rotateLeft(node.left);
	}

	//left left case
	Node temp = node;
	temp.left = node.left.right;
	node.left.right = temp;

	return node;
}

public Node rotateLeft(Node node){
	if(getHeight(node.right) < getHeight(node.left)){
		node.right = rotateRight(node.right);
	}

	Node tmp = node;
	temp.right = node.right.left;
	node.right.left = temp;

	return node;
}






