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
public class varInt{

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

    public static int[] d_Gap(int[] a) {
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
            if (i % 2 == 0 && i != 0) {
                temp[i] = a[i] - a[i - 2];
            }
        }
        return temp;
    }

    public static int[] reverse_d_Gap(int[] a) {
        int[] temp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
            if (i % 2 == 0 && i != 0) {
                temp[i] = a[i] + a[i - 2];
            }
        }
        return temp;
    }

    public static void display(int[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i]);
            System.out.print("\t");
        }
        System.out.println("");
    }

    public static void display(byte[] temp) {
        for (int i = 0; i < temp.length; i++) {
            System.out.print(toStringByte(temp[i]));
            System.out.print("\t");
        }
        System.out.println("");
    }

    public static byte[] encode(int[] a) {
        // you can try this
        int[] temp = d_Gap(a);
        display(temp);
        ArrayList<Byte> array = new ArrayList<Byte>();
        for (int j = 0; j < temp.length; j++) {

            byte[] b = encodeInt(temp[j]);
            int k = b.length - 1;
            while (k >= 0) {
                array.add(b[k]);
                k--;
            }
        }
        byte[] arrayOfByte = new byte[array.size()];
        for (int y = 0; y < array.size(); y++) {
            arrayOfByte[y] = array.get(y);
        }

        return arrayOfByte;
    }

    public static int[] decode(byte[] code) {
        // you can try this
        ArrayList<Integer> array = new ArrayList<Integer>();
        int length = code.length;
        byte[] newByte = new byte[length];
        int check = -1;
        for (int i = 0; i < length; i++) {

            check = code[i] >> 1;
            int temp = 0;
            ArrayList<Byte> newArray = new ArrayList();
            if (check == 0) {
                while (check == 0) {
                    newArray.add(code[i]);
                    // temp = (byte) code[i] + (byte) code[i + 1];
                    // array.add((byte) temp);
                    int before = code[i + 1];
                    code[i] = code[i + 1];
                    check = before >> 1;
                    length--;
                }
                byte[] ga = new byte[newArray.size()];
                for (int l = 0; l < newArray.size(); l++) {

                    ga[l] = (byte) newArray.get(l);
                }
                array.add(decodeInt(ga));
            } else {
                byte[] bnew = new byte[1];
                for(byte a:bnew)
                {
                    a=code[i];
                }
               
                array.add(decodeInt(bnew));
            }

        }
        int[] newb = new int[array.size()];

        for (int i = 0; i < length; i++) {
            newb[i]  =  array.get(i);
        }
        return newb;
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
        display(plist);
        byte[] yeti = encode(plist);
        display(yeti);
        int[] decoded = decode(yeti);
        display(decoded);

    }
}
