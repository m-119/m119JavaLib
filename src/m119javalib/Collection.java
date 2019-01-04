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

public class Collection {
    
    //комментарии разработчика
    static public ArrayList<String> comments = new ArrayList<String>();
    //номер строки, к которой комментарий
    static public ArrayList<Integer> commentsLine = new ArrayList<Integer>();
    //нормализованный код
    static public ArrayList<String> code = new ArrayList<String>();
    //табуляции в коде
    static public ArrayList<Integer> codeTabs = new ArrayList<Integer>();
    //номер строки, в которой код
    static public ArrayList<Integer> codeLine = new ArrayList<Integer>();
    //классы
    static public ArrayList<mClass> classCollection = new ArrayList<mClass>();
}
