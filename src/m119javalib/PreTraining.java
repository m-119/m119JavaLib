/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m119javalib;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JAG
 */
public class PreTraining {

    //паттерны
    //начальная позиция
    static Pattern p_start = Pattern.compile("(//|/\\*|\")", Pattern.MULTILINE);
    //однострочный комментарий
    static Pattern p_csingle = Pattern.compile("[^\\\\]\n", Pattern.MULTILINE);
    //многострочный комментарий
    static Pattern p_cmulti = Pattern.compile("\\*/", Pattern.MULTILINE);
    //строка
    static Pattern p_string = Pattern.compile("[^\\\\]\"", Pattern.MULTILINE);

    static void collect(StringBuilder s, ArrayList<String> com, ArrayList<String> str) {
	Matcher m_start = p_start.matcher(s);
	Matcher m_csingle = p_csingle.matcher(s);
	Matcher m_cmulti = p_cmulti.matcher(s);
	Matcher m_string = p_string.matcher(s);

	int current = 0;

	int start = 0;
	int end = 0;

	//собираем комментарии и тексты
	while (m_start.find(current)) {

	    switch (m_start.group()) {
		case "//":
		    current = m_start.start();
		    start = current;
		    m_csingle.find(current + m_start.group().length());
		    current = m_csingle.end();
		    end = current;
		    s.replace(start, end, "Ⓒ" + com.size() + "Ⓒ");
		    break;
		case "/*":
		    current = m_start.start();
		    start = current;
		    m_cmulti.find(current + m_start.group().length());
		    current = m_cmulti.end();
		    end = current;
		    s.replace(start, end, "Ⓒ" + com.size() + "Ⓒ");
		    break;
		case "\"":
		    current = m_start.start();
		    start = current;
		    m_string.find(current + m_start.group().length());
		    current = m_string.end();
		    end = current;
		    s.replace(start, end, "Ⓣ" + str.size() + "Ⓣ");
		    break;
		default:
		    break;
	    }
	    System.out.println(s.substring(start, end));
	}
    }

    ;
	
	//тестовый метод
	static void tcollect(StringBuilder s) {

    };
	
    PreTraining() {
    };

}
