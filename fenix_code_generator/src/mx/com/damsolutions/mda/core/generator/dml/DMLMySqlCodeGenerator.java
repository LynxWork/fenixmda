/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.damsolutions.mda.core.generator.dml;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.util.BeanUtil;
import mx.com.damsolutions.util.CharacterUtil;


/**
 *
 * @author Administrator
 */
public class DMLMySqlCodeGenerator {

    private static final String SPACE_VALUE = " ";


    public String getSelectStatementByRange(Entity entity,int initVal, int endVal){
		StringBuilder sb = new StringBuilder();
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("SELECT");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("T.ROW_NUM");
		sb.append(CharacterUtil.SPACE_VALUE);
		List<Property> properties = entity.getProperties();
		sb.append(CharacterUtil.SPACE_VALUE);
		for (Property property : properties) {
			sb.append(",T."+property.getName());
		}
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("FROM");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("(SELECT @ROWNUM:=@ROWNUM+1 ROW_NUM, P.* from "+ entity.getName().toUpperCase() +" P, (SELECT @ROWNUM:=0) R) T");
    	return sb.toString();
    }


    public String getSelectStatement(Object bean){
        StringBuffer sqlStatement = new StringBuffer();
        try {
            String tableName = getStandardTableName(bean);
            Method[] methods = bean.getClass().getMethods();
            String[] propertyNames = BeanUtil.getPropertyNames(methods);
            sqlStatement.append("SELECT");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append(getSqlNames(propertyNames));
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append("FROM");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append(tableName.toUpperCase());
        }catch (IllegalArgumentException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sqlStatement.toString();
    }


    public String getInsertStatement(Object bean){
        StringBuffer sqlStatement = new StringBuffer();
        try {
            String tableName = getStandardTableName(bean);
            Method[] methods = bean.getClass().getMethods();
            String[] propertyNames = BeanUtil.getPropertyNamesWhitValues(bean,methods);
            String[] propertyValues = BeanUtil.getPropertyValuesByAccesors(bean,methods);
            sqlStatement.append("INSERT");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append("INTO");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append(tableName.toUpperCase());
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append("(");
            sqlStatement.append(getSqlNames(propertyNames));
            sqlStatement.append(")");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append("VALUES");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append("(");
            sqlStatement.append(getSqlValues(propertyValues));
            sqlStatement.append(")");
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sqlStatement.toString();
    }


    public String getUpdateStatement(Object bean){
        StringBuffer sqlStatement = new StringBuffer();
        try {
            String tableName = getStandardTableName(bean);
            Method[] methods = bean.getClass().getMethods();
            sqlStatement.append("UPDATE");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append(tableName.toUpperCase());
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append("SET");
            sqlStatement.append(SPACE_VALUE);
            String[] stringNames = BeanUtil.getPropertyNames(methods);
            String[] stringValues = BeanUtil.getPropertyValuesByAccesors(bean, methods);
            for (int i = 0; i < stringValues.length; i++) {
                String name = stringNames[i];
                String value = stringValues[i];
                if( (value!=null) && (!value.equals("")) ){
                    if (i == 0) {
                        sqlStatement.append(getStandardMappedName(name));
                        sqlStatement.append("=");
                        sqlStatement.append("'");
                        sqlStatement.append(value);
                        sqlStatement.append("'");
                    } else {
                        sqlStatement.append(",");
                        sqlStatement.append(getStandardMappedName(name));
                        sqlStatement.append("=");
                        sqlStatement.append("'");
                        sqlStatement.append(value);
                        sqlStatement.append("'");
                    }
                }

            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IllegalArgumentException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sqlStatement.toString();
    }

    public String getDeleteStatement(Object bean){
        StringBuffer sqlStatement = new StringBuffer();
        try {
            String tableName = getStandardTableName(bean);
            sqlStatement.append("DELETE");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append("FROM");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append(tableName.toUpperCase());
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append("WHERE");
            sqlStatement.append(SPACE_VALUE);
            sqlStatement.append(getStandardIdNameFromTable(bean));
            sqlStatement.append("=");
            sqlStatement.append(BeanUtil.getPropertyValuesByAccesor(bean,getStandardIdAccesorName(bean)));
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IllegalArgumentException ex) {
            Logger.getLogger(DMLMySqlCodeGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sqlStatement.toString();
    }

    public String concatArrayStringValues(String[] stringValues){
            StringBuffer stringConcat = new StringBuffer();
            for (int i = 0; i < stringValues.length; i++) {
                String value = stringValues[i];
                value = "'"+value+"'";
                if (i == 0) {
                    stringConcat.append(value.toUpperCase());
                } else {
                    stringConcat.append("," + value.toUpperCase());
                }
            }
            return stringConcat.toString();
    }

    /**
     * Es utilizado para concatenar los nombres de las columnas de una tabla separandolas por comas
     **/
    public String concatArrayValues(String[] stringValues){
            StringBuffer stringConcat = new StringBuffer();
            for (int i = 0; i < stringValues.length; i++) {
                String value = stringValues[i];
                value = getStandardMappedName(value);
                if (i == 0) {
                    stringConcat.append(value.toUpperCase());
                } else {
                    stringConcat.append("," + value.toUpperCase());
                }
            }
            return stringConcat.toString();
    }


    /**
     * Esta funcion devuelve los nombres de las propiedades de un objeto 
     * en un string separados por comas para ser usados en un query
     * **/
    public String getSqlNames(String[] propertyNames){
        return concatArrayValues(propertyNames);
    }


    public String getSqlValues(String[] propertyValues){
        return concatArrayStringValues(propertyValues);
    }

    /**
     * Regresa el nombre de la tabla con la que debe estar mapeado el bean
     **/
    public String getStandardTableName(Object bean){
            String tableName = getNameEntity(bean);
            tableName = separateNameByCharacter(tableName, '_');
            return tableName;
    }

    /**
     * Regresa el nombre de la entidad sin el subfijo Bean
     **/
    public String getNameEntity(Object bean){
            System.out.println("package;"+bean.getClass().getName());
            String[] packageElements = bean.getClass().getName().split("\\.");
            System.out.println("packageElements.length;"+packageElements.length);
            String beanName = packageElements[packageElements.length-1];
            String tableName = beanName.replace("Bean", "");
            return tableName;
    }

    /**
     *Coloca un caracter antes de una mayuscula
     *es utilizado para mapear el nombre de un bean con el nombre de una columna de 
     *base de datos.
     **/
    public String separateNameByCharacter(String name,char character){
        StringBuffer separateName = new StringBuffer();
        char[] aux = {'Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'};
        if( (name!=null) && (name.length()>0)){
            char[] nameArray = name.toCharArray();
            for(int i=0; i<nameArray.length;i++){
                char nameChar = nameArray[i];
                if(i>0){
                    for(int j=0; j<aux.length;j++){
                        if(aux[j]==nameChar){
                            //System.out.println("Se agega el separador");
                            separateName.append(character);
                        }
                    }
                }
                separateName.append(String.valueOf(nameChar));
            }
        }
        return separateName.toString();
    }


    /**
     * Regresa el nombre y campos estandar de la tabla  mapeada por un bean
     **/
    public String getStandardMappedName(String name){
        return separateNameByCharacter(name, '_').toUpperCase();
    }

    /**
     * Regresa el nombre estandar la llave primaria de la tabla mapeada con el
     * bean pasado por argumento
     **/
    public String getStandardIdNameFromTable(Object bean){
            StringBuffer IdName = new StringBuffer();
            String tableName = getStandardTableName(bean);
            IdName.append("ID_");
            IdName.append(tableName.toUpperCase());
        return IdName.toString();
    }

    /**
     * Regresa el nombre estandar del accesor del bean
     * pasado por argumento
     **/
    public String getStandardIdAccesorName(Object bean){
        StringBuffer idAccesorNameMethod = new StringBuffer();
        idAccesorNameMethod.append("getId");
        idAccesorNameMethod.append(getNameEntity(bean));
        return idAccesorNameMethod.toString();
    }

    /**
     * Regresa el nombre estandar de la propiedad usada como llave primaria del bean
     * pasado por argumento
     **/
    public String getStandardIdPropertyName(Object bean){
        return "";
    }

}
