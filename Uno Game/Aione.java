package uno;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author SkylarSL
 */
public class AIone extends Player{
    private String name;
    private ArrayList<Card> AIHand = new ArrayList();
    private int score;

    
    //make new AIone
    public AIone(String name, int score){
        super(name,score);
        this.name = name;
        this.score=score;
    }
    //return the name of AIone
    public String getName(){
        return name;
    }
    
    //return a card for test purposes before playing
    public Card getCard(int i){
        return AIHand.get(i);
    }
    //adds cards to AIone hand
    @Override
    public void addCard(Card t){
        AIHand.add(t);
    }
    //returns the number of cards AIone has
    @Override
    public int cardCount(){
        return AIHand.size();
    }
    //return a card for testing purposes
    public Card showCard(Card t){
        for(int i=0;i<AIHand.size();i++){
            if(AIHand.get(i).getColour().equals(t.getColour()) || AIHand.get(i).getValue()==t.getValue() || AIHand.get(i).getColour().equals("wild")){
                return AIHand.get(i);
            }
        }
        return null;
    }
    //actually plays card
    public Card playCard(Card t){
        for(int i=0;i<AIHand.size();i++){
            if(AIHand.get(i).getColour().equals(t.getColour()) || AIHand.get(i).getValue()==t.getValue() || AIHand.get(i).getColour().equals("wild")){
                Card x = AIHand.remove(i);
                return x;
            }
        }
        return null;
    }

        
    //use recursion to add score for AIone
    @Override
    public int addScore(int i){
        
        if(i==0){
            if(AIHand.get(i).getValue()==10 || AIHand.get(i).getValue()==12 || AIHand.get(i).getValue()==18){
                return 20;
            }else if(AIHand.get(i).getValue()==40 || AIHand.get(i).getValue()==44){
                return 50;
            }else{
                return AIHand.get(i).getValue();
            }
        }else if(AIHand.get(i).getValue()==10 || AIHand.get(i).getValue()==12 || AIHand.get(i).getValue()==18){
            return 20 + addScore(i-1);
        }else if(AIHand.get(i).getValue()==40 || AIHand.get(i).getValue()==44){
            return 50 + addScore(i-1);
        }else{
            return AIHand.get(i).getValue() + addScore(i-1);
        }

    } 
    //return score
    public int getScore(){
        return score;
    }
    //add current score to existing score
    public void adding(int i){
        score+=i;
    }
    //clear AIone hand
    public void handClear(){
        AIHand.clear();
    }
}
