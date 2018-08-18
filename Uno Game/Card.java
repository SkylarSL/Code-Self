package uno;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Card{
    private String colour;
    private int value;
    //construct new card with a colour and value
    public Card(String a, int b){
        this.colour = a;
        this.value = b;
    }
    //return colour of card for mechanics
    public String getColour(){
        return colour;
    }
    //set the colour of card
    public void setColour(String y){
        this.colour=y;
    }
    //return the name of the card for visuals
    public String getName(){
        if(value==10){
            return "skip";
        }else if(value==12){
            return "plus 2";
        }else if(value==18){
            return "reverse";
        }else if(value==40){
            return "colour changer";
        }else if(value==44){
            return "plus 4";
        }else if(value==9){
            return "nine";
        }else if(value==8){
            return "eight";
        }else if(value==7){
            return "seven";
        }else if(value==6){
            return "six";
        }else if(value==5){
            return "five";
        }else if(value==4){
            return "four";
        }else if(value==3){
            return "three";
        }else if(value==2){
            return "two";
        }else if(value==1){
            return "one";
        }else if(value==0){
            return "zero";
        }
        return "";
    }
    //return the value of a card for mechanics
    public int getValue(){
        return value;
    }
    //return the image of a card for visuals
    public String getImage(){
        return colour+"_"+value+".png";
    }
}
