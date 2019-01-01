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
    ArrayList <mModifier> Mods = new ArrayList <mModifier>();
    ArrayList <mMethod> Methods = new ArrayList <mMethod>();
    
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
