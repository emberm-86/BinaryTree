package com.examples.datastructure.binarytree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class.
 *
 * @author Matyas Ember
 */
public class BinaryTreeOperationsTest {

    private TreeNode<Integer> s1;

    private TreeNode<Integer> s2;

    private TreeNode<Integer> s3;

    private TreeNode<Integer> s4;

    private TreeNode<Integer> s5;

    private TreeNode<Integer> s6;

    private TreeNode<Integer> s7;

    private TreeNode<Integer> s8;

    private TreeNode<Integer> s9;

    private TreeNode<Integer> s10;

    private TreeNode<Integer> s11;

    private TreeNode<Integer> s12;

    @Before
    public void init() {

        // Initialization of the binary tree.

        s12 = new TreeNode<>(6, null, null);
        s11 = new TreeNode<>(5, null, s12);
        s10 = new TreeNode<>(3, null, null);
        s9 = new TreeNode<>(8, null, null);
        s8 = new TreeNode<>(4, s10, s11);
        s7 = new TreeNode<>(1, null, null);
        s6 = new TreeNode<>(11, null, null);
        s5 = new TreeNode<>(9, s9, null);
        s4 = new TreeNode<>(2, s7, s8);
        s3 = new TreeNode<>(12, s6, null);
        s2 = new TreeNode<>(7, s4, s5);
        s1 = new TreeNode<>(10, s2, s3);

        /*	Root node : s1

                        10
                     /      \
                   7         12
                /    \	    /
               2      9    11
              /	\    /
             1   4  8
                / \
               3   5
                    \
                     6 */
    }

    @Test
    public void testCountNodes() {
        Assert.assertEquals(12, BinaryTreeOperations.countNodes(s1));
    }

    @Test
    public void testCountLeafNodes() {
        Assert.assertEquals(5, BinaryTreeOperations.countLeafNodes(s1));
    }

    @Test
    public void testMirrorTree() {
        BinaryTreeOperations.mirrorTree(s1);

        Assert.assertEquals(s1.getLeft().getValue(), s3.getValue());
        Assert.assertEquals(s1.getRight().getValue(), s2.getValue());

        Assert.assertEquals(s2.getLeft().getValue(), s5.getValue());
        Assert.assertEquals(s2.getRight().getValue(), s4.getValue());

        Assert.assertNull(s3.getLeft());
        Assert.assertEquals(s3.getRight().getValue(), s6.getValue());

        Assert.assertEquals(s4.getLeft().getValue(), s8.getValue());
        Assert.assertEquals(s4.getRight().getValue(), s7.getValue());

        Assert.assertNull(s5.getLeft());
        Assert.assertEquals(s5.getRight().getValue(), s9.getValue());

        Assert.assertNull(s6.getLeft());
        Assert.assertNull(s6.getRight());

        Assert.assertNull(s7.getLeft());
        Assert.assertNull(s7.getRight());

        Assert.assertEquals(s8.getLeft().getValue(), s11.getValue());
        Assert.assertEquals(s8.getRight().getValue(), s10.getValue());

        Assert.assertNull(s9.getLeft());
        Assert.assertNull(s9.getRight());

        Assert.assertNull(s10.getLeft());
        Assert.assertNull(s10.getRight());

        Assert.assertEquals(s11.getLeft().getValue(), s12.getValue());
        Assert.assertNull(s11.getRight());

        Assert.assertNull(s12.getLeft());
        Assert.assertNull(s12.getRight());
    }

    @Test
    public void testMinInTree() {
        TreeNode<Integer> actual = BinaryTreeOperations.minValInTree(s1);

        Assert.assertEquals(Integer.valueOf(1), actual.getValue());
    }

    @Test
    public void testMinInTreeBFS() {
        TreeNode<Integer> actual = BinaryTreeOperations.minValInTreeBFS(s1);

        Assert.assertEquals(Integer.valueOf(1), actual.getValue());
    }

    @Test
    public void testMaxInTree() {
        TreeNode<Integer> actual = BinaryTreeOperations.maxValInTree(s1);

        Assert.assertEquals(Integer.valueOf(12), actual.getValue());
    }

    @Test
    public void testMaxInTreeBFS() {
        TreeNode<Integer> actual = BinaryTreeOperations.maxValInTreeBFS(s1);

        Assert.assertEquals(Integer.valueOf(12), actual.getValue());
    }

    @Test
    public void testCountAppearances() {
        Assert.assertEquals(1, BinaryTreeOperations.countAppearances(s1, 1));

        s3.setRight(new TreeNode<>(1, null, null));
        s5.setRight(new TreeNode<>(1, null, null));
        s6.setRight(new TreeNode<>(1, null, null));

        Assert.assertEquals(4, BinaryTreeOperations.countAppearances(s1, 1));
    }

    @Test
    public void testMaxDepth() {
        Assert.assertEquals(6, BinaryTreeOperations.maxDepth(s1));
    }

    @Test
    public void testIfBinarySearchTreeA() {
        Assert.assertTrue(BinaryTreeOperations.isOrdered(s1));
    }

    @Test
    public void testIfBinarySearchTreeB() {
        s8.setLeft(s11);
        s8.setRight(s10);

        Assert.assertFalse(BinaryTreeOperations.isOrdered(s1));
    }

    @Test
    public void testIfBinarySearchTreeC() {
        s3.setLeft(null);
        s3.setRight(s6);

        Assert.assertFalse(BinaryTreeOperations.isOrdered(s1));
    }

    @Test
    public void testIfBinarySearchTreeD() {
        s3.setLeft(null);
        s12.setRight(s6);

        Assert.assertFalse(BinaryTreeOperations.isOrdered(s1));
    }
}