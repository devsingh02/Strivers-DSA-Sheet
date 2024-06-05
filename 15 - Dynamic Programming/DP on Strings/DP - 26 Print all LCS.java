// // Generic Method :- Print any one

// String giveAnyLCS(int m, int n, String str1, String str2, int[][] dp) {
//     String lcs = "";
//     while (m > 0 && n > 0) {
//         if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
//             lcs = str1.charAt(m - 1) + lcs;
//             m--; n--; // go to dp[m - 1][n - 1]
//         }
//         else { // go where max
//             if (dp[m - 1][n] >= dp[m][n - 1]) m--; // go up
//             else n--; // go left
//         }
//     }
//     return lcs;
// }


// Print all :-
import java.util.*;

public class PrintLCS {
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        String s1 = s, s2 = t;
        int m = s1.length(), n = s2.length();

        int[][] dp = makeLCStable(m, n, s1, s2);

        Set<String> ans = new HashSet<>();
        backtrack(m, n, s1, s2, dp, ans, "");

        List<String> Ans = new ArrayList<>(ans);
        Collections.sort(Ans);
        return Ans;
    }

    int[][] makeLCStable(int m, int n, String s1, String s2) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else  dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp;
    }

    void backtrack(int i, int j, String s1, String s2, int[][] dp, Set<String> ans, String curr) {
        if (i == 0 || j == 0) {
            ans.add(curr);
            return;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            backtrack(i - 1, j - 1, s1, s2, dp, ans, s1.charAt(i - 1) + curr);
        else {
            // takes both possibilities if equal
            if (dp[i - 1][j] >= dp[i][j - 1]) backtrack(i - 1, j, s1, s2, dp, ans, curr);
            if (dp[i - 1][j] <= dp[i][j - 1]) backtrack(i, j - 1, s1, s2, dp, ans, curr);

        }
    }

    public static void main(String[] args) {
        PrintLCS solution = new PrintLCS();
        String s1 = "abaaa";
        String s2 = "baabaca";
        List<String> result = solution.all_longest_common_subsequences(s1, s2);
        System.out.println("Longest Common Subsequences:");
        for (String seq : result) {
            System.out.println(seq);
        }
    }
}