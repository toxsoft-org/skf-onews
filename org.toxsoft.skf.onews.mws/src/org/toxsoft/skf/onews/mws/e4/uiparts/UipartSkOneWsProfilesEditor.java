package org.toxsoft.skf.onews.mws.e4.uiparts;

import org.toxsoft.core.tsgui.bricks.ctx.ITsGuiContext;
import org.toxsoft.core.tsgui.bricks.ctx.impl.TsGuiContext;
import org.toxsoft.core.tsgui.widgets.TsComposite;
import org.toxsoft.core.tslib.bricks.strid.more.IdChain;
import org.toxsoft.skf.onews.gui.panel.PanelOneWsProfilesEditor;
import org.toxsoft.uskat.core.gui.conn.ISkConnectionSupplier;
import org.toxsoft.uskat.core.gui.e4.uiparts.SkMwsAbstractPart;

/**
 * Uipart contains {@link PanelOneWsProfilesEditor}.
 * <p>
 * By default sets {@link PanelOneWsProfilesEditor#getUsedConnectionId()} to <code>null</code> using Sk-connection
 * {@link ISkConnectionSupplier#defConn()} for roles management.
 * <p>
 * TODO add an ability to specify {@link IdChain} of used connection
 *
 * @author hazard157
 */
public class UipartSkOneWsProfilesEditor
    extends SkMwsAbstractPart {

  PanelOneWsProfilesEditor rolesEditor;

  @Override
  protected void doCreateContent( TsComposite aParent ) {
    ITsGuiContext ctx = new TsGuiContext( tsContext() );
    rolesEditor = new PanelOneWsProfilesEditor( ctx, null );
    rolesEditor.createControl( aParent );
  }

}
