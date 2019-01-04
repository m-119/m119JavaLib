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
public class Writer {

    //комментарии разработчика
    static private ArrayList<String> comments = Collection.comments;
    //номер строки, к которой комментарий
    static private ArrayList<Integer> commentsLine = Collection.commentsLine;
    //нормализованный код
    static private ArrayList<String> code = Collection.code;
    //табуляции в коде
    static private ArrayList<Integer> codeTabs = Collection.codeTabs;
    //номер строки, в которой код
    static private ArrayList<Integer> codeLine = Collection.codeLine;
    //классы
    static private ArrayList<mClass> classCollection = Collection.classCollection;

    Writer() {

    }

    public void write(String str) {
	StringBuilder sb = new StringBuilder("");
	for (mClass cc : classCollection) {

	    String name_ = cc.toString(spec.NAME);
	    String package_ = cc.toString(spec.PACKAGE);
	    String implements_ = cc.toString(spec.IMPLEMENTS);
	    String extends_ = cc.toString(spec.EXTENDS);
	    String modifier_ = cc.toString(spec.MODIFIER);

	    sb.append("Класс " + name_ + " (" + modifier_ + ") \n");
	    sb.append(package_);
	    if (implements_.length() > 0) {
		sb.append("Реализуемые интерфейсы:\n" + implements_);
	    }
	    if (extends_.length() > 0) {
		sb.append("\nРасширяет класс: " + extends_);
	    }

	    if (cc.haveConstructors) {
		sb.append("Конструкторы:\n");
	    }
	    for (mMethod m : cc.getMethods()) {
		if (m.isConstructor()) {
		    sb.append(m.toString(spec.MODIFIER) + " " + m.toString(spec.NAME) + "(" + m.toString(spec.METHODS_TYPE) + ")\n");
		}
	    }

	    if (cc.haveMethods) {
		sb.append("Методы:\n");
	    }
	    for (mMethod m : cc.getMethods()) {
		if (!m.isConstructor()) {
		    sb.append(m.toString(spec.MODIFIER) + " " + m.toString(spec.NAME) + "(" + m.toString(spec.METHODS_TYPE) + ")\n");
		}
	    }
	}
	
	System.out.print(sb);
    }

}
