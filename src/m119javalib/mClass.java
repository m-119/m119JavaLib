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
    String implement = "";
    mModifier mods = new mModifier();
    
    ArrayList <StringBuilder> imports = new ArrayList <StringBuilder>();
    ArrayList <mMethod> methods = new ArrayList <mMethod>();
    ArrayList <mProperty> properties = new ArrayList <mProperty>();
    
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
	this.implement = str;
    }
    
    public void addImplement(String str)
    {
	this.implement += str;
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
}
