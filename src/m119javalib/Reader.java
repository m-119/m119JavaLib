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
    static private ArrayList<String> comments = new ArrayList<String>();
    //номер строки, к которой комментарий
    static private ArrayList<Integer> commentsLine = new ArrayList<Integer>();
    //нормализованный код
    static private ArrayList<String> code = new ArrayList<String>();
    //табуляции в коде
    static private ArrayList<Integer> codeTabs = new ArrayList<Integer>();
    //номер строки, в которой код
    static private ArrayList<Integer> codeLine = new ArrayList<Integer>();
    
    //классы
    static private ArrayList<mClass> classCollection = new ArrayList<mClass>();

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
    Reader() {
	
    }
    
    //подготовка
    public void prepare(StringBuilder strb) {
	//предподготовка
	pt.run(strb, c.getComments(), c.getStrings());
	//подготовка
	p.run(strb);
	//возврат строк в текст
	pt.returnTexts(strb, c.getStrings());
	////чтение
	text = p.split(strb);
    }
    public void prepare(String str) {
	StringBuilder sb = new StringBuilder(str);
	prepare(sb);
    }
    
	//чтение
    public void read() {
	
	for (int i=0 ; i<text.length; i++)
	{
	    //игнор переносов и пробелов (лучше перенести в подготовку, иначе много где придется игнорить)
	    if (ignoreBlank&((text[i].equals("\n"))|(text[i].equals("\n")))) {continue;}
	    
	    l = text[i].length();
	    
	    //если модификатор, копим модификаторы
	    if(mod.set(text[i]))
	    {
	    ignoreBlank = true;
	    continue;
	    }
	    
	    else if (text[i].equals("class"))
	    {
		//если класс, далее - название
		i++;
		classCollection.add(new mClass(text[i]));
		continue;
	    }
	    
	    else if (text[i].equals("extends"))
	    {
		//если расширяет, далее - название класса
		i++;
		classCollection.get(classCollection.size()-1).setExtend(text[i]);
		while (!(text[i+1].equals("."))){ i++; classCollection.get(classCollection.size()-1).addExtend("."+text[++i]); }
		continue;
	    }
	    
	    else if (text[i].equals("implements"))
	    {
		//если реализует, далее - название класса
		i++;
		classCollection.get(classCollection.size()-1).setImplement(text[i]);
		while (!(text[i+1].equals("."))){ i++; classCollection.get(classCollection.size()-1).addImplement("."+text[++i]); }
		continue;
	    }
	    
	    //проверка уровня вложенности
	    //если это первый уровень вложенности: описательная часть класса
	    if(text[i].equals("{")) {nesting++; if(nesting==1){i++; continue;}}
	    else if (text[i].equals("{")) {nesting--; if(nesting==0){i++; continue;}}
	    
	    if(l>10)
	    {
	    }
	    else if (l>1)
	    {
		switch(text[i]){
		    
		    case "package":
			while (!(text[++i].equals(";")))
				{
				    if(!" ".equals(text[i])&!"\n".equals(text[i]))
				    {pack.append(text[i]);}
				}
			break;
			//если импорт, собираем в импорт
		    case "import":
			imports.add(new StringBuilder(""));
			r = imports.size()-1;
			while (!(text[++i].equals(";")))
				{
				    if(!" ".equals(text[i])&!"\n".equals(text[i]))
				    {imports.get(r).append(text[i]);}
				}
			break;
			    
		}
	    }
	    else if (l==1)
	    {
		
	    }
	    else
	    {
		try{System.out.println("пусто:"+text[i-1]+"_"+text[i+1]);}
		catch (ArrayIndexOutOfBoundsException e) {System.out.println("пусто");}
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
