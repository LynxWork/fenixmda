package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;



public class TagLib {

	private String uri;
	private String prefix;
	
	public TagLib(String uri, String prefix){
		this.uri = uri;
		this.prefix = prefix;
	}
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSourceCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("<%@ ");
		sb.append("taglib ");
		sb.append("uri=\"" + getUri() + "\" ");
		sb.append("prefix=\"" + getPrefix() + "\" ");
		sb.append("%>");
		return sb.toString();
	}
	
	
}
