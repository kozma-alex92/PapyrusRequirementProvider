/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *  
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *	   Sam Padgett	       - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package hu.bme.mit.papyrus.oslc.adaptor.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.annotation.OslcAllowedValue;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDescription;
import org.eclipse.lyo.oslc4j.core.annotation.OslcMemberProperty;
import org.eclipse.lyo.oslc4j.core.annotation.OslcName;
import org.eclipse.lyo.oslc4j.core.annotation.OslcNamespace;
import org.eclipse.lyo.oslc4j.core.annotation.OslcOccurs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRange;
import org.eclipse.lyo.oslc4j.core.annotation.OslcReadOnly;
import org.eclipse.lyo.oslc4j.core.annotation.OslcRepresentation;
import org.eclipse.lyo.oslc4j.core.annotation.OslcResourceShape;
import org.eclipse.lyo.oslc4j.core.annotation.OslcTitle;
import org.eclipse.lyo.oslc4j.core.annotation.OslcValueType;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.Occurs;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.Representation;
import org.eclipse.lyo.oslc4j.core.model.ValueType;

import hu.bme.mit.papyrus.oslc.adaptor.servlet.ServletListener; 
import hu.bme.mit.papyrus.oslc.adaptor.PapyrusRequirementProviderConstants;

// Start of user code imports
// End of user code

@OslcNamespace(PapyrusRequirementProviderConstants.DUBLIN_CORE_NAMSPACE)
@OslcName(PapyrusRequirementProviderConstants.TYPE) 
@OslcResourceShape(title = "Type Resource Shape", describes = PapyrusRequirementProviderConstants.TYPE_TYPE)
public class Type
	extends AbstractResource
	implements IType
{


public Type()
       throws URISyntaxException
{
    super();

	// Start of user code constructor1
	// End of user code
}

public Type(final URI about)
       throws URISyntaxException
{
    super(about);

	// Start of user code constructor2
	// End of user code
}


public String toString()
{
	return toString(false);
}

public String toString(boolean asLocalResource)
{
		String result = "";
		// Start of user code toString_init
		// End of user code

		if (asLocalResource) {
			result = result + "{a Local Type Resource} - update Type.toString() to present resource as desired.";
			// Start of user code toString_bodyForLocalResource
			// End of user code
		}
		else {
			result = getAbout().toString();
		}

		// Start of user code toString_finalize
		// End of user code

		return result;
}

public String toHtml()
{
	return toHtml(false);
}

public String toHtml(boolean asLocalResource)
{
		String result = "";
		// Start of user code toHtml_init
		// End of user code

		if (asLocalResource) {
			result = toString(true);
			// Start of user code toHtml_bodyForLocalResource
			// End of user code
		}
		else {
			result = "<a href=\"" + getAbout() + "\">" + toString() + "</a>";
		}

		// Start of user code toHtml_finalize
		// End of user code

		return result;
}





}
