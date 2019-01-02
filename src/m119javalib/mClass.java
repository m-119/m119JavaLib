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
    
    ArrayList <String> imports = new ArrayList <String>();
    ArrayList <mMethod> methods = new ArrayList <mMethod>();
    
    mClass(String str)
    {
	this.name = str;
    }
    
    mClass(String name, mModifier mods, String pack, ArrayList <String> imports)
    {
	this.name = name; name = null;
	this.mods = mods; mods = null;
	this.pack = pack; pack = null;
	this.imports = imports; imports = null;
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
    
    //package "xxx"
    //определение пакета
    public void setPackage (String str)
    {
	this.pack = str;
    }
    
    //package "xxx"+"."+"xxx"
    //добавление к определению пакета
    public void addPackage (String str)
    {
	this.pack.concat(str);
    }
    
    //import "xxx"
    //определение импорта
    public void setImport (String str)
    {
	this.pack = str;
    }
    
    //import "xxx"+"."+"xxx"
    //добавление к определению импорта
    public void addImport (String str)
    {
	this.pack.concat(str);
    }
}
