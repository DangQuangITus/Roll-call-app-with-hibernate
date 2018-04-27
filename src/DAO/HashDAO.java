/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Gokki
 */
public class HashDAO {

    private static final String code = "qwertyuiopasdfghjklmnbvcxz_";

    public static String encryp(String pass, int key) {
        pass = pass.toLowerCase();
        String kq = "";
        int size = pass.length();
        for (int i = 0; i < size; i++) {
            int c = code.indexOf(pass.charAt(i));
            int keyval = (c + key) % 26;
            char replace = code.charAt(keyval);
            kq = kq + replace;
        }
        return kq;
    }

    public static String decryp(String pass, int key) {
        pass = pass.toLowerCase();
        String kq = "";
        int size = pass.length();
        for (int i = 0; i < size; i++) {
            int c = code.indexOf(pass.charAt(i));
            int keyval = (c - key) % 26;

            if (keyval < 0) {
                keyval = code.length() + keyval;
            }

            char replace = code.charAt(keyval);
            kq = kq + replace;
        }
        return kq;
    }
}
