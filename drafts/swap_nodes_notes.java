public class Node{
	
	private int value;
	Node parent;
	Node left;
	Node right;

	public Node(int value){
		this.value = value;		
	}

	public int getValue(){
		return value;
	}
	
}

public class Solution{

	Scanner scanner = new Scanner();

	Node tree = new Node(1);
	Queue<Node> childs = new Queue<>();

	public static void main(String[] args){
		
		int nrNodes = scanner.nextInt();
		childs.push(tree);

		while(!child.isEmpty()){
			loadChilds(child.pop());
		}

		
	}

	public static void loadChilds(Node parent){
		Node l = new Node(scanner.nextInt());
		Node r = new Node(scanner.nextInt());
		parent.left = l;
		parent.right = l;

		if(l.getValue() != -1){
			childs.push(l);
		}

		if(r.getValue() != -1){
			childs.push(r);
		}
	}