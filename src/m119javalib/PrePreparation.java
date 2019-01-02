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
public class PrePreparation {

    //паттерны
    //начальная позиция
    private Pattern p_start = Pattern.compile("(//|/\\*|\")", Pattern.MULTILINE);
    //однострочный комментарий
    private Pattern p_csingle = Pattern.compile("[^\\\\]\n", Pattern.MULTILINE);
    //многострочный комментарий
    private Pattern p_cmulti = Pattern.compile("\\*/", Pattern.MULTILINE);
    //строка
    private Pattern p_string = Pattern.compile("[^\\\\]\"", Pattern.MULTILINE);
    //возврат "текстовых данных"
    private Pattern p_retext = Pattern.compile("Ⓣ(\\d+)Ⓣ", Pattern.MULTILINE);
    
    PrePreparation() {
	
    };

    synchronized void run(StringBuilder s, ArrayList<String> com, ArrayList<String> str) {
	Matcher m_start = p_start.matcher(s);
	Matcher m_csingle = p_csingle.matcher(s);
	Matcher m_cmulti = p_cmulti.matcher(s);
	Matcher m_string = p_string.matcher(s);

	// текущая позиция
	int current = 0;
	// начальная позиция
	int start = 0;
	// окончательная позиция
	int end = 0;

	//собираем комментарии и тексты
	while (m_start.find(current)) {

	    switch (m_start.group()) {
		case "//":
		    current = m_start.start();
		    start = current;
		    m_csingle.find(current);
		    end = m_csingle.end();
		    com.add(s.substring(start, end).replaceAll("\n *\\* *\n", "\n").replaceAll("\n( *|\\*)", "").replaceAll("^\\/*\\** *", ""));
		    s.replace(start, end, "Ⓒ" + (com.size()-1) + "Ⓒ");
		    break;
		case "/*":
		    current = m_start.start();
		    start = current;
		    m_cmulti.find(current);
		    end = m_cmulti.end();
		    com.add(s.substring(start, end).replaceAll("\n *\\* *\n", "\n").replaceAll("\n( *|\\*)", "").replaceAll("(^\\/*\\** *| *\\**\\/*$)", ""));
		    s.replace(start, end, "Ⓒ" + (com.size()-1) + "Ⓒ");
		    break;
		case "\"":
		    current = m_start.start();
		    start = current;
		    m_string.find(current);
		    end = m_string.end();
		    str.add(s.substring(start, end));
		    s.replace(start, end, "Ⓣ" + (str.size()-1) + "Ⓣ");
		    break;
		default:
		    break;
	    }
	    //System.out.println(s.substring(start, end));
	}
    };
    
    //Возвращение текстовых данных в код
    synchronized void returnTexts(StringBuilder sb, ArrayList<String> str){
	Matcher m_retext = p_retext.matcher(sb);
	while (m_retext.find()) {
	    sb.replace(m_retext.start(), m_retext.end(), str.get(Integer.parseInt(m_retext.group(1))));
	}
    }
	
	//тестовый метод
	void tcollect(StringBuilder s) {

    };

}
