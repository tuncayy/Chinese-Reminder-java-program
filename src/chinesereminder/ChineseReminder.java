/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinesereminder;

import static java.util.Arrays.stream;
import java.util.Scanner;

/**
 *
 * @author tuncaymsi
 */
public class ChineseReminder {

   public static int chineseRemainder(int[] n, int[] a) {
 try{
        int modmult = 1;
        for (int x = 0; x < n.length; x++) {
           modmult = modmult * n[x];
       }
       
        int p, sm = 0;
        for (int i = 0; i < n.length; i++) {
            p = modmult / n[i];
            sm += a[i] * mulInv(p, n[i]) * p;
        }
        return sm % modmult;
 }
 catch(Exception e)
 {
     System.out.println("entered numbers are not co-prime");
     return 0;
 }
    }
 
    private static int mulInv(int a, int b) {
        try{
        int b0 = b;
        int x0 = 0;
        int x1 = 1;
 
        if (b == 1)
            return 1;
 
        while (a > 1) {
            int q = a / b;
            int amb = a % b;
            a = b;
            b = amb;
            int xqx = x1 - q * x0;
            x1 = x0;
            x0 = xqx;
        }
 
        if (x1 < 0)
            x1 += b0;
 
        return x1;
        }
        catch(Exception e)
        {
            System.out.println("entered numbers are not co-prime");
     return 0;
        }
    }
 
    public static void main(String[] args) {
       // int[] a = {9, 8, 1};
       // int[] n = {13, 11, 7};
       Scanner input = new Scanner(System.in);
        System.out.println("enter the number of equation ");
       int adet = input.nextInt();
         int[] a = new int[adet];
         int[] n= new int[adet];
         
         int i = 0,x = 0;
         System.out.println("type -999 for ok");
                       while(x != -999)
                       {
                          System.out.println("type a ");
			  x = input.nextInt();
                        if(x != -999)
                          a[i] = x;
                        
                        if(x == -999) break;
             
                        System.out.println("type n ");
                        n[i] = input.nextInt();
                        i++;
                       }
			
        System.out.println(chineseRemainder(n, a));
    }
    
}
