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
public class mProperty {
    private String name = "";
    private String type = "";
    private String content = "";
    
    private mModifier mod;
    
    public void addContent (String str) {content.concat(str);}
    
    mProperty(String name,String type,String content)
    {
	this.name = name; name = new String("");
	this.type = type; type = new String("");
	this.content = content;
    }
    
    mProperty(String name,String type)
    {
	this.name = name; name = new String("");
	this.type = type; type = new String("");
    }
    
    mProperty(mModifier mod, String name,String type)
    {
	this.mod = mod;
	this.name = name;
	this.type = type;
    }
    
    public void setModifier (mModifier m)
    {
	this.mod = m; m = new mModifier();
    }
    
}
