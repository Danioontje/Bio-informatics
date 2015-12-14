/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afvink5;

import java.util.HashMap;
import java.util.*;

/**
 *
 * @author danis
 */
public class AminoHash {

    private HashMap<String, List> aminoacids = new HashMap<String, List>(20);
    private String getAmino;
    private static final Set<String> ONE = new HashSet<String>(Arrays.asList(new String[]{"A", "R", "N", "D", "C",
        "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"}));
    private static final Set<String> THREE = new HashSet<String>(Arrays.asList(new String[]{"ALA", "ARG", "ASN", "ASP", "CYS", "GLN", "GLU", "GLY",
        "HIS", "ILE", "LEU", "LYS", "MET", "PHE", "PRO", "SER",
        "THR", "TRP", "TYR", "VAL"}));
    private static final Set<String> AA = new HashSet<String>(Arrays.asList(new String[]{"ALANINE", "ARGININE", "ASPARAGINE", "ASPARAGINEZUUR", "CYSTEINE", "GLUTAMINE", "GLUTAMINEZUUR",
        "GLYCINE", "HISTIDINE", "ISOLEUCINE", "LEUCINE", "LYSINE", "METHIONINE", "PHENYLALANINE", "PROLINE", "SERINE",
        "THREONINE", "TRYPTOFAAN", "TYROSINE", "VALINE"}));

    public AminoHash() {

        List<String> AminoA = Arrays.asList("ALA", "Alanine");
        List<String> AminoR = Arrays.asList("ARG", "Arganine");
        List<String> AminoN = Arrays.asList("ASN", "Asparagine");
        List<String> AminoD = Arrays.asList("ASP", "Aspartaat");
        List<String> AminoC = Arrays.asList("CYS", "Cysteine");
        List<String> AminoE = Arrays.asList("GLU", "Glutamaat");
        List<String> AminoQ = Arrays.asList("GLN", "Glutamine");
        List<String> AminoG = Arrays.asList("GLY", "Glycine");
        List<String> AminoH = Arrays.asList("HIS", "Histidine");
        List<String> AminoI = Arrays.asList("ILE", "Isoleucine");
        List<String> AminoL = Arrays.asList("LEU", "Leucine");
        List<String> AminoK = Arrays.asList("LYS", "lysine");
        List<String> AminoM = Arrays.asList("MET", "Methionine");
        List<String> AminoF = Arrays.asList("PHE", "Phenylalanine");
        List<String> AminoP = Arrays.asList("PRO", "Proline");
        List<String> AminoS = Arrays.asList("SER", "Serine");
        List<String> AminoT = Arrays.asList("THR", "Threonine");
        List<String> AminoW = Arrays.asList("TRP", "Tryptofaan");
        List<String> AminoY = Arrays.asList("TYR", "Tyrosine");
        List<String> AminoV = Arrays.asList("VAL", "Valine");

        aminoacids.put("A", AminoA);
        aminoacids.put("R", AminoR);
        aminoacids.put("N", AminoN);
        aminoacids.put("D", AminoD);
        aminoacids.put("C", AminoC);
        aminoacids.put("E", AminoE);
        aminoacids.put("Q", AminoQ);
        aminoacids.put("G", AminoG);
        aminoacids.put("H", AminoH);
        aminoacids.put("I", AminoI);
        aminoacids.put("L", AminoL);
        aminoacids.put("K", AminoK);
        aminoacids.put("M", AminoM);
        aminoacids.put("F", AminoF);
        aminoacids.put("P", AminoP);
        aminoacids.put("S", AminoS);
        aminoacids.put("T", AminoT);
        aminoacids.put("W", AminoW);
        aminoacids.put("Y", AminoY);
        aminoacids.put("V", AminoV);
    }

    public static void main(String args[]) {
        AminoHash Amino = new AminoHash();
        Scanner user_input = new Scanner(System.in);

        System.out.println("Voer je aminozuur in (eenletter, drieletter of volledige naam)");
        Amino.getAmino = user_input.next();
        System.out.println("Het ingevoerde Aminozuur is :" + Amino.getAmino);
        Amino.CheckAmino();

    }

    public void CheckAmino() {
        getAmino.toUpperCase();
        if (getAmino.length() == 1) {
            System.out.println(getAmino);
            if (ONE.contains(getAmino) == false) {
                System.out.println("Geen Aminozuur");
            } else {
                One2All();
            }
        }

        if (getAmino.length() == 3) {
            if (THREE.contains(getAmino) == false) {
                System.out.println("Geen Aminozuur");
            }
        }
        if (getAmino.length() >= 4) {
            if (AA.contains(getAmino) == false) {
                System.out.println("Geen Aminozuur");
            }
            
        }
    }

    public void One2All() {
        List a = aminoacids.get(getAmino);
        System.out.println("De drielettercode van dit aminozuur is: " + a.get(0));
        System.out.println("De volledige naam van dit aminozuur is: " + a.get(1));
    }
}
