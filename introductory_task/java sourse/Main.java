import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;


public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println("Selected action: \n");
        System.out.println("0 - exit \n");
        System.out.println("1 - input from the file\n");
        System.out.println("2 - input from the console\n");

        Scanner ch = new Scanner(System.in);
        int choice = ch.nextInt();
        if (choice == 0 || choice == 1 || choice == 2) {
            if (choice == 0) {
                System.out.println("Goodbye! \n");
                System.exit(0);
            }
            else if (choice == 1) {
                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader(
                            "C:\\Users\\user\\IdeaProjects\\BinaryTree\\input.txt"));
                    String str = reader.readLine();
                    sb.append(str);
                    System.out.println("A string was read from the file:    " + str + "\n");
                    reader.close();
                    BinaryTree tree = new BinaryTree();
                    Trunk trunk = new Trunk(null,null);
                    tree = tree.createTree(str);
                    trunk.printTree(tree.root, null, false);
                    tree.traverseInOrder(tree.root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (choice == 2) {
                System.out.println("Please enter the tree!\n");
                Scanner in = new Scanner(System.in);
                String str = in.nextLine();
                sb.append(str);
                BinaryTree tree = new BinaryTree();
                Trunk trunk = new Trunk(null,null);
                tree = tree.createTree(str);
                trunk.printTree(tree.root, null, false);
                tree.traverseInOrder(tree.root);
            }
            else {
                System.out.println("Invalid input!\n");
                System.out.println("Goodbye! \n");
                System.exit(0);
            }
        }
    }
}
