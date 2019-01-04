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
public class Reader {

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

    //временные значения//
    String[] text;
    //переносы
    private int newLine = 0;
    //строки
    private ArrayList<String> strings = new ArrayList<String>();
    //сборщик модификаторов
    private mModifier mod = new mModifier();
    //читаем?
    private boolean ignoreBlank = false;
    //сборщик пакета
    StringBuilder pack = new StringBuilder("");
    //сборщик импортов
    private ArrayList<StringBuilder> imports = new ArrayList<StringBuilder>();
    //предподготовка
    private PrePreparation pt = new PrePreparation();
    //подготовка
    private Preparation p = new Preparation();
    //коллекционирование
    private Reader c = this;
    //вложенность
    private int nesting = 0;
    //куда писать
    int r;
    //длина строки;
    int l;

    Translator t = new Translator();

    Reader() {

    }

    //подготовка
    public void prepare(StringBuilder strb) {
	//предподготовка
	pt.run(strb, c.getComments(), c.getStrings());
	//подготовка
	p.run(strb);
	//возврат строк в текст
	//pt.returnTexts(strb, c.getStrings());
	////чтение
	text = p.split(strb);
	//возврат строк в текст
	pt.returnTexts(text, c.getStrings());
    }

    public void prepare(String str) {
	StringBuilder sb = new StringBuilder(str);
	prepare(sb);
    }

