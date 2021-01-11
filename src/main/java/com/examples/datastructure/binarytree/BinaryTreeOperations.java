package com.examples.datastructure.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * BinaryTreeOperations class contains the following operations:
 * <p>
 * 1. Count nodes
 * 2. Count leaf nodes
 * 3. Tree mirroring
 * 4. Minimum value by DFS (Depth First Search)
 * 5. Minimum value by BFS (Breadth First search)
 * 6. Maximum value by DFS
 * 7. Maximum value by BFS
 * 8. Count nodes with a defined value
 * 9. Maximum depth of the tree
 * 10. Checking BST property
 * 10 + 1. Print nodes by BFS
 *
 * @author Matyas Ember
 */
public class BinaryTreeOperations {

    public static void main(String[] args) {

        // Initialization of the binary tree.

        TreeNode<Integer> s12 = new TreeNode<>(6, null, null);
        TreeNode<Integer> s11 = new TreeNode<>(5, null, s12);
        TreeNode<Integer> s10 = new TreeNode<>(3, null, null);
        TreeNode<Integer> s9 = new TreeNode<>(8, null, null);
        TreeNode<Integer> s8 = new TreeNode<>(4, s10, s11);
        TreeNode<Integer> s7 = new TreeNode<>(1, null, null);
        TreeNode<Integer> s6 = new TreeNode<>(11, null, null);
        TreeNode<Integer> s5 = new TreeNode<>(9, s9, null);
        TreeNode<Integer> s4 = new TreeNode<>(2, s7, s8);
        TreeNode<Integer> s3 = new TreeNode<>(12, s6, null);
        TreeNode<Integer> s2 = new TreeNode<>(7, s4, s5);
        TreeNode<Integer> s1 = new TreeNode<>(10, s2, s3);

        System.out.println("Count of nodes: " + countNodes(s1));
        System.out.println("Count of leaf nodes: " + countLeafNodes(s1));

        System.out.print("Nodes of the tree by BFS: ");
        printTree(s1);

        System.out.println();
        System.out.print("Nodes of the mirrored tree by BFS: ");
        mirrorTree(s1);
        printTree(s1);
        System.out.println();

        // Revert back to the original tree
        mirrorTree(s1);
        TreeNode<Integer> mint = minValInTree(s1);
        System.out.print("The minimum value in the tree: ");
        System.out.println(mint.getValue());

        int searchedValue = 1;
        System.out.print("Count of nodes with value " + searchedValue
                + " in the tree: ");
        System.out.println(countAppearances(s1, searchedValue));

        System.out.println("Maximum depth of the tree: " + maxDepth(s1));
        System.out.println("BST(Binary Search Tree) property check: "
                + isOrdered(s1));
    }

    /**
     * 1. Count the nodes in the tree.
     * countNodes(root)
     */

    public static <T extends Comparable<T>> int countNodes(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        return countNodes(root.getLeft()) + countNodes(root.getRight()) + 1;
    }

    /**
     * 2. Count the leaf nodes in the tree.
     * countLeafNodes(root)
     */

    public static <T extends Comparable<T>> int countLeafNodes(
            TreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        return countLeafNodes(root.getLeft())
                + countLeafNodes(root.getRight());
    }

    /**
     * 3. Mirror the tree.
     * mirrorTree(root)
     */

    public static <T extends Comparable<T>> void mirrorTree(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        TreeNode<T> temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);

