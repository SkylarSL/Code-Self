package uno;
import java.util.ArrayList;

/**
 *
 * @author SkylarSL
 */

public class Deck {
    private ArrayList<Card> deck = new ArrayList();

    //create new deck in constructor
    public Deck(){
    }
    //return deck size
    public int count(){
        return deck.size();
    }
    
    //shuffle card using something...
    public ArrayList<Card> shuffle(int k){
        int x = (int) Math.round(Math.random()*25+10);
        for(int c=0;c<x;c++){
            for(int i=0;i<k/2;i++){
                deck.add(deck.remove(i)); 
                deck.add(deck.remove(i+k/2));
            }
        }
        return deck;
    }
    //clear the discard pile
    public void clear(){
        deck.clear();
    }
    //return the top card
    public Card topCard(){
        return deck.get(deck.size()-1);
    }
    //add the card when played
    public void pile(Card t){
        deck.add(t);
    }
    //deal the cards to players
    public Card deal(){
        Card t = deck.get(deck.size()-1);
        deck.remove(t);
        return t;
    }
}
