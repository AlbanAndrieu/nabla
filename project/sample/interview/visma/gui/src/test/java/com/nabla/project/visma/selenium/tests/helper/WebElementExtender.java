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

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

/**
 * DOCUMENT ME! albandri.
 * 
 * @author $Author$
 * @version $Revision$
 * @since $Date$
 */
public class WebElementExtender
{
    public static void highlightElement(final WebElement element)
    {
        for (int i = 0; i < 5; i++)
        {
            final WrapsDriver wrappedElement = (WrapsDriver) element;
            final JavascriptExecutor driver = (JavascriptExecutor) wrappedElement.getWrappedDriver();
            driver.executeScript("arguments[0].setAttribute('style',  arguments[1])", element, "visibility:hidden;");
            // driver.executeScript("arguments[0].setAttribute('style',  arguments[1]);", element, "");
        }
    }

    public static File captureElementBitmap(final WebElement element) throws IOException
    {
        final WrapsDriver wrapsDriver = (WrapsDriver) element;

        final File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);

        final BufferedImage img = ImageIO.read(screen);

        final int width = element.getSize().getWidth();
        final int height = element.getSize().getHeight();

        final Rectangle rect = new Rectangle(width, height);

        final Point p = element.getLocation();

        final BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);

        ImageIO.write(dest, "png", screen);
        return screen;
    }
}
