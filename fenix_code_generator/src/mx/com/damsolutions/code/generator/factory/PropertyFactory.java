package mx.com.damsolutions.code.generator.factory;

import mx.com.damsolutions.code.generator.java.types.JCharacter;
import mx.com.damsolutions.code.generator.types.ICharacter;
import mx.com.damsolutions.fenix.code.generator.classes.impl.Property;
import mx.com.damsolutions.mda.core.generator.Language;
import mx.com.damsolutions.mda.language.IProperty;

public class PropertyFactory {

	private String language;
	private static PropertyFactory propertyFactory;
	
	private PropertyFactory(String language){
		this.language = language;
	}

	public PropertyFactory getInstance(String language){
		if(propertyFactory==null){
			return new PropertyFactory(language);
		}else{
			return propertyFactory;
		}
	}

	
	public IProperty getProperty(){
		IProperty dataType = null;
		if(language.equals(Language.JAVA_LANGUAGE)){
			dataType = new Property();
		}
		return dataType;
	}


}
