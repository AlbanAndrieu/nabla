package com.jboss.embedded.testng;

import javax.ejb.Local;

/**
 *  This is the local interface for the service HelloWorld
 */
@Local
public interface HelloWorldServiceLocal
{

    public void print();
}
