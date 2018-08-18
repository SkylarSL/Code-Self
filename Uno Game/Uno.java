package uno;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author SkylarSL
 */
public class Uno extends javax.swing.JFrame {

   
    

    /**
     * Creates new form Uno
     */
    
    //make important players and deck
    private Deck Deck = new Deck();
    private Deck Discard = new Deck();
    private ArrayList<JButton> hand= new ArrayList();
    private Player player = new Player("", 0);
    private AIone c1 = new AIone("", 0);
    private AItwo c2 = new AItwo("", 0);
    private Timer timer;
    //other variables to help run the game
    private boolean reverse = true;
    private int pickup = 0;
    private int once = 0;
    private int UNOcount = 0;
    private int oneCard=0;

    
    public Uno() {
        
       
        
        initComponents();
         BufferedReader read = null;
        try {
            read = new BufferedReader(new FileReader("src/uno/Initialize.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Uno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String names=null;
        try {
             names= read.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Uno.class.getName()).log(Level.SEVERE, null, ex);
        }
        StringTokenizer t = new StringTokenizer(names," ,");
        String pname = t.nextToken();
        int pscore = Integer.parseInt(t.nextToken());
        String onename = t.nextToken();
        int onescore = Integer.parseInt(t.nextToken());
        String twoname = t.nextToken();
        int twoscore = Integer.parseInt(t.nextToken());
        player = new Player(pname,pscore);
        c1 = new AIone(onename,onescore);
        c2 = new AItwo(twoname,twoscore);
        c1name.setText(c1.getName()+" score: "+c1.getScore());
        c2name.setText(c2.getName()+" score: "+c2.getScore());
        playername.setText(player.getName()+" score: "+player.getScore());
        //initialize the visuals
        pile.setVisible(false);
        Blue.setVisible(false);
        Green.setVisible(false);
        Red.setVisible(false);
        Yellow.setVisible(false);
        UNO.setVisible(false);
        pass.setVisible(false);
        left.setVisible(false);
        right.setVisible(false);
        restart.setVisible(false);
        shuffling.setVisible(false);
        deck.setEnabled(false);
        c1text.setText("");
        c2text.setText("");
        c1uno.setText("");
        c2uno.setText("");
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);
        hand.add(card6);
        hand.add(card7);
        hand.add(card8);
        hand.add(card9);
        hand.add(card10);
        hand.add(card11);
        hand.add(card12);
        hand.add(card13);
        hand.add(card14);
        hand.add(card15);
        hand.add(card16);
        hand.add(card17);
        hand.add(card18);
        hand.add(card19);
        hand.add(card20);
        hand.add(card21);

        //make a specific uno deck
        for(int i=0;i<4;i++){
                Deck.pile(new Card("wild",40));
                Deck.pile(new Card("wild",44));
            }
            for(int i=0;i<2;i++){
                for(int j=1;j<10;j++){
                    Deck.pile(new Card("blue",j));
                    Deck.pile(new Card("green",j));
                    Deck.pile(new Card("red",j));
                    Deck.pile(new Card("yellow",j));
                }
            }
            for(int i=0;i<1;i++){
                Deck.pile(new Card("blue",0));
                Deck.pile(new Card("green",0));
                Deck.pile(new Card("red",0));
                Deck.pile(new Card("yellow",0));
            }
            for(int j=0;j<2;j++){

                Deck.pile(new Card("blue",12));
                Deck.pile(new Card("blue",18));
                Deck.pile(new Card("blue",10));

                Deck.pile(new Card("green",12));
                Deck.pile(new Card("green",18));
                Deck.pile(new Card("green",10));

                Deck.pile(new Card("red",12));
                Deck.pile(new Card("red",18));
                Deck.pile(new Card("red",10));

                Deck.pile(new Card("yellow",12));
                Deck.pile(new Card("yellow",18));
                Deck.pile(new Card("yellow",10));
            }
        
        //shuffle the deck
        Deck.shuffle(Deck.count());

        //deal cards to players
        for(int i=0;i<7;i++){
            Card x = Deck.deal();
            player.addCard(x);
            addCards(x);
            c1.addCard(Deck.deal());
            c2.addCard(Deck.deal());
        }
        
        //deal top card to pile
        Card x = Deck.deal();
        Discard.pile(x);
        
        //set images of pile and deck
        try {
            Image img = ImageIO.read(getClass().getResource("card_back.png"));
            deck.setIcon(new ImageIcon(img));
        } catch (Exception ex) {}
        
        try {
            Image img = ImageIO.read(getClass().getResource(x.getImage()));
            pile.setIcon(new ImageIcon(img));
        } catch (Exception ex) {}
        
        //initialize player hand
        card1.setVisible(false);
        card2.setVisible(false);
        card3.setVisible(false);
        card4.setVisible(false);
        card5.setVisible(false);
        card6.setVisible(false);
        card7.setVisible(false);
        card8.setVisible(false);
        card9.setVisible(false);
        card10.setVisible(false);
        card11.setVisible(false);
        card12.setVisible(false);
        card13.setVisible(false);
        card14.setVisible(false);
        card15.setVisible(false);
        card16.setVisible(false);
        card17.setVisible(false);
        card18.setVisible(false);
        card19.setVisible(false);
        card20.setVisible(false);
        card21.setVisible(false);
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        restart = new javax.swing.JButton();
        UNO = new javax.swing.JButton();
        card21 = new javax.swing.JButton();
        card20 = new javax.swing.JButton();
        card19 = new javax.swing.JButton();
        card18 = new javax.swing.JButton();
        card17 = new javax.swing.JButton();
        card16 = new javax.swing.JButton();
        card15 = new javax.swing.JButton();
        card14 = new javax.swing.JButton();
        card13 = new javax.swing.JButton();
        card12 = new javax.swing.JButton();
        card11 = new javax.swing.JButton();
        card10 = new javax.swing.JButton();
        card9 = new javax.swing.JButton();
        card8 = new javax.swing.JButton();
        card7 = new javax.swing.JButton();
        card6 = new javax.swing.JButton();
        card5 = new javax.swing.JButton();
        card4 = new javax.swing.JButton();
        card3 = new javax.swing.JButton();
        card2 = new javax.swing.JButton();
        card1 = new javax.swing.JButton();
        pile = new javax.swing.JLabel();
        deck = new javax.swing.JButton();
        c1text = new javax.swing.JLabel();
        c2text = new javax.swing.JLabel();
        Start = new javax.swing.JButton();
        Blue = new javax.swing.JButton();
        Green = new javax.swing.JButton();
        Red = new javax.swing.JButton();
        Yellow = new javax.swing.JButton();
        pass = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        signal = new javax.swing.JLabel();
        right = new javax.swing.JLabel();
        left = new javax.swing.JLabel();
        c1uno = new javax.swing.JLabel();
        c2uno = new javax.swing.JLabel();
        c2name = new javax.swing.JLabel();
        c1name = new javax.swing.JLabel();
        playername = new javax.swing.JLabel();
        Colour = new java.awt.Panel();
        shuffling = new javax.swing.JButton();
        card = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1250, 1250));
        getContentPane().setLayout(null);

