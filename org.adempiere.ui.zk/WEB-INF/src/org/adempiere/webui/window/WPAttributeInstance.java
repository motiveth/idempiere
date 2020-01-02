/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2006 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.adempiere.webui.window;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.component.Checkbox;
import org.adempiere.webui.component.ConfirmPanel;
import org.adempiere.webui.component.Panel;
import org.adempiere.webui.component.WListbox;
import org.adempiere.webui.component.Window;
import org.adempiere.webui.theme.ThemeManager;
import org.adempiere.webui.util.ZKUpdateUtil;
import org.compiere.minigrid.ColumnInfo;
import org.compiere.minigrid.IDColumn;
import org.compiere.model.MAttribute;
import org.compiere.model.MAttributeSet;
import org.compiere.model.MProduct;
import org.compiere.util.CLogger;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.North;
import org.zkoss.zul.South;
import org.zkoss.zul.Hbox;


/**
 *	Display Product Attribute Instance Info
 *
 *  @author     Jorg Janke
 *  @version    $Id: PAttributeInstance.java,v 1.3 2006/07/30 00:51:27 jjanke Exp $
 */
public class WPAttributeInstance extends Window implements EventListener<Event> 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4052029122256207113L;

	/**
	 * 	Constructor
	 * 	@param title title
	 * 	@param M_Warehouse_ID warehouse key name pair
	 * 	@param M_Locator_ID locator
	 * 	@param M_Product_ID product key name pair
	 * 	@param C_BPartner_ID bp
	 */
	public WPAttributeInstance(String title,
		int M_Warehouse_ID, int M_Locator_ID, int M_Product_ID, int C_BPartner_ID, int m_WindowNo)
	{
		super ();
		this.setTitle(Msg.getMsg(Env.getCtx(), "PAttributeInstance") + title);
		this.setBorder("normal");
		this.setSizable(true);
		this.setMaximizable(true);
		if (!ThemeManager.isUseCSSForWindowSize())
		{
			ZKUpdateUtil.setWindowWidthX(this, 1000);
			ZKUpdateUtil.setWindowHeightX(this, 550);
		}
		else
		{
			addCallback(AFTER_PAGE_ATTACHED, t-> {
				ZKUpdateUtil.setCSSHeight(this);
				ZKUpdateUtil.setCSSWidth(this);
			});
		}
		this.setSclass("pattribute-instance-dialog");
		this.m_WindowNo = m_WindowNo;
		init (M_Warehouse_ID, M_Locator_ID, M_Product_ID, C_BPartner_ID);
		AEnv.showCenterScreen(this);
	}	//	PAttributeInstance
	
	/**
	 * 	Initialization
	 *	@param M_Warehouse_ID wh
	 *	@param M_Locator_ID loc
	 *	@param M_Product_ID product
	 *	@param C_BPartner_ID partner
	 */
	private void init (int M_Warehouse_ID, int M_Locator_ID, int M_Product_ID, int C_BPartner_ID)
	{
		log.info("M_Warehouse_ID=" + M_Warehouse_ID 
			+ ", M_Locator_ID=" + M_Locator_ID
			+ ", M_Product_ID=" + M_Product_ID);
		//m_M_Warehouse_ID = M_Warehouse_ID;
		m_M_Locator_ID = M_Locator_ID;
		m_M_Product_ID = M_Product_ID;
		try
		{
			init();
			dynInit(C_BPartner_ID);
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, "", e);
		}
	}	// init	

	private Borderlayout mainLayout = new Borderlayout();
	private Panel northPanel = new Panel();
	private ConfirmPanel confirmPanel = new ConfirmPanel (true);
	private Checkbox showAll = new Checkbox();
	private Checkbox showOnlyQtyPositive = new Checkbox();
	private Checkbox showOnlyCurrentWarehouse = new Checkbox();
	//
	private WListbox 			m_table = new WListbox();
	//	Parameter
	//private int			 		m_M_Warehouse_ID;
	private int			 		m_M_Locator_ID;
	private int			 		m_M_Product_ID;
	//
	private int					m_M_AttributeSetInstance_ID = -1;
	private String				m_M_AttributeSetInstanceName = null;
	private String				m_sql;
	protected String 			m_sqlAll;
	protected int m_WindowNo = 0;
	/**	Logger			*/
	private static final CLogger log = CLogger.getCLogger(WPAttributeInstance.class);

	/**
	 * 	Static Init
	 * 	@throws Exception
	 */
	private void init() throws Exception
	{
		//showAll.setLabel(Msg.getMsg(Env.getCtx(), "ShowAll"));
		showOnlyQtyPositive.setLabel(Msg.getMsg(Env.getCtx(), "Show Only Qty Positive"));
		showOnlyCurrentWarehouse.setLabel(Msg.getMsg(Env.getCtx(), "Show Only Current Warehouse"));
		this.appendChild(mainLayout);
		
		//	North
		Hbox box = new Hbox();
		box.setParent(northPanel);
		box.setPack("end");
		//box.appendChild(showAll);
		//showAll.addEventListener(Events.ON_CHECK, this);
		box.appendChild(showOnlyCurrentWarehouse);
		box.appendChild(showOnlyQtyPositive);
		showOnlyCurrentWarehouse.addEventListener(Events.ON_CHECK, this);
		showOnlyQtyPositive.addEventListener(Events.ON_CHECK, this);
		
		North north = new North();
		north.setParent(mainLayout);
		north.appendChild(northPanel);
		
		//	Center
		Center center = new Center();
		center.setParent(mainLayout);
		ZKUpdateUtil.setHflex(m_table, "true");
		ZKUpdateUtil.setVflex(m_table, "true");
		center.appendChild(m_table);
		
		//	South
		South south = new South();
		south.setParent(mainLayout);
		south.appendChild(confirmPanel);
		confirmPanel.addActionListener(this);
		
		
	}	//	jbInit

	/**
	 * SELECT asi_id, xx, yy 
	FROM crosstab(
	  $$select m_attributesetinstance_id, m_attribute_id, "value"
	   from m_attributeinstance
	   where m_attributesetinstance_id > 1000 order by 1, 2$$ )
	AS ct(asi_id numeric(10, 0), xx character varying(40), yy character varying(40));
	 * @param m_M_Product_ID
	 * @return
	 */
	protected ColumnInfo[] getColumnAsiList (int m_M_Product_ID){
		List <ColumnInfo> lsColumnInfo = new ArrayList<>();
		MProduct product = MProduct.get(Env.getCtx(), m_M_Product_ID);
		MAttributeSet as = product.getAttributeSet();
		// order by id to match with pivot query
		MAttribute[] lsAttributeInstance = as.getMAttributes(true, true);
		
		lsColumnInfo.add(new ColumnInfo(" ", "asi.m_attributesetinstance_id", IDColumn.class));
		
		if (lsAttributeInstance.length > 0){
			for (MAttribute attr : lsAttributeInstance){
				lsColumnInfo.add(new ColumnInfo(attr.getName(), "c" + String.valueOf(attr.get_ID()), String.class));
			}
		}
		
		lsColumnInfo.add(new ColumnInfo(Msg.translate(Env.getCtx(), "Description"), "asi.Description", String.class));
		if (as.isLot())
			lsColumnInfo.add(new ColumnInfo(Msg.translate(Env.getCtx(), "Lot"), "asi.Lot", String.class));
		if (as.isSerNo())
			lsColumnInfo.add(new ColumnInfo(Msg.translate(Env.getCtx(), "SerNo"), "asi.SerNo", String.class));
		lsColumnInfo.add(new ColumnInfo(Msg.translate(Env.getCtx(), "QtyOnHand"), "qty", Double.class));
		
		return lsColumnInfo.toArray(new ColumnInfo[]{});
	}
	
	/**
	 * SELECT asi_id, xx, yy 
	FROM crosstab(
	  $$select m_attributesetinstance_id, m_attribute_id, "value"
	   from m_attributeinstance
	   where m_attributesetinstance_id > 1000 order by 1, 2$$ )
	AS ct(asi_id numeric(10, 0), xx character varying(40), yy character varying(40));
	 * @param m_M_Product_ID
	 * @return
	 */
	protected String buildQueryAsi (int m_M_Product_ID, int [] lsAsiID){
		StringBuilder sqlFromBuild = new StringBuilder();
		// build crosstab clause. it like a subquery give a table alias
		StringBuilder sqlCrosstabTable = new StringBuilder();
		StringBuilder sqlCrosstabOrder = new StringBuilder();
		
		MProduct product = MProduct.get(Env.getCtx(), m_M_Product_ID);
		MAttributeSet as = product.getAttributeSet();
		// order by id to match with pivot query
		MAttribute[] lsAttributeInstance = as.getMAttributes(true, true);
		if (lsAttributeInstance.length > 0){
			StringBuilder sqlCrossTabBuild = new StringBuilder();
			sqlCrossTabBuild.append("asi_id NUMERIC(10, 0)");
			for (MAttribute attr : lsAttributeInstance){
				// name of column must start by letter, so use c+id as column name
				//sqlSelectBuild.append (", c");
				//sqlSelectBuild.append (String.valueOf(attr.get_ID()));
				sqlCrossTabBuild.append(", c");
				sqlCrossTabBuild.append(String.valueOf(attr.get_ID()));
				sqlCrossTabBuild.append(" CHARACTER VARYING (40)");
				sqlCrosstabOrder.append("c");
				sqlCrosstabOrder.append(String.valueOf(attr.get_ID()));
				sqlCrosstabOrder.append(",");
			}
			sqlCrosstabOrder.deleteCharAt(sqlCrosstabOrder.length()-1);
			sqlCrosstabTable.append("\ncrosstab(");
			sqlCrosstabTable.append("\n    $$SELECT m_attributesetinstance_id AS asiID, m_attribute.m_attribute_id, \"value\"");
			sqlCrosstabTable.append("\n    FROM m_attributeinstance INNER JOIN m_attribute ON (m_attributeinstance.m_attribute_id = m_attribute.m_attribute_id AND m_attribute.isinstanceattribute = 'Y')");
			
			sqlCrosstabTable.append("\n    WHERE m_attributesetinstance_id ");
			appendINClause (sqlCrosstabTable, lsAsiID);
	
			sqlCrosstabTable.append("\n$$");
			sqlCrosstabTable.append("\n)AS atrNames (");
			sqlCrosstabTable.append(sqlCrossTabBuild);
			sqlCrosstabTable.append(")");
		}
		
		// append lot, serial, ... 
		if (lsAttributeInstance.length > 0){
			sqlFromBuild.append(sqlCrosstabTable);
			sqlFromBuild.append("\n    INNER JOIN m_attributesetinstance asi ON (asi.m_attributesetinstance_id = atrNames.asi_id) ");
		}else{
			sqlFromBuild.append("\n    (SELECT * FROM m_attributesetinstance WHERE m_attributesetinstance_id ");
			appendINClause (sqlFromBuild, lsAsiID);
			sqlFromBuild.append("\n    )AS asi");
		
		}	
		
		int warehouseID = Env.getContextAsInt(Env.getCtx(), m_WindowNo, "M_Warehouse_ID");
		boolean useWarehouse = showOnlyCurrentWarehouse.isChecked() && warehouseID > 0;
		if (useWarehouse){
			sqlFromBuild.append("\n    INNER JOIN");
		}else{
			sqlFromBuild.append("\n    LEFT OUTER JOIN");
		}
		
		sqlFromBuild.append("(SELECT sum (qtyonhand) AS qty, m_attributesetinstance_id, m_product_id FROM m_storageonhand ");
		sqlFromBuild.append("\n    INNER JOIN m_locator ON (m_storageonhand.m_locator_id = m_locator.m_locator_id) ");
		sqlFromBuild.append("\n    WHERE m_attributesetinstance_id IN (");
		for (int asiID : lsAsiID){
			sqlFromBuild.append(asiID);
			sqlFromBuild.append(",");
		}
		sqlFromBuild.deleteCharAt(sqlFromBuild.length()-1);
		sqlFromBuild.append(")");
		
		sqlFromBuild.append("\n    AND m_product_id = ");
		sqlFromBuild.append(m_M_Product_ID);
		
		if (useWarehouse){
			sqlFromBuild.append("\n    AND m_warehouse_id = ");
			sqlFromBuild.append(warehouseID);
		}
		
		sqlFromBuild.append("\n    GROUP BY m_product_id, m_attributesetinstance_id) AS onhand");
		sqlFromBuild.append("\n    ON onhand.m_attributesetinstance_id = asi.m_attributesetinstance_id");
		
		sqlFromBuild.append("\n    LEFT OUTER JOIN m_lot ON (m_lot.m_lot_id = asi.m_lot_id)");
		
		StringBuilder sqlWhereBuild = new StringBuilder();
		if (showOnlyQtyPositive.isChecked()){
			sqlFromBuild.append ("\n    WHERE qty > 0");
		}
		
		if (sqlWhereBuild.length() > 0){
			sqlFromBuild.append(sqlWhereBuild);
		}
		
		sqlFromBuild.append("\n    ORDER BY m_lot.m_lot_id DESC");
		if (sqlCrosstabOrder.length() > 0){
			sqlFromBuild.append(",");
			sqlFromBuild.append(sqlCrosstabOrder);
		}
		sqlFromBuild.append(", asi.m_attributesetinstance_id DESC");
		
		return sqlFromBuild.toString();
	}
	
	protected void appendINClause (StringBuilder sqlFromBuild, int [] lsAsiID){
		sqlFromBuild.append ("   IN ( ");
		for (int asiID : lsAsiID){
			sqlFromBuild.append(asiID);
			sqlFromBuild.append(",");
		}
		sqlFromBuild.deleteCharAt(sqlFromBuild.length()-1);
		sqlFromBuild.append(")");
	}
	
	protected int [] listExitsAsi (int m_M_Product_ID){
		return DB.getIDsEx (null, "SELECT m_attributesetinstance_id FROM m_asi_v WHERE m_product_id = ?", m_M_Product_ID);
	}
	/**
	 * 	Dynamic Init
	 * 	@param C_BPartner_ID BP
	 */
	private void dynInit(int C_BPartner_ID)
	{
		if (log.isLoggable(Level.CONFIG)) log.config("C_BPartner_ID=" + C_BPartner_ID);

		updateQuery();
		
		//
		m_table.addEventListener(Events.ON_SELECT, this);
		//
		refresh();
	}	//	dynInit

	protected void updateQuery() {
		int lsExitsAsi [] = listExitsAsi(m_M_Product_ID);
		if (lsExitsAsi.length == 0)
			return;
		
		m_sql =m_table.prepareTable (getColumnAsiList(m_M_Product_ID), buildQueryAsi(m_M_Product_ID, lsExitsAsi), null, false, null, false);
		
		if (m_sql.trim().endsWith("WHERE")) {
			m_sql = m_sql.trim();
			m_sql = m_sql.substring(0, m_sql.length() - 5);
		}
	}
	
	/**
	 * 	Refresh Query
	 */
	private void refresh()
	{
		String sql = m_sql;
		log.finest(sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = DB.prepareStatement(sql, null);
			rs = pstmt.executeQuery();
			m_table.loadTable(rs);
		}
		catch (Exception e)
		{
			log.log(Level.SEVERE, sql, e);
		}
		finally {
			DB.close(rs, pstmt);
			rs = null; pstmt = null;
		}
		enableButtons();
	}	//	refresh

	public void onEvent(Event e) throws Exception 
	{
		if (e.getTarget().getId().equals("Ok"))
			detach();
		else if (e.getTarget().getId().equals("Cancel"))
		{
			detach();
			m_M_AttributeSetInstance_ID = -1;
			m_M_AttributeSetInstanceName = null;
		}
		else if (e.getTarget() == showAll || e.getTarget() == showOnlyCurrentWarehouse || e.getTarget() == showOnlyQtyPositive)
		{
			updateQuery();
			refresh();
		}
		else if (e.getTarget() == m_table)
		{
			enableButtons();
		}
	}	//	actionPerformed
 
	/**
	 * 	Enable/Set Buttons and set ID
	 */
	private void enableButtons()
	{
		m_M_AttributeSetInstance_ID = -1;
		m_M_AttributeSetInstanceName = null;
		m_M_Locator_ID = 0;
		int row = m_table.getSelectedRow();
		boolean enabled = row != -1;
		if (enabled)
		{
			Integer ID = m_table.getSelectedRowKey();
			if (ID != null)
			{
				m_M_AttributeSetInstance_ID = ID.intValue();
				m_M_AttributeSetInstanceName = (String)m_table.getValueAt(row, 1);
				/*
				Object oo = m_table.getValueAt(row, 5);
				if (oo instanceof KeyNamePair)
				{
					KeyNamePair pp = (KeyNamePair)oo;
					m_M_Locator_ID = pp.getKey();
				}*/
			}
		}
		confirmPanel.getButton("Ok").setEnabled(enabled);
		if (log.isLoggable(Level.FINE)) log.fine("M_AttributeSetInstance_ID=" + m_M_AttributeSetInstance_ID 
			+ " - " + m_M_AttributeSetInstanceName
			+ "; M_Locator_ID=" + m_M_Locator_ID);
	}	//	enableButtons

	//TODO: double click support for WListbox
	/**
	 *  Mouse Clicked
	 *  @param e event
	 */
	/*
	public void mouseClicked(MouseEvent e)
	{
		//  Double click with selected row => exit
		if (e.getClickCount() > 1 && m_table.getSelectedRow() != -1)
		{
			enableButtons();
			dispose();
		}
	}*/   //  mouseClicked


	/**
	 * 	Get Attribute Set Instance
	 *	@return M_AttributeSetInstance_ID or -1
	 */
	public int getM_AttributeSetInstance_ID()
	{
		return m_M_AttributeSetInstance_ID;
	}	//	getM_AttributeSetInstance_ID

	/**
	 * 	Get Instance Name
	 * 	@return Instance Name
	 */
	public String getM_AttributeSetInstanceName()
	{
		return m_M_AttributeSetInstanceName;
	}	//	getM_AttributeSetInstanceName

	/**
	 * 	Get Locator
	 *	@return M_Locator_ID or 0
	 */
	public int getM_Locator_ID()
	{
		return m_M_Locator_ID;
	}	//	getM_Locator_ID

}	//	PAttributeInstance