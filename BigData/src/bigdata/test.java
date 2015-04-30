/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigdata;

import java.util.HashMap;

/**
 *
 * @author prabin
 */
public class test {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("prabin", 1986);
        hm.put("shakya", 2000);
        hm.put("nabin", 2005);

        hm.remove("nabin");
        System.out.println(hm.get("prabin"));

    }
}
