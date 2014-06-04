package org.andromda.timetracker.service;

import javax.ejb.Local;

/**
 * This is the local interface for the service HelloWorld
 */
@Local
public interface HelloWorldServiceLocal
{

    public void print();
}
