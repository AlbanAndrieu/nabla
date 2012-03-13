// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.List;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.FrontEndController;

/**
 * A controller is assigned as the context of a use-case. All manual implementation is done in the
 * controller as Gui actions may result in deferring method calls to this controller.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiController
    extends FrontEndController
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiControllerMetaType();

    /**
     * Returns all the arguments found in this controller's operations. Please note that return
     * types are excluded from this collection.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getAllArguments();

    /**
     * The bean name of this controller (this is what is stored in the JSF configuration file).
     * @return String
     */
    public String getBeanName();

    /**
     * The calculated serial version UID for this controller.
     * @return String
     */
    public String getControllerSerialVersionUID();

    /**
     * The full path to this controller (that is the full file system path made up from the package
     * and name).
     * @return String
     */
    public String getFullPath();

    /**
     * The fully qualified implementation name of this controller.
     * @return String
     */
    public String getFullyQualifiedImplementationName();

    /**
     * The fully qualified path to the controller implemention file.
     * @return String
     */
    public String getFullyQualifiedImplementationPath();

    /**
     * The implementation name of this controller.
     * @return String
     */
    public String getImplementationName();

    /**
     * All dependencies to a front-end JSF session object.
     * @return List<DependencyFacade>
     */
    public List<DependencyFacade> getSessionObjectReferences();

    /**
     * The session objects that this controller has access to.
     * @return List<GuiSessionObject>
     */
    public List<GuiSessionObject> getSessionObjects();
}