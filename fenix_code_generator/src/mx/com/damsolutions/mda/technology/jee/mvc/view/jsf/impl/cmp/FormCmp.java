package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.cmp;

import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Component;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InputTextField;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.OutputTextField;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Panel;

public class FormCmp extends Component{
	
	private static final String DEFAULT_COLUMNS = "1";
	Panel[] panel;
	InputTextField[] inputTextField;
	OutputTextField[] outputTextField;

	//Fields
	Entity entity;

	public FormCmp(Entity entity){
		this.entity = entity;
	}

	public void setInputTextField(InputTextField... inputTextField){
		this.inputTextField = inputTextField;
	} 

	public void setOutputTextField(OutputTextField... outputTextField){
		this.outputTextField = outputTextField;
	}

	public void setPanel(Panel... panels){
		this.panel = panels;
	} 

	public String getSourceCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("<h:form>");
		//Se obtiene el codigo de todos los paneles
		for (int i = 0; i < panel.length; i++) {
			sb.append(panel[i].getSourceCode());
		}
		sb.append("</h:form>");
		return sb.toString();
	}

	public String build() {

		StringBuilder sb = new StringBuilder();
		//Header
		sb.append(Util.buildHeaderComponent());
		//Interface
		sb.append("<composite:interface>");
		sb.append("<composite:attribute name=\""+entity.getName()+"\"/>");
		sb.append("</composite:interface>");
		
		//Implementation
		sb.append("<composite:implementation>");
		sb.append("<h:panelGrid columns=\""+DEFAULT_COLUMNS+"\" columnClasses=\"titleCell\">");

		for(Property p:entity.getProperties()){
			InputTextFieldCmp inputText = new InputTextFieldCmp(entity.getName(),p);
			inputText.setStyleClass(styleClass);
			sb.append(inputText.build());
		}

		//End Implementation
		sb.append("</h:panelGrid>");
		sb.append("</composite:implementation>");

		//Footer
		sb.append(Util.buildFooterComponent());
		
		return sb.toString();
	}
	
	
}
