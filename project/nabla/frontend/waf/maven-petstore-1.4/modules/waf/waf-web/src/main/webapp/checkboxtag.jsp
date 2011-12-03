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

<font size="+3">Checkbox Tag</font>
<br/>
<br/>
<p>The tag can be used to display a checkbox form element either checked or unchecked
based on the state of the application.</p>

<p>It has one parameter:</p>

<table border="1">
 <tr>
  <th>Name</th>
  <th>Purpose</th>
 </tr>
 <tr>
  <td>name</td> 
  <td>The name of the form element.</td>
 </tr>
</table>

<br/><br/> 
This tag has a sub tag &lt;checked&gt; in the body content of which the developer
can specify whether or not the box is checked. In the example below a JSTL
&lt;out&gt; tag is used.
<br/><br/>
Example:
<br/>
<pre>
&lt;waf:checkbox name="mylist_on"&gt;
 &lt;waf:checked&gt;&lt;c:out value="${customer.profile.myListPreference}"/&gt;&lt;/waf:checked&gt;
&lt;/waf:checkbox&gt;
</pre>
<br/>
Based on the return value of the JSTL out tag &lt;c:out value="${customer.profile.myListPreference}"/&gt; 
the check box will be either selected or not.
</html>
