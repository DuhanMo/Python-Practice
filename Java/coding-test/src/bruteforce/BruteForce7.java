package bruteforce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1182
 * 부분 수열의 합
 */
public class BruteForce7 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N, S, ans;
    static int[] nums;


    static void input() {
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static void recFunc(int k, int sum) {
        if (k == N + 1) {
            if (S == sum) {
                ans++;
            }
        } else {
                recFunc(k + 1, sum + nums[k]);
                recFunc(k + 1, sum);
        }
    }

    public static void main(String[] args) {
        input();
        if (S == 0) {
            ans--;
        }
        recFunc(1, 0);
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
