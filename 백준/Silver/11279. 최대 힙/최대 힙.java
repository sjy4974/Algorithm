import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class MaxHeap {
	int[] heap;
	int size;

	public MaxHeap() {
		heap = new int[10];
		size = 0;
	}

	private void resize() {
		int newLength = size * 2;

		this.heap = Arrays.copyOf(heap, newLength);
	}

	public void insert(int element) {
		if (size == 0) {
			heap[++size] = element;
			return;
		}
		if (size + 1 == heap.length) {
			resize();
		}

		heap[++size] = element;
		int temp = size;
		if (heap[temp] > heap[temp / 2]) {
			while (temp > 1 && heap[temp] > heap[temp / 2]) {
				swap(temp, temp / 2);
				temp /= 2;
			}
		}

	}

	public int remove() {
		int res = heap[1];
		heap[1] = heap[size];
		heap[size--] = 0;
		int temp = 1;
		while (true) {
			int child = temp * 2;
			if (child + 1 <= size && heap[child] < heap[child + 1]) {
				child = child + 1;
			}

			if (child > size)
				break;

			if (heap[temp] > heap[child])
				break;

			swap(temp, child);
			temp = child;

		}

		return res;

	}

	public void swap(int a, int b) {
		int temp = heap[a];
		this.heap[a] = heap[b];
		this.heap[b] = temp;
	}

	public int size() {
		return this.size;
	}

	public void print() {
		System.out.println(Arrays.toString(this.heap));
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		MaxHeap maxHeap = new MaxHeap();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp != 0) {
				maxHeap.insert(temp);
			} else {
				if (maxHeap.size() == 0) {
					System.out.println(0);
				} else {
					System.out.println(maxHeap.remove());
				}
			}
		}

	}

}