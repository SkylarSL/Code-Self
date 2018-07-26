
import java.io.*;

import java.util.*;

public class RealFanduWorld {
    //set up the fandu world, make male anf female population equal to 0
    static RealFandus[][] planet = new RealFandus[100][100];
    static int male = 0;
    static int female = 0;
    
    public static void main(String[]args)throws IOException{
        BufferedReader in = new BufferedReader(new FileReader("src/RealFanduIn.txt"));
        String Read = in.readLine();
        int years = Integer.parseInt(Read);
        Read = in.readLine();
        StringTokenizer Fan = new StringTokenizer(Read, "(), ");
        
        //set everything up, take in the data from the text file and initialize variables
        while(Read!=null){
            Fan = new StringTokenizer(Read, "(), ");
            String MF = Fan.nextToken();
            int age = Integer.parseInt(Fan.nextToken());
            int x = Integer.parseInt(Fan.nextToken());
            int y = Integer.parseInt(Fan.nextToken());
            planet[x][y] = new RealFandus(age,MF);
            Read = in.readLine();
            if(MF.equals("M")){
                male++;
            }else{
                female++;
            }
        }
        
        //display female and male colours
        System.out.println("\033[0;31m"+"red "+"\033[0m"+"= female");
        System.out.println("\033[0;34m"+"blue "+"\033[0m"+"= male");
        //display the initial year 
        System.out.println("start year");
        for(int i=1;i<11;i++){
            for(int j=1;j<11;j++){
                if(planet[i][j]!=null && planet[i][j].getAge()!=0 && planet[i][j].getSex().equals("F")){
                    System.out.print("\033[0;31m"+planet[i][j].getAge()+"\033[0m"+" ");
                }else if(planet[i][j]!=null && planet[i][j].getAge()!=0 && planet[i][j].getSex().equals("M")){
                    System.out.print("\033[0;34m"+planet[i][j].getAge()+"\033[0m"+" ");
                }else{
                    System.out.print("0 ");
                }
            }
            System.out.println("");
            }
        
        //print out folloeing years of fandu generations
        for(int year=1; year<years+1; year++){
            System.out.println("\nYear "+year);
            // call imortant methods
            birth();
            age();
            death();
            //display the new world after each year
            for(int i=1;i<11;i++){
                for(int j=1;j<11;j++){
                    if(planet[i][j]!=null && planet[i][j].getAge()!=0 && planet[i][j].getSex().equals("F")){
                        System.out.print("\033[0;31m"+planet[i][j].getAge()+"\033[0m"+" ");
                    }else if(planet[i][j]!=null && planet[i][j].getAge()!=0 && planet[i][j].getSex().equals("M")){
                        System.out.print("\033[0;34m"+planet[i][j].getAge()+"\033[0m"+" ");
                    }else{
                        System.out.print("0 ");
                    }
                }
                System.out.println("");
            }
        }
    }
    
    //creates a new fandu if the requirements are met
    public static void birth(){
        //if the female population is greater than the male population, make a male
        if(female>male){
            //search for a male in the adjacecent area
            for(int i=1;i<11;i++){
                for(int j=1;j<11;j++){
                    boolean tf = false;
                    for(int x=-1;x<=1;x++){
                        for(int y=-1;y<=1;y++){
                            if(planet[i][j]==null && planet[i+x][j+y]!=null && planet[i+x][j+y].getSex().equals("M") && planet[i+x][j+y].getAge()>1 && planet[i+x][j+y].getAge()<7){
                                tf = true;
                            }
                        }
                    }
                    //search for a female in the adjacent area and make a male fandu
                    for(int x=-1;x<=1;x++){
                        for(int y=-1;y<=1;y++){
                            if(tf==true && planet[i][j]==null && planet[i+x][j+y]!=null && planet[i+x][j+y].getSex().equals("F")&& planet[i+x][j+y].getAge()>1 && planet[i+x][j+y].getAge()<5){
                                tf = false;
                                planet[i][j] = new RealFandus(0,"M");
                                male++;
                            }
                        }
                    }
                }
            }
        //else make a female
        }else{
            //search for a male in the adjecent area
            for(int i=1;i<11;i++){
                for(int j=1;j<11;j++){
                    boolean tf = false;
                    for(int x=-1;x<=1;x++){
                        for(int y=-1;y<=1;y++){
                            if(planet[i][j]==null && planet[i+x][j+y]!=null && planet[i+x][j+y].getSex().equals("M") && planet[i+x][j+y].getAge()>1 && planet[i+x][j+y].getAge()<7){
                                tf = true;
                            }
                        }
                    }
                    //search for a female in adjacent area and produce a female fandu
                    for(int x=-1;x<=1;x++){
                        for(int y=-1;y<=1;y++){
                            if(tf==true && planet[i+x][j+y]!=null && planet[i+x][j+y].getSex().equals("F")&& planet[i+x][j+y].getAge()>1 && planet[i+x][j+y].getAge()<5){
                                tf = false;
                                planet[i][j] = new RealFandus(0,"F");
                                female++;
                            }
                        }
                    }
                }
            }
        }
    }
    
    //when fandu reaches the age of 8 he/she will die
    //this reduces the female/male population depending on who died
    public static void death(){
        for(int i=1;i<11;i++){
            for(int j=1;j<11;j++){
                if(planet[i][j]!=null && planet[i][j].getAge()>=8 && planet[i][j].getSex().equals("F")){
                    planet[i][j]=null;
                    female--;
                }else if(planet[i][j]!=null && planet[i][j].getAge()>=8 && planet[i][j].getSex().equals("M")){
                    planet[i][j]=null;
                    male--;
                }
            }
        }
    }
    
    //increases the age of each living fandu
    public static void age(){
        for(int i=1;i<11;i++){
            for(int j=1;j<11;j++){
                if(planet[i][j]!=null){
                    planet[i][j].age();
                }
            }
        }
    }
}


