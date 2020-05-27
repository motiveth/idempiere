package org.compiere.apps.wf;
import org.compiere.wf.MWFNode;
import org.compiere.wf.MWorkflow;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 * add factory for all stuff relate Workflow Editor
 * start with Widget
 * @author hieplq
 *
 */
public interface IWFEditorFactory {
	/**
	 * 
	 * @param graphScene
	 * @param wfNote
	 * @param docRecordId on case draw workflow for document record
	 * @return
	 */
	public Widget getWidgetForNote(Scene graphScene, MWFNode wfNote, MWorkflow wf, int docRecordId);
}
