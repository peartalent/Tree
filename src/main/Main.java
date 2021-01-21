package main;

import controller.TreeNodeController;
import model.TreeNode;
import model.TreeNodeReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String url = Main.class.getResource("tree.txt").getPath();
        List<TreeNode> tree = TreeNodeReader.getInstance().readTreeNodeFromFile(url);
        System.out.println(tree);
        TreeNodeController controller = new TreeNodeController(tree);
        System.out.println(controller.checkParent("D", "Gốc"));
        controller.printChildrent("Gốc");
    }
    
}
