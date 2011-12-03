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


<font size="+3">Input Tag</font>
<br>
<br>
<p>The input tag implements provides a form input tag with validation. This tag <b>must</b> be used 
as a sub-tag of a <a href="formtag.screen">form tag</a>.</p>


<p>It has five parameters:</p>
<table border="1">
 <tr>
  <th>Name</th><th>Purpose</th>
 </tr>
 <tr>
  <td>ccsClass</td>
  <td>The name of the cascading style sheet used for formatting this form element.</td>
 </tr>
 <tr>
  <td>name</td> 
  <td>The name of the form element.</td>
 </tr>
 <tr>
  <td>type</td>
  <td>The type of input.</td>
 </tr>
 <tr>
  <td>size</td>
  <td>The visible display size of the form input field.</td>
 </tr>
 <tr>
  <td>maxlength</td>
  <td>The maximum amout of charachters that can be entered into the input field.</td>
 </tr>
 <tr>
  <td>validation</td>
  <td>When validation is set to validation it requires that text be entered into the form field.
         This is done using some generated Java Script and is performed by the parent form tag.</td>
 </tr>
</table>

<br><br>
This tag has a sub tag called &lt;value&gt; which is used to specify application data that is
set into the form field when the content is specified in the body of this tag.

<br><br>
Example:
<br><br>
<pre>
&lt;waf:input cssClass="petstore_form"
                       type="text"
                     name="address_1_a"
                       size="55"
             maxlength="70"
               validation="validation"&gt;
 &lt;waf:value&gt;&lt;c:out value="${customer.account.contactInfo.address.streetName1}"/&gt;
&lt;/waf:value&gt;
&lt;/waf:input&gt;
</pre>



</html>
