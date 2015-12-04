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
public class OrderBinaryTree {
    
    public static void main(String[] args) {
       BinaryTree<String> root,knoopB,knoopC,knoopD,knoopE,knoopF,knoopG;
    
       root = new BinaryTree<String>("A");
       knoopF = new BinaryTree<String>("F");
       knoopG = new BinaryTree<String>("G");
       knoopD = new BinaryTree<String>("D");
       knoopC = new BinaryTree<String>("C");
       knoopB = new BinaryTree<String>("B");
       knoopE = new BinaryTree<String>("E");
       
       //root is parent van knoop b en c
       //knoop b is parent van knoop d en e
       //knoop e is parent van knoop f en g
       root.add(knoopB);
       root.add(knoopC);
       knoopB.add(knoopD);
       knoopB.add(knoopE);
       knoopE.add(knoopF);
       knoopE.add(knoopG);
       System.out.println("A is de parent van B & C, B van D & E, E van F & G");
       System.out.println("de Preorder van deze boom is: "+root.preOrderString());
       System.out.println("de Inorder van deze boom is: "+root.InOrderString());
       System.out.println("de Postorder van deze boom is: "+root.postOrderString());
       System.out.println("de LevelOrder van deze boom is: "+root.levelOrderString());
   }
   
   



    
    
}
