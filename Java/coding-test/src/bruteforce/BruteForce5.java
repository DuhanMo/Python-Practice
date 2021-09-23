package bruteforce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 14888
 * 연산자 끼워넣기
 * 중복x 순열
 */
public class BruteForce5 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int min;
    static int max;
    static int[] nums;
    static int[] order;
    static int[] operators;

    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
        }
    }

    static int calculate(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        } else if (operator == 2) {
            return operand1 - operand2;
        } else if (operator == 3) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    static void recFunc(int k, int value) {
        if (k == N) {
            //order배열을 끼워넣어 계산한 결과를 반환받아 최대 최소를 고른다.
//            int value = calculate();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    int newValue = calculate(value, cand, nums[k + 1]);
                    recFunc(k + 1, newValue);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        recFunc(1, nums[1]);
        System.out.println((sb.append(max).append("\n").append(min).toString()));
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
