package mx.com.damsolutions.code.generator.java.types;

import mx.com.damsolutions.code.generator.types.IDouble;
import mx.com.damsolutions.fenix.code.generator.classes.impl.JNameSpace;
import mx.com.damsolutions.mda.language.INameSpace;

public class JDouble implements IDouble {

	public java.lang.String getName() {
		return JDataType.DOUBLE_NAME;
	}

	public INameSpace getNameSpace() {
		return new JNameSpace(JDataType.DOUBLE_NAME_SPACE);
	}

	public String getQualifiedName() {
		StringBuilder sb = new StringBuilder(getNameSpace().getQualifiedName());
		sb.append(getName());
		return sb.toString();
	}

	public String toString(){
		return getName();
	}
}
