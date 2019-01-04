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
    mModifier mod = new mModifier();
    StringBuilder content = new StringBuilder("");
    StringBuilder explaining = new StringBuilder("");
    ArrayList<String> args = new ArrayList<String>();
    boolean constructor = false;
    
    mMethod (mModifier mod, String name)
    {
	this.mod = mod; mod = new mModifier();
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
    
    public boolean isConstructor() {return constructor;}
    
    public void setRetrn (String str)
    {
	retrn = str; str = new String("");
    }
    
    public void addContent(String str)
    {
	content.append(str);
	explaining.append(Translator.translate(str));
    }
    
    public String toString(spec ... s)
    {
	StringBuilder sb = new StringBuilder("");
	for(spec e:s)
	{
	    switch(e)
	    {
		case NAME: sb.append(name); break;
		case TYPE: sb.append(retrn); break;
		case RETURN: sb.append(" "+retrn); break;
		case MODIFIER: sb.append(" "+mod.toString()); break;
		//case ARGUMENT: for(int i=0;i<args.size();i++)
		/*case ___: sb	.append(" "+mod.toString())
					.append(" "+retrn)
					.append(" "+name)
					.append("(");
					for(int i=0;i<args.size();i++) {sb.append(" "+args.get(i));}
					sb.append(") {")
					.append(content)
					.append("}"); break;*/
		case ARGUMENT_TYPE: for(int i=0;i<args.size();i++) {if(i%2==1) {sb.append(" "+args.get(i));}} break;
		case ARGUMENT_NAME: for(int i=0;i<args.size();i++) {if(i%2==0) {sb.append(" "+args.get(i));}} break;
		case CONTENT: sb.append(content); break;
	    }
	}
	return sb.toString();
    }
	
}
