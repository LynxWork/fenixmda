package mx.com.damsolutions.mda.util;

public class NamingConvention {

	private static final String SUBFIX_CONTROLLER = "Controller";
	private static String PREFIX_METHOD_ACCESSOR_NAME = "get";
	private static String PREFIX_METHOD_MUTATOR_NAME = "set";
	private static final String SUBFIX_ID = "ID";
	private static final String SUBFIX_PROPERTY_ID = "Id";

	/**
	 * Funcion que devuelve el nombre de la entidad a ser geb¡nerada
	 * **/
	public static String getEntityName(String entityName) {
		String resVal;
		resVal = entityName + "Entity";
		return resVal;
	}

	/**
	 * Funcion que obtiene el nombre de la clase de convencion de nombrado para
	 * controladores
	 * **/
	public static String getClassControllerName(String propertyName) {
		String resVal;
		resVal = propertyName + SUBFIX_CONTROLLER;
		return resVal;
	}

	/**
	 * Funcion que devuelve el nombre de la propiedad a partir de un objeto por
	 * ejemplo User devuelve user
	 * **/
	public static String getPropertyNameByObjectName(String objctName) {
		// Se calcula la primer letra del nombre en minusculas
		String firstlowerCase = objctName.substring(0, 1).toLowerCase();
		String lastPropertyName = objctName.substring(1, 2);
		String propertyName = firstlowerCase + lastPropertyName;
		return propertyName;
	}

	/**
	 * Funcion que devuelve el nombre de la propiedad a partir de una propiedad
	 * por ejemplo UserName devuelve userName
	 * **/
	public static String getPropertyName(String entityName) {
		// Se calcula la primer letra del nombre en minusculas
		String firstlowerCase = entityName.substring(0, 1).toLowerCase();
		String lastPropertyName = entityName.substring(1, entityName.length());
		String propertyNameRes = firstlowerCase + lastPropertyName;
		return propertyNameRes;
	}

	//Devuelve el nombre de la propiedadcon la primer letra en mayusculas
	public static String getPropertyUpperName(String propertyName) {
		// Se obtiene el nombre del setter
		String initSubStr = propertyName.substring(0, 1).toUpperCase();
		String endSubStr = propertyName.substring(1, propertyName.length());
		String setterMethodName = initSubStr + endSubStr;
		return setterMethodName;
	}

	
	
	/**
	 * Funcion que construye el nombre del mutator mediante el nombre de la
	 * propiedad ej: Si la propiedad es name devuelve setName
	 * **/
	public static String getMutatorMethodName(String propertyName) {
		// Se obtiene el nombre del setter
		String initSubStr = propertyName.substring(0, 1).toUpperCase();
		String endSubStr = propertyName.substring(1, propertyName.length());
		String setterMethodName = PREFIX_METHOD_MUTATOR_NAME + initSubStr
				+ endSubStr;
		// log.debug("setterMethodName:"+setterMethodName);
		return setterMethodName;
	}

	/**
	 * Funcion que construye el nombre del accesor mediante el nombre de la
	 * propiedad Si la propiedad es name devuelve nameName
	 * **/
	public static String getAccesorMethodName(String propertyName) {
		// Se obtiene el nombre del setter
		String initSubStr = propertyName.substring(0, 1).toUpperCase();
		String endSubStr = propertyName.substring(1, propertyName.length());
		String setterMethodName = PREFIX_METHOD_ACCESSOR_NAME + initSubStr
				+ endSubStr;
		// log.debug("getterMethodName:"+setterMethodName);
		return setterMethodName;
	}

	/**
	 * Funcion que construye el nombre la ta tabla de base de datos a partir del
	 * nombre de la entidad Si la entidad se llama UserRol la tabla es USER_ROL
	 * **/
	public static String getTableName(String entityName) {
		// Se obtiene el nombre del setter
		String tableName = separateNameByCharacter(entityName, '_');
		return tableName.toUpperCase();
	}

	/**
	 * Funcion que construye el nombre la ta tabla de base de datos a partir del
	 * nombre de la propiedad Si la entidad se llama UserRol la tabla es
	 * USER_ROL
	 * **/
	public static String getColumnName(String propertyName) {
		// Se obtiene el nombre del setter
		String columnName = separateNameByCharacter(propertyName, '_');
		return columnName.toUpperCase();
	}

	/**
	 * Funcion que construye el nombre de la llave primaria a partir del nombre
	 * de la entidad Si la entidad se llama UserRol la tabla es USER_ROL_ID
	 * **/
	public static String getTablePrimaryKeyName(String entityName) {
		// Se obtiene el nombre del setter
		String primaryKeyName = separateNameByCharacter(entityName, '_');
		return (primaryKeyName + "_" + SUBFIX_ID).toUpperCase();
	}

	/**
	 * Funcion que construye el nombre de la llave primaria a partir del nombre
	 * de la entidad Si la entidad se llama UserRol la tabla es USER_ROL_ID
	 * **/
	public static String getPropertyPrimaryKeyName(String entityName) {
		// Se obtiene el nombre del setter
		String primaryKeyName = getPropertyName(entityName);
		return primaryKeyName + SUBFIX_PROPERTY_ID;
	}
	
	/**
	 * Coloca un caracter antes de una mayuscula es utilizado para mapear el
	 * nombre de un bean con el nombre de una columna de base de datos.
	 **/
	public static String separateNameByCharacter(String name, char character) {
		StringBuffer separateName = new StringBuffer();
		char[] aux = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'A',
				'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V',
				'B', 'N', 'M' };
		if ((name != null) && (name.length() > 0)) {
			char[] nameArray = name.toCharArray();
			for (int i = 0; i < nameArray.length; i++) {
				char nameChar = nameArray[i];
				if (i > 0) {
					for (int j = 0; j < aux.length; j++) {
						if (aux[j] == nameChar) {
							// System.out.println("Se agega el separador");
							separateName.append(character);
						}
					}
				}
				separateName.append(String.valueOf(nameChar));
			}
		}
		return separateName.toString();
	}

	/***************************************************************************************************
	 * Convenciones de nombrado para el manejo de JSF
	 ************************************************************************************************ **/

	/**
	 * Funcion que devuelve prefijo core de jsf
	 * **/
	public static String getJsfCorePrefix() {
		return "f:";
	}

	/**
	 * Funcion que devuelve prefijo jsf
	 * **/
	public static String getJsfHtmlPrefix() {
		return "h:";
	}

	/**
	 * Funcion que devuelve prefijo jsf
	 * **/
	public static String getJsfTemplatePrefix() {
		return "ui:";
	}

	/**
	 * Funcion que devuelve prefijo jsf
	 * **/
	public static String getJsfAjaxPrefix() {
		return "a4j:";
	}

	/**
	 * Funcion que devuelve prefijo jsf
	 * **/
	public static String getJsfComponentsPrefix() {
		return "my:";
	}

	/**
	 * Funcion que devuelve prefijo jsf
	 * **/
	public static String getJsfImplPrefix() {
		return "rich:";
	}

}