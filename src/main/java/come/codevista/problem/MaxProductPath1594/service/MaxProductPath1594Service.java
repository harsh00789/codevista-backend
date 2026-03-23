package come.codevista.problem.MaxProductPath1594.service;

import come.codevista.problem.MaxProductPath1594.model.Explanation;
import come.codevista.problem.MaxProductPath1594.model.MaxProductPathSteps;
import come.codevista.problem.MaxProductPath1594.model.ProblemDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MaxProductPath1594Service {

    public Map<String, Object> maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;
        long dp[][][] = new long[m][n][2];

        List<MaxProductPathSteps> steps = new ArrayList<>();

        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        MaxProductPathSteps initialStep = new MaxProductPathSteps("Start", 0, 0, dp[0][0][0], dp[0][0][1]);


        steps.add(initialStep);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                long upMin = Long.MAX_VALUE;
                long upMax = Long.MIN_VALUE;
                if (i - 1 >= 0) {
                    long first = (dp[i - 1][j][0] * grid[i][j]);
                    long second = (dp[i - 1][j][1] * grid[i][j]);

                    upMin = Math.min(first, second);
                    upMax = Math.max(first, second);
                }

                long downMin = Long.MAX_VALUE;
                long downMax = Long.MIN_VALUE;
                if (j - 1 >= 0) {
                    long first = (dp[i][j - 1][0] * grid[i][j]);
                    long second = (dp[i][j - 1][1] * grid[i][j]);
                    downMin = Math.min(first, second);
                    downMax = Math.max(first, second);
                }

                dp[i][j][0] = Math.min(upMin, downMin);
                dp[i][j][1] = Math.max(upMax, downMax);

                MaxProductPathSteps step = new MaxProductPathSteps("Step", i, j, upMin, upMax, downMin, downMax, dp[i][j][0], dp[i][j][1]);
                steps.add(step);

            }
        }


        int answer = (int) ((dp[m - 1][n - 1][1] < 0 ? -1 : dp[m - 1][n - 1][1]) % mod);


        ProblemDetails problemDetails = new ProblemDetails("leetcode","1594","https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/description/","Medium","Matrix");

         List<String> story = List.of(
                "A traveler moves through a grid carrying two briefcases: one Gold (max) and one Lead (min).",
                "At every cell, the traveler must decide which briefcase to fill based on the multipliers they find.",
                "Positive multipliers grow the Gold briefcase, but negative multipliers are the trickiest.",
                "A negative multiplier can turn a heavy Lead briefcase (a large negative) into a mountain of Gold.",
                "The traveler always keeps track of both extremes to ensure no opportunity is missed.",
                "At the end of the journey, if the Gold briefcase is still empty (negative), they return -1."
        );

         List<String> explanation = List.of(
                "DP State: We use a 3D array dp[m][n][2] where [0] is the minimum product and [1] is the maximum.",
                "Tracking Min/Max: We track the minimum because multiplying a large negative by another negative yields a large positive.",
                "Transition: For each cell (i, j), we calculate four products: (upMax * current), (upMin * current), (leftMax * current), and (leftMin * current).",
                "Updating: We set dp[i][j][1] to the maximum of those four, and dp[i][j][0] to the minimum.",
                "Time Complexity: O(M * N) as we visit every cell in the grid exactly once.",
                "Space Complexity: O(M * N) for the DP table, though this can be optimized to O(N).",
                "Final Check: We return the max product modulo 10^9+7, returning -1 if the best possible path is negative."
        );
        String mySolution = """
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;
        long dp[][][] = new long[m][n][2];
        
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) continue;

                long upMin = Long.MAX_VALUE, upMax = Long.MIN_VALUE;
                if(i - 1 >= 0) {
                    long first = dp[i-1][j][0] * grid[i][j];
                    long second = dp[i-1][j][1] * grid[i][j];
                    upMin = Math.min(first, second);
                    upMax = Math.max(first, second);
                }

                long downMin = Long.MAX_VALUE, downMax = Long.MIN_VALUE;
                if(j - 1 >= 0) {
                    long first = dp[i][j-1][0] * grid[i][j];
                    long second = dp[i][j-1][1] * grid[i][j];
                    downMin = Math.min(first, second);
                    downMax = Math.max(first, second);
                }

                dp[i][j][0] = Math.min(upMin, downMin);
                dp[i][j][1] = Math.max(upMax, downMax);
            }
        }
        
        long res = dp[m-1][n-1][1];
        return (int)(res < 0 ? -1 : res % mod);
    }
    """;
         String timeComplexity = "O(MXN)";
        String spaceComplexity = "O(MXN)";

        Explanation exp = new Explanation(story,explanation,mySolution,timeComplexity,spaceComplexity);

        return Map.of("steps", steps, "answer", answer,
        "problemDetails",problemDetails,
            "explanation",exp    );
    }
}
