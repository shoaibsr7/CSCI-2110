/**
 * Take a line of string in upper case from the user and create a Huffman tree using the LettersProbability.txt
 * encode the user input using the huffman codes generated using the txt file and decode it back
 * @author Ahmed Rajgoli Shoaib Shakeel - B00878695
 */

package Assignment4;

import java.io.*;
import java.util.*;

public class Huffman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner((System.in));

        System.out.print("Enter a line (UPPER LETTERS ONLY): \t");
        String inputLine = in.nextLine();

//        file containing Letters and their probability
        /** (IF THE USER WANTS TO INPUT THEIR OWN LettersProbability.txt FILE UNCOMMENT LINE 18 AND 19)
         * System.out.println("Enter the name of the file with letters and probability: ");
         * String filename = in.nextLine();
         */

        String filename = "/Users/shoaibshakeel/Library/CloudStorage/OneDrive-DalhousieUniversity/University/Second year/CSCI 2110/Assignment/Assignment4/Assignment4/LettersProbability.txt";
//        store file
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        //to split the String in the txt file based on the delimiter tab ("\t")
        StringTokenizer token;

        Pair pairObject;
        ArrayList<Pair> arrayListOfPairObject = new ArrayList<Pair>();

        while (inputFile.hasNext()){
            String read = inputFile.nextLine();
            token = new StringTokenizer(read,"\t");

//            read alphabets
            String character = token.nextToken();
            char alphabets = character.charAt(0);

//            read probabilities
            String prob = token.nextToken();
            double probabilities = Double.parseDouble(prob);

            pairObject = new Pair(alphabets,probabilities);
            arrayListOfPairObject.add(pairObject);
        }
        inputFile.close();

//        Queue S
        ArrayList<BinaryTree<Pair>> S = new ArrayList<>();
//        Queue T
        ArrayList<BinaryTree<Pair>> T = new ArrayList<>();

//        Enqueue the ArrayList<BinaryTree<Pair>> objects into Queue S keeping Queue T empty for now
        for (int i = 0; i < arrayListOfPairObject.size(); i++) {
            BinaryTree<Pair> pairBinaryTree = new BinaryTree<>();
            pairBinaryTree.setData(arrayListOfPairObject.get(i));
            S.add(pairBinaryTree);
        }

//        Creating Huffman tree using the algorithm provided
        while (S.size() > 0) {
//            A will be left subtree
            BinaryTree<Pair> A = new BinaryTree<>();
//            B will be right subtree
            BinaryTree<Pair> B = new BinaryTree<>();

            if (T.size() < 1) {
//                set A
                A = S.get(0);
                S.remove(0);

//                set B
                B = S.get(0);
                S.remove(0);
            } // if (T.isEmpty())
            else if (T.size() > 0) {
//                if head of S is < head of T; Get head of S and set as A
                if (S.get(0).getData().getProb() < T.get(0).getData().getProb()) {
                    A = S.get(0);
                    S.remove(0);
                }
                else {
                    A = T.get(0);
                    T.remove(0);
                }

                if ( T.size() < 1 || (S.get(0).getData().getProb() < T.get(0).getData().getProb())) {
                    B = S.get(0);
                    S.remove(0);
                }
                else {
                    B = T.get(0);
                    T.remove(0);
                }
            } //else if (!T.isEmpty())
//            Another Binary tree of type pair that will be the root of A and B
            BinaryTree<Pair> P = new BinaryTree<>();
//            Root pair to store the two small pairs
            Pair pRoot = new Pair('0', (A.getData().getProb() + B.getData().getProb()));

            P.makeRoot(pRoot);
            P.attachLeft(A);
            P.attachRight(B);

//            Add P to T
            T.add(P);
        } // while (S.size() > 0)

        while (T.size() > 1) {
            BinaryTree<Pair> A = new BinaryTree<>();
            BinaryTree<Pair> B = new BinaryTree<>();

            A = T.get(0);
            T.remove(0);

            B = T.get(0);
            T.remove(0);

//            Another Binary tree of type pair that will act as a root of A and B
            BinaryTree<Pair> P = new BinaryTree<>();
//            Root pair to store the two small pairs
            Pair pRoot = new Pair('0', (A.getData().getProb() + B.getData().getProb()));

            P.makeRoot(pRoot);
            P.attachLeft(A);
            P.attachRight(B);

//            Add P to T
            T.add(P);
        } // while (T.size() > 1)

        BinaryTree<Pair> generateHuffmanTree = new BinaryTree<>();
        generateHuffmanTree = T.get(0);

        String[] huffmanCode = findEncoding(generateHuffmanTree);
        char[] uppercaseLetters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W',
                'X','Y','Z'};

        ArrayList<Character> arrayOfInputLine = new ArrayList<Character>();
        for (int i = 0; i < inputLine.length(); i++) {
            arrayOfInputLine.add(inputLine.charAt(i));
        }

        String encoded = "";

        for (int i = 0; i < inputLine.length(); i++) {
            if (arrayOfInputLine.get(i).equals(' ')){
                encoded += " ";
            }
            else {
                encoded += huffmanCode[ ((int) arrayOfInputLine.get(i) - 65) ];
            }
        }

        System.out.println("Here's the encoded line:\t" + encoded);
        System.out.println("The decoded line is:\t" + decoded(encoded, huffmanCode, uppercaseLetters));
    }//main

    /**
     * This method is storing the first words first letter in a variable and checking if it is equal to
     * huffman codes we created and stored in the encoded variable.
     * if it is equal we add the letter at that index into our answer and make the variable empty
     * to store the next character and repeat the process again until we reach the end of the encoded string
     * @param encoded the encoded string
     * @param huffmanCodeStringArray huffman codes stored in an array
     * @param uppercaseLetters array of Character (A,B,C,D,E,F,G,....,X,Y,Z)
     * @return
     */
    private static String decoded(String encoded, String[] huffmanCodeStringArray, char[] uppercaseLetters) {
        String decodedText = "";
        String[] words = encoded.split(" ");
        String huffmanCodesString = "";

        for (String word :
                words) {
            for (int i = 0; i < word.length(); i++) {
                huffmanCodesString += word.charAt(i);

                for (int j = 0; j < huffmanCodeStringArray.length; j++) {

                    if (huffmanCodesString.equals(huffmanCodeStringArray[j])){
                        decodedText += uppercaseLetters[j];
                        huffmanCodesString = "";
                    }

                }
            }
            decodedText += " ";
        }
        return decodedText;
    }

    /**
     * Method provided by @Srini Sampalli
     * @param bt
     * @return
     */
    private static String[] findEncoding(BinaryTree<Pair> bt){
        String[] result = new String[26];
        findEncoding(bt, result, "");
        return result;
    }

    private static void findEncoding(BinaryTree<Pair> bt, String[] a, String prefix){
        // test is node/tree is a leaf
        if (bt.getLeft()==null && bt.getRight()==null){
            a[bt.getData().getValue() - 65] = prefix;
        }
        // recursive calls
        else{
            findEncoding(bt.getLeft(), a, prefix+"0");
            findEncoding(bt.getRight(), a, prefix+"1");
        }
    }
}
