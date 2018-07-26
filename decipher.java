
import java.io.*;
import java.io.*;
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
public class decipher {
    public static void main(String[]args)throws IOException{
        //create new bufferedreader to get the uers input
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
        //create new read link with the file ciph.txt
        BufferedReader fileInput = new BufferedReader (new FileReader("src/ciph.txt"));
        //read the fisrt line in the file
        String k= fileInput.readLine();
        //creat new tokenizer string and ignore ,
        StringTokenizer I = new StringTokenizer(k, ",");
        //set j equal to first token
        String j = I.nextToken();
        //set n equal to next token
        int n = Integer.parseInt(I.nextToken());
        //while s<number of lines, do the following
        for(int s=0; s<n; s++){
        //create new boolean and set it equal to false
        boolean tf = false;
        //read the next line
        String dec = fileInput.readLine();
        //ignore the <> and take the message
        dec = dec.substring(1, (dec.length()-1));
        //while boolean tf id false, do the following
        while(tf == false){
            //make new string
        String secword = "";
        //while, g<the users secret word, do the following
        for(int g=0; g<j.length();){
            //add the lette at g to the secword string
            secword+=dec.charAt(g);
            g++;
            }
        //if the letters/word at g = the users secret word, set boolean tf to true
            if(j.equals(secword)){
               //output the following and stop the while loop
               System.out.println("we found it: "+dec);
               tf = true;
            }
        //creat new string of copy
        String copy = "";
        String copy2 = "";
        String copy3 = "";
        //while a is less then the message length, do the following
        for(int a=0; a<dec.length();){
           //add a letter of the message to the copy string
           copy+=dec.charAt(a);
           a++;
           //add the next letter to the copy2 string
           if(a<dec.length()){
           copy2+=dec.charAt(a);
           a++;
           }
        }
        //the copy string ahs the backwards half of the message
        //so reverse it by adding the last letter to the first to copy3
        for(int x=copy.length(); x>0;){
            x--;
            copy3+= copy.charAt(x);
        }
        //make dec equal to the new message
        dec = copy2+copy3;
        
        }
        }
        //close the file link
        fileInput.close();
    }
}
