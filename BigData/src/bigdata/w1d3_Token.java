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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 984338
 */
public class w1d3_Token {

    public static void sendToReducer(ArrayList<FileReader> file) {
        int tempToken = 0;
        int noOfTokens = 0;
        int fileNumber = 1;
        for (FileReader a : file) {
            BufferedReader br = null;
            try {
                String sCurrentLine;
                br = new BufferedReader(a);
                while ((sCurrentLine = br.readLine()) != null) {
                    if (fileNumber == 1) {
                        //Transported from Reducer 1 to other in network
                        if (sCurrentLine.compareTo("k") >= 0) {
                            noOfTokens++;
                        }
                    }
                    if (fileNumber == 2) {
                        //Transported from Reducer 3 to other in network
                        if (sCurrentLine.compareTo("k") >= 0 || sCurrentLine.compareTo("p") <= 0) {
                            noOfTokens++;
                        }
                    }
                    if (fileNumber == 3) {
                        // Transported from Reducer 2 to other in network
                        if (sCurrentLine.compareTo("p") <= 0) {
                            noOfTokens++;
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("File " + fileNumber + " Outgoing Token: " + (noOfTokens - tempToken));
            tempToken = noOfTokens;
            fileNumber++;
        }
        System.out.println("Total Tokens: " + noOfTokens);
    }

    public static void main(String args[]) throws FileNotFoundException {
        FileReader file1 = new FileReader("doc1.txt");
        FileReader file2 = new FileReader("doc2.txt");
        FileReader file3 = new FileReader("doc3.txt");
        ArrayList<FileReader> array = new ArrayList<FileReader>();
        array.add(file1);
        array.add(file2);
        array.add(file3);
        sendToReducer(array);
    }

}