        restart.setFont(new java.awt.Font("Tahoma", 0, 150)); // NOI18N
        restart.setText("RESTART?");
        restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartActionPerformed(evt);
            }
        });
        getContentPane().add(restart);
        restart.setBounds(160, 780, 910, 160);

        UNO.setBackground(new java.awt.Color(255, 255, 255));
        UNO.setFont(new java.awt.Font("Trebuchet MS", 0, 300)); // NOI18N
        UNO.setForeground(new java.awt.Color(0, 153, 153));
        UNO.setText("UNO!");
        UNO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UNOActionPerformed(evt);
            }
        });
        getContentPane().add(UNO);
        UNO.setBounds(160, 530, 910, 400);

        card21.setText("jButton1");
        card21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card21ActionPerformed(evt);
            }
        });
        getContentPane().add(card21);
        card21.setBounds(940, 750, 130, 182);

        card20.setText("jButton1");
        card20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card20ActionPerformed(evt);
            }
        });
        getContentPane().add(card20);
        card20.setBounds(810, 750, 130, 182);

        card19.setText("jButton1");
        card19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card19ActionPerformed(evt);
            }
        });
        getContentPane().add(card19);
        card19.setBounds(680, 750, 130, 182);

        card18.setText("jButton1");
        card18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card18ActionPerformed(evt);
            }
        });
        getContentPane().add(card18);
        card18.setBounds(550, 750, 130, 182);

        card17.setText("jButton1");
        card17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card17ActionPerformed(evt);
            }
        });
        getContentPane().add(card17);
        card17.setBounds(420, 750, 130, 182);

        card16.setText("jButton1");
        card16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card16ActionPerformed(evt);
            }
        });
        getContentPane().add(card16);
        card16.setBounds(290, 750, 130, 182);

        card15.setText("jButton1");
        card15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card15ActionPerformed(evt);
            }
        });
        getContentPane().add(card15);
        card15.setBounds(160, 750, 130, 182);

        card14.setText("jButton1");
        card14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card14ActionPerformed(evt);
            }
        });
        getContentPane().add(card14);
        card14.setBounds(940, 640, 130, 182);

        card13.setText("jButton1");
        card13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card13ActionPerformed(evt);
            }
        });
        getContentPane().add(card13);
        card13.setBounds(810, 640, 130, 182);

        card12.setText("jButton1");
        card12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card12ActionPerformed(evt);
            }
        });
        getContentPane().add(card12);
        card12.setBounds(680, 640, 130, 182);

        card11.setText("jButton1");
        card11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card11ActionPerformed(evt);
            }
        });
        getContentPane().add(card11);
        card11.setBounds(550, 640, 130, 182);

        card10.setText("jButton1");
        card10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card10ActionPerformed(evt);
            }
        });
        getContentPane().add(card10);
        card10.setBounds(420, 640, 130, 182);

        card9.setText("jButton1");
        card9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card9ActionPerformed(evt);
            }
        });
        getContentPane().add(card9);
        card9.setBounds(290, 640, 130, 182);

        card8.setText("jButton1");
        card8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card8ActionPerformed(evt);
            }
        });
        getContentPane().add(card8);
        card8.setBounds(160, 640, 130, 182);

        card7.setText("jButton1");
        card7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card7ActionPerformed(evt);
            }
        });
        getContentPane().add(card7);
        card7.setBounds(940, 530, 130, 182);

        card6.setText("jButton1");
        card6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card6ActionPerformed(evt);
            }
        });
        getContentPane().add(card6);
        card6.setBounds(810, 530, 130, 182);

        card5.setText("jButton1");
        card5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card5ActionPerformed(evt);
            }
        });
        getContentPane().add(card5);
        card5.setBounds(680, 530, 130, 182);

        card4.setText("jButton1");
        card4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card4ActionPerformed(evt);
            }
        });
        getContentPane().add(card4);
        card4.setBounds(550, 530, 130, 182);

        card3.setText("jButton1");
        card3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card3ActionPerformed(evt);
            }
        });
        getContentPane().add(card3);
        card3.setBounds(420, 530, 130, 182);

        card2.setText("jButton1");
        card2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card2ActionPerformed(evt);
            }
        });
        getContentPane().add(card2);
        card2.setBounds(290, 530, 130, 182);

        card1.setText("jButton1");
        card1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                card1ActionPerformed(evt);
            }
        });
        getContentPane().add(card1);
        card1.setBounds(160, 530, 130, 182);
        getContentPane().add(pile);
        pile.setBounds(600, 170, 130, 182);

        deck.setText("jButton1");
        deck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deckActionPerformed(evt);
            }
        });
        getContentPane().add(deck);
        deck.setBounds(460, 170, 130, 182);

        c1text.setText("jLabel1");
        getContentPane().add(c1text);
        c1text.setBounds(860, 390, 390, 16);

        c2text.setText("jLabel2");
        getContentPane().add(c2text);
        c2text.setBounds(20, 370, 330, 16);

        Start.setText("START");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        getContentPane().add(Start);
        Start.setBounds(560, 70, 73, 25);

        Blue.setBackground(new java.awt.Color(51, 204, 255));
        Blue.setForeground(new java.awt.Color(0, 204, 255));
        Blue.setText("Blue");
        Blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlueActionPerformed(evt);
            }
        });
        getContentPane().add(Blue);
        Blue.setBounds(390, 460, 57, 25);

        Green.setBackground(new java.awt.Color(0, 204, 102));
        Green.setForeground(new java.awt.Color(0, 204, 51));
        Green.setText("Green");
        Green.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GreenActionPerformed(evt);
            }
        });
        getContentPane().add(Green);
        Green.setBounds(480, 460, 67, 25);

        Red.setBackground(new java.awt.Color(255, 51, 51));
        Red.setForeground(new java.awt.Color(204, 0, 0));
        Red.setText("Red");
        Red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedActionPerformed(evt);
            }
        });
        getContentPane().add(Red);
        Red.setBounds(580, 460, 55, 25);

        Yellow.setBackground(new java.awt.Color(255, 204, 0));
        Yellow.setForeground(new java.awt.Color(255, 204, 51));
        Yellow.setText("Yellow");
        Yellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YellowActionPerformed(evt);
            }
        });
        getContentPane().add(Yellow);
        Yellow.setBounds(670, 460, 69, 25);

        pass.setText("pass");
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        getContentPane().add(pass);
        pass.setBounds(770, 460, 59, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/computer 2.PNG"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 60, 330, 290);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/computer 1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(840, 40, 420, 330);

        signal.setText("IT'S YOUR TURN!");
        getContentPane().add(signal);
        signal.setBounds(520, 500, 110, 20);

        right.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/right arrow.png"))); // NOI18N
        right.setText("jLabel3");
        getContentPane().add(right);
        right.setBounds(970, 430, 200, 200);

        left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uno/left arrow.png"))); // NOI18N
        left.setText("jLabel4");
        getContentPane().add(left);
        left.setBounds(90, 440, 150, 190);

        c1uno.setText("jLabel3");
        getContentPane().add(c1uno);
        c1uno.setBounds(860, 420, 390, 16);

        c2uno.setText("jLabel3");
        getContentPane().add(c2uno);
        c2uno.setBounds(20, 400, 330, 16);

        c2name.setText(".");
        getContentPane().add(c2name);
        c2name.setBounds(10, 40, 290, 16);

        c1name.setText(".");
        getContentPane().add(c1name);
        c1name.setBounds(840, 20, 310, 20);

        playername.setText(".");
        getContentPane().add(playername);
        playername.setBounds(660, 500, 240, 16);
        getContentPane().add(Colour);
        Colour.setBounds(390, 390, 440, 40);

        shuffling.setText("SHUFFLE");
        shuffling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shufflingActionPerformed(evt);
            }
        });
        getContentPane().add(shuffling);
        shuffling.setBounds(550, 120, 90, 25);

        card.setText(".");
        getContentPane().add(card);
        card.setBounds(460, 360, 130, 16);

        pack();
    }// </editor-fold>                        

    
    
    private void card2ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(1);
    }                                     

    private void card3ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(2);
    }                                     

    private void card4ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(3);
    }                                     

    private void card5ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(4);
    }                                     

    private void card6ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(5);
    }                                     

    private void card7ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(6);
    }                                     
    
    private void card1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(0);
    }                                     

    private void deckActionPerformed(java.awt.event.ActionEvent evt) {                                     
        //deal a card to the player if the int is 0, else dont
        if(pickup==0){
            Card x = Deck.deal();
            addCards(x);
            player.addCard(x);
            //update number of cards
            card.setText("card count: "+Deck.count());
        }
        pickup+=1;
        pass.setVisible(true);
    }                                    

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {                                      
        Start.setVisible(false);
        deck.setEnabled(true);
        //initialize the visuals of the game
        card1.setVisible(true);
        card2.setVisible(true);
        card3.setVisible(true);
        card4.setVisible(true);
        card5.setVisible(true);
        card6.setVisible(true);
        card7.setVisible(true);
        pile.setVisible(true);  
        pass.setVisible(true);
        shuffling.setVisible(true);
        //if top pile card is something special, apply to player
        if(Discard.topCard().getValue()==10){
            System.out.println("you got blocked");
            once++;
            computer1();
        }else if(Discard.topCard().getValue()==40){
            Blue.setVisible(true);
            Green.setVisible(true);
            Red.setVisible(true);
            Yellow.setVisible(true);
        }else if(Discard.topCard().getValue()==44){
            once++;
            System.out.println("you picked up 4 cards");
            for(int i=0;i<4;i++){
                Card y = Deck.deal();
                player.addCard(y);
                addCards(y);
            }
            card.setText("card count: "+Deck.count());
            computer1();
        }else if(Discard.topCard().getValue()==12){
            once++;
            System.out.println("you picked up 2 cards");
            for(int i=0;i<2;i++){
                Card y = Deck.deal();
                player.addCard(y);
                addCards(y);
            }
            card.setText("card count: "+Deck.count());
            computer1();
        }else if(Discard.topCard().getValue()==18){
            toggle();
        }
        //set visuals of rotation
        if(reverse==true){
            right.setVisible(true);
        }else{
            left.setVisible(true);
        }
    }                                     
    
    //buttons for wild cards
    private void BlueActionPerformed(java.awt.event.ActionEvent evt) {                                     
        //if blue button is pressed change pile card to blue
        Blue.setVisible(false);
        Green.setVisible(false);
        Red.setVisible(false);
        Yellow.setVisible(false);
        Colour.setBackground(Color.BLUE);
        Discard.topCard().setColour("blue");
        System.out.println("You changed the colour to "+Discard.topCard().getColour());
        turn(0);// TODO add your handling code here:
    }                                    

    private void GreenActionPerformed(java.awt.event.ActionEvent evt) {                                      
        //if green button is pressed change pile card to green
        Blue.setVisible(false);
        Green.setVisible(false);
        Red.setVisible(false);
        Yellow.setVisible(false);
        Colour.setBackground(Color.GREEN);
        Discard.topCard().setColour("green");
        System.out.println("You changed the colour to "+Discard.topCard().getColour());
        turn(0);// TODO add your handling code here:
    }                                     

    private void RedActionPerformed(java.awt.event.ActionEvent evt) {                                    
        //if red button is pressed change pile card to red
        Blue.setVisible(false);
        Green.setVisible(false);
        Red.setVisible(false);
        Yellow.setVisible(false);
        Colour.setBackground(Color.RED);
        Discard.topCard().setColour("red");
        System.out.println("You changed the colour to "+Discard.topCard().getColour());
        turn(0);// TODO add your handling code here:
    }                                   

    private void YellowActionPerformed(java.awt.event.ActionEvent evt) {                                       
        //if yellow button is pressed change pile card to yellow
        Blue.setVisible(false);
        Green.setVisible(false);
        Red.setVisible(false);
        Yellow.setVisible(false);
        Colour.setBackground(Color.YELLOW);
        Discard.topCard().setColour("yellow");
        System.out.println("You changed the colour to "+Discard.topCard().getColour());
        turn(0);// TODO add your handling code here:
    }                                      

    private void passActionPerformed(java.awt.event.ActionEvent evt) {                                     
        //restart comments and pass players turn
        c1text.setText("");
        c2text.setText("");
        once++;
        turn(0);
        
// TODO add your handling code here:
    }                                    

    private void card8ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(7);// TODO add your handling code here:
    }                                     

    private void card9ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        playCard(8);// TODO add your handling code here:
    }                                     

    private void card10ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(9);// TODO add your handling code here:
    }                                      

    private void card11ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(10);// TODO add your handling code here:
    }                                      

    private void card12ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(11);// TODO add your handling code here:
    }                                      

    private void card13ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(12);// TODO add your handling code here:
    }                                      

    private void card14ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(13);// TODO add your handling code here:
    }                                      

    private void card15ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(14);// TODO add your handling code here:
    }                                      

    private void card16ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(15);// TODO add your handling code here:
    }                                      

    private void card17ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(16);// TODO add your handling code here:
    }                                      

    private void card18ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(17);// TODO add your handling code here:
    }                                      

    private void card19ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(18);// TODO add your handling code here:
    }                                      

    private void card20ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(19);// TODO add your handling code here:
    }                                      

    private void card21ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        playCard(20);// TODO add your handling code here:
    }                                      

    private void UNOActionPerformed(java.awt.event.ActionEvent evt) {                                    
        UNOcount++;  // TODO add your handling code here:
    }                                   

    private void restartActionPerformed(java.awt.event.ActionEvent evt) {                                        
        //something as start button and initialize, restart entire game with name and past scores
        deck.setEnabled(true);
        restart.setVisible(false);
        reverse=true;
        player.handClear();
        c1.handClear();
        c2.handClear();
        Discard.clear();
        Deck.clear();
        //make a specific uno deck
        for(int i=0;i<4;i++){
                Deck.pile(new Card("wild",40));
                Deck.pile(new Card("wild",44));
            }
            for(int i=0;i<2;i++){
                for(int j=1;j<10;j++){
                    Deck.pile(new Card("blue",j));
                    Deck.pile(new Card("green",j));
                    Deck.pile(new Card("red",j));
                    Deck.pile(new Card("yellow",j));
                }
            }
            for(int i=0;i<1;i++){
                Deck.pile(new Card("blue",0));
                Deck.pile(new Card("green",0));
                Deck.pile(new Card("red",0));
                Deck.pile(new Card("yellow",0));
            }
            for(int j=0;j<2;j++){

                Deck.pile(new Card("blue",12));
                Deck.pile(new Card("blue",18));
                Deck.pile(new Card("blue",10));

                Deck.pile(new Card("green",12));
                Deck.pile(new Card("green",18));
                Deck.pile(new Card("green",10));

                Deck.pile(new Card("red",12));
                Deck.pile(new Card("red",18));
                Deck.pile(new Card("red",10));

                Deck.pile(new Card("yellow",12));
                Deck.pile(new Card("yellow",18));
                Deck.pile(new Card("yellow",10));
            }
        Deck.shuffle(Deck.count());
        left.setVisible(false);
        right.setVisible(false);
        card1.setIcon(null);
        card2.setIcon(null);
        card3.setIcon(null);
        card4.setIcon(null);
        card5.setIcon(null);
        card6.setIcon(null);
        card7.setIcon(null);
        pile.setVisible(true);  
        pass.setVisible(false);
        c1text.setText("");
        c2text.setText("");
        
        c1name.setText(c1.getName()+" score: "+c1.getScore());
        c2name.setText(c2.getName()+" score: "+c2.getScore());
        playername.setText(player.getName()+" score: "+player.getScore());
        for(int i=0;i<7;i++){
            Card x = Deck.deal();
            player.addCard(x);
            addCards(x);
            c1.addCard(Deck.deal());
            c2.addCard(Deck.deal());
        }
        
        Card x = Deck.deal();
        Discard.pile(x);
        card.setText("card count: "+Deck.count());
        try {
            Image img = ImageIO.read(getClass().getResource(x.getImage()));
            pile.setIcon(new ImageIcon(img));
        } catch (Exception ex) {}
        
        card1.setVisible(true);
        card2.setVisible(true);
        card3.setVisible(true);
        card4.setVisible(true);
        card5.setVisible(true);
        card6.setVisible(true);
        card7.setVisible(true);
        pile.setVisible(true);  
        pass.setVisible(false);
        
        if(Discard.topCard().getValue()==10){
            System.out.println("you got blocked");
            once++;
            computer1();
            
        }else if(Discard.topCard().getValue()==40){
            Blue.setVisible(true);
            Green.setVisible(true);
            Red.setVisible(true);
            Yellow.setVisible(true);
        }else if(Discard.topCard().getValue()==44){
            System.out.println("you picked up 4 cards");
            player.addCard(Deck.deal());
            player.addCard(Deck.deal());
            player.addCard(Deck.deal());
            player.addCard(Deck.deal());
            card.setText("card count: "+Deck.count());
            once++;
            computer1();
            
        }else if(Discard.topCard().getValue()==12){
            System.out.println("you picked up 2 cards");
            player.addCard(Deck.deal());
            player.addCard(Deck.deal());
            card.setText("card count: "+Deck.count());
            once++;
            computer1();
            
        }else if(Discard.topCard().getValue()==18){
            toggle();
        }
        
        if(reverse==true){
            right.setVisible(true);
        }else{
            left.setVisible(true);
        }
        pickup=0;
        once=0;
        oneCard=0;// TODO add your handling code here:
    }                                       

    private void shufflingActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Card x = Discard.deal();
        while(Discard.count()>0){
            Card y = Discard.deal();
            if(y.getValue()==44||y.getValue()==40){
                y.setColour("wild");
            }
            Deck.pile(y);
        }
        Discard.pile(x);
        Deck.shuffle(Deck.count());// TODO add your handling code here:
    }                                         

    
    public void playCard(int i){
        
        //restart dialog
        c1text.setText("");
        c2text.setText("");
        //check if it is players turn
        if(oneCard==0){
            //check if players chosen card is equal to pile top card
            if(player.getCard(i).getColour().equals(Discard.topCard().getColour()) || player.getCard(i).getValue()==Discard.topCard().getValue() || player.getCard(i).getColour().equals("wild")){
                //play card
                Card x = player.playCard(i);
                pile.setIcon(hand.get(i).getIcon());
                Discard.pile(x);
                //if players hand has one card, call uno for 1.5 seconds
                if(player.cardCount()==1){
                    UNO.setVisible(true);
                    uno();
                }
                //if players has no cards, stop the game and call endGame
                if(player.cardCount()==0){
                    try {
                        endGame(0);
                    } catch (IOException ex) {
                        Logger.getLogger(Uno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //else keep playing
                }else{
                    //if card played is wild, call colour changing buttons
                    if(x.getColour().equals("wild")){
                        Blue.setVisible(true);
                        Green.setVisible(true);
                        Red.setVisible(true);
                        Yellow.setVisible(true);
                        oneCard++;
                    }else{
                        //else play normally
                        Colour.setBackground(Color.LIGHT_GRAY);
                        turn(0);
                    }
                }
                //once a card is removed for play, shift the others down one
                shift();
                oneCard++;
            //if card doesnt match, dont put it down
            }else{
                System.out.println("U cont pud dat down");
                System.out.println(player.getCard(i).getColour()+" "+player.getCard(i).getValue());
            }
            //if its not the players turn, dont play a card
        }else{
            System.out.println("you cant put that down cheater");
        }
    }
    //uno timer method
    public void uno(){
        //wait 1.5 second before executing code
        timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    //if player doesnt click UNO! at lest once, add 2 card to hand
                    if(UNOcount<1){
                        for(int i=0;i<2;i++){
                            Card x = Deck.deal();
                            player.addCard(x);
                            addCards(x);
                        }
                    }
                    UNO.setVisible(false);
                }
            });
        timer.setRepeats(false);
        timer.start();
        
    }
    //main turn method check for special cards
    public void turn(int t){
        //update number of cards
        card.setText("card count: "+Deck.count());
        //restart pass button
        pass.setVisible(false);
        //if the pile top card is a reverse, change the boolean reverse
        if(Discard.topCard().getValue()==18 && once<1){
                toggle();
        }
        //change the visuals accordingly
        if(reverse==true){
            right.setVisible(true);
            left.setVisible(false);
        }else{
            left.setVisible(true);
            right.setVisible(false);
        }
        //if it is the players turn
        if(t==0){
            //if reverse equals true go counterclockwise
            if(reverse==true){
                //if pile top card is block card, skip computer 2's turn
                if(Discard.topCard().getValue()==10 && once<1){
                    c1text.setText("Why are you bloking meh playah!");
                    computer2();
                //if pile top card is +4, skip computer 1's turn, pick up 4
                }else if(Discard.topCard().getValue()==44 && once<1){
                    c1text.setText("you hav speet on me foh time playah");
                    
                    c1uno.setText("");
                    c1.addCard(Deck.deal());
                    c1.addCard(Deck.deal());
                    c1.addCard(Deck.deal());
                    c1.addCard(Deck.deal());
                    card.setText("card count: "+Deck.count());
                    computer2();
                //if pile top card is +2, skip computer 1's turn and pick 2
                }else if(Discard.topCard().getValue()==12 && once<1){
                    c1text.setText("I get too kweens?");
                    
                    c1uno.setText("");
                    c1.addCard(Deck.deal());
                    c1.addCard(Deck.deal());
                    card.setText("card count: "+Deck.count());
                    computer2();
                //if no special card then play normally
                }else{
                    computer1();
                }
            //if reverse equals the play clockwise
            }else{
                //if pile top card is block, skip player 2's turn
                if(Discard.topCard().getValue()==10 && once<1){
                    c2text.setText("You have sheilded my attack");
                    computer1();
                //if pile top card is +4, pick up 4 and skip com 2's turn
                }else if(Discard.topCard().getValue()==44 && once<1){
                    c2text.setText("AHHH! Four...hits...");
                   
                    c2uno.setText("");
                    c2.addCard(Deck.deal());
                    c2.addCard(Deck.deal());
                    c2.addCard(Deck.deal());
                    c2.addCard(Deck.deal());
                    card.setText("card count: "+Deck.count());
                    computer1();
                //if pile top card is +2, pick up 2 and skip com 2's turn
                }else if(Discard.topCard().getValue()==12 && once<1){
                    c2text.setText("Only two strikes?");
                    c2uno.setText("");
                    c2.addCard(Deck.deal());
                    c2.addCard(Deck.deal());
                    card.setText("card count: "+Deck.count());
                    computer1();
                //else play normally
                }else{
                    computer2();
                }
            }
        //if it is computer 1's turn, do the same as above, but with com 1
        }else if(t==1){
            if(reverse==true){
                if(Discard.topCard().getValue()==10 && once<1){
                    c1text.setText("I speet on Anakin, blocked "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    c2text.setText("You have sheilded my attack");
                    user();
                }else if(Discard.topCard().getValue()==44 && once<1){
                    c1text.setText("Cluck, cluck, cluck, cluck, Ann-ah-keen "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    c2text.setText("Gaining...losing...");
                    
                    c2uno.setText("");
                    c2.addCard(Deck.deal());
                    c2.addCard(Deck.deal());
                    c2.addCard(Deck.deal());
                    c2.addCard(Deck.deal());
                    card.setText("card count: "+Deck.count());
                    change();
                    user();
                }else if(Discard.topCard().getValue()==40 && once<1){
                    change();
                    computer2();
                }else if(Discard.topCard().getValue()==12 && once<1){
                    c1text.setText("I speet on dah Ann-ah-keen dwice "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    c2text.setText("Ugh, imbicile...");
                   
                    c2uno.setText("");
                    c2.addCard(Deck.deal());
                    c2.addCard(Deck.deal());
                    card.setText("card count: "+Deck.count());
                    user();
                }else{
                    computer2();
                }
            }else{
                if(Discard.topCard().getValue()==10 && once<1){
                    c1text.setText("I speet on dah playah, blocked "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    computer2();
                }else if(Discard.topCard().getValue()==44 && once<1){
                    c1text.setText("Cluck, cluck, cluck, cluck, playah! "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
               
                    for(int i=0;i<4;i++){
                        Card x = Deck.deal();
                        player.addCard(x);
                        addCards(x);
                    }
                    card.setText("card count: "+Deck.count());
                    change();
                    computer2();
                }else if(Discard.topCard().getValue()==40 && once<1){
                    change();
                    user();
                }else if(Discard.topCard().getValue()==12 && once<1){
                    c1text.setText("I speet on you dwice, playah! "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                 
                    for(int i=0;i<2;i++){
                        Card x = Deck.deal();
                        player.addCard(x);
                        addCards(x);
                    }
                    card.setText("card count: "+Deck.count());
                    computer2();
                }else{
                    user();
                }
            }
        //if it is computer 2's turn, do the same as above but with com 2
        }else{
            if(reverse==true){
                if(Discard.topCard().getValue()==10 && once<1){
                    c2text.setText("My power shadows you, player! "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    computer1();
                }else if(Discard.topCard().getValue()==44 && once<1){
                    c2text.setText("I attack with 4 cards, player! "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    for(int i=0;i<4;i++){
                        Card x = Deck.deal();
                        player.addCard(x);
                        addCards(x);
                    }
                    card.setText("card count: "+Deck.count());
                    change();
                    computer1();
                }else if(Discard.topCard().getValue()==40 && once<1){
                    change();
                    user();
                }else if(Discard.topCard().getValue()==12 && once<1){
                    c2text.setText("Pick up two cards, player! "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
     
                    for(int i=0;i<2;i++){
                        Card x = Deck.deal();
                        player.addCard(x);
                        addCards(x);
                    }
                    card.setText("card count: "+Deck.count());
                    computer1();
                }else{
                    user();
                }
            }else{
                if(Discard.topCard().getValue()==10 && once<1){
                    c2text.setText("I spit on you now Ugandan Knuckles "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    c1text.setText("playah! avenge meh!");
                    user();
                }else if(Discard.topCard().getValue()==44 && once<1){
                    c2text.setText("Four strikes for you Ugandan Knuckles "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    c1uno.setText("");
                    c1text.setText("AH! four clucks...");
                    c1.addCard(Deck.deal());
                    c1.addCard(Deck.deal());
                    c1.addCard(Deck.deal());
                    c1.addCard(Deck.deal());
                    card.setText("card count: "+Deck.count());
                    change();
                    user();
                }else if(Discard.topCard().getValue()==40 && once<1){
                    change();
                    computer1();
                }else if(Discard.topCard().getValue()==12 && once<1){
                    c2text.setText("Eat double lightsaber, Ugandan Knuckles! "+Discard.topCard().getColour()+" "+Discard.topCard().getName());
                    c1uno.setText("");
                    c1text.setText("Why are you hurding meh?");
                    c1.addCard(Deck.deal());
                    c1.addCard(Deck.deal());
                    card.setText("card count: "+Deck.count());
                    user();
                }else{
                    computer1();
                }
            }
        }
    }
    //com 1 play
    public void computer1(){  
        deck.setEnabled(false);
        //if com1 card count is more than 1 turn uno off
        if(c1.cardCount()>1){
            c1uno.setText("");
        }
        //signify it is not the players turn
        signal.setVisible(false);
        once=0;
        //pause for 2 seconds
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //if com1 return a card play it
                if(c1.showCard(Discard.topCard())!=null){
                    //return card that matches
                    Card x = c1.playCard(Discard.topCard());
                    //pile card onto public pile
                    Discard.pile(x);
                    //create visual for player
                    try {
                        Image img = ImageIO.read(getClass().getResource(x.getImage()));
                        pile.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {}
                    //create text to aid visual
                    c1text.setText("I hav played dah "+x.getColour()+" "+x.getName());
                //else check top card and play it if it matches, if not, pick up a card
                }else{
                    //deal the top card
                    Card x = Deck.deal();
                    //if the dealt card is equal to pile topcard, then play it
                    if(x.getColour().equals(Discard.topCard().getColour()) || x.getValue()==Discard.topCard().getValue()){
                        //pile card to pile
                        Discard.pile(x);
                        //update visuals
                        try {
                            Image img = ImageIO.read(getClass().getResource(x.getImage()));
                            pile.setIcon(new ImageIcon(img));
                        } catch (Exception ex) {}
                        ////update text
                        c1text.setText("I hav peeked up and played "+x.getColour()+" "+x.getName());
                    //if card doesnt work, add it to comp1 hand
                    }else{
                        c1.addCard(x);
                        c1text.setText("I hav peeked up aye cod");
                        c1uno.setText("");
                        once++;
                    }
                }
                //if com1's hand has one card call uno
                if(c1.cardCount()==1){
                    c1uno.setText("UNO FOH DAH KWEEN");
                }
                //if com1 runs out of cards, stop game by calling endGame
                if(c1.cardCount()==0){
                    try {
                        endGame(1);
                    } catch (IOException ex) {
                        Logger.getLogger(Uno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //else play normally
                }else{
                    
                    turn(1);
                }
            }
        });
        
        timer.setRepeats(false);
        timer.start();
    }
    //samething as com1 just with com2
    public void computer2(){
        deck.setEnabled(false);
        if(c2.cardCount()>1){
            c2uno.setText("");
        }
        signal.setVisible(false);
        once=0;
        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(c2.showCard(Discard.topCard())!=null){
                    Card x = c2.playCard(Discard.topCard());
                    Discard.pile(x);
                    try {
                        Image img = ImageIO.read(getClass().getResource(x.getImage()));
                        pile.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {}
                    c2text.setText("I have played "+x.getColour()+" "+x.getName());
                }else{
                    Card x = Deck.deal();
                    if(x.getColour().equals(Discard.topCard().getColour()) || x.getValue()==Discard.topCard().getValue()){
                        Discard.pile(x);
                        try {
                            Image img = ImageIO.read(getClass().getResource(x.getImage()));
                            pile.setIcon(new ImageIcon(img));
                        } catch (Exception ex) {}
                        c2text.setText("I have picked up and played "+x.getColour()+" "+x.getName());
                    }else{
                        c2.addCard(x);
                        c2text.setText("I grow with more cards");
                        c2uno.setText("");
                        once++;
                    }
                }

                if(c2.cardCount()==1){
                    c2uno.setText("POWER OVERWELMING, UNO!");
                }
                
                if(c2.cardCount()==0){
                   
                    try {
                        endGame(2);
                    } catch (IOException ex) {
                        Logger.getLogger(Uno.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                }else{
                    turn(2);
                }
            }
        });
        
        timer.setRepeats(false);
        timer.start();
    }
    //let's user play a card and updates visuals to let player do what they must
    public void user(){
        pickup=0;
        once=0;
        oneCard=0;
        deck.setEnabled(true);
        //let's play know it's his turn
        signal.setText("ITS YOUR TURN");
        signal.setVisible(true);
    }
    //randomly choose and set the colour of the top discard pile
    public void change(){
        int x = (int)Math.round(Math.random()*4);
        if(x==1){
            Discard.topCard().setColour("blue");
            System.out.println("set to blue");
            Colour.setBackground(Color.BLUE);
        }else if(x==2){
            Discard.topCard().setColour("green");
            System.out.println("set to green");
            Colour.setBackground(Color.GREEN);
        }else if(x==3){
            Discard.topCard().setColour("red");
            System.out.println("set to red");
            Colour.setBackground(Color.RED);
        }else{
            Discard.topCard().setColour("yellow");
            System.out.println("set to yellow");
            Colour.setBackground(Color.YELLOW);
        }
    }
    //when called it adds cards to the user's hand and updates visuals appropriately
    public void addCards(Card x){
        for(int i=0;i<hand.size();i++){
            if(hand.get(i).getIcon()==null){
                hand.get(i).setVisible(true);
                try {
                    Image img = ImageIO.read(getClass().getResource(x.getImage()));
                    hand.get(i).setIcon(new ImageIcon(img));
                } catch (Exception ex) {}
                i=hand.size();
            }
        }
    }
    //when called it shifts all the card down by one
    public void shift(){
        for(int i=0;i<player.cardCount();i++){
            try {
                Image img = ImageIO.read(getClass().getResource(player.getCard(i).getImage()));
                hand.get(i).setIcon(new ImageIcon(img));
                } catch (Exception ex) {}
        }
        hand.get(player.cardCount()).setIcon(null);
        hand.get(player.cardCount()).setVisible(false);
    }
    //toggles the reverse boolean
    public void toggle(){
        reverse = !reverse;
    }
    //makes sure no one can play after someone reaches 0 cards
    public void endGame(int i) throws IOException{
        deck.setEnabled(false);
        pass.setVisible(false);
        left.setVisible(false);
        right.setVisible(false);
        c1text.setText("");
        c2text.setText("");
        c1uno.setText("");
        c2uno.setText("");
        //makes new print writer
        PrintWriter print = new PrintWriter(new FileWriter("src/uno/ScoreRanking.txt", false));
        //prints out in the text file who won the round
        if(i==0){
            c1.adding(c1.addScore(c1.cardCount()-1));
            c2.adding(c2.addScore(c2.cardCount()-1));
            signal.setText("YOU HAVE WON");
            print.println("player won this round");
            print.println("com 1 has "+c1.getScore()+" in total");
            print.println("com 2 has "+c2.getScore()+" in total");
        }else if(i==1){
            c2.adding(c2.addScore(c2.cardCount()-1));
            player.adding(player.addScore(player.cardCount()-1));
            c1text.setText("I HAV WON FOH DAH KWEEN!");
            print.println("computer 1 won this round");
            print.println("player has "+player.getScore()+" in total");
            print.println("com 2 has "+c2.getScore()+" in total");
        }else{
            c1.adding(c1.addScore(c1.cardCount()-1));
            player.adding(player.addScore(player.cardCount()-1));
            c2text.setText("I AM VICTORIUS");
            print.println("computer 2 one this round");
            print.println("player has "+player.getScore()+" in total");
            print.println("com 1 has "+c1.getScore()+" in total");
        }
        //closes print writer
        print.close();
        
        //print out curretn scores in gui
        c1name.setText(c1.getName()+" score: "+c1.getScore());
        c2name.setText(c2.getName()+" score: "+c2.getScore());
        playername.setText(player.getName()+" score: "+player.getScore());
        
        //if no one is above cap, then allow player to restart the rounds
        if(player.getScore()>300 || c1.getScore()>300 || c2.getScore()>300){
            END();
        }else{
            restart.setVisible(true);
        }
        
    }
    
    public void END(){
        //makes new print writer
        PrintWriter print2=null;
        try {
            print2 = new PrintWriter(new FileWriter("src/uno/ScoreRanking.txt", false));
        } catch (IOException ex) {
            Logger.getLogger(Uno.class.getName()).log(Level.SEVERE, null, ex);
        }
        //if some has reached the cap, 300, then stop the game and stat final standings
        if(player.getScore()>300 || c1.getScore()>300 || c2.getScore()>300){
            //state who lost UNO
            if(player.getScore()>300){
                print2.println("player lost!");
            }
            if(c1.getScore()>300){
                print2.println("c1 has lost!");
            }
            if(c2.getScore()>300){
                print2.println("c2 has lost!");
            }
            //create int array to sort
            int[] points = new int[3];
            points[0]=player.getScore();
            points[1]=c1.getScore();
            points[2]=c2.getScore();
            //sort using switch, or something
            for(int o=0;o<points.length;o++){
                int x = points[o];
                for(int p=o;p<points.length;p++){
                    if(points[p]<x){
                        points[o]=points[p];
                        points[p]=x;
                        x=points[o];
                    }
                }
            }
            //print out sorted final standings to file
            print2.println("final standings");
            for(int u=0;u<3;u++){
                if(points[u]==player.getScore()){
                    print2.println(u+1+" player "+points[u]);
                }else if(points[u]==c1.getScore()){
                    print2.println(u+1+" c1 "+points[u]);
                }else if(points[u]==c2.getScore()){
                    print2.println(u+1+" c2 "+points[u]);
                }
            }
            print2.close();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {

        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Uno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Uno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Uno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Uno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Uno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Blue;
    private java.awt.Panel Colour;
    private javax.swing.JButton Green;
    private javax.swing.JButton Red;
    private javax.swing.JButton Start;
    private javax.swing.JButton UNO;
    private javax.swing.JButton Yellow;
    private javax.swing.JLabel c1name;
    private javax.swing.JLabel c1text;
    private javax.swing.JLabel c1uno;
    private javax.swing.JLabel c2name;
    private javax.swing.JLabel c2text;
    private javax.swing.JLabel c2uno;
    private javax.swing.JLabel card;
    private javax.swing.JButton card1;
    private javax.swing.JButton card10;
    private javax.swing.JButton card11;
    private javax.swing.JButton card12;
    private javax.swing.JButton card13;
    private javax.swing.JButton card14;
    private javax.swing.JButton card15;
    private javax.swing.JButton card16;
    private javax.swing.JButton card17;
    private javax.swing.JButton card18;
    private javax.swing.JButton card19;
    private javax.swing.JButton card2;
    private javax.swing.JButton card20;
    private javax.swing.JButton card21;
    private javax.swing.JButton card3;
    private javax.swing.JButton card4;
    private javax.swing.JButton card5;
    private javax.swing.JButton card6;
    private javax.swing.JButton card7;
    private javax.swing.JButton card8;
    private javax.swing.JButton card9;
    private javax.swing.JButton deck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel left;
    private javax.swing.JButton pass;
    private javax.swing.JLabel pile;
    private javax.swing.JLabel playername;
    private javax.swing.JButton restart;
    private javax.swing.JLabel right;
    private javax.swing.JButton shuffling;
    private javax.swing.JLabel signal;
    // End of variables declaration                   

}
