/******************************************************************************
 * Copyright (C) 2012 iDempiere                                               *
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/

package org.compiere.util;

import java.util.Properties;

/**
 * wrapper class for info of Env update event  
 * @author hieplq
 *
 */
public class EnvUpdateEventInfo {
	public Properties ctx; 
	public int WindowNo;
	public int TabNo;
	public String context;
	public Object value;
	public Object oldValue;
	public EnvUpdateEventInfo (Properties ctx, int WindowNo, int TabNo, String context, Object value, Object oldValue){
		this.ctx = ctx;
		this.WindowNo = WindowNo;
		this.TabNo = TabNo;
		this.context = context;
		this.value = value;
		this.oldValue = oldValue;
	}
}
