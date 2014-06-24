package mx.com.damsolutions.code.generator.java.project.web;

import java.util.List;

import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.util.NamingConvention;

public class JSFCodeGenerator {


	/**
	 *  <af:inputText 
	 *  label="ACCION CORRECTIVA " 
	 *  value="#{CatErrorController.accionCorrectiva}" 
	 *  id="it15" 
	 *  maximumLength="500"/> 
	 * ***/
	public String buildInputTextField(Property property){
		//propiedad=\"" + string + "\" "
		StringBuilder resVal = new StringBuilder(); 
		resVal.append("<rich:inputText ");
		resVal.append("id=\"" + property.getId() + "\" ");
		resVal.append("label=\"" + property.getTitle() + "\" ");
		resVal.append("value=\"#{" + NamingConvention.getClassControllerName(property.getEntity().getName()) +"."+property.getName()+"\"} ");
		resVal.append("maximumLength=\"" + property.getLenght() + "\" ");
		resVal.append("shortDesc=\"" + property.getDescription() + "\" ");
		resVal.append(">");
		return resVal.toString();
	}


	/**
	 * Desarrollo de un formulario a partir de una entidad
	 *  
	 * ***/
	public String buildForm(Entity entity){
		StringBuilder resVal = new StringBuilder();
		

		resVal.append("<f:view>");
		resVal.append("<af:document id=\"d1\" title=\""+entity.getTitle()+"\">");
		resVal.append("<af:form id=\"f"+entity.getId()+"\">");
		
		/****************************************************************************************************
		 * INICIA LA CONSTRUCCIÓN DEL FORMULARIO DE BUSQUEDA
		 * ESTE FORMULARIO UTILIZA LAS PROPIEDADES MARCADAS COMO isFinding=true PARA CONSTRUIR EL FORMULARIO 
		 * **************************************************************************************************/
		resVal.append("<af:panelFormLayout id=\"pfl"+entity.getId()+"\" rows=\"1\" maxColumns=\"2\">");
		resVal.append("<af:toolbar id=\"tl"+entity.getId()+"\">");
		resVal.append(buildFindButton(entity));
		resVal.append("</af:toolbar>");
		resVal.append("</af:panelFormLayout>");
		/****************************************************************************************************
		 *****************************************************************************************************/
		
		resVal.append("<af:spacer width=\"10\" height=\"20\" id=\"s"+entity.getId()+"\"/>");
		
		/****************************************************************************************************
		 * INICIA LA CONSTRUCCIÓN DE LA TABLA Y SE TOMAN EN CUENTA LOS CAMPOS MARCADOS CON LA PROPIEDAD 
		 * isVisible="true" 
		 * **************************************************************************************************/
		resVal.append("<af:panelFormLayout id=\"pfl2\">");
		resVal.append(buildOutputLabel(entity.getTitle(), "c"+entity.getId()));
		resVal.append(buildTable(entity));
		resVal.append("<af:spacer width=\"10\" height=\"10\" id=\"s40\"/>");
		resVal.append("</af:panelFormLayout");
		//****************************************************************************************
		
		resVal.append("</af:form>");
		resVal.append("</f:view>");
		
		return resVal.toString();
	}


	/**
	 * Desarrollo de un formulario a aprtir de una entidad
	 *  
	 * ***/
	public String buildTable(Entity entity){
		StringBuilder resVal = new StringBuilder();
		List<Property> propertyList = entity.getProperties();
		
		//Se construye la cabecera de la tabla*************************************************************
		resVal.append("<af:table ");
		resVal.append("var=\"row\" ");
		resVal.append("rowBandingInterval=\"0\" ");
		resVal.append("id=\""+ "tbl" + entity.getName() + "\" ");
		resVal.append("partialTriggers=\"::btnSearch ::btnInsert ::btnUpdate ::btnLogicDelete\" ");
		resVal.append("inlineStyle=\"width:800px; height:300px;\"");
		resVal.append("rowSelection=\"multiple\"");
		resVal.append("binding=\"#{"+ NamingConvention.getClassControllerName(entity.getName()) + "." +NamingConvention.getPropertyNameByObjectName(entity.getName())+ "Table}\"");
		resVal.append("selectionListener=\"#{" + NamingConvention.getClassControllerName(entity.getName()) + ".rowSelected}\"");
		resVal.append("value=\"#{" + NamingConvention.getClassControllerName(entity.getName()) +  "." +NamingConvention.getPropertyNameByObjectName(entity.getName()) + "List}\"");
		resVal.append("columnSelection=\"single\" ");
		resVal.append("contentDelivery=\"immediate\">");
		//**************************************************************************************************
		
		for(Property p:propertyList){
			resVal.append("<af:column ");
			resVal.append("id=\""+"c"+p.getId()+"\" ");
			resVal.append("sortable=\""+p.isSortable()+"\" ");
			resVal.append("headerText=\""+p.getTitle()+"\" ");
			resVal.append("width=\""+p.getWidth()+"\" ");
			resVal.append("sortable=\"\" ");
			resVal.append("sortable=\"\" ");
			resVal.append("/> ");
			resVal.append(buildOutputLabel(p));
			resVal.append("</af:column>");
		}
		resVal.append("</af:table>");
		return resVal.toString();
	}

