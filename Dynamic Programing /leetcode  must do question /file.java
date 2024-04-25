/*
 * This curated list provides beginner-friendly dynamic programming (DP) problems grouped by patterns, along with sample solutions. Problems cover various DP concepts like longest increasing subsequence, partition subset, bitmasking, longest common subsequence, palindrome, coin change, matrix operations, hash + DP, state machine, DFS + DP, minimax DP, and miscellaneous problems. Each group offers a set of LeetCode Medium and Hard problems with solutions, serving as a structured roadmap for DP practice. By focusing on specific problem patterns, beginners can grasp common DP techniques and gradually improve their problem-solving skills. This resource offers a valuable opportunity for learners to hone their DP abilities effectively.

Longest Increasing Subsequence
https://leetcode.com/problems/longest-increasing-subsequence/
https://leetcode.com/problems/largest-divisible-subset/
https://leetcode.com/problems/russian-doll-envelopes/
https://leetcode.com/problems/maximum-length-of-pair-chain/
https://leetcode.com/problems/number-of-longest-increasing-subsequence/
https://leetcode.com/problems/delete-and-earn/
https://leetcode.com/problems/longest-string-chain/

class Solution {
    public:
       int lengthOfLIS(vector<int>& nums) {
       int n = nums.size();
    vector<int> LIS(n, 1);

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                LIS[i] = max(LIS[i], 1 + LIS[j]);
            }
        }
    }

    int maxLength = 0;
    for (int i = 0; i < n; i++) {
        maxLength = max(maxLength, LIS[i]);
    }

    return maxLength;
}
};

Top-Down Dynamic Programming Approach:
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> memo(n, -1); // Memoization array to store calculated results
        
        // Call recursive function with starting index 0
        return LIS(nums, -1, 0, memo);
    }
    
    int LIS(vector<int>& nums, int prevIndex, int currentIndex, vector<int>& memo) {
        if (currentIndex == nums.size())
            return 0;
        
        if (memo[currentIndex] != -1)
            return memo[currentIndex];
        
        int takeCurrent = 0;
        if (prevIndex == -1 || nums[currentIndex] > nums[prevIndex]) {
            takeCurrent = 1 + LIS(nums, currentIndex, currentIndex + 1, memo);
        }
        
        int skipCurrent = LIS(nums, prevIndex, currentIndex + 1, memo);
        
        return memo[currentIndex] = max(takeCurrent, skipCurrent);
    }
};
Bottom-Up Dynamic Programming Approach:
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> LIS(n, 1); // Initialize LIS array with 1 as each element itself forms a subsequence of length 1
        
        // Bottom-Up Dynamic Programming
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    LIS[i] = max(LIS[i], 1 + LIS[j]);
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, LIS[i]);
        }
        
        return ans;
    }
};
Partition Subset Sum:
https://leetcode.com/problems/partition-equal-subset-sum/
https://leetcode.com/problems/last-stone-weight-ii/

class Solution {
     public:
    bool canPartition(vector<int>& nums) {

	int n = nums.size();

	int sum = 0;
	for (int i = 0; i < n; i++)
		sum += nums[i];

	if (sum % 2 != 0) return false;

	int target = sum/2;
	vector<bool>dp(target+1, false);

	dp[0] = true;
	for (int i = 0; i < n; i++) {
		for (int j = target; j >= nums[i]; j--) {
			dp[j] = dp[j] | dp[j - nums[i]];
		}
	}

	return dp[target];
  }
};
Top-down approach (Recursion with Memoization):
class Solution {
 public:
   int lengthOfLIS(vector<int>& nums) {
    // Initialize a memoization table with -1
    vector<vector<int>> memo(nums.size() + 1, vector<int>(nums.size(), -1));
    return lengthOfLIS(nums, -1, 0, memo);
 }

int lengthOfLIS(vector<int>& nums, int prevIndex, int currentIndex, vector<vector<int>>& memo) {
    if (currentIndex == nums.size())
        return 0;

    // Check if the result for current index and previous index is already calculated
    if (memo[prevIndex + 1][currentIndex] >= 0)
        return memo[prevIndex + 1][currentIndex];

    int taken = 0;
    if (prevIndex < 0 || nums[currentIndex] > nums[prevIndex])
        taken = 1 + lengthOfLIS(nums, currentIndex, currentIndex + 1, memo);

    int notTaken = lengthOfLIS(nums, prevIndex, currentIndex + 1, memo);

    // Store the result in memoization table
    memo[prevIndex + 1][currentIndex] = max(taken, notTaken);
    return memo[prevIndex + 1][currentIndex];
  }
};

// Example usage:
int main() {
Solution sol;
vector<int> nums = {10, 9, 2, 5, 3, 7, 101, 18};
int lis_length = sol.lengthOfLIS(nums);
return 0;
}
Bottom-up approach (Dynamic Programming):
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return 0;

        // Initialize an array to store the length of LIS ending at each index
        vector<int> dp(n, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = max(dp[i], 1 + dp[j]);
                }
            }
        }

        // Find the maximum length among all the LIS
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = max(maxLength, dp[i]);
        }

        return maxLength;
    }
};

// Example usage:
int main() {
    Solution sol;
    vector<int> nums = {10, 9, 2, 5, 3, 7, 101, 18};
    int lis_length = sol.lengthOfLIS(nums);
    return 0;
}

BitMasking in DP:
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

class Solution {
     int dp[(1<<16) + 2];
  public:
     bool canPartitionKSubsets(vector<int>& nums, int k) {

	int n = nums.size();

	fill(dp, dp+(1<<16)+2, -1);

	int sum = 0;
	for (int i = 0; i < n; i++)
		sum += nums[i];

	if (sum % k != 0) return false;

	int target = sum/k;

	dp[0] = 0;
	for (int mask = 0; mask < (1<<n); mask++) {
		if (dp[mask] == -1) continue;
		for (int i = 0; i < n; i++) {
			if (!(mask & (1 << i)) && dp[mask] + nums[i] <= target)
				dp[mask | (1 << i)] = (dp[mask] + nums[i]) % target;
		}
	}

	return dp[(1<<n)-1] == 0;
    }
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    int dp[(1<<16) + 2]; // Memoization table
    
    bool canPartition(vector<int>& nums, int k, int mask, int target) {
        if (dp[mask] != -1) return dp[mask];
        if (k == 1) return true; // Base case: only one subset remaining
        
        int n = nums.size();
        dp[mask] = 0; // Initialize the current state
        
        for (int i = 0; i < n; ++i) {
            if (!(mask & (1 << i)) && canPartition(nums, k, mask | (1 << i), (dp[mask] + nums[i]) % target)) {
                dp[mask] = 1;
                break;
            }
        }
        
        return dp[mask];
    }
    
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        int n = nums.size();
        memset(dp, -1, sizeof(dp)); // Initialize memoization table
        
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        if (sum % k != 0) return false;
        
        int target = sum / k;
        
        return canPartition(nums, k, 0, target);
    }
};

Bottom-up approach (Dynamic Programming):
class Solution {
public:
    bool canPartitionKSubsets(vector<int>& nums, int k) {
        int n = nums.size();
        int dp[(1<<16) + 2]; // Memoization table
        memset(dp, -1, sizeof(dp)); // Initialize memoization table
        
        int sum = 0;
        for (int num : nums)
            sum += num;
        
        if (sum % k != 0) return false;
        
        int target = sum / k;
        dp[0] = 0;
        
        for (int mask = 0; mask < (1 << n); ++mask) {
            if (dp[mask] == -1) continue;
            
            for (int i = 0; i < n; ++i) {
                if (!(mask & (1 << i)) && dp[mask] + nums[i] <= target) {
                    dp[mask | (1 << i)] = (dp[mask] + nums[i]) % target;
                }
            }
        }
        
        return dp[(1 << n) - 1] == 0;
    }
};

Longest Common Subsequence
https://leetcode.com/problems/longest-common-subsequence/
https://leetcode.com/problems/edit-distance/
https://leetcode.com/problems/distinct-subsequences/
https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/

class Solution {
	int longestCommonSubsequenceUtil(string text1, string text2, int n, int m) {
		if (n == 0 || m == 0)
			return 0;

		vector<vector<int>>L(n+1, vector<int>(m+1, 0));

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (text1[i-1] == text2[j-1])
					L[i][j] = 1 + L[i-1][j-1];
				else
					L[i][j] = max(L[i][j-1], L[i-1][j]);
			}
		}

		return L[n][m];
	}

public:
	int longestCommonSubsequence(string text1, string text2) {
		int n = text1.size();
		int m = text2.size();

		return longestCommonSubsequenceUtil(text1, text2, n, m);
	}
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    unordered_map<string, int> memo;

    int longestCommonSubsequenceUtil(string& text1, string& text2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        string key = to_string(n) + "|" + to_string(m);
        if (memo.find(key) != memo.end())
            return memo[key];

        int result;
        if (text1[n - 1] == text2[m - 1])
            result = 1 + longestCommonSubsequenceUtil(text1, text2, n - 1, m - 1);
        else
            result = max(longestCommonSubsequenceUtil(text1, text2, n, m - 1), longestCommonSubsequenceUtil(text1, text2, n - 1, m));

        memo[key] = result;
        return result;
    }

public:
    int longestCommonSubsequence(string text1, string text2) {
        int n = text1.size();
        int m = text2.size();

        return longestCommonSubsequenceUtil(text1, text2, n, m);
    }
};
Bottom-up approach (Dynamic Programming):
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int n = text1.size();
        int m = text2.size();

        vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (text1[i - 1] == text2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[n][m];
    }
};
Palindrome:
https://leetcode.com/problems/palindrome-partitioning-ii/
https://leetcode.com/problems/palindromic-substrings/

class Solution {
public:
	int minCut(string s) {

		int n = s.length();

		int res[n];
		bool P[n][n];

		for (int i = 0; i < n; i++)
			P[i][i] = true;


		for (int L = 2; L <= n; L++) {
			for (int i = 0; i < n-L+1; i++) {
				int j = i+L-1;

				if (L == 2) {
					P[i][j] = (s[i] == s[j]);
				} else {
					P[i][j] = (s[i] == s[j]) && P[i+1][j-1];
				}
			}
		}

		for (int i = 0; i < n; i++) {
			if (P[0][i])
				res[i] = 0;
			else {
				res[i] = INT_MAX;
				for (int j = 0; j < i; j++) {
					if (P[j+1][i] && res[i] > 1 + res[j])
						res[i] = 1+res[j];
				}
			}
		}

		return res[n-1] == INT_MAX ? 1 : res[n-1];
	}
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    vector<vector<bool>> isPalindrome;
    vector<int> dp;

    bool isPalindromic(string& s, int start, int end) {
        if (start >= end) return true;
        if (isPalindrome[start][end]) return true;
        if (s[start] == s[end]) {
            isPalindrome[start][end] = isPalindromic(s, start + 1, end - 1);
            return isPalindrome[start][end];
        }
        return false;
    }

    int minCutUtil(string& s, int start) {
        if (start >= s.length()) return -1;
        if (dp[start] != -1) return dp[start];

        int minCuts = INT_MAX;
        for (int end = start; end < s.length(); ++end) {
            if (isPalindromic(s, start, end)) {
                int cuts = minCutUtil(s, end + 1);
                minCuts = min(minCuts, cuts + 1);
            }
        }

        return dp[start] = minCuts;
    }

public:
    int minCut(string s) {
        int n = s.length();
        if (n <= 1) return 0;

        isPalindrome.assign(n, vector<bool>(n, false));
        dp.assign(n, -1);

        return minCutUtil(s, 0);
    }
};
Bottom-up approach (Dynamic Programming):
class Solution {
public:
    int minCut(string s) {
        int n = s.length();
        if (n <= 1) return 0;

        vector<vector<bool>> isPalindrome(n, vector<bool>(n, false));
        vector<int> dp(n, INT_MAX);

        for (int end = 0; end < n; ++end) {
            for (int start = 0; start <= end; ++start) {
                if (s[start] == s[end] && (end - start <= 2 || isPalindrome[start + 1][end - 1])) {
                    isPalindrome[start][end] = true;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (isPalindrome[j + 1][i] && dp[j] != INT_MAX) {
                        dp[i] = min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[n - 1];
    }
};
Coin Change:
https://leetcode.com/problems/coin-change/
https://leetcode.com/problems/coin-change-2/
https://leetcode.com/problems/combination-sum-iv/
https://leetcode.com/problems/perfect-squares/
https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution {
public:
	int coinChange(vector<int>& coins, int amount) {

		int n = coins.size();
		if (n == 0) return 0;

		vector<int>res(amount+1, INT_MAX);

		res[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j =  coins[i]; j <= amount; j++) {
				if (res[j-coins[i]] != INT_MAX)
					res[j] = min(res[j], 1+res[j-coins[i]]);
			}
		}

		return res[amount] != INT_MAX ? res[amount] : -1;
	}
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    int coinChangeUtil(vector<int>& coins, int amount, vector<int>& dp) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (dp[amount] != 0) return dp[amount];

        int minCoins = INT_MAX;
        for (int coin : coins) {
            int res = coinChangeUtil(coins, amount - coin, dp);
            if (res >= 0) {
                minCoins = min(minCoins, res + 1);
            }
        }

        return dp[amount] = (minCoins == INT_MAX) ? -1 : minCoins;
    }

public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, 0);
        return coinChangeUtil(coins, amount, dp);
    }
};
Bottom-up approach (Dynamic Programming):
class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount + 1, INT_MAX);
        dp[0] = 0;

        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != INT_MAX) {
                    dp[i] = min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] == INT_MAX ? -1 : dp[amount];
    }
};
Matrix multiplication:
https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
https://leetcode.com/problems/burst-balloons/

class Solution {
public:
	int minScoreTriangulation(vector<int>& A) {

		int n = A.size();        
		vector<vector<int>>dp(n, vector<int>(n, 0));

		for (int L = 2; L <= n; L++) {
			for (int i = 0; i+L < n; i++) {
				int j = i+L;
				dp[i][j] = INT_MAX;
				for (int k = i+1; k < j; k++) {
					dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + A[i]*A[k]*A[j]);
				}
			}
		}

		return dp[0][n-1];
	}
};
Here are the implementations of the Matrix Multiplication problem using both top-down and bottom-up dynamic programming approaches.

Top-down approach (Recursion with Memoization):
class Solution {
private:
    int minScoreTriangulationUtil(vector<int>& A, int i, int j, vector<vector<int>>& dp) {
        if (j - i < 2) return 0;
        if (dp[i][j] != 0) return dp[i][j];

        int minScore = INT_MAX;
        for (int k = i + 1; k < j; ++k) {
            minScore = min(minScore,
                           minScoreTriangulationUtil(A, i, k, dp) +
                           minScoreTriangulationUtil(A, k, j, dp) +
                           A[i] * A[k] * A[j]);
        }

        return dp[i][j] = minScore;
    }

public:
    int minScoreTriangulation(vector<int>& A) {
        int n = A.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        return minScoreTriangulationUtil(A, 0, n - 1, dp);
    }
};
Bottom-up approach (Dynamic Programming):
class Solution {
public:
    int minScoreTriangulation(vector<int>& A) {
        int n = A.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));

        for (int L = 2; L < n; ++L) {
            for (int i = 0; i + L < n; ++i) {
                int j = i + L;
                dp[i][j] = INT_MAX;
                for (int k = i + 1; k < j; ++k) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                }
            }
        }

        return dp[0][n - 1];
    }
};
Matrix/2D Array:
https://leetcode.com/problems/matrix-block-sum/
https://leetcode.com/problems/range-sum-query-2d-immutable/
https://leetcode.com/problems/dungeon-game/
https://leetcode.com/problems/triangle/
https://leetcode.com/problems/maximal-square/
https://leetcode.com/problems/minimum-falling-path-sum/

class Solution {
public:
	vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int K) {


		int m = mat.size();
		int n = mat[0].size();

		vector<vector<int>>sum(m+1, vector<int>(n+1, 0));
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + mat[i-1][j-1];
			}
		}

		vector<vector<int>>res(m, vector<int>(n, 0));
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int r1 = max(0, i-K); int c1 = max(0, j-K);
				int r2 = min(m-1, i+K); int c2 = min(n-1, j+K);
				r1++; r2++;
				c1++; c2++;
				res[i][j] = sum[r2][c2] - (sum[r2][c1-1] + sum[r1-1][c2]- sum[r1-1][c1-1]);
			}
		}

		return res;
	}
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    vector<vector<int>> dp;

    int getSum(vector<vector<int>>& mat, int i, int j, int m, int n, int K) {
        int r1 = max(0, i - K), c1 = max(0, j - K);
        int r2 = min(m - 1, i + K), c2 = min(n - 1, j + K);
        return dp[r2 + 1][c2 + 1] - dp[r2 + 1][c1] - dp[r1][c2 + 1] + dp[r1][c1];
    }

public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int K) {
        int m = mat.size(), n = mat[0].size();
        dp.resize(m + 1, vector<int>(n + 1, 0));

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        vector<vector<int>> res(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res[i][j] = getSum(mat, i, j, m, n, K);
            }
        }

        return res;
    }
};
Bottom-up approach (Dynamic Programming):
class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int K) {
        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        vector<vector<int>> res(m, vector<int>(n, 0));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int r1 = max(0, i - K), c1 = max(0, j - K);
                int r2 = min(m - 1, i + K), c2 = min(n - 1, j + K);
                res[i][j] = dp[r2 + 1][c2 + 1] - dp[r2 + 1][c1] - dp[r1][c2 + 1] + dp[r1][c1];
            }
        }

        return res;
    }
};
Hash + DP:
https://leetcode.com/problems/target-sum/
https://leetcode.com/problems/longest-arithmetic-sequence/
https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/

class Solution {
public:
	int findTargetSumWays(vector<int>& nums, int S) {
		int n = nums.size();
		unordered_map<int, int>hm;

		hm[0] = 1;
		for (int i = 0; i < n; i++) {
			auto mp = hm;
			hm.clear();

			for (auto it = mp.begin(); it != mp.end(); it++) {
				hm[it->first + nums[i]] += it->second;
				hm[it->first - nums[i]] += it->second;

			}
		}

		return hm[S];
	}
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    int findTargetSumWaysUtil(vector<int>& nums, int S, int index, unordered_map<int, int>& memo) {
        if (index == nums.size()) {
            if (S == 0) return 1;
            else return 0;
        }

        int positive = findTargetSumWaysUtil(nums, S - nums[index], index + 1, memo);
        int negative = findTargetSumWaysUtil(nums, S + nums[index], index + 1, memo);

        memo[S] = positive + negative;
        return memo[S];
    }

public:
    int findTargetSumWays(vector<int>& nums, int S) {
        unordered_map<int, int> memo;
        return findTargetSumWaysUtil(nums, S, 0, memo);
    }
};
Bottom-up approach (Dynamic Programming):
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int S) {
        unordered_map<int, int> dp;
        dp[0] = 1;

        for (int num : nums) {
            unordered_map<int, int> temp;
            for (auto& kv : dp) {
                temp[kv.first + num] += kv.second;
                temp[kv.first - num] += kv.second;
            }
            dp = temp;
        }

        return dp[S];
    }
};
State machine:
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

class Solution {
public:
	int maxProfit(vector<int>& prices, int fee) {

		int n = prices.size();
		vector<int>buy(n, 0);
		vector<int>sell(n, 0);

		buy[0] = -prices[0], sell[0] = 0;
		for (int i = 1; i < n; i++) {
			buy[i] = max(buy[i-1], sell[i-1]-prices[i]);
			sell[i] = max(sell[i-1], buy[i-1]+prices[i]-fee);
		}

		return sell[n-1];
	}
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    int maxProfitUtil(vector<int>& prices, int index, int bought, vector<vector<int>>& memo) {
        if (index >= prices.size()) return 0;

        if (memo[index][bought] != INT_MIN) return memo[index][bought];

        // If we have bought a stock, we can either sell it or do nothing
        if (bought) {
            int sell = prices[index] + maxProfitUtil(prices, index + 1, 0, memo);
            int not_sell = maxProfitUtil(prices, index + 1, 1, memo);
            return memo[index][bought] = max(sell, not_sell);
        } else {
            // If we haven't bought a stock, we can either buy it or do nothing
            int buy = -prices[index] + maxProfitUtil(prices, index + 1, 1, memo);
            int not_buy = maxProfitUtil(prices, index + 1, 0, memo);
            return memo[index][bought] = max(buy, not_buy);
        }
    }

public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        vector<vector<int>> memo(n + 1, vector<int>(2, INT_MIN));
        return maxProfitUtil(prices, 0, 0, memo);
    }
};

Bottom-up approach:
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if (n == 0) return 0;

        // Initializing the variables for the last day.
        int buy = -prices[0], sell = 0;

        for (int i = 1; i < n; ++i) {
            // For each day, we calculate the maximum profit if we have bought or sold on the previous day.
            buy = max(buy, -prices[i]); // The maximum profit of buying a stock.
            sell = max(sell, buy + prices[i]); // The maximum profit of selling a stock.
        }

        return sell;
    }
};

Depth First Search +DP:
https://leetcode.com/problems/out-of-boundary-paths/
https://leetcode.com/problems/knight-probability-in-chessboard/

class Solution {
	int mod = 1000000007;
	int dfs(int m, int n, int N, int r, int c,  vector<vector<vector<int>>>& dp) {
		if (r < 0 || c < 0 || r >= m || c >= n) return 1;
		if (N == 0) return 0;
		if (dp[N][r][c] != -1) return dp[N][r][c]%mod;

		int moves = 0;
		moves =  (moves + dfs(m, n, N-1, r, c+1, dp))%mod;
		moves =  (moves + dfs(m, n, N-1, r, c-1, dp))%mod;
		moves =  (moves + dfs(m, n, N-1, r+1, c, dp))%mod;
		moves =  (moves + dfs(m, n, N-1, r-1, c, dp))%mod;

		dp[N][r][c] = moves%mod;
		return dp[N][r][c];
	}
public:
	int findPaths(int m, int n, int N, int i, int j) {
		vector<vector<vector<int>>>dp(N+1, vector<vector<int>>(m+1, vector<int>(n+1, -1)));
		return dfs(m, n, N, i, j, dp);
	}
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    int mod = 1000000007;

    int dfs(int m, int n, int N, int r, int c, vector<vector<vector<int>>>& dp) {
        if (r < 0 || c < 0 || r >= m || c >= n) return 1;
        if (N == 0) return 0;
        if (dp[N][r][c] != -1) return dp[N][r][c] % mod;

        int moves = 0;
        moves = (moves + dfs(m, n, N - 1, r, c + 1, dp)) % mod;
        moves = (moves + dfs(m, n, N - 1, r, c - 1, dp)) % mod;
        moves = (moves + dfs(m, n, N - 1, r + 1, c, dp)) % mod;
        moves = (moves + dfs(m, n, N - 1, r - 1, c, dp)) % mod;

        dp[N][r][c] = moves % mod;
        return dp[N][r][c];
    }

public:
    int findPaths(int m, int n, int N, int i, int j) {
        vector<vector<vector<int>>> dp(N + 1, vector<vector<int>>(m, vector<int>(n, -1)));
        return dfs(m, n, N, i, j, dp);
    }
};

Bottom-up approach (Dynamic Programming):
class Solution {
public:
    int findPaths(int m, int n, int N, int i, int j) {
        int mod = 1000000007;
        vector<vector<vector<int>>> dp(N + 1, vector<vector<int>>(m + 2, vector<int>(n + 2, 0)));
        
        // Initialize the base case: dp[0][i][j] = 1 for all i, j.
        for (int r = 0; r < m + 2; ++r) {
            dp[0][r][0] = 1;
            dp[0][r][n + 1] = 1;
        }
        for (int c = 0; c < n + 2; ++c) {
            dp[0][0][c] = 1;
            dp[0][m + 1][c] = 1;
        }
        
        // Calculate dp[N][i][j] based on the states of dp[N - 1][i][j] and its neighbors.
        for (int step = 1; step <= N; ++step) {
            for (int r = 1; r <= m; ++r) {
                for (int c = 1; c <= n; ++c) {
                    dp[step][r][c] = ((long)dp[step - 1][r - 1][c] + dp[step - 1][r + 1][c] + 
                                      dp[step - 1][r][c - 1] + dp[step - 1][r][c + 1]) % mod;
                }
            }
        }
        
        // Sum up all dp[N][i][j] where i, j are boundary cells.
        int paths = 0;
        for (int step = 1; step <= N; ++step) {
            paths = (paths + dp[step][i + 1][j + 1]) % mod;
        }
        
        return paths;
    }
};

Minimax DP:
https://leetcode.com/problems/predict-the-winner/
https://leetcode.com/problems/stone-game/

class Solution {
public:
	bool PredictTheWinner(vector<int>& nums) {
		int n = nums.size();

		int res[n][n];

		for (int i = 0; i < n; i++)
			res[i][i] = nums[i];

		for (int l = 2; l <= n; l++) {
			for (int i = 0; i+l-1 < n; i++) {
				int j = i+l-1;
				int a = (i+1 <= j-1) ? res[i+1][j-1] : 0;
				int b = (i+2 <= j) ? res[i+2][j] : 0;
				int c = (i <= j-2) ? res[i][j-2] : 0;

				res[i][j] = max(nums[i] + min(a,b), nums[j] + min(a, c));
			}
		}

		int total = 0;
		for (int i = 0; i < n; i++)
			total += nums[i];

		return res[0][n-1] >= total - res[0][n-1];
	}
};
Top-down approach (Recursion with Memoization):
class Solution {
private:
    int dfs(vector& nums, int i, int j, vector>& memo) {
        if (i == j) return nums[i];
        if (memo[i][j] != INT_MIN) return memo[i][j];
        memo[i][j] = max(nums[i] - dfs(nums, i + 1, j, memo), nums[j] - dfs(nums, i, j - 1, memo));
        return memo[i][j];
    }

public:
    bool PredictTheWinner(vector& nums) {
        int n = nums.size();
        vector> memo(n, vector(n, INT_MIN));
        return dfs(nums, 0, n - 1, memo) >= 0;
    }
};
Bottom-up approach (Dynamic Programming):
class Solution {
public:
    bool stoneGame(vector<int>& piles) {
        int n = piles.size();
        vector<vector<int>> dp(n, vector<int>(n, 0));

        for (int i = 0; i < n; ++i) dp[i][i] = piles[i];

        for (int l = 2; l <= n; ++l) {
            for (int i = 0; i + l - 1 < n; ++i) {
                int j = i + l - 1;
                dp[i][j] = max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }
};
 */
