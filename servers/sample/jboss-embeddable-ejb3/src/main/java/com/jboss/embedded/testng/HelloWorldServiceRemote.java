package com.jboss.embedded.testng;

import javax.ejb.Remote;

/**
 * This is the remote interface for the service HelloWorld
 */
@Remote
public interface HelloWorldServiceRemote
{

    public void print();
}
