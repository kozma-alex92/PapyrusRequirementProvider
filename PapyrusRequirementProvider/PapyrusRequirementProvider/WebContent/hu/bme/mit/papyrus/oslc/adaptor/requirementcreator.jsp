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
 
    Sam Padgett 	 - initial API and implementation
    Michael Fiedler	 - adapted for OSLC4J
	Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>

<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="java.util.List"%>
<%@page import="hu.bme.mit.papyrus.oslc.adaptor.resources.Requirement"%>
<%--
Start of user code imports
--%>
<%-- 
End of user code 
--%>


<%@ page contentType="text/html" language="java" pageEncoding="UTF-8"%>

<%
	String id = (String) request.getAttribute("id");
%>
<%--
Start of user code getRequestAttributes
--%>
<%--
End of user code
--%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>Requirement Creation Dialog</title>
<%-- 
Start of user code (RECOMMENDED) headStuff 
		--%>
<%-- 
End of user code 
		--%>
</head>
<body style="padding: 10px;">
	<div id="bugzilla-body">
		<form id="Create" method="POST" class="enter_bug_form">
			<%-- 
Start of user code (RECOMMENDED) formStuff 
		--%>
			<%-- 
End of user code 
		--%>
			<h2>Papyrus properties</h2>
			<table style="clear: both;">
				<tr>
					<td><%=Requirement.titleToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.descriptionToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.identifierToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.derivedToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.derivedFromToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.tracedToToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.verifiedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.refinedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.satisfiedByToHtmlForCreation1(request, id)%></td>
				</tr>
				</table>
				<h2>Other OSLC Core properties</h2>
				<table style="clear: both;">
				<tr>
					<td><%=Requirement.elaboratedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.elaboratesToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.specifiedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.specifiesToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.affectedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.trackedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.implementedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.validatedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.satisfiesToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.decomposedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.decomposesToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.constrainedByToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.constrainsToHtmlForCreation1(request, id)%></td>
				</tr>

				<tr>
					<td><%=Requirement.shortTitleToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.subjectToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.creatorToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.contributorToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.createdToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.modifiedToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.typeToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.serviceProviderToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td><%=Requirement.instanceShapeToHtmlForCreation1(request, id)%></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"> <input
						type="reset" value="Reset"></td>
				</tr>
			</table>
			<div style="width: 500px;"></div>
		</form>

		<div style="clear: both;"></div>
	</div>
</body>
</html>
