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

    static private ArrayList<String> comments;
    static private ArrayList<String> strings;

    Collections() {
    }

    void collect(StringBuilder str) {

    }

    String getComment(int i) {
	return comments.get(i);
    }

    ArrayList<String> getComments() {
	return comments;
    }

    String getString(int i) {
	return strings.get(i);
    }

    ArrayList<String> getStrings() {
	return strings;
    }

}
