package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

public class PanelGrid extends Tag{

	String columns;
	String sourceCode;
	String DEFAULT_COLUMNS = "1";

	public PanelGrid(String prefix) {
		super(prefix);
	}

	public PanelGrid(String prefix, String columns) {
		super(prefix);
		this.columns = columns;
	}

	public String getColumns() {
		if(columns==null || columns.equals("")){
			columns = DEFAULT_COLUMNS; 
		}
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode; 
	}
	
	public String getSourceCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("<"+getPrefix()+":panelGrid columns=\""+getColumns()+"\">");
		sb.append(sourceCode);
		sb.append("</"+getPrefix()+":panelGrid>");
		return sb.toString();
	}

}
