/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afvink3;

import javax.swing.*;
import java.io.*;

import java.util.*;

/**
 *
 * @author danis
 */
public class GeneReaderMens {

    private String gene_id;
    private String symbol;
    private String chrom_map;
    private ArrayList<GeneReaderMens> gene_list = new ArrayList<GeneReaderMens>();
    
    //deze kun je ook omzetten naar arrayliat ipv linked list
    private List<Object> chrom_list = new LinkedList<Object>();
    private List<Object> genes = new LinkedList<Object>();
    private List<List> chrom_list2 = new LinkedList<List>();
   
    //private List<Object> chrom_list = new ArrayList<Object>();
    //private List<Object> genes = new ArrayList<Object>();
    //private List<List> chrom_list2 = new ArrayList<List>();
    

    
    public static void main(String[] args) {
        
        GeneReaderMens gene1 = new GeneReaderMens(null, null, null);
        gene1.read();
        gene1.CreateList();
        
        //print de chromosomen en genen
        for (int i = 0; i < gene1.chrom_list.size(); i++) {
            System.out.println("chromosoom: " + gene1.chrom_list.get(i) + " " + gene1.chrom_list2.get(i));
            System.out.println("\n");
        }
    
     
 
    }

    public GeneReaderMens(String gene_id, String symbol, String chrom_map) {
        super();
        this.gene_id = gene_id;
        this.symbol = symbol;
        this.chrom_map = chrom_map;
    }

    public void read() {

        try {
            BufferedReader file1 = new BufferedReader(new FileReader("D:\\Users\\Dani\\Documents\\School\\OWE6A\\OWe6AJAVA\\src\\afvink2\\Homo_sapiens.gene_info"));
            StringBuilder sb = new StringBuilder();
            String lineFile1 = file1.readLine();
            lineFile1 = file1.readLine();

            while (lineFile1 != null) {
                String read[] = lineFile1.split("\t");
                //lezen van file en de correcte variabelen eruithalen en in object gen stoppen
                gene_id = read[2];
                symbol = read[3];
                chrom_map = read[7];
                for (int i = 0; i < chrom_map.length(); i++) {
                    if (chrom_map.charAt(i) == 'p') {
                        chrom_map = chrom_map.substring(0, i);

                    } else if (chrom_map.charAt(i) == 'q') {
                        chrom_map = chrom_map.substring(0, i);

                    } else if (chrom_map.charAt(i) == 'c') {
                        chrom_map = chrom_map.substring(0, i);

                    }
                }

                gene_list.add(new GeneReaderMens(gene_id, symbol, chrom_map));
                
                lineFile1 = file1.readLine();
            }

        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, exception);

        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, exception);
        }

    }

    public void CreateList() {
        // lijst met unieke waarden
        long startTime = System.currentTimeMillis();
        for (GeneReaderMens gene : gene_list) {
            if (!chrom_list.contains(gene.getChromLoc())) {
                chrom_list.add(gene.getChromLoc());
            }
        }

        //while loop i kleiner dan de unieke waarden in chromosoom lijst
        //kijkt of object gen dat chromosoom heeft zo ja stopt in lijst
        //maakt de lijst leeg nadat het eerste chromsoom is doorlopen en gaat weer door naar de volgende etc.
        int i = 0;
        while (i < chrom_list.size()) {
            for (GeneReaderMens gene : gene_list) {
                if (gene.getChromLoc().equals(chrom_list.get(i)) == true) {
                    genes.add(gene.getGene_id());
                    
                }
            }
            chrom_list2.add(genes);
            genes = new LinkedList();
            i++;
        }
        long endTime = System.currentTimeMillis();
        //System.out.println(endTime - startTime);
    }

    public String getGene_id() {
        return gene_id;

    }

    public String getChromLoc() {
        return chrom_map;
    }

    public String getSymbol() {
        return symbol;

    }

    public void setGene_id(String gene_id) {
        this.gene_id = gene_id;
    }

    public void setChromLoc(String chrom_map) {
        this.chrom_map = chrom_map;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
