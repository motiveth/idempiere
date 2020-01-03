package org.adempiere.report.jasper;

import org.compiere.model.PrintInfo;
import org.compiere.process.ProcessInfo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface JRViewerProvider {

	public void openViewer(JasperPrint jasperPrint, ProcessInfo pi, PrintInfo printInfo) throws JRException;

	default void openViewer(JasperPrint jasperPrint, ProcessInfo pi) throws JRException {
		openViewer(jasperPrint, pi, null);
	}

}
