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
public class Search{
    
    public static int binary(String[] a, String target){
        int high = a.length-1;
        int low = 0;
        while(low<=high){
            int mid = (high+low)/2;
            if(target.compareTo(a[mid])>0){
                low = mid+1;
            }else if(target.compareTo(a[mid])<0){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
