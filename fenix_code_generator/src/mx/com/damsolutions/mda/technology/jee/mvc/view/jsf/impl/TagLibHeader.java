package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public class TagLibHeader {

	public String getSourceCode(HashMap<String, String> tagLibProperty){
		StringBuilder sb = new StringBuilder();
		Iterator<String> itKey = tagLibProperty.keySet().iterator();
		while (itKey.hasNext()) {
			String key = itKey.next(); 
			String value = tagLibProperty.get(key);
			sb.append(new TagLib(key,value));
		}
		return sb.toString();
	}

}
