"""
2583. Kth Largest Sum in a Binary Tree

Definition for a binary tree node.)
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
"""

class Solution:
    def kthLargestLevelSum(self, root, k):
        """
        :type root: Optional[TreeNode]
        :type k: int
        :rtype: int
        """

        sums = []
        max_depth = 0

        def explore_tree(depth, source):
            nonlocal max_depth

            if source is None:
                return

            if max_depth <= depth:
                max_depth += 1
                sums.append(source.val)
            else:
                sums[depth] += source.val

            explore_tree(depth + 1, source.left)
            explore_tree(depth + 1, source.right)

        explore_tree(0, root)

        if max_depth < k:
            return -1

        sums.sort()
        return sums[max_depth - 1 - k + 1]
