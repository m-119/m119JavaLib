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
public class Training {
    
    void run(StringBuilder s){
	s = new StringBuilder(s.toString().replaceAll("(\\p{Punct})", " $1 ") 
	    .replaceAll("(?m)(^[ \\t\\x0B\\f]*|[ \\t\\x0B\\f]*$)", " ") 
	    .replaceAll("[ \\t\\x0B\\f]+", " ") 
	    .replaceAll("([^\\n]) (\\{|})", "$1 \n $2") 
	    .replaceAll("(\\{|}) ([^\\n])", "$1 \n $2") 
	    .replaceAll("( \\n)+", " \n"));
    }
    
    void run(String s){
	s = s.toString().replaceAll("(\\p{Punct})", " $1 ") 
	    .replaceAll("(?m)(^[ \\t\\x0B\\f]*|[ \\t\\x0B\\f]*$)", " ") 
	    .replaceAll("[ \\t\\x0B\\f]+", " ") 
	    .replaceAll("([^\\n]) (\\{|})", "$1 \n $2") 
	    .replaceAll("(\\{|}) ([^\\n])", "$1 \n $2") 
	    .replaceAll("( \\n)+", " \n");
    }
    
    Training(){}
    
}
