package model;

import controller.TreeNodeController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNodeReader {
    private static TreeNodeReader singleton = null;
    public static TreeNodeReader getInstance(){
        if(singleton == null){
            singleton = new TreeNodeReader();
        }
        return singleton;
    }

    public List<TreeNode> readTreeNodeFromFile(String path){
        ArrayList<TreeNode> rs = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            TreeNode node = null;
            TreeNode parent = null;
            int parentIndex = -1;
            while (line != null) {
                String[] output = line.split(" ", 3);
                parentIndex = Collections.binarySearch(rs, new TreeNode(Integer.parseInt(output[1]), null, null), TreeNodeController.indexComparator);
                if(parentIndex >= 0){
                    parent = rs.get(parentIndex);
                }else{
                    parent = null;
                }
                node = new TreeNode(Integer.parseInt(output[0]), 
                        parent, output[2]);
                if(parent != null) parent.addChild(node);
                rs.add(node);
                Collections.sort(rs, TreeNodeController.indexComparator);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(rs, TreeNodeController.nameComparator);
        return rs;
    }
}
