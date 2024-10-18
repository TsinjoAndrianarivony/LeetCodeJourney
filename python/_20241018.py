"""
2044. Count Number of Maximum Bitwise-OR Subsets
"""

class Solution(object):
    def countMaxOrSubsets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_or = 0
        for num in nums:
            max_or |= num

        def explore_subsets_from(i, current_value):
            if i == len(nums):
                return 1 if current_value == max_or else 0
            return (
                explore_subsets_from(i + 1, current_value) +
                explore_subsets_from(i + 1, current_value | nums[i])
            )
        return explore_subsets_from(0, 0)


res = Solution().countMaxOrSubsets([3,2,1,5])
print(res)
