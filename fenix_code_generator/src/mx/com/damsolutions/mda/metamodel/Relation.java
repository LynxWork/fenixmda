package mx.com.damsolutions.mda.metamodel;

public class Relation extends Entity{
	
	public Entity relationSource;
	public Entity relationTarget;
	public String relationType;
	public String sourceCardinality;
	public String targetCardinality;

}
