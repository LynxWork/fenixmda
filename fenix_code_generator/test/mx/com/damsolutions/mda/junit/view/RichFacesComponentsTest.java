package mx.com.damsolutions.mda.junit.view;



import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.A4jAjax;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.ActionListener;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.ActionParam;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.AjaxListener;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Column;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.CommandButton;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.CommandLink;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Form;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.HtmlCommandLink;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Include;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InplaceInput;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InputTextField;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.JsFunction;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.KeepAlive;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.LoadBundle;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Param;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Poll;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Push;



public class RichFacesComponentsTest {

	public static void main(String[] args) {
		

		
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
		
		
		
//		ActionListener listener = new ActionListener("Usuario","nombre");
//	    System.out.println("texto: " + listener.build());
		
//		A4jAjax ajax = new A4jAjax();
//		ajax.setEvent("keyup");
//		ajax.setRender("out");
//		System.out.println("texto: " + ajax.build());
		
//		InputTextField field = new InputTextField("nameId","Nombre","Usuario","nombre");
//		field.setDescription("Descripcion del componente");
//		field.setLabel("Ingrese su nombre");
//		System.out.println("texto: " + field.build());
	
//		InplaceInput inplaceInput = new InplaceInput("id", "name", "Usuario","nombre");
//		System.out.println("texto: " + inplaceInput.build());
		LoadBundle loadBundle = new LoadBundle("id", "name", "Usuario","nombre");
		loadBundle.setBeanName("beanName");
		loadBundle.setVar("var");
		System.out.println("texto: " + loadBundle.build());
		
		KeepAlive keepAlive = new KeepAlive("id", "name", "Usuario","nombre");
		keepAlive.setAjaxOnly("ajaxOnly");
		keepAlive.setBeanName("beanName");
		System.out.println("texto: " + keepAlive.build());
		
		JsFunction function = new JsFunction("id", "name", "Usuario","nombre");
		function.setAjaxSingle(Boolean.FALSE);
		function.setBypassUpdates(Boolean.TRUE);
		function.setData("data");
		function.setEventsQueue("eventsQueue");
		function.setFocus("focus");
		function.setIgnoreDupResponses(Boolean.TRUE);
		function.setImmediate(Boolean.TRUE);
		function.setLimitToList(Boolean.TRUE);
		function.setOnbeforedomupdate("onbeforedomupdate");
		function.setReRender("reRender");
		function.setStatus("status");
		System.out.println("texto: " + function.build());
		
		Include include = new Include("id", "name", "Usuario","nombre"); 
		include.setAjaxRendered(Boolean.TRUE);
		include.setDir("dir");
		include.setKeepTransient(Boolean.TRUE);
		include.setLang("lang");
		include.setReRender("reRender");
		include.setStyle("style");
		System.out.println("texto: " + include.build());
		
		Form form = new Form("id", "name", "Usuario","nombre");
		form.setAjaxSingle(Boolean.TRUE);
        form.setAjaxSubmit(Boolean.TRUE);
        form.setBypassUpdates(Boolean.TRUE);
        form.setData("data");
        form.setEventsQueue("eventsQueue");
        form.setFocus("focus");
        form.setIgnoreDupResponses(Boolean.TRUE);
        form.setImmediate(Boolean.TRUE);
        form.setLimitToList(Boolean.TRUE);
        form.setOnbeforedomupdate("onbeforedomupdate");
        form.setReRender("reRender");
        form.setStatus("status");
        form.setStyle("style");
        form.setTarget("target");
		System.out.println("texto: " + form.build());
		
        HtmlCommandLink htmlCommandLink = new HtmlCommandLink("id", "name","Usuario","Nombre");
        htmlCommandLink.setAccesskey("accesskey");
        htmlCommandLink.setCharset("charset");
        htmlCommandLink.setCoords("coords");
        htmlCommandLink.setData("data");
        htmlCommandLink.setDir("dir");
        htmlCommandLink.setDisabled(Boolean.TRUE);
        htmlCommandLink.setEventsQueue("eventsQueue");
        htmlCommandLink.setFocus("focus");
        htmlCommandLink.setIgnoreDupResponses(Boolean.TRUE);
        htmlCommandLink.setImmediate(Boolean.TRUE);
        htmlCommandLink.setLang("lang");
        htmlCommandLink.setLimitToList(Boolean.TRUE);
        htmlCommandLink.setOnbeforedomupdate("onbeforedomupdate");
        htmlCommandLink.setHreflang("hreflang");
        htmlCommandLink.setOnblur("onblur");
        htmlCommandLink.setOnfocus("onfocus");
        htmlCommandLink.setReRender("reRender");
        htmlCommandLink.setRel("rel");
        htmlCommandLink.setRev("rev");
        htmlCommandLink.setShape("shape");
        htmlCommandLink.setStyle("style");
        htmlCommandLink.setTabindex("tabindex");
        htmlCommandLink.setTarget("target");
        System.out.println("texto:" + htmlCommandLink.build());
		
        AjaxListener ajaxListener = new AjaxListener("id", "name","Usuario","Nombre");
        System.out.println("texto: " + ajaxListener.build());

        ActionParam actionParam  = new ActionParam("id", "name", "Usuario","nombre");
		actionParam.setConverter("converter");
		actionParam.setNoEscape(Boolean.TRUE);
		System.out.println("texto: " + actionParam.build());
        
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
		
		CommandLink link = new CommandLink("id", "name","Usuario","Nombre");
		link.setAccesskey("accesskey");
		link.setAjaxSingle(Boolean.TRUE);
        link.setCharset("charset");
        link.setCoords("coords");
        link.setBypassUpdates(Boolean.TRUE);
        link.setData("data");
        link.setDir("dir");
        link.setDisabled(Boolean.TRUE);
        link.setEventsQueue("eventsQueue");
        link.setFocus("focus");
        link.setIgnoreDupResponses(Boolean.TRUE);
        link.setImmediate(Boolean.TRUE);
        link.setLang("lang");
        link.setLimitToList(Boolean.TRUE);
        link.setOnbeforedomupdate("onbeforedomupdate");
        link.setHreflang("hreflang");
        link.setOnblur("onblur");
        link.setOnfocus("onfocus");
        link.setReRender("reRender");
        link.setRel("rel");
        link.setRev("rev");
        link.setShape("shape");
        link.setStatus("status");
        link.setStyle("style");
        link.setTabindex("tabindex");
        link.setTarget("target");
		System.out.println("texto: " + link.build());
		
		Column column = new Column();
		System.out.println("texto: " + column.build());
	}
		
}
