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
public class mClass {
    
    //имя
    String name = "";
    String pack = "";
    String extend = "";
    mModifier mods = new mModifier();
    
    boolean haveConstructors = false;
    boolean haveMethods = false;
    
    public void haveConstructors(boolean set) {haveConstructors = set;}
    public boolean haveConstructors() {return haveConstructors;}
    public void haveMethods(boolean set){haveMethods = set;}
    public boolean haveMethods(){return haveMethods;}
    
    ArrayList <StringBuilder> imports = new ArrayList <StringBuilder>();
    ArrayList <mMethod> methods = new ArrayList <mMethod>();
    ArrayList <mProperty> properties = new ArrayList <mProperty>();
    ArrayList <StringBuilder> implement = new ArrayList <StringBuilder>();
    mClass(String str)
    {
	this.name = str;
    }
    
    mClass(String name, mModifier mods, String pack, ArrayList <StringBuilder> imports)
    {
	this.name = name; name = new String("");
	this.mods = mods; mods = new mModifier();
	this.pack = pack; pack = new String("");
	this.imports = imports; imports = new ArrayList <StringBuilder>();
    }
    
    public void setImplement(String str)
    {
	this.implement.add(new StringBuilder(str));
    }
    
    public void addImplement(String str)
    {
	this.implement.get(implement.size()-1).append(str);
    }
    
    public void setExtend(String str)
    {
	this.extend = str;
    }
    
    public void addExtend(String str)
    {
	this.extend += str;
    }
    
    //определение имени
    public void setName (String str)
    {
	this.name = str;
    }
    
    //получение имени
    public String getName ()
    {
	return this.name;
    }    
    
    //package "xxx"
    //определение пакета
    public void setPackage (String str)
    {
	this.pack = str; str = new String("");
    }
    
    //package "xxx"+"."+"xxx"
    //добавление к определению пакета
    public void addPackage (String str)
    {
	this.pack.concat(str); str = new String("");
    }
    
    //import "xxx"
    //определение импорта
    public void setImport (String str)
    {
	this.pack = str; str = new String("");
    }
    
    //import "xxx"+"."+"xxx"
    //добавление к определению импорта
    public void addImport (String str)
    {
	this.pack.concat(str); str = new String("");
    }
    
    public ArrayList <mProperty> getProperties()
    {
	return properties;
    }
    
    public mProperty lastProperty()
    {
	return properties.get(properties.size()-1);
    }
    
    public void setProperty(ArrayList <mProperty> p)
    {
	properties = p;
	p = new ArrayList <mProperty>();
    }
    
    public ArrayList <mMethod> getMethods()
    {
	return methods;
    }
    
    public mMethod lastMethod()
    {
	return methods.get(methods.size()-1);
    }
    
    @Override
    public String toString() {
	
	StringBuilder sb = new StringBuilder();
	return sb.toString().substring(0, sb.length()-1);
    }
    
    public String toString(spec ... s)
    {
	StringBuilder sb = new StringBuilder("");
	for(spec e:s)
	{
	    switch(e)
	    {
		case NAME: sb.append(name); break;
		case PACKAGE: sb.append(pack); break;
		case MODIFIER: sb.append(mods); break;
		case IMPORT: for(int i=0;i<imports.size();i++) sb.append(" "+imports.get(i)); break;
		case EXTENDS: sb.append(" "+extend); break;
		case IMPLEMENTS: for(int i=0;i<imports.size();i++) sb.append("\n"+implement.get(i)); break;
		
		case METHODS: for(int i=0;i<methods.size();i++) {sb.append(" "+methods.get(i).toString());} break;
		case METHODS_NAME: 	for(int i=0;i<methods.size();i++) {sb.append(" "+methods.get(i).toString(e.NAME));} break;
		case METHODS_TYPE: 	for(int i=0;i<methods.size();i++) {sb.append(" "+methods.get(i).toString(e.TYPE));} break;
		case METHODS_RETURN: 	for(int i=0;i<methods.size();i++) {sb.append(" "+methods.get(i).toString(e.RETURN));} break;
		case METHODS_MODIFIER: 	for(int i=0;i<methods.size();i++) {sb.append(" "+methods.get(i).toString(e.MODIFIER));} break;
		case METHODS_ARGUMENT: 	for(int i=0;i<methods.size();i++) {sb.append(" "+methods.get(i).toString(e.ARGUMENT));} break;
		case METHODS_CONTENT: 	for(int i=0;i<methods.size();i++) {sb.append(" "+methods.get(i).toString(e.CONTENT));} break;
	    }
	}
	return sb.toString();
    }
}
