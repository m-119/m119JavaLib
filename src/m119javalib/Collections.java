/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m119javalib;

import java.util.ArrayList;

/**
 *
 * @author JAG
 */
public class Collections {

    static private ArrayList<String> comments = new ArrayList<String>();
    static private ArrayList<String> strings = new ArrayList<String>();
    
    

    Collections() {
	//
    }

    void collect(StringBuilder str) {

    }

    static public String getComment(int i) {
	return comments.get(i);
    }

    static public ArrayList<String> getComments() {
	return comments;
    }

    static String getString(int i) {
	return strings.get(i);
    }

    static ArrayList<String> getStrings() {
	return strings;
    }

}
