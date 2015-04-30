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
public class w1d3_Token1 {

    public static void sendToReducer(ArrayList<FileReader> file) {

        int noOfTokens = 0;
        int counter = 0;
        for (FileReader a : file) {
            BufferedReader br = null;
            try {
                String sCurrentLine;
                String sSingle;
                br = new BufferedReader(a);
//                List blockA = new ArrayList();
//                List blockB = new ArrayList();
//                List blockC = new ArrayList();
                while ((sCurrentLine = br.readLine()) != null) {
                    char c = sCurrentLine.charAt(0);
                    sSingle = Character.toString(c);
//                    if (sSingle.compareTo("k") < 0) {
//                        //Transported from Reducer 1 to other in network
//                        blockA.add(sCurrentLine);
//                        noOfTokens++;
//                    } else if (sSingle.compareTo("p")  <= 0) {
//                        //Transported from Reducer 3 to other in network
//                        //blockB.add(sCurrentLine);
//                    } else {
//                        // Transported from Reducer 2 to other in network
//                        //blockC.add(sCurrentLine);
//                    }
                    if (sSingle.compareTo("k") >= 0) {
                        //Transported from Reducer 1 to other in network
//                        blockA.add(sCurrentLine);
                        if (counter == 0) {
                            noOfTokens++;
                        }

                    } else if (sSingle.compareTo("p") <= 0) {
                        //Transported from Reducer 3 to other in network
                        //blockB.add(sCurrentLine);
                        if (counter == 1) {
                            noOfTokens++;
                        }
                    } else {
                        // Transported from Reducer 2 to other in network
                        //blockC.add(sCurrentLine);
                        if (counter == 2) {
                            noOfTokens++;
                        }
                    }
                   
                }

              // System.out.println("no of token in block A = " + blockA.size());
                //  System.out.println("no of token in block B = " + blockB.size());
                //   System.out.println("no of token in block C = " + blockC.size());
            } catch (IOException e) {
                System.out.println(e);
            }
            
        }
        System.out.println("File " + noOfTokens);

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
        ArrayList<FileReader> array = new ArrayList<FileReader>();
        array.add(file1);
        array.add(file2);
        array.add(file3);
        sendToReducer(array);

    }

}
