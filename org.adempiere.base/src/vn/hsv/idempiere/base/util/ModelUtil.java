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

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.I_C_Order;
import org.compiere.model.I_C_OrderLine;
import org.compiere.model.I_M_InOut;
import org.compiere.model.I_M_InOutLine;
import org.compiere.model.I_M_Product;
import org.compiere.model.I_M_StorageOnHand;
import org.compiere.model.MStorageOnHand;
import org.compiere.model.MStorageReservation;
import org.compiere.model.MTransaction;

/**
 * @author hieplq@hasuvimex.vn:Dec 20, 2015
 *
 */
public class ModelUtil {
	public static boolean isShipmmentLine (IOrderLineLink provideOrderInfo){
		if (provideOrderInfo instanceof I_M_InOutLine){
			I_M_InOutLine shipmentLine = (I_M_InOutLine)provideOrderInfo;
			I_M_InOut shipment = shipmentLine.getM_InOut();
			return shipment.isSOTrx();
		}
		return false;
	}
	
	public static boolean isTrackingByOrderLine (IOrderLineLink provideOrderInfo){
		if (provideOrderInfo.getOrderRef() == null){
			return false;
		}
		
		return provideOrderInfo.getOrderRef().isTrackingInfo();
	}
	
	public static void setOrderLinkForTransaction (IOrderLineLink provideOrderInfo, MTransaction transaction){
		I_C_OrderLine olRef = provideOrderInfo.getOrderLineRef();
		if (olRef != null && olRef.getC_OrderLine_ID() != 0){
			if (isShipmmentLine(provideOrderInfo) && !provideOrderInfo.getOrderRef().isTrackingInfo()){
				return;// don't set transaction for shipment in case order mark is not tracking
			}
			
			if (provideOrderInfo.getOrderRef().isTrackingInfo()){
				transaction.setC_OrderLine_ID(provideOrderInfo.getOrderLineRefID());
				transaction.setC_Order_ID(provideOrderInfo.getOrderRefID());
			}else{
				throw new AdempiereException("By wrong way, you set tracking follow order line for order line without isTrackingInfo");
			}
		}
	}
	
	public static I_C_Order implementGetOrderRef (IOrderLineLink providerOrder){
		I_C_OrderLine orderLine = providerOrder.getOrderLineRef();
		if (orderLine == null)
			return null;
		
		return orderLine.getC_Order();
	}
	
	public static int implementGetOrderRefID (IOrderLineLink providerOrder){
		
		if (providerOrder.getOrderLineRefID() == 0)
			return 0;
		
		return providerOrder.getOrderRef().getC_Order_ID();
	}
	
	public static int implementGetOrderRefIDFromParent (IOrderLineLink parent){
		return parent.getOrderRefID();
	}
	
	public static I_C_Order implementGetOrderRefFromParent (IOrderLineLink parent){
		return parent.getOrderRef();
	}
	
	public static int implementGetOrderLineRefIDFromParent (IOrderLineLink parent){
		return parent.getOrderLineRefID();
	}
	
	public static I_C_OrderLine implementGetOrderLineRefFromParent (IOrderLineLink parent){
		return parent.getOrderLineRef();
	}
	
	public static Boolean implementCheckMatchRequirement (I_M_Product product){
		if (product == null)
			return null;
		return new Boolean(product.isMatchRequirement());
	}
	
	public static void setOrderLinkForStorageOnhand (IOrderLineLink provideOrderInfo, MStorageOnHand storage){
		I_C_OrderLine olRef = provideOrderInfo.getOrderLineRef();
		if (olRef != null && olRef.getC_OrderLine_ID() != 0){
			if (isShipmmentLine(provideOrderInfo) && !provideOrderInfo.getOrderRef().isTrackingInfo()){
				return;// don't set transaction for shipment in case order mark is not tracking
			}
			
			if (provideOrderInfo.getOrderRef().isTrackingInfo()){
				storage.setC_OrderLine_ID(provideOrderInfo.getOrderLineRefID());
				storage.setC_Order_ID(provideOrderInfo.getOrderRefID());
			}else{
				throw new AdempiereException("By wrong way, you set tracking follow order line for order line without isTrackingInfo");
			}
		}
		
	}
	
	public static void setOrderLinkForStorageReservation (IOrderLineLink provideOrderInfo, MStorageReservation storage){
		if (provideOrderInfo.getOrderLineRef() != null){
			storage.setC_OrderLine_ID(provideOrderInfo.getOrderLineRefID());
			storage.setC_Order_ID(provideOrderInfo.getOrderRefID());
		}
	}
	
	public static String appendOrderClause (String tableAlias, String sqlWhere, ITrackingProduct provideOrderInfo, boolean appendAnd){
		String clName = I_M_StorageOnHand.COLUMNNAME_C_OrderLine_ID;
		if (tableAlias != null && tableAlias.trim().length() > 0)
			clName = tableAlias + "." + clName;
		
		if (appendAnd)
			sqlWhere = sqlWhere + " AND ";
		
		if (!isTrackingByOrderLine (provideOrderInfo)){
			sqlWhere += clName + " IS NULL ";
			return sqlWhere;
		}
		
		if (provideOrderInfo.getOrderLineRefID() == 0)
			sqlWhere += "COALESCE (" + clName + ", 0) = ? ";
		else
			sqlWhere += clName + "=? ";
		
		return sqlWhere;
	}
	
}
