package mx.com.damsolutions.mda.junit.view;



import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.A4jAjax;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.ActionListener;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.ActionParam;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.AjaxListener;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Column;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.CommandButton;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.CommandLink;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.HtmlCommandLink;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InplaceInput;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InputTextField;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.JsFunction;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Param;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Poll;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Push;



public class RichFacesComponentsTest {

	public static void main(String[] args) {
		
//		HtmlCommandLink htmlCommandLink = new HtmlCommandLink("Usuario","nombre");
//		htmlCommandLink.setAction("action");
//		htmlCommandLink.setValue("link");
//		System.out.println("texto:" + htmlCommandLink.build());
		
		
//		AjaxListener ajaxListener = new AjaxListener();
//		System.out.println("texto: " + ajaxListener.build());
		
//		Column column = new Column();
//		System.out.println("texto: " + column.build());
		
//		Param param = new Param("Usuario","nombre");
//		param.setValue("John");
//		param.setAssignTo("");
//		System.out.println("texto: " + param.build());
		
//		Poll poll = new Poll("Usuario","nombre");
//	    poll.setInterval("2000");
//		poll.setRender("poll,grid");
//		System.out.println("texto: " + poll.build());
		
//		Push push = new Push();
//		push.setId("pushJms");
//		push.setAddress("pushTopicsContext");
//		System.out.println("texto: " + push.build());
		
		
		
		ActionListener listener = new ActionListener("Usuario","nombre");
	    System.out.println("texto: " + listener.build());
		
//		A4jAjax ajax = new A4jAjax();
//		ajax.setEvent("keyup");
//		ajax.setRender("out");
//		System.out.println("texto: " + ajax.build());
		
//		InputTextField field = new InputTextField("nameId","Nombre","Usuario","nombre");
//		field.setDescription("Descripcion del componente");
//		field.setLabel("Ingrese su nombre");
//		System.out.println("texto: " + field.build());
		
/*		JsFunction function = new JsFunction("Usuario","nombre");
		function.setName("updateName");
		function.setAjaxSingle(Boolean.FALSE);
		function.setBypassUpdates(Boolean.TRUE);
		function.setEventsQueue("eventsQueue");
		function.setIgnoreDupResponses(Boolean.TRUE);
		function.setImmediate(Boolean.TRUE);
		function.setLimitToList(Boolean.TRUE);
		function.setOnbeforedomupdate("onbeforedomupdate");
		
		System.out.println("texto: " + function.build()); */
		
		InplaceInput inplaceInput = new InplaceInput("id", "name", "Usuario","nombre");
		System.out.println("texto: " + inplaceInput.build()); 
		
		
		CommandButton button = new CommandButton("id", "name","Usuario","Nombre");
	    button.setAccesskey("accesskey");
	    button.setAction("action");
	    button.setAjaxSingle(Boolean.FALSE);
	    button.setAlt("alt");
	    button.setBypassUpdates(Boolean.TRUE);
	    button.setData("data");
	    button.setDir("dir");
	    button.setDisabled(Boolean.TRUE);
	    button.setEventsQueue("eventsQueue");
	    button.setFocus("focus");
	    button.setIgnoreDupResponses(Boolean.TRUE);
	    button.setImage("image");
	    button.setImmediate(Boolean.TRUE);
	    button.setLang("lang");
	    button.setLimitToList(Boolean.TRUE);
	    button.setOnbeforedomupdate("onbeforedomupdate");
	    button.setOnblur("onblur");
	    button.setOnchange("onchange");
	    button.setOnclick("onclick");
        button.setOncomplete("oncomplete");
        button.setOndblclick("ondblclick");
        button.setOnfocus("onfocus");
        button.setOnkeydown("onkeydown");
        button.setOnkeypress("onkeypress");
        button.setOnkeyup("onkeyup");
        button.setOnmousedown("onmousedown");
        button.setOnmousemove("onmousemove");
        button.setOnmouseout("onmouseout");
        button.setOnmouseover("onmouseover");
        button.setOnmouseup("onmouseup");
        button.setProcess("process");
        button.setReRender("reRender");
        button.setRender("render");
        button.setRendered("rendered");
        button.setRequestDelay("requestDelay");
        button.setSimilarityGroupingId("similarityGroupingId");
        button.setSize("size");
        button.setStatus("status");
        button.setStyle("style");
        button.setStyleClass("styleClass");
        button.setTabindex("tabindex");
        button.setTimeout("timeout");
        button.setTitle("title");
        button.setType("type");
        System.out.println("texto: " + button.build());
		
		
        /*ActionParam actionParam  = new ActionParam("Usuario","Nombre");
		actionParam.setActionListener("actionListener");
		actionParam.setBinding("binding");
		actionParam.setConverter("converter");
		actionParam.setNoEscape("noEscape");
		actionParam.setValue("value");
		System.out.println("texto: " + actionParam.build());*/
		
		/*CommandLink link = new CommandLink("Usuario","nombre");
		link.setAction("keyup");
		link.setActionListener("out");
		link.setBinding("@form");
		link.setBypassUpdates(Boolean.TRUE);
		link.setCharset("out");
		link.setCoords("@form");
		link.setData("keyup");
		link.setDisabled("out");
		link.setExecute("@form");
		link.setHreflang("keyup");
		link.setImmediate (Boolean.TRUE);
		link.setLimitToList(Boolean.TRUE);
		link.setLimitRender("@form");
		link.setOnbeforedomupdate("onbeforedomupdate");
		link.setOnbegin("onbegin");
		link.setOnclick("onclick");
		link.setOncomplete("oncomplete");
		link.setOndblclick("ondblclick");
		link.setOaccesskey("oaccesskey");
		link.setOnkeydown("onkeydown");
		link.setOnkeypress("onkeypress");
		link.setOnkeyup("onkeyup");
		link.setOnmousedown("onmousedown");
		link.setOnmousemove("onmousemove");
		link.setOnmousemove("onmousemove");
		link.setOnmouseout("onmouseout");
		link.setOnmouseover("onmouseover");
		link.setOnmousedown("onmousedown");
		link.setOnmouseup("onmouseup");
		link.setRel("rel");
		link.setRender("render");
		link.setRendered("rendered");
		link.setRev("rev");
		link.setShape("shape");
		link.setStatus("status");
		link.setStyle("style");
		link.setStyleClass("styleClass");
		link.setTitle("title");
		link.setType("type");
		link.setValue("value");
		System.out.println("texto: " + link.build()); */
		
		
		
		
	}
		
}
