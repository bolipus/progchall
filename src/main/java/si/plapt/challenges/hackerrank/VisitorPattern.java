package si.plapt.challenges.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}


class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	
	private int result = 0;
	
    public int getResult() {      	
        return result;
    }

    public void visitNode(TreeNode node) {
      	
    }

    public void visitLeaf(TreeLeaf leaf) {
      	result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
	private int result = 1;
	private final int M = 1000000007;
	
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
      	if (node.getColor().equals(Color.RED)) {
      		 result = (result * node.getValue()) % M;
      	}
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if (leaf.getColor().equals(Color.RED)) {
      		result = (result * leaf.getValue()) % M;
      	}
    }
}

class FancyVisitor extends TreeVis {
	int sum1 = 0;
	int sum2 = 0;
	
    public int getResult() {
    	return Math.abs(sum1-sum2);
    }

    public void visitNode(TreeNode node) {
    	if (node.getDepth() % 2==0) {
    		sum1+= node.getValue();
    	}
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if (leaf.getColor().equals(Color.GREEN)) {
    		sum2+=leaf.getValue();
    	}
    }
}


public class VisitorPattern {
	
	 public static Tree solve() throws FileNotFoundException {
		 String input = "5\n" + 
		 		"4 7 2 5 12\n" + 
		 		"0 1 0 0 1\n" + 
		 		"1 2\n" + 
		 		"1 3\n" + 
		 		"3 4\n" + 
		 		"3 5";
		 
		 	
			
		 	//InputStream is = new ByteArrayInputStream(input.getBytes());
		 FileInputStream is = new FileInputStream("/home/bogdan/Dropbox/Sluzba/"
		 		+ "Programiranje/ProgrammingChallenges"
		 		+ "/src/main/java/si/plapt/challenges/hackerrank/vp1.txt");
			
			Scanner scanner = new Scanner(is); 
			
			int n = scanner.nextInt();
			int[] x = new int[n];
			for (int i=0;i<n;i++) {
				x[i] = scanner.nextInt();
			}
			
			Color[] c = new Color[n];
			for(int i=0;i<n; i++) {
				int val= scanner.nextInt();
				if (val==0) {
					c[i] = Color.RED;
				} else {
					c[i] = Color.GREEN;
				}
			}	
			
			List<Integer[]> pairs = new ArrayList<>();
			
			Set<Integer> areNodes = new HashSet<>();
		
			
			for (int i=0;i<n-1;i++) {
				int u = scanner.nextInt();
				int v = scanner.nextInt();
				Integer[] pair = {u, v};				
				pairs.add(pair);
				areNodes.add(u);				
			}
			
			
 			Map<Integer, Tree> nodesMap = new HashMap<>();
 			nodesMap.put(1, new TreeNode(x[0], c[0], 0));
			for (int i=0;i<n-1; i++) {
				Integer[] pair = pairs.get(i);
				int u = pair[0];
				int v = pair[1];
				System.out.println("u:" + u);
				System.out.println("v:" + v);
				
				if (!nodesMap.containsKey(u)){
					nodesMap.put(u, new TreeNode(x[u-1], c[u-1], 0));
				} 
				
				TreeNode parent = (TreeNode) nodesMap.get(u);				
				int depth = parent.getDepth();
				Tree child = null;
				if (!areNodes.contains(v)) {
					child = new TreeLeaf(x[v-1], c[v-1], depth +1);
				} else {
					child = new TreeNode(x[v-1], c[v-1], depth + 1);
				}
				nodesMap.put(v, child);
				parent.addChild(child);	
				nodesMap.replace(u, parent);
			}
			
			return nodesMap.get(1);
	  }

	public static void main(String[] args) throws FileNotFoundException {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
    	
    	/**
    	 * 45136
    	 * 56618427
    	 * 14333
    	 */
	}

}
