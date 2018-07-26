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
public class Sort {
    
    public static int[] insertion(int[] a){
        for(int i=a.length-1;i>0;i--){
            int insVal = a[i];
            int loc = i;
            while(loc>0 && a[loc-1] < insVal){
                a[loc] = a[loc-1];
                loc--;
            }
            a[loc] = insVal;
        }
        return a;
    }
        
    public static int[] selection(int[] a){
        return a;
    }
}
