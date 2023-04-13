package lab7;
import java.util.*;

public class Exercise2<T> {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BinaryTree<String> binaryTree = new BinaryTree();
        ArrayList<BinaryTree<String>> list = new ArrayList<>();

        int count = 0;

        System.out.println("Enter name or done: ");
        String string = in.next();
        binaryTree.makeRoot(string);

        while (!string.equals("done")) {
            list.add(new BinaryTree<String>());
            list.get(count++).makeRoot(string);
            System.out.println("Enter name or done: ");
            string = in.next();
        }

        int  num = list.size();
        int i = 1;
        int turn = 1;

        if (num == 0){
            list.remove(0);
        }

        BinaryTree<String> binaryTree2 = binaryTree;

        while (i < num){
            binaryTree2.attachLeft(list.get(i++));

            if(i >= num){
                break;
            }
            binaryTree2.attachRight(list.get(i++));
            binaryTree2 = (turn%2!= 0) ? binaryTree2.getLeft() :  binaryTree2.getRight();
            turn++;
        }

        System.out.print("Height of the tree is: " + BinaryTree.height(binaryTree));

        System.out.print("\nNumber of nodes in the tree is: " + BinaryTree.nodes(binaryTree) + "\n");

        System.out.print("Inorder:\t\t");
        BinaryTree.inorder(binaryTree);
        System.out.println();

        System.out.print("Preorder:\t\t");
        BinaryTree.preorder(binaryTree);
        System.out.println();

        System.out.print("Postorder:\t\t");
        BinaryTree.postorder(binaryTree);
        System.out.println();

        System.out.print("Level order:\t");
        BinaryTree.levelOrder(binaryTree);
        System.out.println();

        System.out.printf("\nAnd is it height balanced... %s\n", BinaryTree.heightBalanced(binaryTree) ? "Yes!" : "No.");
    }
}