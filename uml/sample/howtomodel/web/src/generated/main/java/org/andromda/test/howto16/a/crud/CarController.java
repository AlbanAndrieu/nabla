// license-header java merge-point
// Generated by andromda-jsf cartridge (controllers\crud\Controller.java.vsl) DO NOT EDIT!
package org.andromda.test.howto16.a.crud;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.andromda.presentation.jsf.ControllerBase;
import org.andromda.presentation.jsf.Messages;
import org.andromda.presentation.jsf.PatternMatchingExceptionHandler;
import org.andromda.test.ManageableServiceLocator;
import org.andromda.test.howto16.a.Car;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Javaserver Faces Controller of the Car CRUD management.
 */
public abstract class CarController
    extends ControllerBase
{
    private static final Log logger = LogFactory.getLog(CarController.class);

    /**
    * Initializes the controller, calling the doInit method
    *
    * @return the controller view path.
    */
    public String init()
    {
        this.resetUseCaseFormsAndPageVariables();

        try
        {
            final ManageCarForm form = this.getForm();

            try
            {
                this.setCurrentActionForm(form);
                this.doInit(form);
            }
            catch (final Throwable throwable)
            {
                final String messageKey = PatternMatchingExceptionHandler.instance().handleException(throwable);
                // - the exception is re-thrown by the exception handler and handled by the catch below if it can't get a messageKey
                //   (no reason to check for presence of messageKey)
                this.addErrorMessage(Messages.get(messageKey, null));
            }
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }
        return "/org/andromda/test/howto16/a/crud/car-crud";
    }

    /**
    * Initializes the controller. This method can be overriden.
    */
    public void doInit(ManageCarForm form)
        throws Exception
    {

        form.getSearchForm().setName(null);
        form.getSearchForm().setType(null);
        form.getSearchForm().setOwner(null);

        form.setManageableList(null);

        final Map<String,?> backingLists = ManageableServiceLocator.instance().getCarManageableService().readBackingLists();
        form.setOwnerBackingList((Collection)backingLists.get("owner"));

        form.setEditState(false);
    }

    /**
    * The instance load action.
    */
    public void load(ActionEvent event)
    {
        try
        {
            final ManageCarForm form = this.getForm();

            try
            {
                this.setCurrentActionForm(form);
                this.doLoad(String.valueOf(((UIParameter)event.getComponent().findComponent("serial")).getValue().toString()),form);
            }
            catch (final Throwable throwable)
            {
                final String messageKey = PatternMatchingExceptionHandler.instance().handleException(throwable);
                // - the exception is re-thrown by the exception handler and handled by the catch below if it can't get a messageKey
                //   (no reason to check for presence of messageKey)
                this.addErrorMessage(Messages.get(messageKey, null));
            }
            resetAllEditableComponentsValues();
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }
    }

    /**
    * Loads the selected instance.
    */
    public void doLoad(String serial, ManageCarForm form)
        throws Exception
    {
        //final CarValueObject vo= ManageableServiceLocator.instance().getCarManageableService().readById(serial);
        final Car vo= ManageableServiceLocator.instance().getCarManageableService().readById(serial);

        form.setSerial(vo.getSerial());
        form.setName(vo.getName());
        form.setType(vo.getType());
        //org.andromda.cartridges.jsf.metafacades.JSFManageableEntityAssociationEndLogicImpl[Car.owner]
        //org.andromda.cartridges.jsf.metafacades.JSFManageableEntityLogicImpl[org.andromda.test.howto16.a.Person]
        //String        
        //org.andromda.metafacades.emf.uml22.ClassifierFacadeLogicImpl[String]
        //getSerial
        form.setOwner(vo.getOwner().getSerial());

        form.setEditState(true);
    }

    /**
    * The cancel edit action
    *
    * @return the controller view path.
    */
    public String cancel()
    {
        try
        {
            final ManageCarForm form = this.getForm();

            try
            {
                this.setCurrentActionForm(form);
                this.doCancel(form);
            }
            catch (final Throwable throwable)
            {
                final String messageKey = PatternMatchingExceptionHandler.instance().handleException(throwable);
                // - the exception is re-thrown by the exception handler and handled by the catch below if it can't get a messageKey
                //   (no reason to check for presence of messageKey)
                this.addErrorMessage(Messages.get(messageKey, null));
            }
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }

        resetAllEditableComponentsValues();
        return null;
    }

    /**
    * Executes the edit cancel.
    */
    public void doCancel(ManageCarForm form)
        throws Exception
    {
        form.setEditState(false);
    }

    /**
    * The new instance action.
    *
    * @return the controller view path.
    */
    public String startNew()
    {
        try
        {
            final ManageCarForm form = this.getForm();

            try
            {
                this.setCurrentActionForm(form);
                this.doStartNew(form);
            }
            catch (final Throwable throwable)
            {
                final String messageKey = PatternMatchingExceptionHandler.instance().handleException(throwable);
                // - the exception is re-thrown by the exception handler and handled by the catch below if it can't get a messageKey
                //   (no reason to check for presence of messageKey)
                this.addErrorMessage(Messages.get(messageKey, null));
            }
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }

        resetAllEditableComponentsValues();
        return null;
    }

    /**
    * Executes the new instance action.
    */
    public void doStartNew(ManageCarForm form)
        throws Exception
    {

        form.setSerial(null);
        form.setName(null);
        form.setType(null);

        form.setOwner(null);

        final Map backingLists = ManageableServiceLocator.instance().getCarManageableService().readBackingLists();
        form.setOwnerBackingList((Collection)backingLists.get("owner"));

        form.setEditState(true);
    }
    /**
    * The save instance action.
    *
    * @return the controller view path.
    */
    public String save()
    {
        try
        {
            final ManageCarForm form = this.getForm();

            try
            {
                this.setCurrentActionForm(form);
                this.doSave(form);
            }
            catch (final Throwable throwable)
            {
                final String messageKey = PatternMatchingExceptionHandler.instance().handleException(throwable);
                // - the exception is re-thrown by the exception handler and handled by the catch below if it can't get a messageKey
                //   (no reason to check for presence of messageKey)
                this.addErrorMessage(Messages.get(messageKey, null));
            }
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }

        resetAllEditableComponentsValues();
        return null;
    }

    /**
    * Saves instance action.
    */
    public void doSave(ManageCarForm form)
        throws Exception
    {

        if(form.getSerial() == null){
            form.setSerial(
                ManageableServiceLocator.instance().getCarManageableService().create(
                    null
                    , form.getName()
                    , form.getType()
                    , form.getOwner()
                ).getSerial()
            );
            this.addInfoMessage(Messages.get("manageable.entity.created", new Object[]{Messages.get("car")}));
        }
        else{
            ManageableServiceLocator.instance().getCarManageableService().update(
                form.getSerial()
                , form.getName()
                , form.getType()
                , form.getOwner()
            );
            this.addInfoMessage(Messages.get("manageable.entity.changed", new Object[]{Messages.get("car")}));
        }
        if(form.getManageableList() != null) //only searches again if there was an old search
            doSearch(form); //search again to show the updated item (if it fits the search criteria)

        form.setEditState(false);
    }

    /**
    * The save and new instance action.
    *
    * @return the controller view path.
    */
    public String saveAndNew()
    {
        try
        {
            final ManageCarForm form = this.getForm();

            try
            {
                this.setCurrentActionForm(form);
                this.doSave(form);
                this.doStartNew(form);
            }
            catch (final Throwable throwable)
            {
                final String messageKey = PatternMatchingExceptionHandler.instance().handleException(throwable);
                // - the exception is re-thrown by the exception handler and handled by the catch below if it can't get a messageKey
                //   (no reason to check for presence of messageKey)
                this.addErrorMessage(Messages.get(messageKey, null));
            }
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }

        resetAllEditableComponentsValues();
        return null;
    }

    /**
    * The search action.
    *
    * @return the controller view path.
    */
    public String search()
    {
        try
        {
            final ManageCarForm form = this.getForm();

            try
            {
                this.setCurrentActionForm(form);
                this.doSearch(form);
            }
            catch (final Throwable throwable)
            {
                final String messageKey = PatternMatchingExceptionHandler.instance().handleException(throwable);
                // - the exception is re-thrown by the exception handler and handled by the catch below if it can't get a messageKey
                //   (no reason to check for presence of messageKey)
                this.addErrorMessage(Messages.get(messageKey, null));
            }
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }

        resetAllEditableComponentsValues();
        return null;
    }

    /**
    * Executes the search action.
    */
    public void doSearch(ManageCarForm form)
        throws Exception
    {
        @SuppressWarnings("rawtypes")
        final List list;
        //if all search fields are null, call readAll()
        if(
             StringUtils.isBlank(form.getSearchForm().getName())
            && form.getSearchForm().getType() == null
            && form.getSearchForm().getOwner() == null
            )
        list=ManageableServiceLocator.instance().getCarManageableService().readAll();
    else
        list = ManageableServiceLocator.instance().getCarManageableService().read(
            null
            , form.getSearchForm().getName()
            , form.getSearchForm().getType()
            , form.getSearchForm().getOwner()
        );

        form.setManageableList(list);
        if (list.size() >= 250)
            saveMaxResultsWarning();

        final Map<String,?> backingLists = ManageableServiceLocator.instance().getCarManageableService().readBackingLists();
        form.setOwnerBackingList((Collection)backingLists.get("owner"));

        form.setEditState(false);
    }

    /**
    * The delete event.
    */
    public void delete(ActionEvent event)
    {
        try
        {
            final ManageCarForm form = this.getForm();

            try
            {
                this.setCurrentActionForm(form);
                this.doDelete(String.valueOf(((UIParameter)event.getComponent().findComponent("serial")).getValue().toString()),form);
            }
            catch (final Throwable throwable)
            {
                final String messageKey = PatternMatchingExceptionHandler.instance().handleException(throwable);
                // - the exception is re-thrown by the exception handler and handled by the catch below if it can't get a messageKey
                //   (no reason to check for presence of messageKey)
                this.addErrorMessage(Messages.get(messageKey, null));
            }
            resetAllEditableComponentsValues();
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }
    }

    /**
    * Deletes the selected instance.
    */
    public void doDelete(String serial, ManageCarForm form)
        throws Exception
    {
        ManageableServiceLocator.instance().getCarManageableService().delete(new String[]{serial});
        this.addInfoMessage(Messages.get("manageable.entity.deleted", new Object[]{Messages.get("car")}));

        doSearch(form);
    }

    /**
    * Shows a message warning the user can exists more records available.
    */
    private void saveMaxResultsWarning()
    {
        addWarningMessage(Messages.get("maximum.results.fetched.warning", new Object[]{String.valueOf("250")}));
    }

    /**
    * Export as ODS spreadsheed
    */
    public String odsExport()
    {
        return "/org/andromda/test/howto16/a/crud/car-ods-export";
    }

    /**
    * Helper method to fill the autocomplete component list.
    */
    public void fillAutocomplete(ActionEvent event)
    {
        final FacesContext facesContext = this.getContext();
        final Map<String,String> parameters = facesContext.getExternalContext().getRequestParameterMap();
        final Object fieldValue = parameters.get(this.getParameterValue("searchFieldRequestParamName",event));
        try{
            @SuppressWarnings("rawtypes")
            final List list = ManageableServiceLocator.instance().getCarManageableService().read(
                (fieldValue==null || fieldValue.toString().length() == 0) ? null : fieldValue.toString()
                , null
                , null
                , null
            );
            final ValueBinding vb = facesContext.getApplication().createValueBinding("#{autocompleteResult}");
            vb.setValue(facesContext, list);
        }
        catch (final Throwable throwable)
        {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
        }
    }

    /**
    * Loads an instance of Car.
    *
    * @return CarValueObject from the loaded entity.
    */
    //static public CarValueObject load(String serial)
    static public Car load(String serial)
    {
        if(serial == null || StringUtils.isBlank(serial))
        {
            return null;
        }
        else
        {
            try
            {
                return ManageableServiceLocator.instance().getCarManageableService().readById(serial);
            }
            catch(Exception e)
            {
                throw new RuntimeException(e);
            }
        }
    }

    /**
    * Helper method to fill the select component list.
    *
    * @return a collection with the filtered list.
    */
    public Collection<SelectItem> getAsSelectItems()
    {
        //final Collection<CarValueObject> vos;
        //final Collection<org.andromda.test.howto16.a.CareValueObject> vos;
        final Collection<Car> vos;   
        try {
            //vos = (Collection<CarValueObject>)ManageableServiceLocator.instance().getCarManageableService().readAll();
            vos = (Collection<Car>)ManageableServiceLocator.instance().getCarManageableService().readAll();
        } catch (final Throwable throwable) {
            logger.error(throwable);
            this.addExceptionMessage(throwable);
            return null;
        }
        final Collection<SelectItem> result=new ArrayList<SelectItem>(vos.size());
        //for(CarValueObject vo: vos){
        for(Car vo: vos){
            result.add(new SelectItem(vo.getSerial(),ObjectUtils.toString(vo.getSerial())));
        }
        return result;
    }

    public static final String FORM_BEAN_NAME="manageCarForm";

    /**
     * Resolves "manageCarForm".
     *
     * @return the manageable form.
     */
    public ManageCarForm getForm()
    {
        final Map<String,Object> forms=getForms();
        ManageCarForm form=(ManageCarForm)forms.get(FORM_BEAN_NAME);
        if(form == null){
            form = new ManageCarForm();
            forms.put(FORM_BEAN_NAME,form);
        }
        return form;
    }

    // crud-controller merge-point

}