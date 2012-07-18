// license-header java merge-point
// Generated by andromda-jsf cartridge (forms\crud\Form.java.vsl) DO NOT EDIT!
package org.andromda.test.howto16.a.crud;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;

/**
 * 
 * This form encapsulates the fields that are used in the execution of the CRUD operations in Person
 */
public class ManagePersonForm
    implements Serializable
{
    /**
     * Default constructor. Initializes the attribute formatters.
     */
    public ManagePersonForm(){
        DateFormat birthDateDateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        birthDateDateFormatter.setLenient(true);
        this.dateTimeFormatters.put("birthDate", birthDateDateFormatter);
        this.dateTimeFormatters.put("searchForm.birthDate", birthDateDateFormatter);
        // - setup the default Date.toString() formatter
        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        dateFormatter.setLenient(true);
        this.dateTimeFormatters.put(null, dateFormatter);

        this.searchForm = new ManagePersonSearchForm();

        this.editState=false;
    }

    /**
     * Holds the edit/search state of the form
     */
    private boolean editState;

    /**
     * @return editState
     */
    public boolean getEditState(){
        return this.editState;
    }

    /**
     * @param editStateIn
     */
    public void setEditState(boolean editStateIn){
        this.editState = editStateIn;
    }

    private ManagePersonSearchForm searchForm;

    /**
     * @return searchForm
     */
    public ManagePersonSearchForm getSearchForm(){
        return this.searchForm;
    }

    /**
     * @param searchFormIn
     */
    public void setSearchForm(ManagePersonSearchForm searchFormIn){
        this.searchForm = searchFormIn;
    }

    private List manageableList = null;

    /**
     * @return manageableList
     */
    public List getManageableList()
    {
        return this.manageableList;
    }

    /**
     * @param manageableListIn
     */
    public void setManageableList(List manageableListIn)
    {
        this.manageableList = manageableListIn;
    }

    private String[] selectedRows = null;

    /**
     * @return selectedRows
     */
    public String[] getSelectedRows()
    {
        return this.selectedRows;
    }

    /**
     * @param selectedRowsIn
     */
    public void setSelectedRows(String[] selectedRowsIn)
    {
        this.selectedRows = selectedRowsIn;
    }

    private String name;

    /**
     * 
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * 
     * @param nameIn
     */
    public void setName(String nameIn)
    {
        this.name = nameIn;
    }

    private Collection<?> nameBackingList;

    /**
     * @return nameBackingList
     */
    public Collection<?> getNameBackingList(){
        return this.nameBackingList;
    }

    /**
     * @param nameBackingListIn
     */
    public void setNameBackingList(Collection<?> nameBackingListIn){
        this.nameBackingList = nameBackingListIn;
    }

    private Date birthDate;

    /**
     * 
     * @return birthDate
     */
    public Date getBirthDate()
    {
        return this.birthDate;
    }

    /**
     * 
     * @param birthDateIn
     */
    public void setBirthDate(Date birthDateIn)
    {
        this.birthDate = birthDateIn;
    }

    private Collection<?> birthDateBackingList;

    /**
     * @return birthDateBackingList
     */
    public Collection<?> getBirthDateBackingList(){
        return this.birthDateBackingList;
    }

    /**
     * @param birthDateBackingListIn
     */
    public void setBirthDateBackingList(Collection<?> birthDateBackingListIn){
        this.birthDateBackingList = birthDateBackingListIn;
    }

    private String serial;

    /**
     * 
     * @return serial
     */
    public String getSerial()
    {
        return this.serial;
    }

    /**
     * 
     * @param serialIn
     */
    public void setSerial(String serialIn)
    {
        this.serial = serialIn;
    }

    private Collection<?> serialBackingList;

    /**
     * @return serialBackingList
     */
    public Collection<?> getSerialBackingList(){
        return this.serialBackingList;
    }

    /**
     * @param serialBackingListIn
     */
    public void setSerialBackingList(Collection<?> serialBackingListIn){
        this.serialBackingList = serialBackingListIn;
    }


    // Manageable associationEnds in Person
    private String[] cars;

    /**
     * 
     * @return cars
     */
    public String[] getCars()
    {
        return this.cars;
    }

    /**
     * 
     * @param carsIn
     */
    public void setCars(String[] carsIn)
    {
        this.cars = carsIn;
    }

    private Collection carsBackingList;

    /**
     * The current collection of possible values of cars.
     * @return carsBackingList
     */
    public Collection getCarsBackingList(){
        return this.carsBackingList;
    }

    /**
     * The current collection of possible values of cars.
     * @param carsBackingListIn
     */
    public void setCarsBackingList(Collection carsBackingListIn){
        this.carsBackingList = carsBackingListIn;
    }

    /**
     * Stores any date or time formatters for this form.
     */
    private final Map<String,DateFormat> dateTimeFormatters = new HashMap<String,DateFormat>();

    /**
     * Gets any date and time formatters (keyed by property name)
     * for this form.
     *
     * @return the Map containing any date and time formatters.
     */
    public Map<String,DateFormat> getDateTimeFormatters()
    {
        return this.dateTimeFormatters;
    }

    /**
     * The current collection of messages stored within this form.
     */
    private Map<String, FacesMessage> jsfMessages =
        new LinkedHashMap<String, FacesMessage>();

    /**
     * Adds a {@link FacesMessage} message to the current messages
     * stored within this form.
     *
     * @param jsfMessage the faces message to add.
     */
    public void addJsfMessages(FacesMessage jsfMessage)
    {
        if (jsfMessage != null)
        {
            this.jsfMessages.put(jsfMessage.getDetail(), jsfMessage);
        }
    }

    /**
     * Gets the current {@link FacesMessage} message
     * instances stored within this form.
     *
     * @return the current Faces messages.
     */
    public Collection<FacesMessage> getJsfMessages()
    {
        return this.jsfMessages.values();
    }

    /**
     * Sets the current {@link FacesMessage} message
     * instances stored within this form.
     *
     * @param messages a collection of the current Faces messages.
     */
    public void setJsfMessages(final Collection<FacesMessage> messages)
    {
        if (messages != null)
        {
            for (final FacesMessage jsfMessage : messages)
            {
                this.jsfMessages.put(jsfMessage.getDetail(), jsfMessage);
            }
        }
    }

    /**
     * Clear the current {@link FacesMessage} message
     * instances stored within this form.
     */
    public void clearJsfMessages()
    {
        this.jsfMessages.clear();
    }

    /**
     * The faces message title (used on a view).
     */
    private String jsfMessagesTitle;

    /**
     * The optional faces message title to set (used on a view).  If not set, the default title
     * will be used.
     *
     * @param jsfMessagesTitleIn the title to use for the messages on the view.
     */
    public void setJsfMessagesTitle(final String jsfMessagesTitleIn)
    {
        this.jsfMessagesTitle = jsfMessagesTitleIn;
    }

    /**
     * Gets the faces messages title to use.
     *
     * @return the faces messages title.
     */
    public String getJsfMessagesTitle()
    {
        return this.jsfMessagesTitle;
    }

    /**
     * Gets the maximum severity of the messages stored in this form.
     *
     * @return the maximum severity or null if no messages are present and/or severity isn't set.
     */
    public FacesMessage.Severity getMaximumMessageSeverity()
    {
        FacesMessage.Severity maxSeverity = null;
        for (final FacesMessage message : this.getJsfMessages())
        {
            final FacesMessage.Severity severity = message.getSeverity();
            if (maxSeverity == null || (severity != null && severity.getOrdinal() > maxSeverity.getOrdinal()))
            {
                maxSeverity = severity;
            }
        }
        return maxSeverity;
    }

    /**
     * Copy all the properties from the other form to the current form.
     *
     * @param otherForm the form with the source properties to be copied.
     */
    public void copyFrom(ManagePersonForm otherForm){
        this.setName(otherForm.getName());
        this.setNameBackingList(otherForm.getNameBackingList());
        this.setBirthDate(otherForm.getBirthDate());
        this.setBirthDateBackingList(otherForm.getBirthDateBackingList());
        this.setSerial(otherForm.getSerial());
        this.setSerialBackingList(otherForm.getSerialBackingList());
        this.setCars(otherForm.getCars());
        this.setCarsBackingList(otherForm.getCarsBackingList());

        this.setJsfMessages(otherForm.getJsfMessages());
        this.setJsfMessagesTitle(otherForm.getJsfMessagesTitle());

        this.setEditState(otherForm.getEditState());
        this.setSearchForm(otherForm.getSearchForm());
        this.setManageableList(otherForm.getManageableList());
        this.setSelectedRows(otherForm.getSelectedRows());
    }

    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 2620271319911906665L;
}