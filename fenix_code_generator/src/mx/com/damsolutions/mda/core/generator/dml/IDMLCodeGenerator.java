package mx.com.damsolutions.mda.core.generator.dml;

public interface IDMLCodeGenerator {

	public String getSelectStatementByRange(String entityName,
			String entityPropertyName);

	public String getSelectStatementByProperty(String entityName,
			String entityPropertyName);

	public String getSelectStatementFindAll(String entityName);


}
