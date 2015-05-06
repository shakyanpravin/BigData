/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdata;

import java.util.ArrayList;

/**
 *
 * @author 984338
 */
public class varInt {

    public static int byteRequiredForInt(int n) {
        int size = 1;
        if ((n >>> 28) != 0) {
            size = 5;
        } else if ((n >>> 21) != 0) {
            size = 4;
        } else if ((n >>> 14) != 0) {
            size = 3;
        } else if ((n >>> 7) != 0) {
            size = 2;
        }

        return size;
    }

    public static byte[] encodeInt(int n) {
        int size = byteRequiredForInt(n);

        byte[] code = new byte[size];

        for (int i = 0; i < size; i++) {
            code[i] = (byte) (n & 0x0000007F);
            n = n >>> 7;
        }
        byte mask = (byte) 0x80;
        code[0] = (byte) (code[0] | mask);

        return code;
    }

    public static int decodeInt(byte[] code) {
        byte mask = (byte) 0x7F;
        code[0] = (byte) (code[0] & mask);

        int n = 0;
        for (int i = code.length - 1; i >= 0; i--) {
            n = n << 7;
            n = (n | code[i]);
        }
        return n;
    }

    public static byte[] encode(int[] a) {
	  // you can try this

        int[] temp=new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i]=a[i];
            if (i % 2 == 0 && i != 0) {
                temp[i] = a[i] - a[i - 2];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
            System.out.print("\t");
        }
        System.out.println("");
        for(int j=0;j<temp.length;j++)
        {
            System.out.print(encodeInt(temp[j]));
            System.out.print("\t");
        }
        ArrayList<Byte> array =new ArrayList<Byte>();
        
        for(byte bb:)
        return b;
    }

    public static int[] decode(byte[] code) {
        // you can try this
    }

    public static String toStringByte(byte b) {
        String str = "";
        for (int i = 0; i < 8; i++) {
            str += (b < 0) ? "1" : "0";
            b = (byte) (b << 1);
        }
        return str;
    }

    public static void main(String[] args) {
        int[] plist = {100, 8, 150, 7, 300, 24, 500, 36};
        // you can add whatever you want
        for (int i = 0; i < plist.length; i++) {
            System.out.print(plist[i]);
            System.out.print("\t");
        }
        System.out.println("");
        encode(plist);

    }
}
