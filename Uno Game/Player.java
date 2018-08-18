package uno;

import java.util.ArrayList;


public class Player{
    
    private ArrayList<Card> playerHand = new ArrayList();
    private String name;
    private int score;
    
    //make new player in constructor with name and score
    public Player(String name, int score){
        this.name = name;
        this.score=score;
    }
    //return the naem of player
    public String getName(){
        return name;
    }
    //add cards to player's hand
    public void addCard(Card a){
        playerHand.add(a);
    }
    //return the cards in player's hand
    public int cardCount(){
        return playerHand.size();
    }
    //play a card and return played card
    public Card playCard(int i){
        Card x = playerHand.remove(i);
        return x;
    }
    //return a card for test purposes before playing
    public Card getCard(int i){
        return playerHand.get(i);
    }
    //use recursion to add score
    public int addScore(int i){
        if(i==0){
            if(playerHand.get(i).getValue()==10 || playerHand.get(i).getValue()==12 || playerHand.get(i).getValue()==18){
                return 20;
            }else if(playerHand.get(i).getValue()==40 || playerHand.get(i).getValue()==44){
                return 50;
            }else{
                return playerHand.get(i).getValue();
            }
        }else if(playerHand.get(i).getValue()==10 || playerHand.get(i).getValue()==12 || playerHand.get(i).getValue()==18){
            return 20 + addScore(i-1);
        }else if(playerHand.get(i).getValue()==40 || playerHand.get(i).getValue()==44){
            return 50 + addScore(i-1);
        }else{
            return playerHand.get(i).getValue() + addScore(i-1);
        }
    }
    //return score
    public int getScore(){
        return score;
    }
    //adds the current score to total score
    public void adding(int i){
        score+=i;
    }
    //clears players hand for new round
    public void handClear(){
        playerHand.clear();
    }
}
