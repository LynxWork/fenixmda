package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class Column extends Component {

	private Component[] components;

	public Column(Component... components){
		this.components = components;
	}
	
	
	/**
	 * Build a Rich Faces 4.3 column element
	 * Generate a code of this element
	 * <rich:column>
                <f:facet name="header">Price</f:facet>
                <h:outputText value="#{car.price}" />
       </rich:column>
	 * **/
	public String build() {
		StringBuilder sb = new StringBuilder();
		sb.append("<"+NamingConvention.getJsfAjaxPrefix()+"column >");
		if(getComponents()!=null && getComponents().length>0){
			for(Component component: getComponents() ){
				if(component instanceof OutputTextField){
					OutputTextField outputTextField = (OutputTextField) component;
					sb.append(outputTextField.toString());
				}
				//Validate more valid components inner this component
			}
		}
		sb.append("</"+NamingConvention.getJsfAjaxPrefix()+"column >");
		return sb.toString();
	}

	public Component[] getComponents() {
		return components;
	}

	public void setComponents(Component[] components) {
		this.components = components;
	}

}
