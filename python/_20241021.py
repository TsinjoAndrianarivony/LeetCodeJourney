"""
1593. Split a String Into the Max Number of Unique Substrings
"""

class Solution(object):
    def maxUniqueSplit(self, s):
        """
        :type s: str
        :rtype: int
        """

        def explore_splits(start, current_split):
            if start == len(s):
                return 0

            res = 0
            for i in range(start, len(s)):
                e = s[start:i+1]
                if e not in current_split:
                    current_split[e] = e
                    res = max(res, 1 + explore_splits(i + 1, current_split))
                    del current_split[e]

            return res

        return explore_splits(0, {})


solver = Solution()
res = solver.maxUniqueSplit("ababccc")
print(res)
