package bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 9663
 * N-Queen
 */
public class BruteForce6 {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int ans;
    static int[] col;

    static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) {
            return true;
        }
        if (r1 + c1 == r2 + c2) {
            return true;
        }
        if (r1 - c1 == r2 - c2) {
            return true;
        }
        return false;
    }

    static boolean validate() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (attackable(i, col[i], j, col[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static void recFunc(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean posssible = true;
                for (int i = 1; i <= row - 1; i++) {
                    if (attackable(row, c, i, col[i])) {
                        posssible = false;
                        break;
                    }
                }
                if (posssible) {
                    // row, c i,col[i]
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
        System.out.println(sb.append(ans).toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
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
