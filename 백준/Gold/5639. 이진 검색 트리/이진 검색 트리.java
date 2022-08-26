import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node{
	
	int value;
	Node left;
	Node right;
	Node head;
	
	
	public Node() {
	}
	
	public Node(int element) {
		this.value = element;
	}
	
	void insert(int element) {
		Node cur = head;
		if(head == null) {
			head = new Node(element);
			return;
		}
		while(true) {
			if(element < cur.value) {
				if(cur.left == null) {
					cur.left = new Node(element);
					return;
				} else {
					cur = cur.left;
				}
			} else {
				if(cur.right == null) {
					cur.right = new Node(element);
					return;
				} else {
					cur = cur.right;
				}
			}
		}
	}
	
	void postorder_traverse(Node node) {
		if(node != null) {
			postorder_traverse(node.left);
			postorder_traverse(node.right);
			System.out.println(node.value);
		}
	}
}


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node node = new Node();
		String num = "";
		while((num = br.readLine()) != null) {
			node.insert(Integer.parseInt(num));
		}
		node.postorder_traverse(node.head);
	}

}