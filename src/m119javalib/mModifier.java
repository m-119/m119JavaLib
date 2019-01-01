/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m119javalib;


import java.lang.reflect.Method;
/**
 *
 * @author JAG
 */
public class mModifier {
    
    int Modifier = 0;
    
// public
    static final int PUBLIC           = 0x00000001;
// private
    static final int PRIVATE          = 0x00000002;
// protected
    static final int PROTECTED        = 0x00000004;
// static
    static final int STATIC           = 0x00000008;
// final
    static final int FINAL            = 0x00000010;
// synchronized
    static final int SYNCHRONIZED     = 0x00000020;
// volatile
    static final int VOLATILE         = 0x00000040;
// transient
    static final int TRANSIENT        = 0x00000080;
// native
    static final int NATIVE           = 0x00000100;
// interface
    static final int INTERFACE        = 0x00000200;
// abstract
    static final int ABSTRACT         = 0x00000400;
// strictfp
    static final int STRICT           = 0x00000800;
    
// The Java source modifiers that can be applied to a class.
     static final int CLASS_MODIFIERS =
        PUBLIC         | PROTECTED    | PRIVATE |
        ABSTRACT       | STATIC       | FINAL   |
        STRICT;
// The Java source modifiers that can be applied to an interface.
     static final int INTERFACE_MODIFIERS =
        PUBLIC         | PROTECTED    | PRIVATE |
        ABSTRACT       | STATIC       | STRICT;
// The Java source modifiers that can be applied to a constructor.
     static final int CONSTRUCTOR_MODIFIERS =
        PUBLIC         | PROTECTED    | PRIVATE;
// The Java source modifiers that can be applied to a method.
     static final int METHOD_MODIFIERS =
        PUBLIC         | PROTECTED    | PRIVATE |
        ABSTRACT       | STATIC       | FINAL   |
        SYNCHRONIZED   | NATIVE       | STRICT;
// The Java source modifiers that can be applied to a field.
     static final int FIELD_MODIFIERS =
        PUBLIC         | PROTECTED    | PRIVATE |
        STATIC         | FINAL        | TRANSIENT |
        VOLATILE;
// The Java source modifiers that can be applied to a method or constructor parameter.
     static final int PARAMETER_MODIFIERS =
        FINAL;
//
    static final int ACCESS_MODIFIERS =
        PUBLIC | PROTECTED | PRIVATE;

    // прочие
    static final int BRIDGE    = 0x00000040;
    static final int VARARGS   = 0x00000080;
    static final int SYNTHETIC = 0x00001000;
    static final int ANNOTATION  = 0x00002000;
    static final int ENUM      = 0x00004000;
    static final int MANDATED  = 0x00008000;
    
    public boolean set(String s) {
	switch (s) {
	    case "public":
		Modifier = Modifier|PUBLIC;
		break;
		case "private":
		Modifier = Modifier|PRIVATE;
		break;
		case "protected":
		Modifier = Modifier|PROTECTED;
		break;
		case "static":
		Modifier = Modifier|STATIC;
		break;
		case "final":
		Modifier = Modifier|FINAL;
		break;
		case "synchronized":
		Modifier = Modifier|SYNCHRONIZED;
		break;
		case "volatile":
		Modifier = Modifier|VOLATILE;
		break;
		case "transient":
		Modifier = Modifier|TRANSIENT;
		break;
		case "native":
		Modifier = Modifier|NATIVE;
		break;
		case "interface":
		Modifier = Modifier|INTERFACE;
		break;
		case "abstract":
		Modifier = Modifier|ABSTRACT;
		break;
		case "strictfp":
		Modifier = Modifier|STRICT;
		break;
		default:
		    return false;
		
	}
	return true;
    }
    
}
