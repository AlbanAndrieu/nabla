/**
 * Copyright 2010 ArcBees Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.dispatch.server.seam.actionvalidator;

import org.jboss.seam.annotations.Name;

import com.gwtplatform.dispatch.server.actionvalidator.AbstractDefaultActionValidator;

/**
 * The default {@link com.gwtplatform.dispatch.server.actionvalidator.ActionValidator} seam implementation.
 * It's here just to define default action validator as a seam component.
 * 
 * @author Florian Sauter
 */
@Name("gwtpDefaultActionValidator")
public class DefaultActionValidator extends AbstractDefaultActionValidator
{
}