	public String buildFindButton(Entity entity){
		StringBuilder resVal = new StringBuilder();
		resVal.append(buildToolbarButton("Buscar"+entity.getTitle(),
				entity.getId().toString(),
				entity.getName()+".find"+entity.getName()+"List"));
		return resVal.toString();
	}
	

	public String buildToolbarButton(String text, String id, String action){
		StringBuilder resVal = new StringBuilder();
		resVal.append("<af:commandToolbarButton ");
		resVal.append("text=\""+text+"\" ");
		resVal.append("id=\""+id+"\" ");
		resVal.append("action=\"#{"+action+"\" />");
		return resVal.toString();		
	}


	public String buildOutputLabel(Property property){
		String value = "#{"+ NamingConvention.getClassControllerName(property.getEntity().getName()) + "." +NamingConvention.getPropertyName((property.getName()));
		return buildOutputLabel(value, "out"+property.getId());
	}
	
	public String buildOutputLabel(String text, String id){
		StringBuilder resVal = new StringBuilder();
		resVal.append("<af:outputLabel ");
		resVal.append("value=\""+ text +"\" ");
		resVal.append("id=\""+ text +"\" />");
		return resVal.toString();
	}


	public String buildFormPopup(Entity entity){
		StringBuilder resVal = new StringBuilder();
		String id = entity.getId().toString();
		String contentDelivery = "lazyUncached";
		String binding = "#{"+ NamingConvention.getClassControllerName(entity.getName()) + ".popupInsert" + entity.getName() ;
		String childCreation = "deferred";
		String popupFetchListener = "#{"+ NamingConvention.getClassControllerName(entity.getName()) + ".popupInsert" + entity.getName() + "FetchListener";
		resVal.append(buildFormPopup(id, contentDelivery, binding, childCreation, popupFetchListener));
		return resVal.toString();
	}


	public String buildFormPopup(String id, String contentDelivery, String binding, String childCreation, String popupFetchListener){
		StringBuilder resVal = new StringBuilder();
		resVal.append("<af:popup id=\""+id+"\" ");
		resVal.append("contentDelivery=\""+contentDelivery+"\"  ");
		resVal.append("binding=\""+binding+"\" ");
		resVal.append("childCreation=\""+childCreation+"\" ");
		resVal.append("popupFetchListener=\""+popupFetchListener+"\"> ");
		resVal.append("</af:popup>  ");
		
		/****************************************************************************************************
		 * DIALOG DEL POPUP
		 * **************************************************************************************************/		
		resVal.append("<af:dialog id=\"dc3\" ");
		resVal.append("id=\"dc3\" ");
		resVal.append("title=\"Alta de Tipo de Mensaje\" ");
		resVal.append("dialogListener=\"#{CatMensajeController.persistCatMensajeDialogEvent}\" ");
        /****************************************************************************************************/
        
		/****************************************************************************************************
		 * CONSTRUCCIÓN DEL FORMULARIO DE INSERCIÓN DE REGISTROS
		 * **************************************************************************************************/
		resVal.append("popupFetchListener=\""+popupFetchListener+"\"> ");
		/****************************************************************************************************/		
		
		resVal.append("</af:popup>  ");
		return resVal.toString();
	}

}
