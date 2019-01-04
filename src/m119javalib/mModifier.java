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
public class mModifier {
    
    private int mod = 0;
    
// public
    private static final int PUBLIC           = 0x00000001;
// private
    private static final int PRIVATE          = 0x00000002;
// protected
    private static final int PROTECTED        = 0x00000004;
// static
    private static final int STATIC           = 0x00000008;
// final
    private static final int FINAL            = 0x00000010;
// synchronized
    private static final int SYNCHRONIZED     = 0x00000020;
// volatile
    private static final int VOLATILE         = 0x00000040;
// transient
    private static final int TRANSIENT        = 0x00000080;
// native
    private static final int NATIVE           = 0x00000100;
// interface
    private static final int INTERFACE        = 0x00000200;
// abstract
    private static final int ABSTRACT         = 0x00000400;
// strictfp
    private static final int STRICT           = 0x00000800;

    // прочие
    private static final int BRIDGE    = 0x00000040;
    private static final int VARARGS   = 0x00000080;
    private static final int SYNTHETIC = 0x00001000;
    private static final int ANNOTATION  = 0x00002000;
    private static final int ENUM      = 0x00004000;
    private static final int MANDATED  = 0x00008000;
    
    public boolean set(String s) {
	switch (s) {
	    case "public":
		mod = mod|PUBLIC;
		break;
		case "private":
		mod = mod|PRIVATE;
		break;
		case "protected":
		mod = mod|PROTECTED;
		break;
		case "static":
		mod = mod|STATIC;
		break;
		case "final":
		mod = mod|FINAL;
		break;
		case "synchronized":
		mod = mod|SYNCHRONIZED;
		break;
		case "volatile":
		mod = mod|VOLATILE;
		break;
		case "transient":
		mod = mod|TRANSIENT;
		break;
		case "native":
		mod = mod|NATIVE;
		break;
		case "interface":
		mod = mod|INTERFACE;
		break;
		case "abstract":
		mod = mod|ABSTRACT;
		break;
		case "strictfp":
		mod = mod|STRICT;
		break;
		default:
		return false;
		
	}
	return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if ((mod & PUBLIC) != 0)        sb.append("public ");
        if ((mod & PROTECTED) != 0)     sb.append("protected ");
        if ((mod & PRIVATE) != 0)       sb.append("private ");

        /* Canonical order */
        if ((mod & ABSTRACT) != 0)      sb.append("abstract ");
        if ((mod & STATIC) != 0)        sb.append("static ");
        if ((mod & FINAL) != 0)         sb.append("final ");
        if ((mod & TRANSIENT) != 0)     sb.append("transient ");
        if ((mod & VOLATILE) != 0)      sb.append("volatile ");
        if ((mod & SYNCHRONIZED) != 0)  sb.append("synchronized ");
        if ((mod & NATIVE) != 0)        sb.append("native ");
        if ((mod & STRICT) != 0)        sb.append("strictfp ");
        if ((mod & INTERFACE) != 0)     sb.append("interface ");

        if (sb.length() > 0)    /* trim trailing space */
            return sb.toString().substring(0, sb.length()-1);
        return "";
    }
    
    public boolean is(spec e)
    {
	switch (e){
	case PUBLIC:	if((PUBLIC&mod)==PUBLIC) return true;
	case PRIVATE:	if((PRIVATE&mod)==PRIVATE) return true;
	case PROTECTED:	if((PROTECTED&mod)==PROTECTED) return true;
	case STATIC:	if((STATIC&mod)==STATIC) return true;
	case FINAL:	if((FINAL&mod)==FINAL) return true;
	case SYNCHRONIZED:	if((SYNCHRONIZED&mod)==SYNCHRONIZED) return true;
	case VOLATILE:	if((VOLATILE&mod)==VOLATILE) return true;
	case TRANSIENT:	if((TRANSIENT&mod)==TRANSIENT) return true;
	case NATIVE:	if((NATIVE&mod)==NATIVE) return true;
	case INTERFACE:	if((INTERFACE&mod)==INTERFACE) return true;
	case ABSTRACT:	if((ABSTRACT&mod)==ABSTRACT) return true;
	case STRICT:	if((STRICT&mod)==STRICT) return true;
	default:  return false;
	}
	
    }
    
}
