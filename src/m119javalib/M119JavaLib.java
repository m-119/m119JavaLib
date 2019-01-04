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
public class M119JavaLib {

    /**
     * @param args the command line arguments
     */
    String s = "public class Person{\n    public static List<Class<?>> = \" ва    \";\n    private final String lastName;\n\n    public Person(String firstName, String lastName) {\n        this.firstName = firstName;\n        this.lastName = lastName;\n    }\n	\n	public Person() {\n        this.firstName = firstName;\n        this.lastName = lastName;\n    }\n\n    public String getFirstName() {\n        return firstName;\n    }\n\n    public String getLastName() {\n        return lastName;\n    }\n}\n";
    
    M119JavaLib()
    {
	Reader c = new Reader();
	
	c.prepare(s);
	c.read();
	System.out.println("<<--END-->>");
	//System.out.print(sb.toString());
    }
    
    public static void  main(String[] args) {
	M119JavaLib m = new M119JavaLib();

    }
    
}
