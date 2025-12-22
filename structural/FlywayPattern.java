package structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ============= TreeType Class ================
class TreeType {
    // Properties that are common among all trees of this type
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y) {
        System.out.println("Drawing " + name + " tree at (" + x + ", " + y + ")");
    }
}
// ============= Tree Class ================
class Tree{
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
// ============= TreeFactory Class ================
class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();
    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeType(name, color, texture));
        }
        return treeTypes.get(key);
    }
}


// ============= Forest Class ================
class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        Tree tree = new Tree(x, y, TreeFactory.getTreeType(name, color, texture));
        trees.add(tree);
    }

    public void draw() {
        for (Tree tree : trees) {
            tree.draw();
        }
    }
}

public class FlywayPattern {
    public static void main(String[] args) {
        Forest forest = new Forest();

        for(int i = 0; i < 100000; i++) {
            forest.plantTree((int)(Math.random() * 100), (int)(Math.random() * 100),
                    "Oak", "Green", "Rough");
            forest.plantTree((int)(Math.random() * 100), (int)(Math.random() * 100),
                    "Pine", "Dark Green", "Smooth");
        }
        forest.draw();
    }
}
