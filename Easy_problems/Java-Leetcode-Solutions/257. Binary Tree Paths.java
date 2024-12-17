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
