/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 984338
 */
public class w1d3_Token {

   public int sendToReducer(String a)
   {
       FileReader file1 = new FileReader("doc1.txt");
        FileReader file2 = new FileReader("doc2.txt");
        FileReader file3 = new FileReader("doc3.txt");
        
        
       int noOfTokens=0;
       for(String a:)
       if(a.compareTo("k")==0 || a.compareTo("k")>0)
       {
           noOfTokens++;
       }
       else if(a.compareTo("p")==0||a.compareTo("p")<0)
       {
           noOfTokens++;
       }
       else
       {
           noOfTokens++;
       }
   }

    public int readFile(String fileName) {
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(fileName));
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void main(String args[]) throws FileNotFoundException {
        FileReader file1 = new FileReader("doc1.txt");
        FileReader file2 = new FileReader("doc2.txt");
        FileReader file3 = new FileReader("doc3.txt");
        
        
        

    }

}
