package mx.com.damsolutions.mda.junit.view;

import org.apache.log4j.Logger;

import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InputTextField;


public class InputTextFieldTest {

	private static Logger log = Logger.getLogger(InputTextFieldTest.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputTextField itf = new InputTextField("nameId","Nombre","Usuario","nombre");

	}

}
