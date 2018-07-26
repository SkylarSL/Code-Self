
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SkylarSL
 */
public class minesweeper {
    public static void main(String[]args)throws IOException{
    String[][] mines = {
        {"*","0","0","*"},
        {"*","0","*","0"},
        {"0","*","0","0"},
        {"0","*","*","0"},
    };
    int num=0;
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            if(mines[i][j]!="*"){
            if(i+1<mines.length&&mines[i+1][j]=="*"){
            mines[i][j] = String.valueOf(Integer.parseInt(mines[i][j])+1);
        }
            if(i+1<mines.length && j+1<mines[0].length&&mines[i+1][j+1]=="*"){
            mines[i][j] = String.valueOf(Integer.parseInt(mines[i][j])+1);
        }
            if(j+1<mines[0].length&&mines[i][j+1]=="*"){
            mines[i][j] = String.valueOf(Integer.parseInt(mines[i][j])+1);
        }
            
            if(i-1>=0 && j+1<mines[0].length&& mines[i-1][j+1]=="*"){
            mines[i][j] = String.valueOf(Integer.parseInt(mines[i][j])+1);
        }
            if(i-1>=0&&mines[i-1][j]=="*"){
            mines[i][j] = String.valueOf(Integer.parseInt(mines[i][j])+1);
        }
            
            if(i-1>=0 && j-1>=0&&mines[i-1][j-1]=="*"){
            mines[i][j] = String.valueOf(Integer.parseInt(mines[i][j])+1);
        }

            if(j-1>=0&&mines[i][j-1]=="*"){
            mines[i][j] = String.valueOf(Integer.parseInt(mines[i][j])+1);
        }
            if(j-1>=0&&i+1<mines.length&&mines[i+1][j-1]=="*"){
            mines[i][j] = String.valueOf(Integer.parseInt(mines[i][j])+1);
        }
            }
            System.out.print(mines[i][j]+" ");
        }
        
        System.out.println("");
    }
        
    }
}
