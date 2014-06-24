package mx.com.damsolutions.code.generator.factory;

import mx.com.damsolutions.code.generator.java.types.*;
import mx.com.damsolutions.code.generator.types.*;
import mx.com.damsolutions.mda.core.generator.Language;

public class DataTypeFactory {

	DataTypeFactory(String language){
		this.language = language; 
	}
	
	private String language;
	
	public ICharacter getCharacter() {
		ICharacter dataType = null;
		if(language.equals(Language.JAVA_LANGUAGE)){
			dataType = new JCharacter();
		}
		return dataType;
	}

	public IDateTime getDate() {
		IDateTime dataType = null;
		if(language.equals(Language.JAVA_LANGUAGE)){
			dataType = new JDateTime();
		}
		return dataType;
	}

	public IDouble getDouble() {
		IDouble dataType = null;
		if(language.equals(Language.JAVA_LANGUAGE)){
			dataType = new JDouble();
		}
		return dataType;
	}

	public IFloat getFloat() {
		IFloat dataType = null;
		if(language.equals(Language.JAVA_LANGUAGE)){
			dataType = new JFloat();
		}
		return dataType;
	}

	public IInteger getInteger() {
		IInteger dataType = null;
		if(language.equals(Language.JAVA_LANGUAGE)){
			dataType = new JInteger();
		}
		return dataType;
	}

	public ILong getLong() {
		ILong dataType = null;
		if(language.equals(Language.JAVA_LANGUAGE)){
			dataType = new JLong();
		}
		return dataType;
	}

	public IString getString() {
		IString dataType = null;
		if(language.equals(Language.JAVA_LANGUAGE)){
			dataType = new JString();
		}
		return dataType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
