class Solution {

    static final int MOD = 1000000007;
    public int countPalindromes(String s) {

        int n = s.length();

        long[][] left = new long[10][10];
        long[][] right = new long[10][10];

        long[] leftCount = new long[10];
        long[] rightCount = new long[10];

        for (int i = n - 1; i >= 0; i--) {

            int d = s.charAt(i) - '0';

            for (int a = 0; a < 10; a++) {
                right[d][a] =
                    (right[d][a] + rightCount[a]) % MOD;
            }

            rightCount[d]++;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            int d = s.charAt(i) - '0';

            rightCount[d]--;

            for (int a = 0; a < 10; a++) {
                right[d][a] =
                    (right[d][a] - rightCount[a] + MOD) % MOD;
            }

            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {

                    ans = (ans +
                           left[a][b] * right[b][a]) % MOD;
                }
            }
            for (int a = 0; a < 10; a++) {
                left[a][d] =
                    (left[a][d] + leftCount[a]) % MOD;
            }

            leftCount[d]++;
        }

        return (int) ans;
    }
}