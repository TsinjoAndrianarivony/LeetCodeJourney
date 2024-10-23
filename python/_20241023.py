"""
2641. Cousins in Binary Tree II
"""
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def replaceValueInTree(self, root):
        sums = []
        max_depth = 0

        def dfs_do_sum(depth, source):
            nonlocal max_depth

            if source is None:
                return

            if max_depth <= depth:
                max_depth += 1
                sums.append(source.val)
            else:
                sums[depth] += source.val

            dfs_do_sum(depth + 1, source.left)
            dfs_do_sum(depth + 1, source.right)

        dfs_do_sum(0, root)
        root.val = 0

        def dfs_do_build_tree(depth, source):
            if source is None:
                return

            next_depth = depth + 1
            if depth < max_depth - 1:
                abstract = ((0 if source.left is None else source.left.val) +
                            (0 if source.right is None else source.right.val))
                if source.left is not None:
                    source.left.val = sums[next_depth] - abstract
                if source.right is not None:
                    source.right.val = sums[next_depth] - abstract

            dfs_do_build_tree(next_depth, source.left)
            dfs_do_build_tree(next_depth, source.right)

        dfs_do_build_tree(0, root)
        return root
