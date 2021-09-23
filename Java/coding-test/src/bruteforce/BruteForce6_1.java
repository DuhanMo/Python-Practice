package bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 9663
 * N-Queen
 */
public class BruteForce6_1 {

    static BruteForce6.FastReader scan = new BruteForce6.FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int ans;
    static int[] col;

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        else if (r1 + c1 == r2 + c2) return true;
        else if (r1 - c1 == r2 - c2) return true;
        return false;
    }

    static void recFunc(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++) {
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    recFunc(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1);
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
