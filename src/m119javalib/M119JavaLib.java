/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m119javalib;

/**
 *
 * @author JAG
 */
public class M119JavaLib {

    /**
     * @param args the command line arguments
     */
    String s = "\npackage javaapplication8;\n\nimport java.util.regex.Matcher;\nimport java.util.regex.Pattern;\n\n\n\n/**\n *\n * @author JAG\n */\n		public class JavaApplication8 {\n\n    String s = \"\";\n    \n    JavaApplication8()\n    {\n	//начальная позиция\n	Pattern p_start = Pattern.compile(\"(//|/\\\\*|\\\")\", Pattern.MULTILINE);\n	//однострочный комментарий\n	Pattern p_csingle = Pattern.compile(\"[^\\\\\\\\]\\n\", Pattern.MULTILINE);\n	//многострочный комментарий\n	Pattern p_cmulti = Pattern.compile(\"\\\\*/\", Pattern.MULTILINE);\n	//строка\n	Pattern p_string = Pattern.compile(\"[^\\\\\\\\]\\\"\", Pattern.MULTILINE);\n	\n	Matcher m_start = p_start.matcher(s);\n	Matcher m_csingle = p_csingle.matcher(s);\n	Matcher m_cmulti = p_cmulti.matcher(s);\n	Matcher m_string = p_string.matcher(s);\n	\n	int current = 0;\n	\n	int start=0;\n	int end=0;\n	\n	\n	while (m_start.find(current)) {\n\n	    switch (m_start.group()) {\n		case \"//\":\n		    current = m_start.start();\n		    start = current;\n		    m_csingle.find(current+ m_start.group().length());\n		    current = m_csingle.end();\n		    end = current;\n		    break;\n		case \"/*\":\n		    current = m_start.start();\n		    start = current;\n		    m_cmulti.find(current+ m_start.group().length());\n		    current = m_cmulti.end();\n		    end = current;\n		    break;\n		case \"\\\"\":\n		    current = m_start.start();\n		    start = current;\n		    m_string.find(current+ m_start.group().length());\n		    current = m_string.end();\n		    end = current;\n		    break;\n		default: break;\n	    }\n	    System.out.println(s.substring(start, end));\n	    \n        }\n		\n	//Pattern p_stat = Pattern.compile(\"(\\/\\/|\\/\\*|\\\")\");\n    }\n    \n    /**\n     * @param args the command line arguments\n     */\n    public static void main(String[] args) {\n	// TODO code application logic here\n	new JavaApplication8();\n\n    }\n    \n}";
    
    M119JavaLib()
    {
	Collections c = new Collections();
	
	c.collect(s);
	
	//System.out.print(sb.toString());
    }
    
    public static void  main(String[] args) {
	M119JavaLib m = new M119JavaLib();

    }
    
}
