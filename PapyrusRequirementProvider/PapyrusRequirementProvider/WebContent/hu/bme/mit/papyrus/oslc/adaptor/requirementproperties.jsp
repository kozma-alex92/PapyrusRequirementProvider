<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="java.util.List" %>
<%@page import="hu.bme.mit.papyrus.oslc.adaptor.resources.Requirement"%>
<%@page import="hu.bme.mit.papyrus.oslc.adaptor.util.QueryHelper"%>
<%--
Start of user code imports
--%>
<%-- 
End of user code 
--%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
    Requirement aRequirement = (Requirement) request.getAttribute("aRequirement");
%>
<%--
Start of user code getRequestAttributes
--%>
<%--
End of user code
--%>

<h1>Resource Presentation</h1>
			<p>
				Summary:
				<%=aRequirement.toHtml()%><br />
			</p>
			<h2>Properties</h2>
			<table style="clear: both;" border="1">
				<br>
				<%= aRequirement.getPropertiesHTML(QueryHelper.propertyParams) %>
			</table>


			</div>
		</div>
		
		<div id="footer">
			<div class="intro"></div>
			<div class="outro">
				<div style="margin: 0 1em 1em 1em; line-height: 1.6em; text-align: left">
					<b>OSLC Tools Adapter Server 0.1</b> brought to you by <a href="http://eclipse.org/lyo">Eclipse Lyo</a><br />
				</div>
			</div>
		</div>
		

		
	</body>
</html>