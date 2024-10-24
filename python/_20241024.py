# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def flipEquiv(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        if root1 is None or root2 is None:
            return root1 == root2

        if root1.val != root2.val:
            return False

        if self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right):
            return True

        else:
            root1.left, root1.right = root1.right, root1.left
            return self.flipEquiv(root1.left, root2.left) and self.flipEquiv(root1.right, root2.right)
