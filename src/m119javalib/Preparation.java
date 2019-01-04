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
    
    public void run(StringBuilder sb){
	sb.replace(0, sb.length()-1,
	    sb.toString().replaceAll("(\\p{Punct})", " $1 ") 
	    .replaceAll("(?m)(^[ \\t\\x0B\\f]*|[ \\t\\x0B\\f]*$)", " ") 
	    .replaceAll("(?m)[ \\t\\x0B\\f]+", " ") 
	    .replaceAll("([^\\n]) (\\{|})", "$1 \n $2") 
	    .replaceAll("(\\{|}) ([^\\n])", "$1 \n $2") 
	    .replaceAll("( \\n)+", " \n")
	//корректировки возникшие по ходу написания:
		.replaceAll(" (<|\\[|>|]) ", "$1") //ArrayList<String>();
		
		
	);
	
    }
    public void run(String s){
	s = s.toString().replaceAll("(\\p{Punct})", " $1 ") 
	    .replaceAll("(?m)(^[ \\t\\x0B\\f]*|[ \\t\\x0B\\f]*$)", " ") 
	    .replaceAll("[ \\t\\x0B\\f]+", " ") 
	    .replaceAll("([^\\n]) (\\{|})", "$1 \n $2") 
	    .replaceAll("(\\{|}) ([^\\n])", "$1 \n $2") 
	    .replaceAll("( \\n)+", " \n")
	    //корректировки возникшие по ходу написания:
		.replaceAll(" (<|>) ", "$1")
		;
    }
    public String[] split(String s){
	return s.split(" ");
    }
    public String[] split(StringBuilder s){
	return s.toString().split(" ");
    }
    Preparation(){}
    
}