    //чтение
    public void read() {

	for (int i = 0; i < text.length; i++) {

	    //System.out.println(text[i] + " " + i);
	    //игнор переносов и пробелов (лучше перенести в подготовку, иначе много где придется игнорить)
	    /*if (ignoreBlank & ((text[i].equals("\n")) | (text[i].equals("\n")))) {
		continue;
	    }*/

	    l = text[i].length();

	    //если модификатор, копим модификаторы
	    if (mod.set(text[i])) {
		ignoreBlank = true;
		continue;
	    } else if (text[i].equals("class")) {
		//если класс, далее - название
		i++;

		classCollection.add(new mClass(text[i], mod, pack.toString(), imports));
		continue;
	    } else if (text[i].equals("extends")) {
		//если расширяет, далее - название класса
		i++;
		classCollection.get(classCollection.size() - 1).setExtend(text[i]);
		while (!(text[i + 1].equals("."))) {
		    i++;
		    classCollection.get(classCollection.size() - 1).addExtend("." + text[++i]);
		}
		continue;
	    } else if (text[i].equals("implements")) {
		//если реализует, далее - название класса
		
		i++;
		classCollection.get(classCollection.size() - 1).setImplement(text[i]);
		while ((text[i + 1].equals("."))) {
		    i++;
		    classCollection.get(classCollection.size() - 1).addImplement("." + text[++i]);
		}
		while (text[i + 1].equals(",")) {
		    
		    i++;
		    i++;
		    classCollection.get(classCollection.size() - 1).setImplement(text[i]);
		    while ((text[i + 1].equals("."))) {
			i++;
			classCollection.get(classCollection.size() - 1).addImplement("." + text[++i]);
		    }
		}

		continue;
	    }

	    //проверка уровня вложенности
	    //если это первый уровень вложенности: описательная часть класса
	    if (text[i].equals("{")) {
		nesting++;
		if (nesting == 1) {
		    i++;
		    continue;
		}
	    } else if (text[i].equals("}")) {
		nesting--;
		if (nesting == 0) {
		    i++;
		    continue;
		}
	    }

	    switch (text[i]) {
		case "package":
		    while (!(text[++i].equals(";"))) {
			if (!" ".equals(text[i]) & !"\n".equals(text[i])) {
			    pack.append(text[i]);
			}
		    }
		    continue;
		//если импорт, собираем в импорт
		case "import":
		    imports.add(new StringBuilder(""));
		    r = imports.size() - 1;
		    while (!(text[++i].equals(";"))) {
			if (!" ".equals(text[i]) & !"\n".equals(text[i])) {
			    imports.get(r).append(text[i]);
			}
		    }
		    continue;
	    }

	    if (!(text[i].equals("\n")) & !(text[i].equals(" ")) & !(text[i].equals(""))) {
		int count_parenthesis = 0;
		int count_brace = 0;
		String str1;
		String str2;
		String str3;

		str1 = text[i];
		str2 = text[++i];
		str3 = text[++i];

		//если 3й символ ;, значит объявление переменной
		if (str3.equals(";")) {
		    classCollection.get(classCollection.size() - 1).getProperties().add(new mProperty(mod, str1, str2));
		    continue;
		} //если второй символ =, значит присвоение объявленной переменной значения
		//if(str2.equals("="))
		//{}
		//если третий символ =, значит объяевление с присвоением
		else if (str3.equals("=")) {
		    //добавляем свойство
		    classCollection.get(classCollection.size() - 1).getProperties().add(new mProperty(mod, str1, str2));
		    classCollection.get(classCollection.size() - 1).lastProperty().addContent(str3);

		    while (text[++i].equals(";")) {
			classCollection.get(classCollection.size() - 1).lastProperty().addContent(text[i]);
		    }
		    continue;
		}

		//методы
		if (str2.equals("(")) {

		    classCollection.get(classCollection.size() - 1).getMethods().add(new mMethod(mod, str1));
		    //возвращает void
		    classCollection.get(classCollection.size() - 1).lastMethod().setRetrn("void");
		    //это конструктор
		    if (str1.equals(classCollection.get(classCollection.size() - 1).getName())) {
			classCollection.get(classCollection.size() - 1).haveConstructors(true);
			classCollection.get(classCollection.size() - 1).lastMethod().constructor();
		    }else {classCollection.get(classCollection.size() - 1).haveMethods(true);}

		    //сбор атрибутов
		    if (!str3.equals(")")) {
			classCollection.get(classCollection.size() - 1).lastMethod().getArgs().add(str3);

			while (!text[++i].equals(")")) {
			    if (text[i].equals(")")) {
				break;
			    }
			    if (!text[i].equals(",")) {
				classCollection.get(classCollection.size() - 1).lastMethod().getArgs().add(text[i]);
			    }
			}
		    }

		    //получение контента
		    while (true) {
			i++;
			if (text[i].equals("\n") & count_brace == 0) {
			    continue;
			}

			if (text[i].equals("{")) {
			    count_brace++;
			    i++;
			} else if (text[i].equals("}")) {
			    count_brace--;
			}
			if (count_brace == 0) {
			    break;
			}

			classCollection.get(classCollection.size() - 1).lastMethod().addContent(text[i]);

		    }

		} else if (str3.equals("(")) {

		    classCollection.get(classCollection.size() - 1).getMethods().add(new mMethod(mod, str2));
		    //возвращает void
		    classCollection.get(classCollection.size() - 1).lastMethod().setRetrn(str1);
		    //это конструктор
		    if (str2.equals(classCollection.get(classCollection.size() - 1).getName())) {
			classCollection.get(classCollection.size() - 1).haveConstructors(true);
			classCollection.get(classCollection.size() - 1).lastMethod().constructor();
		    }else {classCollection.get(classCollection.size() - 1).haveMethods(true);}

		    //сбор атрибутов
		    if (!text[++i].equals(")")) {
			classCollection.get(classCollection.size() - 1).lastMethod().getArgs().add(text[i]);

			while (!text[++i].equals(")")) {
			    if (text[i].equals(")")) {
				break;
			    }
			    if (!text[i].equals(",")) {
				classCollection.get(classCollection.size() - 1).lastMethod().getArgs().add(text[i]);
			    }
			}
		    }

		    //получение контента
		    while (true) {
			i++;
			if (text[i].equals("\n") & count_brace == 0) {
			    continue;
			}

			if (text[i].equals("{")) {
			    count_brace++;
			    i++;
			} else if (text[i].equals("}")) {
			    count_brace--;
			}
			if (count_brace == 0) {
			    break;
			}

			classCollection.get(classCollection.size() - 1).lastMethod().addContent(text[i]);

		    }

		}
		//System.out.println("--END--:"+text[i]);
	    }

	}

	//trace
	//for (String s : comments){System.out.println(s);}
	//System.out.print(strb.toString());
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
