package com.jboss.embedded.testng;

import javax.ejb.Local;

/**
 *  This is the local interface for the service HelloWorld
 * @author Hocine Grine
 *
 */
@Local
public interface HelloWorldServiceLocal {
	
	public void print();
}
