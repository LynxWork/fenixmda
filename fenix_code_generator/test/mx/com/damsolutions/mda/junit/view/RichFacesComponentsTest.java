package mx.com.damsolutions.mda.junit.view;

import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InputTextField;


public class RichFacesComponentsTest {

	public static void main(String[] args) {
		InputTextField field = new InputTextField("nameId","Nombre","Usuario","nombre");
		field.setDescription("Descripcion dek componente");
		field.setLabel("Ingrese su nombre");
		System.out.println("texto: " + field.toString());
	}


}
