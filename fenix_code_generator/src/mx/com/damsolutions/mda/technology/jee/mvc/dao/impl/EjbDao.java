package mx.com.damsolutions.mda.technology.jee.mvc.dao.impl;

import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.technology.jee.definitions.AnotationsDefinitions;
import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.mda.util.MapDataTypes;

public class EjbDao extends Entity{

	
	public EjbDao(Entity entity){
		this.setNamespace(entity.getNamespace());
		this.setName(entity.getName());
		this.setType(entity.getType());
		this.setId(entity.getId());
		this.setDescription(entity.getDescription());
		this.setProperties(entity.getProperties());
		this.setEntitySup(entity.getEntitySup());
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		/****************************************************************************************************
		 * PAQUETE DE LA CLASE
		 * **************************************************************************************************/
		sb.append("package " + getNamespace().toLowerCase()+ ";");
		/****************************************************************************************************
		 * CONSTRUCCION DE LAS IMPORTACIONES DE CLASES
		 * **************************************************************************************************/
		sb.append("import javax.ejb.Stateless;");
		sb.append("import javax.enterprise.event.Event;");
		sb.append("import javax.inject.Inject;");
		sb.append("import javax.persistence.EntityManager;");
		sb.append("import javax.ejb.*;");
		sb.append("import java.util.logging.Logger;");
		
		//Import entity
		/****************************************************************************************************/
		//Class name
		sb.append(getStatelessAnotation());
		sb.append(AnotationsDefinitions.TRANSACTION_PERSISTANT_CONTAINER);
		sb.append(" public class "+getName()+ "Dao" +" { ");
		//Log events
		sb.append(getInjectAnotation());
		sb.append( "private Logger log;" );
		//Entity Manager
		sb.append(getInjectAnotation());
		sb.append( "private EntityManager em;" );
		//Event Handler
		sb.append(getInjectAnotation());
		sb.append( " private Event<"+getName()+"> "+NamingConvention.getPropertyName(getName())+"EventSrc;" );
		//Create Find All Methos*****************************************************
		sb.append( buildMethodFindById() );
		sb.append( buildMethodListFindByProperty() );
		sb.append( buildMethodFindAll() );
		sb.append( buildMethodFindByFilter() );
		//Create Save Methos*****************************************************
		sb.append( buildMethodSave() );
		//Create Update Methos*****************************************************
		sb.append( "}" );
		return sb.toString();
	}
	
	
	private String buildMethodFindByFilter() {
		StringBuilder sb = new StringBuilder();
		sb.append( AnotationsDefinitions.TRANSACTION_REQUIRED );
		
		return sb.toString();
	}


	private String buildMethodFindById(){
		StringBuilder sb = new StringBuilder();
		sb.append( AnotationsDefinitions.TRANSACTION_REQUIRED );
		sb.append( " public "+getName()+" findById(Long "+ NamingConvention.getPropertyPrimaryKeyName(getName()) +" ) {" );
			sb.append( " log.info(\"FindById\"+ " + NamingConvention.getPropertyPrimaryKeyName(getName()) + " );" );
			sb.append( " "+NamingConvention.getPropertyName(getName())+"EventSrc.fire("+NamingConvention.getPropertyPrimaryKeyName(getName())+");");
			sb.append( " return em.find("+ getName() +".class, " + NamingConvention.getPropertyPrimaryKeyName(getName()) + "); ");
		sb.append( "}");	
		return sb.toString();
	}

	private String buildMethodFindByProperty(Property property){
		StringBuilder sb = new StringBuilder();
		String propertyValueName = NamingConvention.getPropertyUpperName(getName())+"Value";
		String propertyName = NamingConvention.getPropertyUpperName(getName());
		String dataTypeName = MapDataTypes.getJavaDataType(property.getDataType());
		String methodName = "findBy"+ NamingConvention.getPropertyUpperName(property.getName());
		String returnValueName = getName();
		sb.append( AnotationsDefinitions.TRANSACTION_REQUIRED );
		sb.append( "public " + returnValueName + " "+ methodName + "("+ dataTypeName + " " + propertyValueName +" ) {" );
			sb.append( " log.info(\"FindByProperty\"+" + propertyValueName + " );" );
			sb.append( " CriteriaBuilder cb = em.getCriteriaBuilder(); ");
			sb.append( " CriteriaQuery<"+returnValueName+"> criteria = cb.createQuery("+returnValueName+".class); ");
			sb.append( " Root<"+returnValueName+"> "+NamingConvention.getPropertyName(getName())+" = criteria.from("+returnValueName+".class); ");
			sb.append( " criteria.select("+NamingConvention.getPropertyName(getName())+").where(cb.equal("+NamingConvention.getPropertyName(getName())+".get(\""+ propertyName +"\"), "+propertyValueName+")); ");
			sb.append( " "+NamingConvention.getPropertyName(getName())+"EventSrc.fire("+ getName()+"."+ NamingConvention.getAccesorMethodName(property.getName())  +");");
			sb.append( " em.createQuery(criteria).getSingleResult() ");
		sb.append( "}");
		return sb.toString();
	}
	
	
	private String buildMethodFindAll(){
		StringBuilder sb = new StringBuilder();
		String propertyName = NamingConvention.getPropertyUpperName(getName());
		String methodName = "findAll";
		String returnValueName = getName();
		sb.append( AnotationsDefinitions.TRANSACTION_REQUIRED );
		sb.append( "public " + returnValueName + " "+ methodName + "( ) {" );
			sb.append( " log.info(\"FindByProperty\" + " + propertyName + " );" );
			sb.append( " CriteriaBuilder cb = em.getCriteriaBuilder(); ");
			sb.append( " CriteriaQuery<"+returnValueName+"> criteria = cb.createQuery("+returnValueName+".class); ");
			sb.append( " Root<"+returnValueName+"> " + NamingConvention.getPropertyName(getName()) + " = criteria.from("+returnValueName+".class); ");
			sb.append( " criteria.select("+NamingConvention.getPropertyName(getName())+").orderBy(cb.asc(" + NamingConvention.getPropertyName(getName())+".get(" + propertyName + ") ) ); ");
			sb.append( " em.createQuery(criteria).getResultList() ");
		sb.append( "}");
		return sb.toString();
	}
	
	
	private String buildMethodListFindByProperty(){
		StringBuilder sb = new StringBuilder();
		for(Property property: getProperties()){
			sb.append( buildMethodFindByProperty(property) );
		}
		return sb.toString();
	}

	private String buildMethodSave(){
		StringBuilder sb = new StringBuilder();
		String objectName = NamingConvention.getPropertyUpperName(getName());
		String className = getName();
		sb.append( AnotationsDefinitions.TRANSACTION_REQUIRED );
		sb.append( "public void save(" + className + " " + objectName +" ) throws Exception {" );
			sb.append( "log.info(\"Registering\" + "+ className +");");
			sb.append( "em.persist(" + objectName + ");");
		sb.append( "}");
		return sb.toString();
	}

	protected String getStatelessAnotation(){
		return "@Stateless";
	}
	
	protected String getInjectAnotation(){
		return "@Inject";
	}
	
	
		
	
	
	
}
