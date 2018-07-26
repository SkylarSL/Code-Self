import com.sun.xml.internal.ws.util.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.regex.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SkylarSL
 */
public class cipher {
    public static void main(String[]args)throws IOException{
        //create new bufferreader stream, to get users input
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        //prompt
        System.out.println("What's your secret code?");
        //get users input
        String code = input.readLine();
        //prompt
        System.out.println("What's your secret messege");
        //users input
        String mess = input.readLine();
        //prompt
        System.out.println("how many times?");
        //users input
        int fold = Integer.parseInt(input.readLine());
        //set ocd to the full message, including secret word
        String ocd = code+mess;
        //tell user their meassage
        System.out.println("your messege is: "+ocd);
        //set int half to half the message
        int half = ocd.length();
        //while u is less then number of folds, do the following
        for(int u=0; u<fold; u++){
        //make new string copy
        String copy = "";
        //make new x, 0
        int x=0;
        //while i>half the message add the letters starting from the end
        for(int i=half; i>half/2;){
            i--;
            copy+=ocd.charAt(i);
            //if x is less then half the message, add the letter starting from the beginning
            if(x<half/2){
                copy+=ocd.charAt(x);
                x++;
            }
        }
        //set ocd equal to the encoded message
        ocd = copy;
        }
        //out final encoded message
        System.out.println("<"+ocd+">");
    }
}
