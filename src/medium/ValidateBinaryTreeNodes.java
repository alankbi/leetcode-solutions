package medium;

/**
 * Problem 1361: Validate Binary Tree Nodes
 */
public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] numIns = new int[n];
        int[] numOuts = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                numIns[leftChild[i]]++;
                numOuts[i]++;
            }
            if (rightChild[i] != -1) {
                numIns[rightChild[i]]++;
                numOuts[i]++;
            }
        }


        int numRoots = 0;
        for (int i = 0; i < n; i++) {
            if (numOuts[i] > 2 || numIns[i] > 1) {
                return false;
            }

            // More of a gimmick to detect lone nodes; might not generalize
            if (numIns[i] == 0 && numOuts[i] == 0 && n > 1) {
                return false;
            }

            if (numIns[i] == 0) {
                numRoots++;
            }
        }

        return numRoots == 1;
    }

    public static void main(String[] args) {
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};

        boolean result = new ValidateBinaryTreeNodes().validateBinaryTreeNodes(4, leftChild, rightChild);
        System.out.println(result);
    }
}
