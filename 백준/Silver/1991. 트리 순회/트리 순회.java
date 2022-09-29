import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		String value;
		Node left;
		Node right;

		public Node(String value) {
			// TODO Auto-generated constructor stub
			this.value = value;
		}
	}

	static class TreeOrder {
		Node root;

		public void createNode(String value, String leftValue, String rightValue) {
			if (root == null) {
				root = new Node(value);
				if (!leftValue.equals(".")) {
					root.left = new Node(leftValue);
				}
				if (!rightValue.equals(".")) {
					root.right = new Node(rightValue);
				}
			} else {
				searchNode(root.left, value, leftValue, rightValue);
				searchNode(root.right, value, leftValue, rightValue);
			}
		}

		public void searchNode(Node node, String value, String leftValue, String rightValue) {
			if (node == null)
				return;

			if (node.value.equals(value)) {
				if (!leftValue.equals(".")) {
					node.left = new Node(leftValue);
				}
				if (!rightValue.equals(".")) {
					node.right = new Node(rightValue);
				}
			} else {
				searchNode(node.left, value, leftValue, rightValue);
				searchNode(node.right, value, leftValue, rightValue);
			}
		}
		
		public void preOrder(Node node) {
			if(node != null) {
				System.out.print(node.value);
				preOrder(node.left);
				preOrder(node.right);
			}
		}
		
		public void inOrder(Node node) {
			if(node != null) {
				inOrder(node.left);
				System.out.print(node.value);
				inOrder(node.right);
			}
		}
		
		public void postOrder(Node node) {
			if(node != null) {
				postOrder(node.left);
				postOrder(node.right);
				System.out.print(node.value);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		TreeOrder tr = new TreeOrder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			String l = st.nextToken();
			String r = st.nextToken();
			tr.createNode(p, l, r);

		}
		
		tr.preOrder(tr.root);
		System.out.println();
		tr.inOrder(tr.root);
		System.out.println();
		tr.postOrder(tr.root);
		System.out.println();

	
	}

}