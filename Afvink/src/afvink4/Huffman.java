/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afvink4;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import javax.swing.tree.*;
import javax.swing.*;

/**
 *
 * @author danis
 */
public class Huffman extends JTree{

    private String DNA = "tatgccaatgcatttttgcccgcatgaagcatgtagcgcgcatgcctacctgcacgc";
    
    private List<Integer> frequencyDNA = new LinkedList<Integer>();
   private static StringBuffer buffer;
    private DefaultMutableTreeNode wortel, kind1, kind2, kleinkind1,kleinkind2, kkind1, kkind2;
    private DefaultTreeModel treeModel;
    private int leftchild, rightchild, leftparent, rightparent, leftpp, rightpp, parent;

    public static void main(String[] args) {
        Huffman huf1 = new Huffman();
        Trees frame = new Trees();
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Huffman tree");
        frame.setContentPane(huf1);
        huf1.frequency();
        huf1.CreateHuff();
        huf1.DNAbinary();
        System.out.println(huf1.DNA.length()*8);
        frame.setVisible(true);
    }

    public void frequency() {
        int counter_a = 0;
        int counter_t = 0;
        int counter_c = 0;
        int counter_g = 0;
        
        for (int i = 0; i < DNA.length(); i++) {
            if (DNA.charAt(i) == 'a') {
                counter_a++;
            }
            if(DNA.charAt(i) == 't') {
                counter_t++;
        }
            if(DNA.charAt(i) == 'c') {
                counter_c++;
            }
            if (DNA.charAt(i) == 'g') {
                counter_g++;
            }
    }
        System.out.println("a: " + counter_a + "t: " + counter_t+ "c: "+counter_c + "g: " + counter_g);
        frequencyDNA.add(counter_g);
        frequencyDNA.add(counter_a);
        frequencyDNA.add(counter_t);
        frequencyDNA.add(counter_c);
        Collections.sort(frequencyDNA);
        
    }
    
    //heel lelijk geprogrameerd maar dit is zo'n beetje het principe
    public void CreateHuff(){
        int sum = 0;
            sum = frequencyDNA.get(0)+frequencyDNA.get(1);  
            leftchild = frequencyDNA.get(0);
            rightchild = frequencyDNA.get(1);
            frequencyDNA.remove(0);
            frequencyDNA.remove(0);
            frequencyDNA.add(sum);
            Collections.sort(frequencyDNA);
            leftparent = frequencyDNA.get(0);
            rightparent = frequencyDNA.get(1);
            sum = leftparent+rightparent;
            frequencyDNA.remove(0);
            frequencyDNA.remove(0);
            frequencyDNA.add(sum);
            Collections.sort(frequencyDNA);
            leftpp = frequencyDNA.get(0);
            rightpp = frequencyDNA.get(1);
            parent = leftpp+rightpp;
            
            wortel = new DefaultMutableTreeNode(parent);
            kind1 = new DefaultMutableTreeNode(leftpp);
            kind2 = new DefaultMutableTreeNode(rightpp);
            kleinkind1 = new DefaultMutableTreeNode(leftparent);
            kleinkind2 = new DefaultMutableTreeNode(rightparent);
            kkind1 = new DefaultMutableTreeNode(leftchild);
            kkind2 = new DefaultMutableTreeNode(rightchild);
            
            wortel.add(kind1);
            wortel.add(kind2);
            kind1.add(kleinkind1);
            kind1.add(kleinkind2);
            kleinkind1.add(kkind1);
            kleinkind1.add(kkind2);
       
        treeModel = new DefaultTreeModel(wortel);
        setModel(treeModel);
    }
    
    public void DNAbinary(){
        buffer = new StringBuffer();
        for (int i = 0; i < DNA.length(); i++) {
            if (DNA.charAt(i) == 'a') {
                buffer.append(000);
            }
            if(DNA.charAt(i) == 't') {
                buffer.append(00);
        }
            if(DNA.charAt(i) == 'c') {
               buffer.append(01); 
            }
            if (DNA.charAt(i) == 'g') {
                buffer.append(001);
            }
    }
        System.out.println(buffer);
        System.out.println(buffer.length());
}
    
}

    
