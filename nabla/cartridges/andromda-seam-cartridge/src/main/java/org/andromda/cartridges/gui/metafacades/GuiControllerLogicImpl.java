package org.andromda.cartridges.gui.metafacades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.andromda.cartridges.gui.GuiGlobals;
import org.andromda.cartridges.gui.GuiUtils;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.utils.StringUtilsHelper;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiController.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiController
 */
public class GuiControllerLogicImpl extends GuiControllerLogic {
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiControllerLogicImpl(final Object metaObject, final String context) {
        super(metaObject, context);
    }

    /**
     * @return implementationName
     * @see org.andromda.cartridges.gui.metafacades.GuiController#getImplementationName()
     */
    @Override
    protected String handleGetImplementationName() {
        final String pattern = ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.CONTROLLER_IMPLEMENTATION_PATTERN));
        return pattern.replaceFirst("\\{0\\}", StringUtils.capitalize(this.getName()));
    }

    /**
     * @return fullyQualifiedImplementationName
     * @see org.andromda.cartridges.gui.metafacades.GuiController#getFullyQualifiedImplementationName()
     */
    @Override
    protected String handleGetFullyQualifiedImplementationName() {
        final StringBuilder fullyQualifiedName = new StringBuilder();
        final String packageName = this.getPackageName();
        if (StringUtils.isNotBlank(packageName)) {
            fullyQualifiedName.append(packageName + ".");
        }
        return fullyQualifiedName.append(this.getImplementationName()).toString();
    }

    /**
     * @return getFullyQualifiedImplementationName().replace(".", GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiController#getFullyQualifiedImplementationPath()
     */
    @Override
    protected String handleGetFullyQualifiedImplementationPath() {
        return this.getFullyQualifiedImplementationName().replace(".", GuiGlobals.SEPARATOR);
    }

    /**
     * @return StringUtilsHelper.lowerCamelCaseName(this.getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiController#getBeanName()
     */
    @Override
    protected String handleGetBeanName() {
        return StringUtilsHelper.lowerCamelCaseName(this.getName());
    }

    /**
     * @return references
     * @see org.andromda.cartridges.gui.metafacades.GuiController#getSessionObjectReferences()
     */
    @Override
    protected List<DependencyFacade> handleGetSessionObjectReferences() {
        final List<DependencyFacade> references = new ArrayList<DependencyFacade>(this.getSourceDependencies());
        for (final Iterator<DependencyFacade> iterator = references.iterator(); iterator.hasNext();) {
            final ModelElementFacade targetElement = (iterator.next()).getTargetElement();
            if (!(targetElement instanceof GuiSessionObject)) {
                iterator.remove();
            }
        }
        return references;
    }

    /**
     * @return controllerSerialVersionUID
     * @see org.andromda.cartridges.gui.metafacades.GuiController#getControllerSerialVersionUID()
     */
    @Override
    protected String handleGetControllerSerialVersionUID() {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(this.getFullyQualifiedImplementationName());
        this.addSerialUIDData(buffer);
        return GuiUtils.calcSerialVersionUID(buffer);
    }

    private void addSerialUIDData(final StringBuilder buffer) {
        for (final FrontEndAction action : this.getUseCase().getActions()) {
            buffer.append(action.getName());
        }
    }

    @Override
    protected java.lang.String handleGetFullPath() {

        return GuiGlobals.SEPARATOR + this.getPackageName().replace(".", GuiGlobals.SEPARATOR) + GuiGlobals.SEPARATOR + this.getName();

    }

    /**
     * @return getSourceDependencies().getTargetElement() GuiSessionObject
     * @see org.andromda.cartridges.gui.metafacades.GuiController#getSessionObjects()
     */
    @Override
    protected List<GuiSessionObject> handleGetSessionObjects() {
        final List<GuiSessionObject> objectsList = new ArrayList<GuiSessionObject>();

        for (final DependencyFacade dependency : this.getSourceDependencies()) {
            final ModelElementFacade modelElement = dependency.getTargetElement();
            if (modelElement instanceof GuiSessionObject) {
                objectsList.add((GuiSessionObject) modelElement);
            }
        }

        return objectsList;
    }

    /**
     * @return getOperations().getArguments()
     * @see org.andromda.cartridges.gui.metafacades.GuiController#getAllArguments()
     */
    @Override
    protected List<ParameterFacade> handleGetAllArguments() {
        final List<ParameterFacade> allArguments = new ArrayList<ParameterFacade>();
        for (final OperationFacade operationFacade : this.getOperations()) {
            for (final ParameterFacade parameterFacade : operationFacade.getArguments()) {
                allArguments.add(parameterFacade);
            }
        }

        return allArguments;
    }
}
