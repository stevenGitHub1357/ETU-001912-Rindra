package fenetre;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import ecouteur.*;
import upload.*;
public class Tableau1 extends JPanel{
    JPanel pan = new JPanel();
        JPanel pan1 = new JPanel();
        JPanel conteneur = new JPanel();
        JPanel contenu = new JPanel();
        JTextArea textPane = new JTextArea();
        JTextField text = new JTextField();
        JTextField text1 = new JTextField();
        JButton envoyer = new JButton("Envoyer");
        JButton actu = new JButton("Actualiser");
        JLabel lab = new JLabel("BIENVENU SUR APPSPOONADRAAP");
        JLabel lab1 = new JLabel("okokoko");
        BorderLayout bord = new BorderLayout();
        Upload up = new Upload();
        Vector<String> str = up.getMessageServer("Server.txt");
        Vector<String> str1 = up.getMessageServer("Client.txt");
        JLabel[] anatiny = new JLabel[str.size()];
        JLabel[] anatiny1 = new JLabel[str1.size()];
        int x = 10;
        //JScrollPane scroll = new JScrollPane(contenu);
        //int y = 10;
        //Vector<String> str = new Vector<String>();
        Fenetre1 fen;
        public Tableau1(Fenetre1 fen){
        this.fen = fen;
        this.setSize(800,400);
        this.setLayout(null);
        lab.setBounds(300,20,200,60);
        pan.setBounds(200,250,400,60);
        pan.setBackground(Color.gray);
        text.setPreferredSize(new Dimension(250, 50));
        pan.add(text);
        pan1.setBounds(500,250,200,60);
        envoyer.setBackground(Color.BLUE);
        envoyer.setForeground(Color.WHITE);
        envoyer.setPreferredSize(new Dimension(100, 30));
        envoyer.addMouseListener(new Mousse1(this,fen.getSocket()));
        pan.add(envoyer);
        //contenu.add(lab1);
      	message1(anatiny,str,anatiny1,str1);
        contenu.setBounds(200,80,400,150);
        //scroll.setPreferredSize(new Dimension(200,100));
        /*conteneur.add(scroll,BorderLayout.EAST);
        conteneur.setBounds(200,80,400,150);
       	conteneur.setLayout(bord);
        conteneur.add(contenu,BorderLayout.CENTER);*/
       
        //System.out.println(str.get(0));
        //contenu.setBackground(Color.red);
        //contenu.add(scroll);
        actu.setBounds(10,10,100,20);
        actu.addMouseListener(new Mousse1(this,fen.getSocket()));     
        this.add(contenu);
        this.add(actu);
        //this.validate();
        this.add(pan);
        this.add(pan1);
        this.add(lab);
       
    }
        public JButton getBouton(){
                return this.envoyer;
        }
        public JButton getBouton1(){
                return this.actu;
        }
        public JTextField getField(){
                return this.text;
        }
        public JLabel[] getLabel1(){
                return this.anatiny1;
        }
        public void setLabel1(JLabel[] lab){
                this.anatiny1 = lab;
        }
        public JLabel[] getLabel(){
                return this.anatiny;
        }
        public void setLabel(JLabel[] lab){
                this.anatiny = lab;
        }
        public Vector<String> getMessageAffichier(){
                return this.str;
        }
        public Vector<String> getMessageAffichier1(){
                return this.str1;
        }
        public void setMessageAffichier(Vector<String> str1){
                this.str = str1;
        }
        public void setMessageAffichier1(Vector<String> str){
                this.str1 = str;
        }

        public void message1(JLabel[] lab,Vector<String> str,JLabel[] lab1,Vector<String> str1){
        	int y =5; int x =200; int y1=5;
       		//System.out.println(anatiny.length);
        	for(int i=2;i<lab.length;i++){
                contenu.setLayout(null);
                lab[i] = new JLabel(str.get(i));
                lab[i].setBounds(10,y,200,20);
                lab[i].setForeground(Color.blue);
                contenu.add(lab[i]);
                /*anatiny1[i] = new JLabel(str1.get(i));
                anatiny1[i].setBounds(x,y,200,20);
                anatiny1[i].setBackground(Color.gray);
                contenu.add(anatiny1[i]);*/
                y = y+30; 
                //System.out.println(y);
        	}
        	for(int p=2;p<lab1.length;p++){
            	lab1[p] = new JLabel(str1.get(p));
            	lab1[p].setBounds(x,y1,200,20);
            	lab1[p].setForeground(Color.gray);
            	contenu.add(lab1[p]);
             	y1 = y1+30;
        	}
        }

        public void start(){
            this.removeAll();
            
            //this.add(contenu);
            message1(getLabel(),getMessageAffichier(),getLabel1(),getMessageAffichier1());
            this.add(contenu);
            this.add(actu);
            this.add(pan);
            this.add(pan1);
            this.add(lab);
           
           
            repaint();
         
        }
}