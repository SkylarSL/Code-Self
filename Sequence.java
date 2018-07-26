/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author SkylarSL
 */
public class Sequence {
    //public thing
    public static void main(String[]args){
        //print out my loop, it starts at 1
        for(int i=1;i<10;i++){
            System.out.println(sequence(i));
        }
    }
    
    public static int sequence(int k){
        //if the k value is 1, then return 2
        if(k==1){
            return 2;
        //if the k value is 2, then return 5
        }else if(k==2){
            return 5;
        //if the k value is 3, then return 7
        }else if(k==3){
            return 7;
        //else call the sequence function with a k value of 1 less
        //e.i if k is 5, then call the function with a k value of 4
        }else{
            return 3*sequence(k-1)+1;
        }
    }
}
