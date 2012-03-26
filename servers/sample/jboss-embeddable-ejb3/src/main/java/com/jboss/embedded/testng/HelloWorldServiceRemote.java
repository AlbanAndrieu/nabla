package com.jboss.embedded.testng;

import javax.ejb.Remote;

/**
 * This is the remote interface for the service HelloWorld
 * @author Hocine Grine
 *
 */
@Remote
public interface HelloWorldServiceRemote {

	public void print();
}
