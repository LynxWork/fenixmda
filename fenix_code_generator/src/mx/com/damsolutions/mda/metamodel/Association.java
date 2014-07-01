package mx.com.damsolutions.mda.metamodel;

public class Association extends Element{
	
	public Entity relationSource;
	public Entity relationTarget;
	public String relationType;
	public String sourceCardinality;
	public String targetCardinality;
	
	public Entity getRelationSource() {
		return relationSource;
	}
	public void setRelationSource(Entity relationSource) {
		this.relationSource = relationSource;
	}
	public Entity getRelationTarget() {
		return relationTarget;
	}
	public void setRelationTarget(Entity relationTarget) {
		this.relationTarget = relationTarget;
	}
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

}
