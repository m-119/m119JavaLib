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
    String s = "public class Person implements Serializable {\n    private final String firstName;\n    private final String lastName;\n\n    public Person(String firstName, String lastName) {\n        this.firstName = firstName;\n        this.lastName = lastName;\n    }\n\n    public String getFirstName() {\n        return firstName;\n    }\n\n    public String getLastName() {\n        return lastName;\n    }\n\n    public Person withFirstName(String firstName) {\n        return new Person(firstName, lastName);\n    }\n\n    public Person withLastName(String lastName) {\n        return new Person(firstName, lastName);\n    }\n\n    public boolean equals(Object o) {\n        if (this == o) {\n            return true;\n        }\n        if (o == null || getClass() != o.getClass()) {\n            return false;\n        }\n        Person person = (Person) o;\n        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) {\n            return false;\n        }\n        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) {\n            return false;\n        }\n        return true;\n    }\n\n    public int hashCode() {\n        int result = firstName != null ? firstName.hashCode() : 0;\n        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);\n        return result;\n    }\n\n    public String toString() {\n        return \"Person(\" + firstName + \",\" + lastName + \")\";\n    }\n}";
    
    M119JavaLib()
    {
	Reader r = new Reader();
	Writer w = new Writer();
	r.prepare(s);
	r.read();
	w.write(s);
	System.out.println("<<--END-->>");
	//System.out.print(s);
    }
    
    public static void  main(String[] args) {
	M119JavaLib m = new M119JavaLib();

    }
    
}
