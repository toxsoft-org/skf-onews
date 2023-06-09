package org.toxsoft.skf.onews.gui.km5;

import static org.toxsoft.core.tsgui.m5.gui.mpc.IMultiPaneComponentConstants.*;
import static org.toxsoft.core.tslib.av.impl.AvUtils.*;
import static org.toxsoft.uskat.core.ISkHardConstants.*;

import org.toxsoft.core.tsgui.bricks.ctx.ITsGuiContext;
import org.toxsoft.core.tsgui.m5.gui.mpc.impl.MultiPaneComponentModown;
import org.toxsoft.core.tsgui.m5.gui.panels.IM5CollectionPanel;
import org.toxsoft.core.tsgui.m5.gui.panels.impl.M5CollectionPanelMpcModownWrapper;
import org.toxsoft.core.tsgui.m5.model.IM5ItemsProvider;
import org.toxsoft.core.tsgui.m5.model.IM5LifecycleManager;
import org.toxsoft.core.tsgui.m5.model.impl.M5AttributeFieldDef;
import org.toxsoft.core.tsgui.m5.model.impl.M5DefaultPanelCreator;
import org.toxsoft.core.tsgui.m5.std.fields.*;
import org.toxsoft.core.tslib.utils.errors.TsNullArgumentRtException;
import org.toxsoft.skf.onews.lib.IOneWsAbility;
import org.toxsoft.skf.onews.lib.ISkOneWsService;
import org.toxsoft.uskat.core.connection.ISkConnection;
import org.toxsoft.uskat.core.gui.conn.ISkConnectionSupplier;
import org.toxsoft.uskat.core.gui.km5.KM5ConnectedModelBase;

/**
 * M5-model of entities {@link IOneWsAbility}.
 * <p>
 * The model is onlu to list abilities from {@link ISkOneWsService#listKnownAbilities()}.
 *
 * @author dima
 */
public class OneWsAbilityM5Model
    extends KM5ConnectedModelBase<IOneWsAbility> {

  /**
   * The model ID.
   */
  public static final String MODEL_ID = SK_ID + ".km5.OneWsAbility"; //$NON-NLS-1$

  /**
   * Field {@link IOneWsAbility#id()}.
   */
  public final M5AttributeFieldDef<IOneWsAbility> ID = new M5StdFieldDefId<>();

  /**
   * Field {@link IOneWsAbility#nmName()}.
   */
  public final M5AttributeFieldDef<IOneWsAbility> NAME = new M5StdFieldDefName<>();

  /**
   * Field {@link IOneWsAbility#description()}.
   */
  public final M5AttributeFieldDef<IOneWsAbility> DESCRIPTION = new M5StdFieldDefDescription<>();

  /**
   * Constructor.
   *
   * @param aConn {@link ISkConnection} - the connection
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  public OneWsAbilityM5Model( ISkConnection aConn ) {
    super( MODEL_ID, IOneWsAbility.class, aConn );
    addFieldDefs( ID, NAME, DESCRIPTION );
    setPanelCreator( new M5DefaultPanelCreator<>() {

      @Override
      protected IM5CollectionPanel<IOneWsAbility> doCreateCollChecksPanel( ITsGuiContext aContext,
          IM5ItemsProvider<IOneWsAbility> aItemsProvider ) {
        OPDEF_IS_ACTIONS_CRUD.setValue( aContext.params(), AV_FALSE );
        OPDEF_IS_SUPPORTS_TREE.setValue( aContext.params(), AV_TRUE );
        OPDEF_IS_SUPPORTS_CHECKS.setValue( aContext.params(), AV_TRUE );
        OPDEF_IS_FILTER_PANE.setValue( aContext.params(), AV_TRUE );
        OPDEF_IS_DETAILS_PANE.setValue( aContext.params(), AV_TRUE );
        MultiPaneComponentModown<IOneWsAbility> mpc =
            new OneWsAbilityMpc( skConn(), aContext, model(), aItemsProvider );
        return new M5CollectionPanelMpcModownWrapper<>( mpc, false );
      }

    } );
  }

  @Override
  protected IM5LifecycleManager<IOneWsAbility> doCreateDefaultLifecycleManager() {
    ISkConnectionSupplier connSup = tsContext().get( ISkConnectionSupplier.class );
    return new OneWsAbilityM5LifecycleManager( this, connSup.defConn() );
  }

  @Override
  protected IM5LifecycleManager<IOneWsAbility> doCreateLifecycleManager( Object aMaster ) {
    return new OneWsAbilityM5LifecycleManager( this, ISkConnection.class.cast( aMaster ) );
  }

}
