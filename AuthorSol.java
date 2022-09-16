import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			HashMap<Integer, Integer> mp = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int x = fs.nextInt();
				mp.put(x, mp.getOrDefault(x, 0) + 1);
			}
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			for (Map.Entry<Integer, Integer> itr : mp.entrySet()) {
				pq.add(new Pair(itr.getValue(), itr.getKey()));
			}
			int size = n;
			while (pq.size() >= 2) {
				Pair p1 = pq.poll();
				Pair p2 = pq.poll();
				p1.first--;
				p2.first--;
				size -= 2;
				if (p1.first > 0) {
					pq.add(new Pair(p1.first, p1.second));
				}
				if (p2.first > 0) {
					pq.add(new Pair(p2.first, p2.second));
				}
			}
			out.println(size);
		}
		out.close();
	}
	
	static class Pair implements Comparable<Pair> {
		int first, second;
		
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		@Override
		public int compareTo(Pair o) {
			return Integer.compare(o.first, this.first);
		}
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
