package mx.com.damsolutions.mda.metamodel;

public class Association extends Element{
	
	private Entity sourceElement;
	private Entity targetElement;
	private String relationType;
	private String sourceCardinality;
	private String targetCardinality;
	

	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	public String getSourceCardinality() {
		return sourceCardinality;
	}
	public void setSourceCardinality(String sourceCardinality) {
		this.sourceCardinality = sourceCardinality;
	}
	public String getTargetCardinality() {
		return targetCardinality;
	}
	public void setTargetCardinality(String targetCardinality) {
		this.targetCardinality = targetCardinality;
	}
	public Entity getSourceElement() {
		return sourceElement;
	}
	public void setSourceElement(Entity sourceElement) {
		this.sourceElement = sourceElement;
	}
	public Entity getTargetElement() {
		return targetElement;
	}
	public void setTargetElement(Entity targetElement) {
		this.targetElement = targetElement;
	}

}
