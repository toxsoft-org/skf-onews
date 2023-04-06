package org.toxsoft.skf.onews.gui;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.toxsoft.core.tsgui.bricks.quant.AbstractQuant;
import org.toxsoft.skf.onews.gui.km5.KM5OneWsContributor;
import org.toxsoft.skf.onews.lib.impl.SkExtServOneWs;
import org.toxsoft.uskat.core.gui.km5.KM5Utils;
import org.toxsoft.uskat.core.impl.SkCoreUtils;

/**
 * The library quant.
 *
 * @author hazard157
 */
public class QuantSkOneWsGui
    extends AbstractQuant {

  /**
   * Constructor.
   */
  public QuantSkOneWsGui() {
    super( QuantSkOneWsGui.class.getSimpleName() );
    KM5Utils.registerContributorCreator( KM5OneWsContributor.CREATOR );
    SkCoreUtils.registerSkServiceCreator( SkExtServOneWs.CREATOR );
  }

  @Override
  protected void doInitApp( IEclipseContext aAppContext ) {
    // nop
  }

  @Override
  protected void doInitWin( IEclipseContext aWinContext ) {
    ISkOneWsGuiConstants.init( aWinContext );
  }

}
