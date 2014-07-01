package mx.com.damsolutions.mda.technology.jee.definitions;

public class AnotationsDefinitions {

	//JPA Definitions
	public static String PERSISTENCE_ANOTATION_NAMED_QUERY = "@NamedQuery";
	public static String PERSISTENCE_ANOTATION_NAMED_QUERIES = "@NamedQueries";
	public static String PERSISTENCE_ANOTATION_ENTITY = "@Entity";
	public static String PERSISTENCE_ANOTATION_COLUMN = "@Column";
	public static String PERSISTENCE_ANOTATION_TABLE = "@Table";
	public static String PERSISTENCE_ANOTATION_ID="@Id";
	public static String PERSISTENCE_ANOTATION_GENERATED_VALUE="@GeneratedValue";
	
	public static String TRANSACTION_PERSISTANT_CONTAINER="@TransactionManagement(TransactionManagementType.CONTAINER)";
	public static String TRANSACTION_REQUIRED="@TransactionAttribute(TransactionAttributeType.REQUIRED)";
	
}
