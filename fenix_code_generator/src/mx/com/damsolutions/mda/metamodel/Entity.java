package mx.com.damsolutions.mda.metamodel;

import java.util.List;

public class Entity extends Element{

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -3064261135434062462L;
	
	private String type;
    private Entity entitySup;
    private List<Property> properties;
    
	public Entity getEntitySup() {
		return entitySup;
	}

	public void setEntitySup(Entity entitySup) {
		this.entitySup = entitySup;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



}
