package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.cmp;

import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InplaceInput;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Message;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.OutputTextField;
import mx.com.damsolutions.mda.util.NamingConvention;

public class InputTextFieldCmp extends InplaceInput{

	public InputTextFieldCmp(String id, String name, String entityName,
			String entityProperty) {
		super(id, name, entityName, entityProperty);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String build() {
		StringBuilder resVal = new StringBuilder(); 
		resVal.append("<"+NamingConvention.getJsfHtmlPrefix()+"panelGrid columns=\"3\"> ");
		//Label
		OutputTextField outputTextField = new OutputTextField();
		outputTextField.setId(id);
		outputTextField.setLabel(label);
		resVal.append( outputTextField.toString() );
		//Input
		InplaceInput inplaceInput = new InplaceInput(defaultLabel, defaultLabel, defaultLabel, defaultLabel);
		inplaceInput.setId(id);
		inplaceInput.setEntityName(entityName);
		inplaceInput.setEntityProperty(entityProperty);
		inplaceInput.setDescription(description);
		inplaceInput.setDefaultLabel(defaultLabel);
		inplaceInput.setMinimum(minimum);
		inplaceInput.setMaximum(maximum);
		inplaceInput.setPattern(pattern);
		inplaceInput.setRequired(required);
		inplaceInput.setStyleClass(styleClass);
		resVal.append( inplaceInput.build() );
		//Message
		Message message = new Message();
		message.setForComponent(inplaceInput.buildNameId());
		resVal.append("</"+NamingConvention.getJsfHtmlPrefix()+"panelGrid> ");
		return resVal.toString();
	}

}
