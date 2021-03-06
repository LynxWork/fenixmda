package mx.com.damsolutions.mda.metamodel;

import java.util.List;

public class Element {

	private String namespace;
	private String id;
    private String name;
    private String title;
    private String description;
    private List <Association> association;
    
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public List <Association> getAssociation() {
		return association;
	}
	public void setAssociation(List <Association> association) {
		this.association = association;
	}
}
