package org.adempiere.webui.adwindow.validator;

import java.lang.ref.WeakReference;

import org.adempiere.util.Callback;

public interface WindowValidator {
	public void onWindowEvent(WindowValidatorEvent event, Callback<Boolean> callback);
	
	default WeakReference<WindowValidator> getValidatorWeakRef(){
		return null;
	}
	
	default boolean isOnDesktopLive(){
		return true;
	}
}
