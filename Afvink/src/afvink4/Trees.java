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

import javax.swing.*;
import javax.swing.tree.*;

public class Trees extends JFrame {

    public static void main(String[] args) {
        Trees frame = new Trees();
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tree opbouw invulling eerste semester derde jaar");
        frame.setContentPane(new Boom());
        frame.setVisible(true);
    }

}

class Boom extends JTree {
    private DefaultTreeModel treeModel;
    
    public Boom() {
        //de standaard treemodel
        DefaultMutableTreeNode wortel, kind1, kind2, kleinkind1, kleinkind2, kleinkind3, kleinkind4, kleinkind5,
                achterkk1,achterkk2,achterkk3,achterkk4, achterakk1, achterakk2, achterakk3, achterakk4, wereld, achterakk5;
                
        wortel = new DefaultMutableTreeNode("Derde jaar");
        kind1 = new DefaultMutableTreeNode("Stage");
        kind2 = new DefaultMutableTreeNode("Minor");
        kleinkind1 = new DefaultMutableTreeNode("Nederland");
        kleinkind2 = new DefaultMutableTreeNode("Buitenland");
        kleinkind3 = new DefaultMutableTreeNode("HAN");
        kleinkind4 = new DefaultMutableTreeNode("Andere Hogeschool");
        kleinkind5 = new DefaultMutableTreeNode("Universiteit (PreMaster)");
        achterkk1 = new DefaultMutableTreeNode("Nijmegen");
        achterkk2 = new DefaultMutableTreeNode("Wageningen");
        achterkk3 = new DefaultMutableTreeNode("Utrecht");
        achterkk4 = new DefaultMutableTreeNode("Europa");
        wereld = new DefaultMutableTreeNode("Rest van de Wereld");
        achterakk1 = new DefaultMutableTreeNode("Radboud UMC");
        achterakk2 = new DefaultMutableTreeNode("Radboud Universiteit");
        achterakk3 = new DefaultMutableTreeNode("WUR");
        achterakk4 = new DefaultMutableTreeNode("KeyGene");
        achterakk5 = new DefaultMutableTreeNode("GeneTwister");
        
        
        wortel.add(kind1);
        wortel.add(kind2);
        kind1.add(kleinkind1);
        kind1.add(kleinkind2);
        kind2.add(kleinkind3);
        kind2.add(kleinkind4);
        kind2.add(kleinkind5);
        kleinkind1.add(achterkk1);
        kleinkind1.add(achterkk2);
        kleinkind1.add(achterkk3);
        kleinkind2.add(achterkk4);
        kleinkind2.add(wereld);
        achterkk1.add(achterakk1);
        achterkk1.add(achterakk2);
        achterkk2.add(achterakk3);
        achterkk2.add(achterakk4);
        achterkk2.add(achterakk5);
        //aangepaste treemodel
        DefaultMutableTreeNode Maastricht, Leiden, Amsterdam, Oss, DenBosch, Hilversum,Deventer, Delft, Groningen, 
                Hubrecht,UMC,GenDX,BigCat,LUMC,VU,UVA,PRI,Greenvision,NIZO,Merck,PamGene,SVI,Mercachem, Frieslandcampina, DSM,Hanze;
        DefaultMutableTreeNode UK, Duitsland, Frankrijk, Spanje, Belgie, Schotland, Australie, Cambridge, Manchester, Heidelberg,
        Muzillac, Valencia, Charleroi, Dundee, Brisbane, EBI, Taverna, EMBL, Korilog, CIPF, DNAvision, SCRI, QueenslandUNI;
        
        //in nederland steden kleinkind1
        Maastricht = new DefaultMutableTreeNode("Maastricht");
        Leiden = new DefaultMutableTreeNode("Leiden");
        Amsterdam = new DefaultMutableTreeNode("Amsterdam");
        Oss = new DefaultMutableTreeNode("Oss");
        DenBosch= new DefaultMutableTreeNode("Den Bosch");
        Hilversum = new DefaultMutableTreeNode("Hilversum");
        Deventer = new DefaultMutableTreeNode("Deventer");
        Delft = new DefaultMutableTreeNode("Delft");
        Groningen = new DefaultMutableTreeNode("Groningen");
        
        kleinkind1.add(Maastricht);
        kleinkind1.add(Leiden);
        kleinkind1.add(Amsterdam);
        kleinkind1.add(Oss);
        kleinkind1.add(DenBosch);
        kleinkind1.add(Hilversum);
        kleinkind1.add(Deventer);
        kleinkind1.add(Delft);
        kleinkind1.add(Groningen);
        
        //in buitenland achterkk4 eruropa, wereld rest van de wereld
        UK = new DefaultMutableTreeNode("UK");
        Duitsland = new DefaultMutableTreeNode("Duitsland");
        Frankrijk = new DefaultMutableTreeNode("Frankrijk");
        Spanje = new DefaultMutableTreeNode("Spanje");
        Belgie = new DefaultMutableTreeNode("'Belgie");
        Schotland = new DefaultMutableTreeNode("Schotland");
        Australie = new DefaultMutableTreeNode("Australie");
                
        achterkk4.add(UK);
        achterkk4.add(Duitsland);
        achterkk4.add(Frankrijk);
        achterkk4.add(Spanje);
        achterkk4.add(Belgie);
        achterkk4.add(Schotland);
        wereld.add(Australie);
             
        ///en nu vind ik het wel gebakken ik hoef dit geen honderduizend keer te doen 
        
                
        treeModel = new DefaultTreeModel(wortel);
        setModel(treeModel);
                
        
        
        
        
        
        
    }

}
