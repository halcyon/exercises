import java.util.Arrays;
import java.util.ArrayList;

class SimpleNode implements GNode {
    public SimpleNode(String name, GNode[] children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public GNode[] getChildren() {
        return children;
    }

    public String toString() {
        return this.getName();
    }

    public ArrayList walkGraph(GNode node) {
        if(node == null) {
            return new ArrayList<>();
        } else {
            return walkGraphHelper(new ArrayList<>(), node);
        }
    }

    public ArrayList<ArrayList<GNode>> paths(GNode node) {
        if(node == null) {
            return new ArrayList<>();
        } else {
            return pathsHelper(node);
        }
    }

    private String name;
    private GNode[] children = new GNode[0];

    private ArrayList walkGraphHelper(ArrayList acc, GNode node) {
        if (node.getChildren().length == 0) {
            acc.add(node);
            return acc;
        }
        else {
            ArrayList<GNode> children = new ArrayList<>(Arrays.asList(node.getChildren()));
            acc.add(node);
            children.forEach(n -> walkGraphHelper(acc, n));
            return acc;
        }
    }

    private ArrayList<ArrayList<GNode>> pathsHelper(GNode node) {
        ArrayList<ArrayList<GNode>> paths = new ArrayList<>();
        if(node.getChildren().length == 0) {
            ArrayList<GNode> leaves = new ArrayList<>();
            leaves.add(node);
            paths.add(leaves);
        } else {
            for (GNode child : node.getChildren()) {
                ArrayList<ArrayList<GNode>> nodeLists = pathsHelper(child);
                for (ArrayList<GNode> nodeList : nodeLists) {
                    nodeList.add(0, node);
                    paths.add(nodeList);
                }
            }
        }
        return paths;
    }
}
