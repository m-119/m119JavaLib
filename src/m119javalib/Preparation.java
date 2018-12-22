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
public class Preparation {
    
    static public void run(StringBuilder s){
	s.replace(0, s.length(),
	    s.toString().replaceAll("(\\p{Punct})", " $1 ") 
	    .replaceAll("(?m)(^[ \\t\\x0B\\f]*|[ \\t\\x0B\\f]*$)", " ") 
	    .replaceAll("[ \\t\\x0B\\f]+", " ") 
	    .replaceAll("([^\\n]) (\\{|})", "$1 \n $2") 
	    .replaceAll("(\\{|}) ([^\\n])", "$1 \n $2") 
	    .replaceAll("( \\n)+", " \n"));
	
	    
    }
    
    static public void run(String s){
	s = s.toString().replaceAll("(\\p{Punct})", " $1 ") 
	    .replaceAll("(?m)(^[ \\t\\x0B\\f]*|[ \\t\\x0B\\f]*$)", " ") 
	    .replaceAll("[ \\t\\x0B\\f]+", " ") 
	    .replaceAll("([^\\n]) (\\{|})", "$1 \n $2") 
	    .replaceAll("(\\{|}) ([^\\n])", "$1 \n $2") 
	    .replaceAll("( \\n)+", " \n");
    }
    
    Preparation(){}
    
}
