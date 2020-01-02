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
import org.compiere.model.I_M_AttributeSetInstance;

/**
 * @author hieplq@hasuvimex.vn:Jan 3, 2016
 *
 */
public class NullProviderOrderInfo implements ITrackingProduct {

	public static NullProviderOrderInfo NULL = new NullProviderOrderInfo();
	
	/* (non-Javadoc)
	 * @see vn.hsv.idempiere.base.util.IOrderLineLink#getOrderLineRef()
	 */
	@Override
	public I_C_OrderLine getOrderLineRef() {
		return null;
	}

	/* (non-Javadoc)
	 * @see vn.hsv.idempiere.base.util.IOrderLineLink#getOrderRef()
	 */
	@Override
	public I_C_Order getOrderRef() {
		return null;
	}

	/* (non-Javadoc)
	 * @see vn.hsv.idempiere.base.util.IOrderLineLink#getOrderLineRefID()
	 */
	@Override
	public int getOrderLineRefID() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see vn.hsv.idempiere.base.util.IOrderLineLink#getOrderRefID()
	 */
	@Override
	public int getOrderRefID() {
		return 0;
	}

	@Override
	public int getAsiID() {
		return 0;
	}

	@Override
	public I_M_AttributeSetInstance getAsi() {
		return null;
	}

	@Override
	public Boolean isMatchRequirementASI() {
		return null;
	}

}
