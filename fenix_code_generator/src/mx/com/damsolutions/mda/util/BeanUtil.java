package mx.com.damsolutions.mda.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BeanUtil {
	private static final Log log = LogFactory.getLog(BeanUtil.class);

    private static String PREFIX_METHOD_ACCESSOR_NAME ="get";
    private static String PREFIX_METHOD_MUTATOR_NAME ="set";

    /**
     *Return a property name from a name Method getter
     **/
    public static String getPropertyName(Method getMethod){
            String property = "";
            String propertyName = "";
            String name = getMethod.getName();
            String subName = name.substring(0, 3);
            //System.out.println("subName:"+subName);
            if(!name.equals("getClass")){
                if(subName.equals(PREFIX_METHOD_ACCESSOR_NAME)){
                    property = name.substring(3, name.length());
                    String initSubStr = property.substring(0,1).toLowerCase();
                    String endSubStr = property.substring(1,property.length());
                    propertyName = initSubStr+endSubStr;
                }
            }
        return propertyName.trim();
    }

    public static boolean isAccessor(Method method){
        String name = method.getName();
        //System.out.println("propiedad evaluada:"+name);
        String subName = name.substring(0, 3);
        boolean resval = false;
            if(subName.equals(PREFIX_METHOD_ACCESSOR_NAME)){
                //System.out.println("Nombre del Accessor:"+name);
                if(!name.equals("getClass")){
                    resval = true;
                }
            }else{
                resval = false;
            }
        return resval;
    }

    public static boolean isMutator(Method method){
        String name = method.getName();
        //System.out.println("propiedad evaluada:"+name);
        String subName = name.substring(0, 3);
        boolean resval = false;
            if(subName.equals(PREFIX_METHOD_MUTATOR_NAME)){
                //System.out.println("Nombre del Accessor:"+name);
                if(!name.equals("getClass")){
                    resval = true;
                }
            }else{
                resval = false;
            }
        return resval;
    }

    /**
     *Regresa el valor si las propiedades son publicas
     **/
    public static String[] getPropertyValues(Object bean,String[] propertyNames )
            throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        String[] propertyValues = new String[propertyNames.length];
        String values = "";
        for(int i=0; i<propertyNames.length;i++){
            Field field = bean.getClass().getField(propertyNames[i]);
            values = (String)field.get(values);
            propertyValues[i] = values;
        }
        return propertyValues;
    }

    /**
     * Regresa el valor devuelto por el metodo indicado en methodName
     **/
    public static String getPropertyValuesByAccesor(Object bean,String methodsName) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        String value="";
        Method method = bean.getClass().getMethod(methodsName, new Class[0]);
        String name = method.getName();
        String subName = name.substring(0, 3);
        if(subName.equals(PREFIX_METHOD_ACCESSOR_NAME)){
           if(!name.equals("getClass")){
               Object objValue = method.invoke(bean);
               String resval = getStringValueFromObject(objValue);
               if(resval.equals("")){
                value = (String)method.invoke(bean);
               }else{
                value = resval;
               }
               
            }else{
                value="";
            }
        }
        return value;
    }

    public static String[] getPropertyValuesByAccesors(Object bean,Method[] methods) throws IllegalAccessException, InvocationTargetException{
        String[] propertyArrayTmp = new String[methods.length];
        String value="";
        int k=0;
        for(int i=0; i<methods.length;i++){
            Method method = methods[i];
            String name = method.getName();
            String subName = name.substring(0, 3);
            if(subName.equals(PREFIX_METHOD_ACCESSOR_NAME)){
                //System.out.println("Nombre del Accessor:"+name);
                if(!name.equals("getClass")){
                    value = (String)method.invoke(bean);
                }
            }else{
                value="";
            }
            if(value!=null && !value.equals("") ){
                propertyArrayTmp[k] = value;
                k++;
            }
        }
        String[] propertyArray = new String[k];
        for(int j=0;j<k;j++){
            propertyArray[j] = propertyArrayTmp[j];
        }
        return propertyArray;
    }

    /**
     * Obtiene el valor de un metodo pasado por argumento
     **/
    public static String getPropertyValueByAccesor(Object bean,Method method) throws IllegalAccessException, InvocationTargetException{
        String value="";
            String name = method.getName();
            String subName = name.substring(0, 3);
            if(subName.equals(PREFIX_METHOD_ACCESSOR_NAME)){
                //System.out.println("Nombre del Accessor:"+name);
                if(!name.equals("getClass")){
                    value = (String)method.invoke(bean);
                }
            }else{
                value="";
            }
        return value;
    }


    public static String[] getPropertyNames(Method[] methods){
        String[] propertyArrayTmp = new String[methods.length];
        int k=0;
        for(int i=0; i<methods.length;i++){
            Method method = methods[i];
            String name = getPropertyName(method);
            if(name!=null && !name.equals("") ){
                propertyArrayTmp[k] = name;
                k++;
            }
        }
        String[] propertyArray = new String[k];
        for(int j=0;j<k;j++){
            propertyArray[j] = propertyArrayTmp[j];
        }
        return propertyArray;
    }

    /**
     * Regresa los nombres de las propiedades que pertenecen a un tipo de dato Base
     * como Integer,String,Character,Float,Date
     * **/
    public static String[] getPropertyNamesBaseTypes(Method[] methods){
        String[] propertyArrayTmp = new String[methods.length];
        int k=0;
        for(int i=0; i<methods.length;i++){
            Method method = methods[i];
            String name = getPropertyName(method);
            if(name!=null && !name.equals("") ){
                propertyArrayTmp[k] = name;
                k++;
            }
        }
        String[] propertyArray = new String[k];
        for(int j=0;j<k;j++){
            propertyArray[j] = propertyArrayTmp[j];
        }
        return propertyArray;
    }
    

    public static String[] getPropertyNamesWhitValues(Object bean,Method[] methods){
        String[] propertyArrayTmp = new String[methods.length];
        int k=0;
        String value = "";
        String name = "";
        for(int i=0; i<methods.length;i++){
            Method method = methods[i];
            if(isAccessor(method)){
                try {
                    value = getPropertyValueByAccesor(bean, method);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(BeanUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                if( (value!=null) && (!value.equals("")) ){
                    name = getPropertyName(method);
                    System.out.println("propiedad:"+name);
                    propertyArrayTmp[k] = name;
                    System.out.println("propiedad asignada:"+name);
                    k++;
                }
            }
        }
        String[] propertyArray = new String[k];
        for(int j=0;j<k;j++){
            propertyArray[j] = propertyArrayTmp[j];
        }
        return propertyArray;
    }

    /**
     * Funcion que verifica si un valor pertenece a un objeto wraper y lo devuelve en
     * formato de String.
     *
     **/
    public static String getStringValueFromObject(Object object){
        String resval = "";
        if( object instanceof String ){
            resval = (String)object;
        }else if( object instanceof Integer ){
            Integer valueInteger = (Integer)object;
            resval = valueInteger.toString();
        }else if( object instanceof Float ){
            Float valueFloat = (Float)object;
            resval = valueFloat.toString();
        }else if( object instanceof Long ){
            Long valueLong = (Long)object;
            resval = valueLong.toString();
        }else if( object instanceof Byte ){
            Byte valueByte = (Byte)object;
            resval = valueByte.toString();
        }else if( object instanceof Character ){
            Character valueCharacter = (Character)object;
            resval = valueCharacter.toString();
        }else if( object instanceof Boolean ){
            Boolean valueBoolean = (Boolean)object;
            resval = valueBoolean.toString();
        }else if( object instanceof Date ){
            //Formatter format = new Formatter();
            Date valueDate = (Date)object;
            resval = valueDate.toString();
        }else{
            resval = "";
        }
        return resval;
    }//En of method


    /**
     * Funcion que construye el nombre del setter mediante el nombre
     * de la propiedad
     * **/
    public static String getSetterMethodName(String propertyName){
    	//Se obtiene el nombre del setter
        String initSubStr = propertyName.substring(0,1).toUpperCase();
        String endSubStr = propertyName.substring(1,propertyName.length());
        String setterMethodName = PREFIX_METHOD_MUTATOR_NAME+initSubStr+endSubStr;
        log.debug("setterMethodName:"+setterMethodName);
        return setterMethodName;
    }
    
    /**
     * Funcion que construye el nombre del setter mediante el nombre
     * de la propiedad
     * **/
    public static String getGetterMethodName(String propertyName){
    	//Se obtiene el nombre del setter
        String initSubStr = propertyName.substring(0,1).toUpperCase();
        String endSubStr = propertyName.substring(1,propertyName.length());
        String setterMethodName = PREFIX_METHOD_ACCESSOR_NAME+initSubStr+endSubStr;
        log.debug("getterMethodName:"+setterMethodName);
        return setterMethodName;
    }
    
    public static void asignValueToProperty(Object obj){
    	
    }
}
