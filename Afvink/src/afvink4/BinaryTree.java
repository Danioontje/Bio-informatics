/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afvink4;

/**
 *
 * @author danis
 */
//klasse voor het maken van een binarire boom
import java.util.*;
public class BinaryTree<E> {

    //variabelen

    private E userObject;
    private BinaryTree<E> parent, leftchild, rightchild;
    private static StringBuffer buffer;
    private Queue<BinaryTree<E>> q;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;

    //constructors   
    public BinaryTree(E userObject) {
        this.userObject = userObject;
        leftchild = null;
        rightchild = null;
        parent = null;
    }

    public BinaryTree() {
        this(null);
    }
    //toevoegen van een node in de tree (bij meer dan twee exception)
    //roept de insert aan voor het daadwerkelijke toevoegen

    public void add(BinaryTree<E> newchild) {
        if (leftchild == null) {
            insert(newchild, LEFT);
        } else if (rightchild == null) {
            insert(newchild, RIGHT);
        } else {
            throw new IllegalArgumentException("Meer dan 2 kinderen");
        }
    }

    public void insert(BinaryTree<E> newchild, int childIndex) {
        newchild.parent = this;
        if (childIndex == LEFT) {
            leftchild = newchild;

        } else {
            rightchild = newchild;
        }
    }

    //override userobject to string
    public String toString() {
        return userObject.toString();
    }

    //preordered de tree
    public String preOrderString() {
        buffer = new StringBuffer();
        preOrder();
        return buffer.toString();

    }

    //als er links een kind is dan wordt de preOrder aangeroepen (recursive)
    //Dus eerst wordt de wortel toegevoegd in de buffer.append
    //in userobject staat de informatie die in de knoop is opgeslagen
    //zo de hele tijd wordt eerst links aan de buffer toegevoegd en als er geen 
    //linker kind meer is dan worden de rechterkinderen toegevoegd. 

    private void preOrder() {
        buffer.append(userObject.toString());

        if (leftchild != null) {
            leftchild.preOrder();
        }
        if (rightchild != null) {
            rightchild.preOrder();
        }

    }

    public String InOrderString() {
        buffer = new StringBuffer();
        InOrder();
        return buffer.toString();
    }
    
    //Eerste helemaal naar links onder dat is D,
    //totaan dat ie null is wordt er geappend
    //dan wordt de linkerkant daarboven geappend
    //dan naar de rechterkant van B weer de onderste linkerkant = f
    //dan e appenden etc.
    private void InOrder() {
        if (leftchild != null) {
            leftchild.InOrder();
        }
        buffer.append(userObject.toString());
        if (rightchild != null) {
            rightchild.InOrder();
        }

    }
   //toevoegen aan de string vindt pas plaats na het doorlopen
    //dus eerst linkerkanten onderaan en dan naar de rechterkanten
    public String postOrderString(){
        buffer = new StringBuffer();
        postOrder();
        return buffer.toString();
    }
    
    private void postOrder(){
        if (leftchild != null) {
            leftchild.postOrder();
        }
        if (rightchild != null) {
            rightchild.postOrder();
        }
        buffer.append(userObject.toString());
    }
    
    public String levelOrderString(){
        buffer = new StringBuffer();
        q = new ArrayDeque<BinaryTree<E>>();
        q.add(this);
        levelOrder();
        return buffer.toString();
    }
    
    public void levelOrder(){
        while(!q.isEmpty()){
            BinaryTree<E> knoop = q.remove();
            buffer.append(knoop.userObject.toString());
            if (knoop.leftchild != null) {
                q.add(knoop.leftchild);
            }
            if (knoop.rightchild != null) {
                q.add(knoop.rightchild);
            }
            
        }
    }

    //getters

    public E get() {
        return userObject;
    }

    public BinaryTree<E> getLeftChild() {
        return leftchild;
    }

    public BinaryTree<E> getRightChild() {
        return rightchild;
    }

    public BinaryTree<E> getParent() {
        return parent;
    }
}
