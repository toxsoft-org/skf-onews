package org.toxsoft.skf.onews.mws.e4.addons;

import org.eclipse.e4.core.contexts.*;
import org.toxsoft.core.tsgui.mws.bases.*;
import org.toxsoft.skf.onews.mws.*;

/**
 * Plugin's addon.
 *
 * @author hazard157
 */
public class AddonSkOneWsMws
    extends MwsAbstractAddon {

  /**
   * Constructor.
   */
  public AddonSkOneWsMws() {
    super( Activator.PLUGIN_ID );
  }

  // ------------------------------------------------------------------------------------
  // MwsAbstractAddon
  //

  @Override
  protected void initApp( IEclipseContext aAppContext ) {
    // nop
  }

  @Override
  protected void initWin( IEclipseContext aWinContext ) {
    ISkOneWsMwsConstants.init( aWinContext );
  }

}
