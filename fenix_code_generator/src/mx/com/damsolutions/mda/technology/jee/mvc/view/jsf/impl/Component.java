package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

public abstract class Component {

	protected String id;
	protected String name;
	protected String description;
	protected String styleClass;
	protected String disabled;
	protected String rendered;
	protected String binding;
	protected String forComponent;
	protected String entityName;
	protected String entityProperty;
	protected String event;
	protected String render;
	protected String execute;
	protected String address;
	protected String interval;
	protected String enabled;
	
	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	
	public String getForComponent() {
		return forComponent;
	}
	public String buildForComponent() {
		StringBuilder resVal = new StringBuilder("");
		if(getForComponent()!=null && getForComponent().length()>0){
			resVal.append(" for=\""+ getForComponent() +"\" ");
		}
		return resVal.toString();
	}
	public void setForComponent(String forComponent) {
		this.forComponent = forComponent;
	}

	
	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String buildStyleClass() {
		StringBuilder resVal = new StringBuilder(""); 
		if(getStyleClass()!=null && getStyleClass().length()>0){
			resVal.append(" styleClass=\""+ getStyleClass() +"\" ");
		}
		return resVal.toString();
	}

	
	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getRendered() {
		return rendered;
	}

	public void setRendered(String rendered) {
		this.rendered = rendered;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}

	public String getExecute() {
		return execute;
	}

	public void setExecute(String execute) {
		this.execute = execute;
	}

	public String build() {
		StringBuilder resVal = new StringBuilder("");
		if(getForComponent()!=null && getForComponent().length()>0){
			resVal.append(" for=\""+ getForComponent() +"\" ");
		}
		return resVal.toString();
	}

	
	
}
