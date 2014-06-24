package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

public abstract class TextField extends Text {
	
	
	protected String entityName;
	protected String entityProperty;
	protected String render;
	protected String label;
	protected String minimum;
	protected String maximum;


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getMinimum() {
		return minimum;
	}

	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}

	public String getMaximum() {
		return maximum;
	}

	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityProperty() {
		return entityProperty;
	}

	public void setEntityProperty(String entityProperty) {
		this.entityProperty = entityProperty;
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}
}
