/******************************************************************************
 * Product: Idempiere ERP & CRM Smart Business Solution                       *
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
 *****************************************************************************/

package vn.hsv.idempiere.base.util;

import org.compiere.model.I_C_Order;
import org.compiere.model.I_C_OrderLine;

/**
 * @author hieplq@hasuvimex.vn:Dec 20, 2015
 * for tracking product use for order. 
 * when in/out move to warehouse, product will add order line info.
 * this interface to get order line info
 */
public interface IOrderLineLink {
	public I_C_OrderLine getOrderLineRef ();
	public I_C_Order getOrderRef ();
	public int getOrderLineRefID ();
	public int getOrderRefID ();
}
