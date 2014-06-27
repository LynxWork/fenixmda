package mx.com.damsolutions.code.generator.java.types;

import mx.com.damsolutions.code.generator.types.IFloat;
import mx.com.damsolutions.fenix.code.generator.classes.impl.JNameSpace;
import mx.com.damsolutions.mda.language.INameSpace;

public class JFloat implements IFloat {

	public java.lang.String getName() {
		return JDataType.FLOAT_NAME;
	}

	public INameSpace getNameSpace() {
		return new JNameSpace(JDataType.FLOAT_NAME_SPACE);
	}

	public String getQualifiedName() {
		StringBuilder sb = new StringBuilder(getNameSpace().getQualifiedName());
		sb.append(getName());
		return sb.toString();
	}

	public String build(){
		return getName();
	}
}
