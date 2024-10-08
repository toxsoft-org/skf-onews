package org.toxsoft.skf.onews.lib;

import static org.toxsoft.core.tslib.av.EAtomicType.*;
import static org.toxsoft.core.tslib.av.impl.AvUtils.*;
import static org.toxsoft.core.tslib.av.metainfo.IAvMetaConstants.*;
import static org.toxsoft.skf.onews.lib.ISkResources.*;
import static org.toxsoft.uskat.core.ISkHardConstants.*;

import org.toxsoft.core.tslib.av.impl.*;
import org.toxsoft.core.tslib.av.metainfo.*;
import org.toxsoft.core.tslib.av.opset.impl.*;
import org.toxsoft.core.tslib.bricks.keeper.*;
import org.toxsoft.core.tslib.bricks.strid.*;
import org.toxsoft.core.tslib.bricks.strid.coll.*;
import org.toxsoft.core.tslib.bricks.strid.coll.impl.*;
import org.toxsoft.core.tslib.bricks.strid.impl.*;
import org.toxsoft.core.tslib.coll.basis.*;
import org.toxsoft.core.tslib.coll.helpers.*;
import org.toxsoft.core.tslib.coll.primtypes.*;
import org.toxsoft.core.tslib.coll.primtypes.impl.*;
import org.toxsoft.core.tslib.gw.skid.*;
import org.toxsoft.uskat.core.api.sysdescr.dto.*;
import org.toxsoft.uskat.core.api.users.*;
import org.toxsoft.uskat.core.impl.dto.*;

// TODO TRANSLATE.

/**
 * Constants f the service {@link ISkOneWsService}.
 *
 * @author hazard157
 */
public interface IOneWsConstants {

  /**
   * Prefix for builtin kinds and abilities.
   */
  String OWS_ID = SK_ID + ".onews"; //$NON-NLS-1$

  /**
   * ID of class {@link IOneWsProfile}.
   */
  String CLSID_OWS_PROFILE = OWS_ID + ".Profile"; //$NON-NLS-1$

  /**
   * Identifier of builting root profile.
   * <p>
   * Root profile always allows all abilities and components of OneWS.
   */
  String OWS_ID_PROFILE_ROOT = OWS_ID + ".profile.root"; //$NON-NLS-1$

  /**
   * SKID of profile {@link #OWS_ID_PROFILE_ROOT}.
   */
  Skid OWS_SKID_PROFILE_ROOT = new Skid( CLSID_OWS_PROFILE, OWS_ID_PROFILE_ROOT );

  /**
   * ID of builting guest profile.
   * <p>
   * Root profile always denies all abilities and components of OneWS.
   */
  String OWS_ID_PROFILE_GUEST = OWS_ID + ".profile.guest"; //$NON-NLS-1$

  /**
   * SKID of profile {@link #OWS_ID_PROFILE_GUEST}.
   */
  Skid OWS_SKID_PROFILE_GUEST = new Skid( CLSID_OWS_PROFILE, OWS_ID_PROFILE_GUEST );

  /**
   * Builtin profile IDs.
   */
  IStringList OWS_BUILTIN_PROFILE_IDS = new StringArrayList( //
      OWS_ID_PROFILE_ROOT, //
      OWS_ID_PROFILE_GUEST //
  );

  /**
   * ID of builtin kind - ability to open perspectives.
   */
  String OWS_KIND_ID_PERSPECTIVE = OWS_ID + ".kind.perspective"; //$NON-NLS-1$

  /**
   * ID of builtin kind - ability to run an action.
   */
  String OWS_KIND_ID_ACTION = OWS_ID + ".kind.action"; //$NON-NLS-1$

  /**
   * List o builtin kinds.
   */
  IStridablesList<IStridableParameterized> BUILTIN_ABILITY_KINDS = new StridablesList<>( //
      StridableParameterized.create( OWS_KIND_ID_PERSPECTIVE, //
          TSID_NAME, STR_N_KIND_PERSPECTIVE, //
          TSID_DESCRIPTION, STR_D_KIND_PERSPECTIVE//
      ), //
      StridableParameterized.create( OWS_KIND_ID_ACTION, //
          TSID_NAME, STR_N_KIND_ACTION, //
          TSID_DESCRIPTION, STR_D_KIND_ACTION //
      ) //
  );

  /**
   * ID of option {@link #OP_OWS_ABILITY_KIND_ID}.
   */
  String OPID_OWS_ABILITY_KIND_ID = OWS_ID + ".AbilityKindId"; //$NON-NLS-1$

  /**
   * Option of {@link IOneWsAbility#params()}: contains kind ID {@link IOneWsAbility#kindId()}.
   */
  IDataDef OP_OWS_ABILITY_KIND_ID = DataDef.create( OPID_OWS_ABILITY_KIND_ID, STRING, //
      TSID_NAME, STR_N_KIND_ID, //
      TSID_IS_MANDATORY, AV_TRUE, //
      TSID_DESCRIPTION, STR_D_KIND_ID //
  );

  // ------------------------------------------------------------------------------------
  // Profile class

  /**
   * ID of CLOB {@link #CLBINF_PROFILE_RULES}
   */
  String CLBID_PROFILE_RULES = "rules"; //$NON-NLS-1$

  /**
   * Clob {@link IOneWsProfile#rules()}.
   * <p>
   * Important: this CLOB stores list of {@link OneWsRule} stored by {@link IEntityKeeper#coll2str(ITsCollection)}.
   */
  IDtoClobInfo CLBINF_PROFILE_RULES = DtoClobInfo.create2( CLBID_PROFILE_RULES, //
      TSID_NAME, STR_N_PROFILE_ATTR_RULES, //
      TSID_DESCRIPTION, STR_D_PROFILE_ATTR_RULES, //
      TSID_DEFAULT_VALUE, IEntityKeeper.STR_EMPTY_COLLECTION_REPRESENTATION //
  );

  /**
   * ID of attribute {@link #ATRINF_PROFILE_PARAMS}
   */
  String ATRID_PROFILE_PARAMS = "params"; //$NON-NLS-1$

  /**
   * Attribute {@link IOneWsProfile#params()}.
   */
  IDtoAttrInfo ATRINF_PROFILE_PARAMS = DtoAttrInfo.create2( ATRID_PROFILE_PARAMS, DDEF_VALOBJ, //
      TSID_NAME, STR_N_PROFILE_ATTR_PARAMS, //
      TSID_DESCRIPTION, STR_D_PROFILE_ATTR_PARAMS, //
      TSID_DEFAULT_VALUE, OptionSetKeeper.AV_EMPTY_OPSET //
  );

  /**
   * ID of link #
   */
  String LNKID_ROLES = "roles"; //$NON-NLS-1$

  /**
   * Link {@link IOneWsProfile#profileRoles()}.
   */
  IDtoLinkInfo LNKINF_PROFILE_ROLES = DtoLinkInfo.create2( LNKID_ROLES, //
      new SingleStringList( ISkRole.CLASS_ID ), CollConstraint.NONE, //
      TSID_NAME, STR_N_PROFILE_ATTR_ROLES, //
      TSID_DESCRIPTION, STR_D_PROFILE_ATTR_ROLES //
  );

}
