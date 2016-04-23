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
 *     Michael Fiedler      - Bugzilla adpater implementations
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 * 
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/

package hu.bme.mit.papyrus.oslc.adaptor;

import org.eclipse.lyo.oslc4j.core.model.OslcConstants;

// Start of user code imports
// End of user code

public interface PapyrusRequirementProviderConstants
{
	// Start of user code user constants
	// End of user code

	public static String DUBLIN_CORE_DOMAIN = "http://purl.org/dc/terms/";
public static String DUBLIN_CORE_NAMSPACE = "http://purl.org/dc/terms/";
public static String DUBLIN_CORE_NAMSPACE_PREFIX = "dcterms";

	public static String FOAF_DOMAIN = "http://xmlns.com/foaf/0.1/";
public static String FOAF_NAMSPACE = "http://xmlns.com/foaf/0.1/";
public static String FOAF_NAMSPACE_PREFIX = "foaf";

	public static String OSLC_CORE_DOMAIN = "http://open-services.net/ns/core#";
public static String OSLC_CORE_NAMSPACE = "http://open-services.net/ns/core#";
public static String OSLC_CORE_NAMSPACE_PREFIX = "oslc";

	public static String REQUIREMENT_MANAGEMENT_DOMAIN = "http://open-services.net/ns/rm#";
public static String REQUIREMENT_MANAGEMENT_NAMSPACE = "http://open-services.net/ns/rm#";
public static String REQUIREMENT_MANAGEMENT_NAMSPACE_PREFIX = "oslc_rm";


	public static String PERSON = "person";
public static String PATH_PERSON = "person";
public static String TYPE_PERSON = FOAF_NAMSPACE + "person";
	public static String REQUIREMENT = "requirement";
public static String PATH_REQUIREMENT = "requirement";
public static String TYPE_REQUIREMENT = REQUIREMENT_MANAGEMENT_NAMSPACE + "requirement";
	public static String REQUIREMENTCOLLECTION = "requirementCollection";
public static String PATH_REQUIREMENTCOLLECTION = "requirementCollection";
public static String TYPE_REQUIREMENTCOLLECTION = REQUIREMENT_MANAGEMENT_NAMSPACE + "requirementCollection";
	public static String TYPE = "type";
public static String PATH_TYPE = "type";
public static String TYPE_TYPE = DUBLIN_CORE_NAMSPACE + "type";

    public static final String HDR_OSLC_VERSION = "OSLC-Core-Version";

}

