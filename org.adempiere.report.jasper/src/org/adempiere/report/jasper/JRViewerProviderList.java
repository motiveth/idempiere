package org.adempiere.report.jasper;

import java.util.List;

import org.compiere.model.PrintInfo;
import org.compiere.process.ProcessInfo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface JRViewerProviderList {

	public void openViewer(List<JasperPrint> jasperPrintList, ProcessInfo pi, PrintInfo printInfo) throws JRException;

	default void openViewer(List<JasperPrint> jasperPrintList, ProcessInfo pi) throws JRException {
		openViewer(jasperPrintList, pi, null);
	}

}
