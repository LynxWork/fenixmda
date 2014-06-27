package mx.com.damsolutions.code.generator.java.types;

import mx.com.damsolutions.code.generator.java.types.JDataType;
import mx.com.damsolutions.code.generator.types.ICharacter;
import mx.com.damsolutions.fenix.code.generator.classes.impl.JNameSpace;
import mx.com.damsolutions.mda.language.INameSpace;



public class JCharacter implements ICharacter{

	public java.lang.String getName() {
		return JDataType.CHARACTER_NAME;
	}

	public INameSpace getNameSpace() {
		return new JNameSpace(JDataType.CHARACTER_NAME_SPACE);
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
