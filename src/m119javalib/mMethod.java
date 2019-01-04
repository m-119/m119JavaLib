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
public class mMethod {
    String name = "";
    String retrn = "";
    mModifier mods = new mModifier();
    StringBuilder content = new StringBuilder("");
    StringBuilder explaining = new StringBuilder("");
    ArrayList<String> args = new ArrayList<String>();
    boolean constructor = false;
    
    mMethod (mModifier mods, String name)
    {
	this.mods = mods; mods = new mModifier();
	this.name = name; name = new String("");
    }
    
    mMethod (String name)
    {
	this.name = name; name = new String("");
    }
    
    public ArrayList<String> getArgs()
    {
	return args;
    }
    
    public void constructor() {constructor = true;}
    
    public void setRetrn (String str)
    {
	retrn = str; str = new String("");
    }
    
    public void addContent(String str)
    {
	content.append(str);
    }
}
