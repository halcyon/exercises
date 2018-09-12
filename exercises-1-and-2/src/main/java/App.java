import java.util.Arrays;
import java.util.ArrayList;

public class App {
    static public SimpleNode buildExampleTree() {
        SimpleNode b = new SimpleNode("B", Arrays.asList("E","F")
                                                 .stream()
                                                 .map(s -> new SimpleNode(s, new GNode[0]))
                                                 .toArray(SimpleNode[]::new));

        SimpleNode c = new SimpleNode("C", Arrays.asList("G","H","I")
                                                .stream()
                                                .map(s -> new SimpleNode(s, new GNode[0]))
                                                .toArray(SimpleNode[]::new));

        SimpleNode d = new SimpleNode("D", Arrays.asList("J")
                                                 .stream()
                                                 .map(s -> new SimpleNode(s, new GNode[0]))
                                                 .toArray(SimpleNode[]::new));

        return new SimpleNode("A", (Arrays.asList(b,c,d).toArray(new GNode[0])));
    }

    public static void main(String[] args) {
        SimpleNode classUnderTest = new SimpleNode("CUT",new GNode[0]);
        SimpleNode root = App.buildExampleTree();
        System.out.println(classUnderTest.walkGraph(root));
        System.out.println(classUnderTest.paths(root));
    }
}
