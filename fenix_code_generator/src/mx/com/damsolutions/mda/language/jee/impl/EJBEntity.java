package mx.com.damsolutions.mda.language.jee.impl;

public class EJBEntity extends JClass {

	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		/****************************************************************************************************
		 * CONSTRUCCION DE LAS IMPORTACIONES DE CLASES DE LA ENTIDAD
		 * **************************************************************************************************/
		sb.append(
				"import java.io.Serializable;" +
				"import java.util.List;" +
				"import javax.persistence.Column;" +
				"import javax.persistence.Entity;" +
				"import javax.persistence.GeneratedValue;" +
				"import javax.persistence.GenerationType;" +
				"import javax.persistence.Id;" +
				"import javax.persistence.NamedQueries;" +
				"import javax.persistence.NamedQuery;" +
				"import javax.persistence.OneToMany;" +
				"import javax.persistence.SequenceGenerator;" +
				"import javax.persistence.Table;");
		/****************************************************************************************************/
		
		
		/****************************************************************************************************
		 * CONSTRUCCION DE LAS META ANOTACIONES DEL EJB
		 * **************************************************************************************************/
		sb.append(" @Entity " +
				  " @NamedQueries({ " +
				  " @NamedQuery(name = \"CatError.findAll\", query = \"select o from CatError o\")})" +
				  " @Table(name = \"WFM_CAT_ERROR\")" +
				  " @SequenceGenerator(name = \"ERROR_ID_SEQ_GEN\", sequenceName = \"SEQ_WFM_CAT_ERROR\",allocationSize=1)");
		/****************************************************************************************************/

		/****************************************************************************************************
		 * CONSTRUCCION DE la clase
		 * **************************************************************************************************/
		sb.append(" public class "+getName()+" implements Serializable { ");

		/****************************************************************************************************
		 * CONSTRUCCION DE LAS POPIEDADES DE LA CLASE
		 * **************************************************************************************************/
		
		/****************************************************************************************************/

		/****************************************************************************************************
		 * CONSTRUCCION DE LOS ACCESORS DE LA CLASE
		 * **************************************************************************************************/
		
		/****************************************************************************************************/

		/****************************************************************************************************
		 * CONSTRUCCION DE LOS MUTATORS DE LA CLASE
		 * **************************************************************************************************/
		
		/****************************************************************************************************/
		
		
		sb.append(" } ");
		
		/****************************************************************************************************/


		return sb.toString();
	}
	
}
