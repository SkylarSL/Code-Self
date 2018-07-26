
import java.io.*;


public class pascalTriangle {
    public static void main(String[]args)throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int input = Integer.parseInt(in.readLine());
    int[][] tri = new int[input][input];
    
    tri[0][0] = 1;
    for(int r=1;r<input;r++){
        for(int c=1;c<input;c++){
            
            tri[r][c] = tri[r-1][c]+tri[r-1][c-1];
            if(tri[r][c]!=0){
            System.out.print(tri[r][c]+" ");
            }
        }
        System.out.println("");
    }
    }
}
