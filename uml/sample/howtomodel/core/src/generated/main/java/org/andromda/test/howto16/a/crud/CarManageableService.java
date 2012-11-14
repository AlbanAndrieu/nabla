// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by crud/ManageableServiceRemote.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto16.a.crud;

import java.util.List;
import java.util.Map;
import org.andromda.test.howto16.a.CarType;

/**
 * Manageable service bean remote interface
 */
public interface CarManageableService
{
    public CarValueObject create(String serial, String name, CarType type, String owner)
        throws CarCreateManageableException;


    public CarValueObject readById(String serial)
        throws CarReadManageableException;    
        
    public List read(String serial, String name, CarType type, String owner)
        throws CarReadManageableException;

    public List readAll()
        throws CarReadManageableException;

    public Map readBackingLists()
        throws CarReadManageableException;

    public CarValueObject update(String serial, String name, CarType type, String owner)
        throws CarUpdateManageableException;

    public void delete(String[] ids)
        throws CarDeleteManageableException;

}