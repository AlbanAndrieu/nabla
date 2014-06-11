/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package com.nabla.project.visma.selenium.tests.helper;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * DOCUMENT ME! albandri.
 * 
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class JQuerySeleniumHelper
{

    public static void injectjQueryIfNeeded(final WebDriver driver)
    {
        if (!JQuerySeleniumHelper.jQueryLoaded(driver))
        {
            JQuerySeleniumHelper.injectjQuery(driver);
        }
    }

    /**
     * DOCUMENT ME! albandri.
     */
    private static void injectjQuery(final WebDriver driver)
    {
        final JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" var headID = document.getElementsByTagName(\"head\")[0];);" + "var newScript = document.createElement('script');" + "newScript.type = 'text/javascript';"
                + "newScript.src = 'http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js';" + "headID.appendChild(newScript);");

    }

    /**
     * DOCUMENT ME! albandri.
     * 
     * @return
     */
    private static boolean jQueryLoaded(final WebDriver driver)
    {
        Boolean loaded;
        try
        {
            final JavascriptExecutor js = (JavascriptExecutor) driver;
            loaded = (Boolean) js.executeScript("return jQuery()!=null");
        } catch (final WebDriverException e)
        {
            loaded = false;
        }
        return loaded;
    }

    @SuppressWarnings("unchecked")
    public List<WebElement> getSelectedCheckbox(final WebDriver driver)
    {

        // Create an instance of JavaScript Executor from driver
        final JavascriptExecutor js = (JavascriptExecutor) driver;

        // Locate all the Checkbox which are checked by calling jQuery find() method.
        // find() method returns elements in array
        final List<WebElement> elements = (List<WebElement>) js.executeScript("return jQuery.find(':checked')");

        return elements;
    }
}
