/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author omaripayne
 */
public class BinaryTree {
    
    private BinaryTree() {
    }
    
    public static BinaryTree getInstance() {
        return BinaryTreeHolder.INSTANCE;
    }
    
    private static class BinaryTreeHolder {

        private static final BinaryTree INSTANCE = new BinaryTree();
    }
}
