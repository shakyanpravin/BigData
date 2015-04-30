/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdata;

/**
 *
 * @author 984338
 */
public class MapFold_Contains0000 {

    public static int f(int x) {
     
       return x==0?0:1;
    }

    public static int g(int x, int y) {
        if(x<y&&y==0)
            return x+1;
        else if(x==5&&y==0)
            return 5;
        else if(x==4&&y==1)
            return 6;
        else if (x==6)
    }

    public static int isPrime(int n) {
        if (n < 2) {
            return 0;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] a = {13, 11, 12, 16, 0, 21};
        int[] b = new int[a.length];
        int[] c = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = f(a[i]);
        }

        int x = 0;
        for (int i = 0; i < a.length; i++) {
            x = g(x, b[i]);
            c[i] = x;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + b[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t" + c[i] + " ");
        }
        System.out.println();
    }
}
