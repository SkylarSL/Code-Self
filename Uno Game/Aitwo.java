package uno;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author SkylarSL
 */

//literally the exact same as AIone
public class AItwo extends Player{
    private String name;
    private ArrayList<Card> AIHand = new ArrayList();
    private int tempscore;
    private int score;
    
    public AItwo(String name, int score){
        super(name,score);
        this.name = name;
        this.score=score;
    }
    
    public String getName(){
        return name;
    }
    
    public Card getCard(int i){
        return AIHand.get(i);
    }
    
    @Override
    public void addCard(Card t){
        AIHand.add(t);
    }
    
    @Override
    public int cardCount(){
        return AIHand.size();
    }
    
    public Card showCard(Card t){
        for(int i=0;i<AIHand.size();i++){
            if(AIHand.get(i).getColour().equals(t.getColour()) || AIHand.get(i).getValue()==t.getValue() || AIHand.get(i).getColour().equals("wild")){
                return AIHand.get(i);
            }
        }
        return null;
    }
    
    public Card playCard(Card t){
        for(int i=0;i<AIHand.size();i++){
            if(AIHand.get(i).getColour().equals(t.getColour()) || AIHand.get(i).getValue()==t.getValue() || AIHand.get(i).getColour().equals("wild")){
                Card x = AIHand.remove(i);
                return x;
            }
        }
        return null;
    }
    
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

    public int getScore(){
        return score;
    }
    
    public void adding(int i){
        score+=i;
    }
    
    public void handClear(){
        AIHand.clear();
    }
}
