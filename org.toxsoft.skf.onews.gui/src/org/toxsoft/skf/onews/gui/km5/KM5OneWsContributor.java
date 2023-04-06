package org.toxsoft.skf.onews.gui.km5;

import org.toxsoft.core.tsgui.m5.IM5Domain;
import org.toxsoft.core.tslib.coll.primtypes.IStringList;
import org.toxsoft.core.tslib.coll.primtypes.impl.StringArrayList;
import org.toxsoft.core.tslib.utils.errors.TsNullArgumentRtException;
import org.toxsoft.skf.onews.lib.ISkOneWsService;
import org.toxsoft.uskat.core.connection.ISkConnection;
import org.toxsoft.uskat.core.gui.km5.IKM5ContributorCreator;
import org.toxsoft.uskat.core.gui.km5.KM5AbstractContributor;

/**
 * Contributes M5-models for {@link ISkOneWsService} manager classes.
 *
 * @author hazard157
 */
public class KM5OneWsContributor
    extends KM5AbstractContributor {

  /**
   * Creator singleton.
   */
  public static final IKM5ContributorCreator CREATOR = KM5OneWsContributor::new;

  private static final IStringList CONRTIBUTED_MODEL_IDS = new StringArrayList( //
      OneWsAbilityM5Model.MODEL_ID, //
      OneWsProfileM5Model.MODEL_ID //
  );

  /**
   * Constructor.
   *
   * @param aConn {@link ISkConnection} - the connection
   * @param aDomain {@link IM5Domain} - connection domain
   * @throws TsNullArgumentRtException any argument = <code>null</code>
   */
  public KM5OneWsContributor( ISkConnection aConn, IM5Domain aDomain ) {
    super( aConn, aDomain );
  }

  @Override
  protected IStringList papiCreateModels() {
    m5().addModel( new OneWsAbilityM5Model( skConn() ) );
    m5().addModel( new OneWsProfileM5Model( skConn() ) );
    return CONRTIBUTED_MODEL_IDS;
  }

}
