package learning;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SkylarSL
 */
import java.io.*;
import java.util.*;

public class SelfSegmentTree {
    
    private static int[] n;
    private static int[] qr = new int[1000];
    private static int[] ql = new int[1000];
    private static int[] min = new int[10];
    private static int[] max = new int[10];
    private static int[] sum = new int[10];
    private static String[] t = new String[10];
    
    public static void main(String[]args)throws IOException{
        BufferedReader read = new BufferedReader(new FileReader("src/TestSite"));
        PrintWriter write = new PrintWriter(System.out);
        t = read.readLine().split(" ");
        n = new int[Integer.parseInt(t[0])];
        int m = Integer.parseInt(t[1]);
        
        t = read.readLine().split(" ");
        
        System.out.println("Min");
        buildmin(0, n.length-1, 1);
        for(int i=0;i<min.length;i++){
            System.out.print(min[i]+" ");
        }
        
        System.out.println("\n"+"Max");
        buildmax(0, n.length-1, 1);
        for(int i=0;i<max.length;i++){
            System.out.print(max[i]+" ");
        }
        
        System.out.println("\n"+"Sum");
        buildsum(0, n.length-1, 1);
        for(int i=0;i<sum.length;i++){
            System.out.print(sum[i]+" ");
        }
    }
    
    private static void buildmin(int l, int r, int i){
        ql[i] = l;
        qr[i] = r;
        if(l == r){
            min[i]=Integer.parseInt(t[l]);
        }else{
            buildmin(l, (r+l)/2, i*2);
            buildmin((l+r)/2+1, r, i*2+1);
            min[i]=Math.min(min[i*2], min[i*2+1]);
        }
    }
    private static int minimum(int l, int r, int i){
        if(r<ql[i] || l>qr[i])
            return Integer.MAX_VALUE;
        if(l<=ql[i] && r>=qr[i])
            return min[i];
        
        return Math.min(minimum(l, r, i*2), minimum(l, r, i*2+1));
    }
    
    private static void buildmax(int l, int r, int i){
        ql[i] = l;
        qr[i] = r;
        if(l == r){
            max[i]=Integer.parseInt(t[l]);
        }else{
            buildmax(l, (r+l)/2, i*2);
            buildmax((l+r)/2+1, r, i*2+1);
            max[i]=Math.max(max[i*2], max[i*2+1]);
        }
    }
    private static int maximum(int l, int r, int i){
        if(r<ql[i] || l>qr[i])
            return 0;
        if(l<=ql[i] && r>=qr[i])
            return max[i];
        return Math.max(maximum(l, r, i*2), maximum(l, r, i*2+1));
    }
    
    private static void buildsum(int l, int r, int i){
        ql[i]=l;
        qr[i]=r;
        if(l==r){
            sum[i]=Integer.parseInt(t[l]);
        }else{
            int s = add(l, r);
            System.out.println(s+" ");
            buildsum(l, (l+r)/2, i*2);
            buildsum((l+r)/2+1, r, i*2+1);
            sum[i] = s;
        }
    }

    private static int sumation(int l, int r, int i){
        
    }
    
    private static int add(int x, int y){
        int s = 0;
        for(int i=x;i<y+1;i++){
            s+=Integer.parseInt(t[i]);
        }
        return s;
    }
}
