package mx.com.damsolutions.mda.junit.view;

import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.A4jAjax;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.ActionListener;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.ActionParam;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.AjaxListener;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Column;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.CommandButton;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.CommandLink;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InputTextField;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.JsFunction;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Param;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Poll;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Push;



public class RichFacesComponentsTest {

	public static void main(String[] args) {
		
		AjaxListener ajaxListener = new AjaxListener();
		System.out.println("texto: " + ajaxListener.toString());
		
		ActionParam actionParam  = new ActionParam("Usuario","nombre");
		System.out.println("texto: " + actionParam.toString());
		
		
		Column column = new Column();
		System.out.println("texto: " + column.toString());
		
		Param param = new Param("Usuario","nombre");
		param.setValue("John");
		param.setAssignTo("");
		System.out.println("texto: " + param.toString());
		
		Poll poll = new Poll("Usuario","nombre");
	    poll.setInterval("2000");
		poll.setRender("poll,grid");
		System.out.println("texto: " + poll.toString());
		
		Push push = new Push();
		push.setId("pushJms");
		push.setAddress("pushTopicsContext");
		System.out.println("texto: " + push.toString());
		
		
		JsFunction function = new JsFunction();
		function.setName("updateName");
		function.setRender("showname");
		System.out.println("texto: " + function.toString());
		
		ActionListener listener = new ActionListener("Usuario","nombre");
		System.out.println("texto: " + listener.toString());
		
		CommandLink link = new CommandLink();
		link.setEvent("keyup");
		link.setRender("out");
		link.setExecute("@form");
		System.out.println("texto: " + link.toString());
		
		CommandButton button = new CommandButton();
		button.setEvent("keyup");
		button.setRender("out");
		button.setExecute("@form");
		System.out.println("texto: " + button.toString());
		
		
		A4jAjax ajax = new A4jAjax();
		ajax.setEvent("keyup");
		ajax.setRender("out");
		System.out.println("texto: " + ajax.toString());
		
		InputTextField field = new InputTextField("nameId","Nombre","Usuario","nombre");
		field.setDescription("Descripcion del componente");
		field.setLabel("Ingrese su nombre");
		System.out.println("texto: " + field.toString());
	}
		
}
