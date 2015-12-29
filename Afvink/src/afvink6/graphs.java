/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afvink6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author danis
 */
public class graphs {

    private String fastaHeader;
    private String sequence;
  
    private Map<String, String> data = new HashMap<String, String>();

    public void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Users\\Dani\\Documents\\School\\OWE6A\\OWE6\\src\\afvink6\\sample.txt"));
            String line = reader.readLine();

            while (line != null) {
                if (line.contains(">")) {
                    fastaHeader = line;
                    line = reader.readLine();
                } else {
                    sequence = line; 
                    data.put(sequence, fastaHeader);
                    line = reader.readLine();
                }
            }            
        } catch (FileNotFoundException exception) {
            JOptionPane.showMessageDialog(null, exception);

        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, exception);
        }
    }

    public void overlap() {
        List<String> listSeq = new ArrayList<String>(data.keySet());
        for (int i = 0; i < listSeq.size(); i++) {
            String seq = listSeq.get(i);
            String first = seq.substring(0, 3);
            String last = seq.substring(seq.length() - 3);          
            for (int j = 0; j < listSeq.size(); j++) {
                String test = listSeq.get(j);               
                if (first.equals(test.substring(test.length() - 3))) {
                    if (data.get(seq).equals(data.get(test)) == false) {
                        System.out.println(data.get(seq) + " : " + data.get(test));
                    }
                }             
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("Werkt");
        graphs test = new graphs();
        test.readFile();
        test.overlap();
    }
}
