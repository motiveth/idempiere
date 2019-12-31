/******************************************************************************
 * Copyright (C) 2012 Heng Sin Low                                            *
 * Copyright (C) 2012 Trek Global                 							  *
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
package org.adempiere.base;

import org.compiere.process.ProcessCall;
import org.compiere.process.ProcessInfo;

/**
 * 
 * @author hengsin
 *
 */
public interface IProcessFactory {

	/**
	 * Create new process instance
	 * @param className
	 * @return new process instance
	 */
	public ProcessCall newProcessInstance(String className);
	
	/**
	 * for backward compatible, all implement will forward caller to {@link #newProcessInstance(String)} with pi = null
	 * @param className
	 * @param pi
	 * @return
	 */
	public default ProcessCall newProcessInstance(String className, ProcessInfo pi) {
		return newProcessInstance (className);
	}
	
	/**
	 * new interface for {@link IProcessFactory}, help developer focus to implement {@link #newProcessInstance(String, ProcessInfo)}
	 * @author hieplq
	 *
	 */
	public interface IProcessFactoryNew extends IProcessFactory{
		/**
		 * backward compatible, implement by default function. Extend hasn't care about this function.
		 */
		@Override
		public default ProcessCall newProcessInstance(String className) {
			return newProcessInstance (className, null);
		}
		
		/**
		 * take care, pi can be null
		 */
		@Override
		public ProcessCall newProcessInstance(String className, ProcessInfo pi);
	}
	
}
