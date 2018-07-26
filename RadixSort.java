/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;
import QueueStack.Queue;
import java.io.*;
import java.util.*;


public class RadixSort {
    

    
    public static void main(String[]args)throws IOException{
        //creates a new string
        Queue<String> Arr = new Queue();
        //creates a new bufferreader
        BufferedReader line = new BufferedReader(new FileReader("src/algorithm/input.txt"));
        //makes new readline thing
        String read = line.readLine();
        //create new int longest
        int longest = 0;
        //create new int count
        int count = 0;
        //while there are more lince to read, read
        while(read!=null){
            //enqueue the word on the line
            Arr.enqueue(new String(read));
            //if the length of the word id greater than longest, then set longest to that length
            if(read.length()>longest){
                longest = read.length();
            }
            //read the next line
            read = line.readLine();
            //increment count variable
            count++;
        }
        //create an array of strings with the size of count
        String[] sort = new String[count];
        //dequeue the queue and put it in the array
        for(int i=0;i<count;i++){
            sort[i] = Arr.dequeue();
        }
        //print out the sorted list
        for(int k=0;k<sort.length;k++){
            System.out.println(sort(longest,sort)[k]);
        }
    }
    
    //new class
    public static String[] sort(int longest, String[] list){
        //create new queue
        Queue<String> Arr = new Queue();
        //while i is more than 0, do the following
        for(int i=longest; i>0; i--){
            //enqueue the words that are smaller than the current size word
            for(int k=0; k<list.length;k++){
                if(list[k].length()<i){
                    Arr.enqueue(list[k]);
                    
                }
            }
            

            //run through the alphabet and queue the words in order from a-z
            for(int j=97; j<123; j++){
                //run through the entire list
                for(int m=0; m<list.length;m++){
                    //if the word is more than or equal to i, and the char at i-1 is equal to the current letter at j, then enqueue
                    if(list[m].length()>=i && list[m].charAt(i-1) == j){
                        Arr.enqueue(list[m]);
                        
                    }
                }
            }
            //dequeue the Queue into the array
            for(int n=0;n<list.length;n++){
                list[n] = Arr.dequeue();
                //System.out.println(list[n]);
            }
        }
        //return array
        return list;
    }
}