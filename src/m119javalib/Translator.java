/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m119javalib;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author JAG
 */


public class Translator {
   static Map<String,String> dict = new HashMap<>();
   
   Translator()
   {
	dict.put("abstract", "абстрактный");
	dict.put("assert", "диагностическое утверждение");
	dict.put("boolean", "булевая переменная(true или false)");
	dict.put("break", "завершается цикл");
	dict.put("byte", "битовая переменная(-128 до 127)");
	dict.put("case", "если проверяемое значение равно");
	dict.put("catch", "перехватывает исключение");
	dict.put("char", "двубайтовая переменная(0 до 65536)");
	dict.put("class", "вложенный класс");
	dict.put("сonst", "!сonst!");
	dict.put("continue", "продолжить выполнение цикла с начала");
	dict.put("default", "если условие ветвления не было выполнено");
	dict.put("do", "выполнить блок кода");
	dict.put("double", "переменная с двойной точностью(64 бит)");
	dict.put("else", "иначе");
	dict.put("enum", "перечислимый тип");
	dict.put("extends", "расширяет класс");
	dict.put("final", "не наследует и не расширяется");
	dict.put("finally", "независимо от корректности выполнения будет выполено");
	dict.put("float", "переменная с плавающей точкой ");
	dict.put("for", "цикл for выполняемый по условиям");
	dict.put("goto", "!goto!");
	dict.put("if", "если верно условие");
	dict.put("implements", "реализует интерфейс");
	dict.put("import", "импортируемый класс");
	dict.put("instanceof", "наследуется от");
	dict.put("int", "целочисленная переменная");
	dict.put("interface", "интерфейс");
	dict.put("long", "переменная типа long");
	dict.put("native", "метод реализован на другом языке программирования");
	dict.put("new", "новый экземпляр класса");
	dict.put("package", "пекет");
	dict.put("private", "переменная класса");
	dict.put("protected", "переменная доступная при наследовании");
	dict.put("public", "открытая переменная");
	dict.put("return", "завершить выполнение метода");
	dict.put("short", "переменная типа short");
	dict.put("static", "статическая переменная");
	dict.put("strictfp", "контроль выполнения операций с плавающей точкой");
	dict.put("super", "обращение к родительскому классу");
	dict.put("switch", "для дальнейшего перехода, проверить значение");
	dict.put("synchronized", "блок выполняется для одного потока");
	dict.put("this", "данный класс");
	dict.put("throw", "генерируется исключение");
	dict.put("throws", "исключения передающиеся выше");
	dict.put("transient", "не сериализуемая");
	dict.put("try", "попробовать выполнить код");
	dict.put("void", "не возвращает значение");
	dict.put("volatile", "для асинхронного выполнения");
	dict.put("while", "повторять код блока пока выполняется условие");
   }
   
   static String translate(String str)
   {
       String s;
       s = dict.getOrDefault(str, str);
       return s;
   }
   
}
