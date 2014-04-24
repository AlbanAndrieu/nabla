package com.nabla.project.application.model.message.domain;

/**
 * Author : $author$ Date : $Date: 2010-06-14 12:02:51 +0200 (Thu, 14 Jun 2010) $ Revision : $revision$
 */
public class Party
{
    private String reference;
    private String id;
    private String idVersion;
    private String name;
    private String shortName;

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("<Party id=\"").append(id);
        str.append("\" reference=\"").append(reference);
        str.append("\" idVersion=\"").append(idVersion);
        str.append("\" name=\"").append(name);
        str.append("\" shortName=\"").append(shortName);
        str.append("\" type=\"").append(type);
        str.append("\" />\n");

        return str.toString();
    } // end toString()

    public enum PartyType
    {
        EXTERNAL, AGENCY, PORTFOLIO, OTHER; // end enum
    } // end enum

    private PartyType type;

    /**
     * 
     * @return the id
     */
    public String getId()
    {
        return id;
    } // end getId()

    /**
     * 
     * @param id the id to set
     */
    public void setId(final String id)
    {
        this.id = id;
    } // end setId()

    /**
     * 
     * @return the idVersion
     */
    public String getIdVersion()
    {
        return idVersion;
    } // end getIdVersion()

    /**
     * 
     * @param idVersion the idVersion to set
     */
    public void setIdVersion(final String idVersion)
    {
        this.idVersion = idVersion;
    } // end setIdVersion()

    /**
     * 
     * @return the name
     */
    public String getName()
    {
        return name;
    } // end getName()

    /**
     * 
     * @param name the name to set
     */
    public void setName(final String name)
    {
        this.name = name;
    } // end setName()

    /**
     * 
     * @return the shortName
     */
    public String getShortName()
    {
        return shortName;
    } // end getShortName()

    /**
     * 
     * @param shortName the shortName to set
     */
    public void setShortName(final String shortName)
    {
        this.shortName = shortName;
    } // end setShortName()

    /**
     * 
     * @return the type
     */
    public PartyType getType()
    {
        return type;
    } // end getType()

    /**
     * 
     * @param type the type to set
     */
    public void setType(final PartyType type)
    {
        this.type = type;
    } // end setType()

    public String getReference()
    {
        return reference;
    } // end getReference()

    public void setReference(final String reference)
    {
        this.reference = reference;
    } // end setReference()
} // end Party
