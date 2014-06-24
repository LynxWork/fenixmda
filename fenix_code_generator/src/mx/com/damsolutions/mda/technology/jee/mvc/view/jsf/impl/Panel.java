package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

public class Panel extends Tag{
	
	PanelGrid[] panelGridList;
	
	public Panel(String prefix) {
		super(prefix);
	}

	public void setPanelGrid(PanelGrid... panelGridList){
		this.panelGridList = panelGridList;
	}

	public String getSourceCode(){
		StringBuilder sb = new StringBuilder();
		sb.append("<"+getPrefix()+":panel>");
		//Se obtiene el codigo de todos los paneles
		for (int i = 0; i < panelGridList.length; i++) {
			sb.append(panelGridList[i].getSourceCode());
		}
		sb.append("</"+getPrefix()+":panel>");
		return sb.toString();
	}
	
	
	
}