        mirrorTree(root.getLeft());
        mirrorTree(root.getRight());
    }

    /**
     * 4. Search for minimum value in the tree by DFS (Depth First Search).
     * minValInTree(root)
     */

    public static <T extends Comparable<T>> TreeNode<T> minValInTree(
            TreeNode<T> root) {
        if (root == null) {
            return null;
        }

        TreeNode<T> minInLeft = minValInTree(root.getLeft());
        TreeNode<T> minInRight = minValInTree(root.getRight());
        TreeNode<T> minNode = root;

        if (root.getLeft() != null
                && minNode.getValue().compareTo(minInLeft.getValue()) > 0) {

            minNode = minInLeft;
        }

        if (root.getRight() != null
                && minNode.getValue().compareTo(minInRight.getValue()) > 0) {

            minNode = minInRight;
        }

        return minNode;
    }

    /**
     * 5. Search for maximum value in the tree by DFS (Depth First Search).
     * maxValInTree(root)
     */

    public static <T extends Comparable<T>> TreeNode<T> maxValInTree(
            TreeNode<T> root) {
        if (root == null) {
            return null;
        }

        TreeNode<T> maxInLeft = maxValInTree(root.getLeft());
        TreeNode<T> maxInRight = maxValInTree(root.getRight());
        TreeNode<T> maxNode = root;

        if (root.getLeft() != null
                && maxNode.getValue().compareTo(maxInLeft.getValue()) < 0) {

            maxNode = maxInLeft;
        }

        if (root.getRight() != null
                && maxNode.getValue().compareTo(maxInRight.getValue()) < 0) {

            maxNode = maxInRight;
        }

        return maxNode;
    }

    /**
     * 6. Search for minimum value in the tree by BFS (Breadth First search).
     * minValInTreeBFS(root)
     */

    public static <T extends Comparable<T>> TreeNode<T> minValInTreeBFS(
            TreeNode<T> root) {
        List<TreeNode<T>> actualNodes = new LinkedList<>();
        actualNodes.add(root);

        TreeNode<T> minNode = root;

        while (!actualNodes.isEmpty() && actualNodes.get(0) != null) {

            TreeNode<T> actualNode = actualNodes.get(0);
            TreeNode<T> left = actualNode.getLeft();
            TreeNode<T> right = actualNode.getRight();

            if (left != null) {

                if (minNode.getValue().compareTo(left.getValue()) > 0) {
                    minNode = left;
                }

                actualNodes.add(left);
            }

            if (right != null) {

                if (minNode.getValue().compareTo(right.getValue()) > 0) {
                    minNode = right;
                }

                actualNodes.add(right);
            }

            actualNodes.remove(0);
        }

        return minNode;
    }

    /**
     * 7. Search for maximum value in the tree by BFS (Breadth First search).
     * maxValInTreeBFS(root)
     */

    public static <T extends Comparable<T>> TreeNode<T> maxValInTreeBFS(
            TreeNode<T> root) {

        List<TreeNode<T>> actualNodes = new LinkedList<>();
        actualNodes.add(root);

        TreeNode<T> maxNode = root;

        while (!actualNodes.isEmpty() && actualNodes.get(0) != null) {

            TreeNode<T> actualNode = actualNodes.get(0);
            TreeNode<T> left = actualNode.getLeft();
            TreeNode<T> right = actualNode.getRight();

            if (left != null) {

                if (maxNode.getValue().compareTo(left.getValue()) < 0) {
                    maxNode = left;
                }

                actualNodes.add(left);
            }

            if (right != null) {

                if (maxNode.getValue().compareTo(right.getValue()) < 0) {
                    maxNode = right;
                }

                actualNodes.add(right);
            }

            actualNodes.remove(0);
        }

        return maxNode;
    }

    /**
     * 8. Count the appearance of a value in the tree.
     * countAppearances(root)
     */

    public static <T extends Comparable<T>> int countAppearances(
            TreeNode<T> root, int s) {

        if (root == null) {
            return 0;
        }

        if (root.getValue().equals(s)) {
            return countAppearances(root.getLeft(), s)
                    + countAppearances(root.getRight(), s) + 1;
        }

        return countAppearances(root.getLeft(), s)
                + countAppearances(root.getRight(), s);
    }

    /**
     * 9. Calculate the maximum depth of a tree.
     * maxDepth(root)
     */

    public static <T extends Comparable<T>> int maxDepth(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeft() != null && (root.getRight() != null)) {
            return Math.max(maxDepth(root.getLeft()) + 1,
                    maxDepth(root.getRight()) + 1);
        }

        if (root.getLeft() != null) {
            return maxDepth(root.getLeft()) + 1;
        }

        if (root.getRight() != null) {
            return maxDepth(root.getRight()) + 1;
        }

        return 1;
    }

    /**
     * 10. Return true if binary tree is BST (binary search tree).
     * isOrdered(root)
     */

    public static <T extends Comparable<T>> boolean isOrdered(
            TreeNode<T> root) {

        if (root == null) {
            return true;
        }

        if (root.getLeft() != null && root.getRight() != null) {
            TreeNode<T> maxInLeft = maxValInTree(root.getLeft());
            TreeNode<T> minInRight = minValInTree(root.getRight());

            return maxInLeft.compareTo(root) <= 0
                    && root.compareTo(minInRight) <= 0
                    && isOrdered(root.getLeft()) && isOrdered(root.getRight());

        }

        if (root.getLeft() != null) {
            TreeNode<T> maxInLeft = maxValInTree(root.getLeft());

            return maxInLeft.compareTo(root) <= 0
                    && isOrdered(root.getLeft());

        }

        if (root.getRight() != null) {
            TreeNode<T> minInRight = minValInTree(root.getRight());

            return root.compareTo(minInRight) <= 0
                    && isOrdered(root.getRight());
        }

        return true;
    }

    /**
     * 10 + 1. Print the values of the nodes by BFS (Breadth First search).
     * printTree(root)
     */

    public static <T extends Comparable<T>> void printTree(TreeNode<T> root) {
        List<TreeNode<T>> actualNodes = new LinkedList<>();
        actualNodes.add(root);

        while (!actualNodes.isEmpty() && actualNodes.get(0) != null) {

            System.out.print(actualNodes.get(0).getValue() + " ");

            TreeNode<T> actualNode = actualNodes.get(0);

            if (actualNode.getLeft() != null) {
                actualNodes.add(actualNode.getLeft());
            }

            if (actualNode.getRight() != null) {
                actualNodes.add(actualNode.getRight());
            }

            actualNodes.remove(0);
        }
    }
}