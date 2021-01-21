package model;

import java.util.ArrayList;


public class TreeNode {
    private int id;
    private TreeNode parent;
    private ArrayList<TreeNode> children = new ArrayList<>();
    private String name;

    public TreeNode() {
    }

    public TreeNode(int id, TreeNode parent, String name) {
        this.id = id;
        this.parent = parent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addChild(TreeNode child){
        this.children.add(child);
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public String toLine() {
        return this.id +" | "+ this.name;
    }
}
