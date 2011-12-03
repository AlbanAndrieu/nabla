<%--
 Copyright 2004 Sun Microsystems, Inc. All rights reserved.
 
 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 
 - Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
 
 - Redistribution in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in
   the documentation and/or other materials provided with the
   distribution.
 
 Neither the name of Sun Microsystems, Inc. or the names of
 contributors may be used to endorse or promote products derived
 from this software without specific prior written permission.
 
 This software is provided "AS IS," without a warranty of any
 kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES
 SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 DISTRIBUTING THE SOFTWARE OR ITS DERIVATIVES. IN NO EVENT WILL SUN
 OR ITS LICENSORS BE LIABLE FOR ANY LOST REVENUE, PROFIT OR DATA, OR
 FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL, INCIDENTAL OR
 PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY OF
 LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE SOFTWARE,
 EVEN IF SUN HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 
 You acknowledge that Software is not designed, licensed or intended
 for use in the design, construction, operation or maintenance of
 any nuclear facility.
--%>


<%@ taglib uri="/WEB-INF/waftags.tld" prefix="waf" %>
<html>


<font size="+3">Select Tag</font>
<br/>
<br/>
<p>
The select tag provides a means of selecting some text from an HTML form combo
box depending on whether or not the tag is editable.
</p>

<p>It has three parameters:</p>

<table border="1">
 <tr>
  <th>Name</th>
  <th>Purpose</th>
 </tr>
 <tr>
  <td>name</td>
  <td>The form name of the tag.</td>
 </tr>
 <tr>
  <td>size</td>
  <td>The size or number of options in the tag.</td>
 </tr>
 <tr>
  <td>editable</td> 
  <td>When <b>true</b> the tag produces a  html form combo box with item specified in the 
          selected option sub tag selected.
         <br/>
         Example:
<pre>
&lt;waf:select size="1" name="language" editable="true">
  &lt;waf:selected>&lt;c:out value="${customer.profile.preferredLanguage}"/>&lt;/waf:selected>
  &lt;waf:option value="en_US">English&lt;/waf:option>
  &lt;waf:option value="ja_JP">Japanese&lt;/waf:option>
&lt;/waf:select>
</pre>
   <br/>
   The previous example will display a compbo box with either English or Japanese selected depending
   on the return value of the JSTL &lt;c:out value="${customer.profile.preferredLanguage}"/> tag.
   <br/><br/>
   When <b>false</> the tag simply displays the text of the selected item in a non-combobox this
   allows you to provide the same mapping ability without worrying about a user changing the value
   when it can not be changed.
   <br/>
   Example:
   <br/>
<pre>
&lt;waf:select size="1" name="language" editable="false">
  &lt;waf:selected>&lt;c:out value="${customer.profile.preferredLanguage}"/>&lt;/waf:selected>
  &lt;waf:option value="en_US">English&lt;/waf:option>
  &lt;waf:option value="ja_JP">Japanese&lt;/waf:option>
&lt;/waf:select>
</pre>
   <br/>
   This tag will simply display the language based on the return value of the
   JSTL out tag &lt;c:out value="${customer.profile.preferredLanguage}"/&gt;
  </td>
 </tr>
</table>
</html>
