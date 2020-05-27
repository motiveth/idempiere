package org.compiere.apps.wf;

import java.awt.Point;

import org.compiere.wf.MWFNode;

/**
 * implement Widget for Workflow Node need to extend Widget and implement IWFNodeWidget
 * @author hieplq
 *
 */
public interface IWFNodeWidget {
	public void setColumn(int column);
	public int getColumn();
	public void setRow(int row);
	public int getRow();
	public void setPreferredLocation (Point point);
	public MWFNode getModel ();
}
