
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        if self.isSame(s,t): 
            return True
        elif (s):
            return self.isSubtree(s.left,t) or self.isSubtree(s.right,t)
        else:
            return False
            

    def isSame(self,s: TreeNode, t: TreeNode) -> bool:
        if not (s and  t): return s is t
        print( s.val , t.val)
        return (s.val == t.val and 
            self.isSame(s.left, t.left) and 
            self.isSame(s.right, t.right))

if __name__ == "__main__":
    s = Solution()
    root1 = TreeNode(4)
    root1.left = TreeNode(1)
    root1.right = TreeNode(2)
    root2 = TreeNode(3)
    root2.left = root1
    root2.right = TreeNode(5)
    ans = s.isSubtree(root2,root1)
    print(ans)
