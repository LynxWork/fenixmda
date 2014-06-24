package mx.com.damsolutions.mda;

import mx.com.damsolutions.mda.core.xml.BuildModelXml;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("-->");
		BuildModelXml buildModel = new BuildModelXml();
		buildModel.buildModel();
	}

}