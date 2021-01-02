package com.examples.datastructure.binarytree;

/**
 * TreeNode: Node element definition.
 *
 * @author Matyas Ember
 */

public class TreeNode<T extends Comparable<T>>
        implements Comparable<TreeNode<T>> {

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        return getValue().compareTo(o.getValue());
    }
}
