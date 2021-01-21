package controller;

import model.TreeNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class TreeNodeController {
    private List<TreeNode> tree;
    
        
    public static Comparator<TreeNode> indexComparator = new Comparator<TreeNode>() 
       { 
           public int compare(TreeNode u1, TreeNode u2) 
           { 
               int x = u1.getId();
               int y = u2.getId();
               return (x < y) ? -1 : ((x == y) ? 0 : 1);
           } 
       }; 
    public static Comparator<TreeNode> nameComparator = new Comparator<TreeNode>() 
       { 
           public int compare(TreeNode u1, TreeNode u2) 
           { 
               return u1.getName().compareTo(u2.getName());
           } 
       }; 
    public TreeNodeController(List<TreeNode> tree) {
        this.tree = tree;
    }
    
    public boolean checkParent(String X, String Y){
        TreeNode child = null;
        try{
            child = tree.get(Collections.binarySearch(tree, new TreeNode(0, null, X), nameComparator));
        }catch(IndexOutOfBoundsException e){
            System.out.println("Không tìm thấy " + X);
            return false;
        }
        TreeNode parent = null;
        try {
            parent = tree.get(Collections.binarySearch(tree, new TreeNode(0, null, Y), nameComparator));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Không tìm thấy " + Y);
            return false;
        }
        String output = child.getName();
        TreeNode iter = child;
        while (iter.getParent() != null) {            
            iter = iter.getParent();
            output = output.concat(" => " + iter.getName());
            if(nameComparator.compare(iter, parent) == 0){
                System.out.println(output);
                return true;
            }
        }
        return false;
    }
    
    public void printChildrent(String node){
        TreeNode root = null;
        try{
            root = tree.get(Collections.binarySearch(tree, new TreeNode(0, null, node), nameComparator));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Không tìm thấy " + node);
            return;
        }
        System.out.println("Childen of " + node + ":");
        for (TreeNode child : root.getChildren()) {
            treeTraversal(child);
        }
    }
    
    private void treeTraversal(TreeNode root){
        System.out.println(root.toLine());
        for (TreeNode child : root.getChildren()) {
            treeTraversal(child);
        }
    }
}
