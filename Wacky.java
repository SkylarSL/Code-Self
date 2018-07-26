
import QueueStack.Stack;
import java.io.*;
import java.text.*;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SkylarSL
 */
public class Wacky {
    public static void main(String[]args)throws IOException{
        //makes new read line thing
        BufferedReader in = new BufferedReader(new FileReader("src/WackyIn.txt"));
        //makes new double stack
        Stack<Double> s = new Stack();
        //makes new decimal place format
        DecimalFormat n = new DecimalFormat("##.##");
        //while run < 6 do the following
        for(int run=1;run<6;run++){
            //create new tokenizer
            StringTokenizer t = new StringTokenizer(in.readLine()," ");
            //print out the line number
            System.out.println("\n \nline "+run);
            //while the line has no more tokens
            while(t.hasMoreTokens()){
                //consume the next token
                String next = t.nextToken();
                //if the next token is a plus sign, add the last 2 numbers
                if(next.equals("+")){
                    //pop the first number
                    double x = s.pop();
                    //pop the next number
                    double y = s.pop();
                    //add the sum of the popped number to the stack
                    s.push(y + x);
                //if the next token is a -
                }else if(next.equals("-")){
                    //pop
                    double x = s.pop();
                    //pop
                    double y = s.pop();
                    //add the subtraction of the popped number to the stack
                    s.push(y - x);
                //if the next token is a *
                }else if(next.equals("*")){
                    //pop
                    double x = s.pop();
                    //pop
                    double y = s.pop();
                    //add the product of the popped numbers to the stack
                    s.push(y * x);
                //if the next token is a /
                }else if(next.equals("/")){
                    //pop
                    double x = s.pop();
                    //pop
                    double y = s.pop();
                    //add the division of the popped numbers to the stack
                    s.push(y / x);
                }else{
                    //add the number token to the stack
                    s.push(Double.parseDouble(next));
                }
            }
            //print out the final number after maths happen
            System.out.print(n.format(s.pop())+" ");
        }
    }
    
}
