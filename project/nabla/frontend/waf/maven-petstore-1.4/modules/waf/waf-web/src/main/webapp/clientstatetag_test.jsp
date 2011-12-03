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

<font size="+3">Client Cache Link Tag</font>
<br>
<br>
This page demonstrates the Client Cache Link Tag which will let you
cache state witin a JSP page. Thus allowing for the user to return to
a page with its Request Parameters and HttpServletRequest Attributes
which are encoded into the page in Base64 format.
<br>
<br>
<%
  if (request.getAttribute("mycollection") == null) {
      Integer count = new Integer(0);
      java.util.ArrayList myCollection = new java.util.ArrayList();
      myCollection.add("Entry " + count);
      request.setAttribute("mycollection", myCollection);
      request.setAttribute("count", count);
  } else {
      Integer count = (Integer)request.getAttribute("count");
      int countInt = count.intValue();
      count = new Integer(countInt+=1);
      java.util.ArrayList myCollection = (java.util.ArrayList)request.getAttribute("mycollection");
      myCollection.add("Entry " + count);
      request.setAttribute("count", count);
      out.println(request.getAttribute("mycollection") + "<br/<br/>");
      out.println("<font size=\"+2\" color=\"red\">We have seen the results already " + count +" times</font>");
  }
%>
<br>
<br>

  <waf:client_cache_link id="mytest"
                            targetURL="changeclientchachelinklocale.do"
                                         alt="Change the Locale to English"
encodeRequestParameters="true" 
  encodeRequestAttributes="true"
                           imageURL="images/us_flag.gif">
    <waf:param name="locale" value="en_US"/>
  </waf:client_cache_link>
<br>
  <waf:client_cache_link id="mytest"
                            targetURL="changeclientchachelinklocale.do"
                                         alt="Change the Locale to Japanese"
encodeRequestParameters="true" 
  encodeRequestAttributes="true"
                           imageURL="images/ja_flag.gif">
    <waf:param name="locale" value="ja_JP"/>
  </waf:client_cache_link>

<br>
  <waf:client_cache_link id="mytest2"
                            targetURL="changeclientchachelinklocale.do"
                                         alt="Change the Locale to Japanese"
encodeRequestParameters="true" 
  encodeRequestAttributes="true"
                           buttonText="Switch to Japanese">
    <waf:param name="locale" value="ja_JP"/>
  </waf:client_cache_link>

