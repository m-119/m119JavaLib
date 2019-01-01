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
    static private ArrayList<String> types = new ArrayList<String>();
    static

    //предподготовка
    private PrePreparation pt = new PrePreparation();
    //подготовка
    private Preparation p = new Preparation();
    //коллекционирование
    private Collections c = this;
    
    

    Collections() {
	
    }
    
    public void collect(StringBuilder strb) {
	//предподготовка
	pt.collect(strb, c.getComments(), c.getStrings());
	//подготовка
	p.run(strb);
	//возврат строк в текст
	pt.returnTexts(strb, c.getStrings());
	
	//trace
	System.out.print(strb.toString());
    }
    
    public void collect(String str) {
	StringBuilder sb = new StringBuilder(str);
	collect(sb);
    }

    public String getComment(int i) {
	return comments.get(i);
    }

    public ArrayList<String> getComments() {
	return comments;
    }

    String getString(int i) {
	return strings.get(i);
    }

    ArrayList<String> getStrings() {
	return strings;
    }

}
