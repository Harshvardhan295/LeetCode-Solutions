//DFS
class Solution {
public static void paths(TreeNode root,String s,List<String> a){
    if(root ==null) return;
    if(root.left==null && root.right==null){//leaf node
        s+=root.val;
        a.add(s);
        return;
    }
    paths(root.left,s+root.val+"->",a);
    paths(root.right,s+root.val+"->",a);
}
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> a=new ArrayList<>();
       paths(root,"",a);
       return a;
    }
}

// Backtracking
class Solution {
    List<String> paths;

    public void pathprint(TreeNode root, StringBuilder ans) {
        if (root == null) return;
        // Save the length of the builder BEFORE adding anything
        int len = ans.length();
        ans.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(ans.toString());
        } else {
            ans.append("->");
            pathprint(root.left, ans);
            pathprint(root.right, ans);
        }
        //Backtrack
        ans.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        pathprint(root, ans);
        return paths;
    }
}
