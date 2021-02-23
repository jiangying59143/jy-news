package com.jy.eureka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Tree {
    public static void main(String[] args) {
        TreeNode treeNode = createTree(new Integer[]{2,3,3,4,null,null,4,null,5,5,null,null,6,6,null,7,8,8,7,9,0,0,1,1,0,0,9});
//        TreeNode treeNode1 = createTree(new Integer[]{1,2});
//        dfs(treeNode);
//        bfs(treeNode);
//        System.out.println(isSameTree(treeNode, treeNode1));
        System.out.println(isSymmetric(treeNode));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public static boolean isSymmetric(TreeNode node, TreeNode node2){
        if(node == node2){
            return true;
        }else if(node == null || node2 == null){
            return false;
        }else{
            return node.val == node2.val && isSymmetric(node.left, node2.right) && isSymmetric(node.right, node2.left);
        }
    }

    public static void dfs(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node == null) System.out.println("null");
            else System.out.println(node.val);
            if(node.right != null)
            stack.push(node.right);
            if(node.left != null)
            stack.push(node.left);
        }
    }

    public static void bfs(TreeNode treeNode) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while(!queue.isEmpty()){
            TreeNode node = queue.pop();
            if(node == null) System.out.println("null");
            else System.out.println(node.val);
            if(node.right != null)
                queue.push(node.right);
            if(node.left != null)
                queue.push(node.left);
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==q){
            return true;
        }
        Stack<TreeNode> pstack = new Stack<>();
        Stack<TreeNode> qstack = new Stack<>();
        pstack.push(p);
        qstack.push(q);
        while(!pstack.isEmpty() || !qstack.isEmpty()){
            if(pstack.size() != qstack.size()){
                return false;
            }
            TreeNode pnode = pstack.pop();
            TreeNode qnode = qstack.pop();
            if(!isSameNode(pnode, qnode) || !isSameNode(pnode.left, qnode.left) || !isSameNode(pnode.right, qnode.right)){
                return false;
            }

            if(pnode.right != null){
                pstack.push(pnode.right);
            }

            if(qnode.right != null){
                qstack.push(qnode.right);
            }

            if(pnode.left != null){
                pstack.push(pnode.left);
            }

            if(qnode.left != null){
                qstack.push(qnode.left);
            }

        }
        return true;
    }

    private static boolean isSameNode(TreeNode a, TreeNode b){
        if(!(a == b || a != null && b != null && a.val == b.val )){
            return false;
        }
        return true;
    }



    public static TreeNode createTree(Integer[] arr){
        if(arr == null || arr.length ==0 ){
            return null;
        }
        if(arr.length == 1){
            return new TreeNode(arr[0]);
        }
        List<TreeNode> treeNodes = new LinkedList<>();
        for (Integer i : arr) {
            if(i==null){
                treeNodes.add(null);
            }else {
                treeNodes.add(new TreeNode(i));
            }
        }

        for(int i=0; i<treeNodes.size() / 2 -1; i++){
            TreeNode tn = treeNodes.get(i);
            if(tn == null){
                continue;
            }
            tn.left = treeNodes.get(2*i +1);
            tn.right = treeNodes.get(2*i +2);
        }

        TreeNode lastTreeNode = treeNodes.get(treeNodes.size() / 2 -1);
        if(lastTreeNode == null){
            return treeNodes.get(0);
        }

        if(treeNodes.size() % 2 == 1){
            lastTreeNode.left = treeNodes.get(treeNodes.size() - 2);
            lastTreeNode.right = treeNodes.get(treeNodes.size() - 1);
        }else{
            lastTreeNode.left = treeNodes.get(treeNodes.size() - 1);
        }

        return treeNodes.get(0);

    }

    private static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(Integer val) { this.val = val; }
        TreeNode(Integer val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


