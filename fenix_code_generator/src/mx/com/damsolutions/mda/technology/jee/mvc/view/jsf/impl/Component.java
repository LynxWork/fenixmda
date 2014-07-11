package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public abstract class Component {

	protected String alt;
	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	protected String address;
	protected String assignTo;
	protected String action;
	protected String actionparam;
	protected String accesskey;
	protected String actionListener;
	protected Boolean ajaxSingle;
	protected Boolean ajaxSubmit;
	protected String ajaxListener;
	protected Boolean ajaxRendered;
	protected Boolean bypassUpdates;
	protected String binding;
	protected String charset;
	protected String commandButton;
	protected String commandLink;
	protected String converter;
	protected String coords;
	protected String data;
	protected String dir; 
	protected String description;
	protected Boolean disabled;
	protected String eventsQueue;
	protected String entityName;
	protected String entityProperty;
	protected String enctype;
	protected String event;
	protected String enabled;
	protected String execute;
	protected String focus;
	protected String form;
	protected String forComponent;
	protected String htmlCommandLink;
	protected String hreflang;
	protected String id;
	protected Boolean ignoreDupResponses;
	protected Boolean immediate;
	protected String image;
	protected String include;
	protected String interval;
	protected String lang;
	protected String layout;
	protected String limitRender;
	protected Boolean limitToList;
	protected String mediaOutput;
	protected String name;
	protected Boolean noEscape;
	protected String oaccesskey;
	
	protected String onbeforedomupdate;
	protected String onblur;
	protected String onclick;
	protected String oncomplete;
	protected String onchange;
	protected String ondblclick;
	protected String onreset;
	protected String onsubmit;
	protected String onfocus;
	protected String onkeydown;
	protected String onkeypress;
	protected String onkeyup;
	protected String onmousedown;
	protected String onmousemove;
	protected String onmouseout;
	protected String onmouseover;
	protected String onmouseup;
	protected String onbegin;
	protected String outputPanel;
	
	protected String page;
	protected String prependId;
	protected String poll;
	protected String portlet;
	protected String push;
	protected String queue;
	protected String process;
	protected String keepAlive;
	protected String region;
	protected String repeat;
	protected String reRender;
	protected String rel;
	protected String requestDelay;
	protected String rev;
    protected String rendered;
	protected String render;
	protected String jsFunction;
	protected Boolean keepTransient;
	protected String loadBundle;
	protected String loadScript;
	protected String loadStyle;
	protected String log;
	
	protected String styleClass;
	protected String shape;
	protected String similarityGroupingId;
	protected String status;
	protected String style;
	protected String support;
	protected String size;
	protected String tabindex;
	protected String target;
	protected String timeout;
	protected String title;
	protected String type;
	protected String viewId;
	protected String value;
	
	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	public Boolean getKeepTransient() {
		return keepTransient;
	}

	public void setKeepTransient(Boolean keepTransient) {
		this.keepTransient = keepTransient;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public Boolean getAjaxRendered() {
		return ajaxRendered;
	}

	public void setAjaxRendered(Boolean ajaxRendered) {
		this.ajaxRendered = ajaxRendered;
	}

	public String getPrependId() {
		return prependId;
	}

	public void setPrependId(String prependId) {
		this.prependId = prependId;
	}

	public String getOnsubmit() {
		return onsubmit;
	}

	public void setOnsubmit(String onsubmit) {
		this.onsubmit = onsubmit;
	}

	public String getOnreset() {
		return onreset;
	}

	public void setOnreset(String onreset) {
		this.onreset = onreset;
	}

	public String getEnctype() {
		return enctype;
	}

	public void setEnctype(String enctype) {
		this.enctype = enctype;
	}

	public Boolean getAjaxSubmit() {
		return ajaxSubmit;
	}

	public void setAjaxSubmit(Boolean ajaxSubmit) {
		this.ajaxSubmit = ajaxSubmit;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getNoEscape() {
		return noEscape;
	}

	public void setNoEscape(Boolean noEscape) {
		this.noEscape = noEscape;
	}

	public String getConverter() {
		return converter;
	}

	public void setConverter(String converter) {
		this.converter = converter;
	}

	public String getLimitRender() {
		return limitRender;
	}

	public void setLimitRender(String limitRender) {
		this.limitRender = limitRender;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOaccesskey() {
		return oaccesskey;
	}

	public void setOaccesskey(String oaccesskey) {
		this.oaccesskey = oaccesskey;
	}

	public String getOnbegin() {
		return onbegin;
	}

	public void setOnbegin(String onbegin) {
		this.onbegin = onbegin;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getEventsQueue() {
		return eventsQueue;
	}

	public void setEventsQueue(String eventsQueue) {
		this.eventsQueue = eventsQueue;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getHreflang() {
		return hreflang;
	}

	public void setHreflang(String hreflang) {
		this.hreflang = hreflang;
	}

	public Boolean getIgnoreDupResponses() {
		return ignoreDupResponses;
	}

	public void setIgnoreDupResponses(Boolean ignoreDupResponses) {
		this.ignoreDupResponses = ignoreDupResponses;
	}

	public Boolean getImmediate() {
		return immediate;
	}

	public void setImmediate(Boolean immediate) {
		this.immediate = immediate;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Boolean getLimitToList() {
		return limitToList;
	}

	public void setLimitToList(Boolean limitToList) {
		this.limitToList = limitToList;
	}

	public String getOnbeforedomupdate() {
		return onbeforedomupdate;
	}

	public void setOnbeforedomupdate(String onbeforedomupdate) {
		this.onbeforedomupdate = onbeforedomupdate;
	}

	public String getOnblur() {
		return onblur;
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOncomplete() {
		return oncomplete;
	}

	public void setOncomplete(String oncomplete) {
		this.oncomplete = oncomplete;
	}

	public String getOndblclick() {
		return ondblclick;
	}

	public void setOndblclick(String ondblclick) {
		this.ondblclick = ondblclick;
	}

	public String getOnfocus() {
		return onfocus;
	}

	public void setOnfocus(String onfocus) {
		this.onfocus = onfocus;
	}

	public String getOnkeydown() {
		return onkeydown;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnkeypress() {
		return onkeypress;
	}

	public void setOnkeypress(String onkeypress) {
		this.onkeypress = onkeypress;
	}

	public String getOnkeyup() {
		return onkeyup;
	}

	public void setOnkeyup(String onkeyup) {
		this.onkeyup = onkeyup;
	}

	public String getOnmousedown() {
		return onmousedown;
	}

	public void setOnmousedown(String onmousedown) {
		this.onmousedown = onmousedown;
	}

	public String getOnmousemove() {
		return onmousemove;
	}

	public void setOnmousemove(String onmousemove) {
		this.onmousemove = onmousemove;
	}

	public String getOnmouseout() {
		return onmouseout;
	}

	public void setOnmouseout(String onmouseout) {
		this.onmouseout = onmouseout;
	}

	public String getOnmouseover() {
		return onmouseover;
	}

	public void setOnmouseover(String onmouseover) {
		this.onmouseover = onmouseover;
	}

	public String getOnmouseup() {
		return onmouseup;
	}

	public void setOnmouseup(String onmouseup) {
		this.onmouseup = onmouseup;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getReRender() {
		return reRender;
	}

	public void setReRender(String reRender) {
		this.reRender = reRender;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getRequestDelay() {
		return requestDelay;
	}

	public void setRequestDelay(String requestDelay) {
		this.requestDelay = requestDelay;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getSimilarityGroupingId() {
		return similarityGroupingId;
	}

	public void setSimilarityGroupingId(String similarityGroupingId) {
		this.similarityGroupingId = similarityGroupingId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getTabindex() {
		return tabindex;
	}

	public void setTabindex(String tabindex) {
		this.tabindex = tabindex;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getCoords() {
		return coords;
	}

	public void setCoords(String coords) {
		this.coords = coords;
	}

	public Boolean getBypassUpdates() {
		return bypassUpdates;
	}

	public void setBypassUpdates(Boolean bypassUpdates) {
		this.bypassUpdates = bypassUpdates;
	}

	public Boolean getAjaxSingle() {
		return ajaxSingle;
	}

	public void setAjaxSingle(Boolean ajaxSingle) {
		this.ajaxSingle = ajaxSingle;
	}

	public String getActionListener() {
		return actionListener;
	}

	public void setActionListener(String actionListener) {
		this.actionListener = actionListener;
	}

	public String getAccesskey() {
		return accesskey;
	}

	public void setAccesskey(String accesskey) {
		this.accesskey = accesskey;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityProperty() {
		return entityProperty;
	}

	public void setEntityProperty(String entityProperty) {
		this.entityProperty = entityProperty;
	}

	
	public String getForComponent() {
		return forComponent;
	}
	public String buildForComponent() {
		StringBuilder resVal = new StringBuilder("");
		if(getForComponent()!=null && getForComponent().length()>0){
			resVal.append(" for=\""+ getForComponent() +"\" ");
		}
		return resVal.toString();
	}
	public void setForComponent(String forComponent) {
		this.forComponent = forComponent;
	}

	
	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String buildStyleClass() {
		StringBuilder resVal = new StringBuilder(""); 
		if(getStyleClass()!=null && getStyleClass().length()>0){
			resVal.append(" styleClass=\""+ getStyleClass() +"\" ");
		}
		return resVal.toString();
	}

	
	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getRendered() {
		return rendered;
	}

	public void setRendered(String rendered) {
		this.rendered = rendered;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}

	public String getExecute() {
		return execute;
	}

	public void setExecute(String execute) {
		this.execute = execute;
	}

	public String build() {
		StringBuilder resVal = new StringBuilder("");
		if(getForComponent()!=null && getForComponent().length()>0){
			resVal.append(" for=\""+ getForComponent() +"\" ");
		}
		return resVal.toString();
	}

	
	public String buildAccesskey(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" accesskey=\""+getAccesskey()+"\"");
		return sb.toString();
	}
	public String buildAction(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" action=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	
	public String buildActionListener(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" actionListener=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	
	public String buildAjaxSingle(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" ajaxSingle=\""+getAjaxSingle()+"\" ");
		return sb.toString();
	}
	public String buildAjaxRendered(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" ajaxRendered=\""+getAjaxRendered()+"\" ");
		return sb.toString();
	}
	public String buildAjaxSubmit(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" ajaxSubmit=\""+getAjaxSingle()+"\" ");
		return sb.toString();
	}
	
	
	public String buildBinding(){
		StringBuilder sb = new StringBuilder("");
		sb.append("binding=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	public String buildBypassUpdates(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" bypassUpdates=\""+getAjaxSingle()+"\" ");
		return sb.toString();
	}
	
	public String buildData(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" data=\""+getData()+"\" ");
		return sb.toString();
	}
	public String buildDir(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" dir=\""+getDir()+"\" ");
		return sb.toString();
	}
	public String buildDisabled(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" disabled=\""+getDisabled()+"\" ");
		return sb.toString();
	}
	public String buildEventsQueue(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" eventsQueue=\""+getEventsQueue()+"\" ");
		return sb.toString();
	}
	public String buildFocus(){
		StringBuilder sb = new StringBuilder("");
		sb.append("focus=\"#{"+ getFocus()+"}" + "\" ");
		return sb.toString();
	}
	public String buildIgnoreDupResponses(){
		StringBuilder sb = new StringBuilder("");
		sb.append("ignoreDupResponses=\""+ getIgnoreDupResponses()+ "\" ");
		return sb.toString();
	}
	public String buildImage(){
		StringBuilder sb = new StringBuilder("");
		sb.append("image=\""+"/"+ getImage()+"/"+"shell"+"/"+"spacer"+"."+"gif"+ "\" ");
		
		return sb.toString();
	}
	public String buildImmediate(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" immediate=\""+ getImmediate()+ "\"");
		return sb.toString();
	}
	public String buildkeepTransient(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" keepTransient=\""+ getKeepTransient()+ "\"");
		return sb.toString();
	}
	public String buildLang(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" lang=\""+ getLang()+ "\"");
		return sb.toString();
	}
	public String buildLimitToList(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" limitToList=\"#{"+ getLimitToList()+"}" + "\" ");
		return sb.toString();
	}
	public String buildNoEscape(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" noEscape=\""+ getNoEscape()+ "\" ");
		return sb.toString();
	}
	public String buildOnbeforedomupdate(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" Onbeforedomupdate=\"#{"+ getOnbeforedomupdate()+"}" + "\" ");
		return sb.toString();
	}
	
	public String buildOnclick(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onclick=\"" + " setTheValue()"+" \"");
		return sb.toString();
	}
	public String buildOncomplete(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" oncomplete=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	public String buildOndblclick(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" ondblclick\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	public String buildOnkeydown(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onkeydown=\""+"test()"+" \"");
		return sb.toString();
	}
	public String buildOnkeypress(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onkeypress=\""+"return"+"("+"event"+"."+"keycode"+")"+" \"");
		return sb.toString();
	}
	public String buildOnkeyup(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onkeyup=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	public String buildOnmousedown(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onmousedown=\"" +NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"();" + "\" ");
		return sb.toString();
	}
	public String buildOnmousemove(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onmousemove=\"" +NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"();" + "\" ");
		return sb.toString();
	}
	public String buildOnmouseout(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onmouseout=\"" +NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"()" + "\" ");
		return sb.toString();
	}
	public String buildOnmouseover(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onmouseover=\"#{"+ NamingConvention.getClassControllerName(getEntityProperty())+"}" + "\" ");
		return sb.toString();
	}
	public String buildOnmouseup(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" onmouseup=\"#{"+ NamingConvention.getClassControllerName(getEntityProperty())+"}" + "\" ");
		return sb.toString();
	}
	public String buildProcess(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" process=\"#{"+ NamingConvention.getClassControllerName(getEntityProperty())+"}" + "\" ");
		return sb.toString();
	}
	public String buildReRender(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" reRender=\"" + getReRender() + " \"");
		return sb.toString();
	}
	public String buildRendered(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" rendered=\"#{"+ NamingConvention.getClassControllerName(getEntityProperty())+"}" + "\" ");
		return sb.toString();
	}
	public String buildRequestDelay(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" requestDelay=\"#{"+ NamingConvention.getClassControllerName(getEntityProperty())+"}" + "\" ");
		return sb.toString();
	}
	public String buildSimilarityGroupingId(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" similarityGroupingId=\"#{"+ NamingConvention.getClassControllerName(getEntityProperty())+"}" + "\" ");
		return sb.toString();
	}
	public String buildStatus(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" status=\""+getStatus()+" \"");
		return sb.toString();
	}
	public String buildStyle(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" style=\""+getStyle()+" \"");
		return sb.toString();
	}
	
	public String buildTimeout(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" timeout=\""+" 100 "+" \"");
		return sb.toString();
	}
	public String buildTitle(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" title=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	public String buildType(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" Type=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	public String buildValue(){
		StringBuilder sb = new StringBuilder("");
		sb.append(" Value=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		return sb.toString();
	}
	
	
	
	public String buildId(){
		return " id=\"" + this.buildStringId() + "\"";
	}
	
	public String buildStringId(){
		StringBuilder sb = new StringBuilder("");
		sb.append( " id=\"" + buildStringId() + "\"" );
		return sb.toString();
		
		
	
	}
	
	public String buildName(){
		
		return " name=\"" + this.buildStringName() + "\"";
	}
	
	public String buildStringName(){
		StringBuilder sb = new StringBuilder("");
		sb.append( " name=\"" + buildStringName() + "\"" );
		return getEntityProperty()+getName();
	}
	
	
	
}
