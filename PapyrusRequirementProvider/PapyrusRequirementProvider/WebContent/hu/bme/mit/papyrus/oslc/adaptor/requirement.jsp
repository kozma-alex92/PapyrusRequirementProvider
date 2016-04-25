<!DOCTYPE html>
<%--
 Copyright (c) 2011, 2012 IBM Corporation and others.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 
 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.
 
 Contributors:
 
    Sam Padgett	  	- initial API and implementation
    Michael Fiedler	- adapted for OSLC4J
	Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>

<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="java.util.List" %>
<%@page import="hu.bme.mit.papyrus.oslc.adaptor.resources.Requirement"%>
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
			<h3>Papyrus properties</h3>
			<table style="clear: both;" border="1">
				<tr>
					<td><%=aRequirement.identifierToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.titleToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.descriptionToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.derivedToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.derivedFromToHtml()%></td>
				</tr>
				</tr>
				<tr>
					<td><%=aRequirement.tracedToToHtml()%></td>
				</tr>
				</tr>
				<tr>
					<td><%=aRequirement.verifiedByToHtml()%></td>
				</tr>
				</tr>
				<tr>
					<td><%=aRequirement.refinedByToHtml()%></td>
				</tr>

				<tr>
					<td><%=aRequirement.satisfiedByToHtml()%></td>
				</tr>

			</table>
			<br>
			<h3>Requirements Management Specification Version 2.0 properties</h3>
			<table style="clear: both;" border="1">
				<br>
				<tr>
					<td><%=aRequirement.elaboratedByToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.elaboratesToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.specifiedByToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.specifiesToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.affectedByToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.trackedByToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.implementedByToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.validatedByToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.satisfiesToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.decomposedByToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.decomposesToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.constrainedByToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.constrainsToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.shortTitleToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.subjectToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.creatorToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.contributorToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.createdToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.modifiedToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.typeToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.serviceProviderToHtml()%></td>
				</tr>
				<tr>
					<td><%=aRequirement.instanceShapeToHtml()%></td>
				</tr>
			</table>

			</div>
		</div>
		
	</body>
</html>
