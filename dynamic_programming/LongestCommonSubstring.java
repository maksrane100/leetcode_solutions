package com.exercises.interview;

/*
 * Longest common substring. 
 * 
 * Uses tabulation of dynamic programming. 
 */
public class LongestCommonSubstring {

	public static String findLCS(String S1, String S2, int m, int n)
    {
        int maxLength = 0;         
        int endIndex = m;    // end index of LCS in S1
 
        int[][] DP = new int[m + 1][n + 1];
 
        // bottom-up fashion dynamic programming
        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                // if the current character of S1 and S2 matches
                if (S1.charAt(i - 1) == S2.charAt(j - 1))
                {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
 
                    // update the maximum length and ending index
                    if (DP[i][j] > maxLength)
                    {
                        maxLength = DP[i][j];
                        endIndex = i;
                    }
                }
            }
        }
 
        return S1.substring(endIndex - maxLength, endIndex);
    }
 
    public static void main(String[] args)
    {
        String string1 = "SOMANYBEUTIFULFLOWERS";
        String string2 = "MANYFLOWERS";
        
        int m = string1.length();
        int n = string2.length();
 
        String lcsString = findLCS(string1, string2, m, n);
        
        System.out.print("Longest common substring : "
                        + lcsString);
    }
}
