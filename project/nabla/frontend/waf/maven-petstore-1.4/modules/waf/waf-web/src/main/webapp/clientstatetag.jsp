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


<font size="+3">Client State Tag</font>
<br/>
<br/>
This page demonstrates the Client StateTag which will let you
cache state witin a HTML page. Thus allowing for the user to return to
a page with the same Request Parameters and HttpServletRequest Attributes
and possibly more based on the actions that occured when the user left the page.
<br/><br/>
This tag works along with the ClientStateFlowHandler which is used to
re-consititute the date that was saved on the client tier and return to
page.
<br/>
<br/>

<center><image src="images/clientstate.jpg"/></center>


The graphic above describes how the client state tag may be used.
For example an application needs to do some processing and return to the
same page with the same data. An example is when the user chooses to
change the language of the application. In which case the user will click on
one of the flag images. The flag images are actually form submit buttons 
which contain forms that have data encoded in the form variables. When
the user clicks the image and action occurs in which the application locale
which the user prefers to view the pages in is changed. After the action
occurs the user would like to be returned to the same page from which
the button was pressed. This may have been during a search, while
viewing the shopping cart, or while viewing product data. In any one of the
cases information about where the user is in the application is maintained
in data that is kept in request parameters and request attributes (request
scope data). In order to return to the place where the user was the information
about where the user was must be stored.
<br/><br/>
The <b>client state tag</b> is responsible for creating the forms and the hidden 
form data which has the request attributes which are <b>serializable</b>
encoded in Base64 format. A future version of this tag may use plugable
serialize/de-serialize for serializing the data. This would allow a user
to provide serializers/de-serializers that serialize/de-serialize data in encrypted
format. Currenlty it is not recommended to use this tag with confidential data
in that it could be extracted from the page and de-serialized with a little work.
<br/><br/>
The <b>ClientStateFlowHandler</b> is responsible for de-serializing the data
which and putting returning the user to the page/screen from which the action
occured. The ClientStateFlowHandler is also responsible for forwarding the
application to the screen from which the user departed.
<br/><br/>
This method of storing state on the client helps developers avoid problems that
are caused by clients navigating using the browers forward and back buttons. This
is because the state is stored in the page itself and thus the user can return to the
exact place in the application from which the user departed to preform an action.
<br/><br/>
This method of storing state allows an application to scale to a large number of
clients because the state is store on the clients. However this method of store
state requires the clients to be HTML clients and also does require bandwith in
that the state needs to be transferred along with each page request.
<br/><br/>
Click on the Submit Button to test the tag:
<br/><br/>

<form action="clientstatetag_test.screen" method="POST">
  <input type="HIDDEN" name="param1" value="apple">
  <input type="HIDDEN" name="param2" value="orange">
  <input type="HIDDEN" name="param3" value="pear">
  <input type="SUBMIT" name="param1" value="Go to the Test Page">
</form>

</html>
