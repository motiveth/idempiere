/**
 *
 */
package org.compiere.apps.wf;


import java.awt.Color;
import java.util.List;

import org.adempiere.base.Service;
import org.compiere.util.Env;
import org.compiere.wf.MWFNode;
import org.compiere.wf.MWFNodeNext;
import org.compiere.wf.MWorkflow;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.layout.LayoutFactory.ConnectionWidgetLayoutAlignment;
import org.netbeans.api.visual.router.RouterFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 * @author hengsin
 *
 */
public class WorkflowGraphScene extends GraphScene<Integer, MWFNodeNext> {

	private LayerWidget mainLayer;
    private LayerWidget connectionLayer;
    private int recordId = -1; // use on case draw WF of current record, use for lookup activity state
    private MWorkflow wf; // to get activity for customize wiget
    private WidgetAction selectAction = createSelectAction();

    public WorkflowGraphScene() {
    	mainLayer = new LayerWidget (this);
    	mainLayer.setBackground(new Color(255,255,255,0));
        connectionLayer = new LayerWidget (this);
        connectionLayer.setBackground(new Color(255,255,255,0));
        addChild (mainLayer);
        addChild (connectionLayer);
        this.setBackground(new Color(255,255,255,0));
    }

    
    /**
    * 	Set record id of current document
    *	@param recordId key of document record
    */
    public void setActivityWfInfo (MWorkflow wf, int recordId){
    	this.recordId = recordId;
    	this.wf = wf;
    }
    
	@Override
	protected void attachEdgeSourceAnchor(MWFNodeNext edge, Integer oldsource,
			Integer sourceNode) {
		((ConnectionWidget) findWidget (edge)).setSourceAnchor (AnchorFactory.createRectangularAnchor (findWidget (sourceNode)));
	}

	@Override
	protected void attachEdgeTargetAnchor(MWFNodeNext edge, Integer oldtarget,
			Integer targetNode) {
		((ConnectionWidget) findWidget (edge)).setTargetAnchor (AnchorFactory.createRectangularAnchor (findWidget (targetNode)));
	}

	@Override
	protected Widget attachEdgeWidget(MWFNodeNext edge) {
		 ConnectionWidget connection = new ConnectionWidget (this);
		 connection.setTargetAnchorShape (AnchorShape.TRIANGLE_FILLED);
		 connection.setRouter (RouterFactory.createOrthogonalSearchRouter (mainLayer, connectionLayer));
		 connection.setRoutingPolicy (ConnectionWidget.RoutingPolicy.ALWAYS_ROUTE);
		 
		 String description = edge.getDescription();
		 if (description != null && description.length() > 0) {
			 description = "{" + String.valueOf(edge.getSeqNo()) 
						+ ": " + description + "}";
			 LabelWidget label = new LabelWidget(this, description);
			 connection.addChild(label);
			 connection.setConstraint (label, ConnectionWidgetLayoutAlignment.TOP_CENTER, 0.5f);
		 }
			
	     connectionLayer.addChild (connection);
	     return connection;
	}

	/**
	 * call factory to create Widget, give a chance for customize it about color,...
	 * @param graphScene
	 * @param wfNote
	 * @param docRecordId
	 * @return
	 */
	public static Widget getFactory (Scene graphScene, MWFNode wfNote, MWorkflow wf, int docRecordId){
		List<IWFEditorFactory> factoryList = Service.locator().list(IWFEditorFactory.class).getServices();
		Widget widget;
        for(IWFEditorFactory factory : factoryList)
        {
        	widget = factory.getWidgetForNote(graphScene, wfNote, wf, docRecordId);
        	if (widget != null)
        		return widget;
        }
        
        return new WFNodeWidget(graphScene, wfNote);
	}
	
	@Override
	protected Widget attachNodeWidget(Integer node) {
		Widget widget = (WFNodeWidget) findWidget(node);
		if (widget == null) {
			widget = WorkflowGraphScene.getFactory(this, MWFNode.get(Env.getCtx(), node), wf, recordId);
			widget.getActions ().addAction (selectAction);
			mainLayer.addChild (widget);
		}
		return widget;
	}
}
