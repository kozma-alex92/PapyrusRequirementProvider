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
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
package hu.bme.mit.papyrus.oslc.adaptor.services;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.common.internal.model.admin.QueryParameters;
import org.eclipse.lyo.oslc4j.core.OSLC4JConstants;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.core.query.ParseException;
import org.eclipse.lyo.core.query.Properties;
import org.eclipse.lyo.core.query.PropertiesClause;
import org.eclipse.lyo.core.query.Property;
import org.eclipse.lyo.core.query.QueryUtils;

import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import hu.bme.mit.papyrus.oslc.adaptor.PapyrusRequirementProviderManager;
import hu.bme.mit.papyrus.oslc.adaptor.PapyrusRequirementProviderConstants;
import hu.bme.mit.papyrus.oslc.adaptor.servlet.ServiceProviderCatalogSingleton;
import hu.bme.mit.papyrus.oslc.adaptor.resources.Person;	
import hu.bme.mit.papyrus.oslc.adaptor.resources.Requirement;	
import hu.bme.mit.papyrus.oslc.adaptor.resources.Type;	

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

@OslcService(PapyrusRequirementProviderConstants.REQUIREMENT_MANAGEMENT_DOMAIN)
@Path("serviceProviders/RequirementService{id}/requirements")
public class RequirementService
{
	@Context private HttpServletRequest httpServletRequest;
	@Context private HttpServletResponse httpServletResponse;
	@Context private UriInfo uriInfo;

	// Start of user code class_attributes
	// End of user code
	
	// Start of user code class_methods
	// End of user code
	
    public RequirementService()
    {
        super();
    }

    /**
     * RDF/XML, XML and JSON representation of a change request collection
     * 
     * TODO:  add query support
     * 
     * @param productId
     * @param where
     * @param pageString
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @OslcQueryCapability
    (
        title = "Requirement Query Capability",
        label = "Requirement Query",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + PapyrusRequirementProviderConstants.PATH_REQUIREMENT,
        resourceTypes = {PapyrusRequirementProviderConstants.TYPE_REQUIREMENT},
        usages = {OslcConstants.OSLC_USAGE_DEFAULT}
    ) 
    @GET 
    @Path("r_query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Requirement[] queryRequirements(
													@PathParam("id") final String id ,
    		                                 		@QueryParam("oslc.where") final String where,
    		                                 		@QueryParam("page") final String pageString,
													@QueryParam("limit") final String limitString) throws IOException, ServletException 
    {
		int page=0;
		int limit=20;
		if (null != pageString) {
			page = Integer.parseInt(pageString);
		}
		if (null != limitString) {
			limit = Integer.parseInt(limitString);
		}
        
		// Start of user code queryRequirements
		
		// End of user code

        final List<Requirement> resources = PapyrusRequirementProviderManager.queryRequirements(httpServletRequest, id, where, page, limit);
        return resources.toArray(new Requirement [resources.size()]);
    }

    /**
     * HTML representation of change request collection
     * 
     * Forwards to changerequest_collection_html.jsp to build the html page
     * 
     * @param productId
     * @param changeRequestId
     * @param pageString
     * @return
     * @throws ServletException
     * @throws IOException
     */
	@GET
    @Path("r_query")
	@Produces({ MediaType.TEXT_HTML })
	public Response queryRequirementsAsHtml(
									@PathParam("id") final String id ,
                               		@QueryParam("oslc.where") final String where,
                               		@QueryParam("page") final String pageString,
			                        @QueryParam("limit") final String limitString) throws ServletException, IOException
	{
		int page=0;
		int limit=20;
		if (null != pageString) {
			page = Integer.parseInt(pageString);
		}
		if (null != limitString) {
			limit = Integer.parseInt(limitString);
		}

		// Start of user code queryRequirementsAsHtml
		// End of user code

        final List<Requirement> resources = PapyrusRequirementProviderManager.queryRequirements(httpServletRequest, id, where, page, limit);
		
        if (resources!= null) {
        	httpServletRequest.setAttribute("resources", resources);
			// Start of user code queryRequirementsAsHtml_setAttributes
			// End of user code

        	httpServletRequest.setAttribute("queryUri", 
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
        	if (resources.size() > limit) {
        		resources.remove(resources.size() - 1);
        		httpServletRequest.setAttribute("nextPageUri", 
        				uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&amp;page=" + (page + 1));
        	}
        	RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/hu/bme/mit/papyrus/oslc/adaptor/requirementscollection.jsp");
        	rd.forward(httpServletRequest,httpServletResponse);
        }
		
		throw new WebApplicationException(Status.NOT_FOUND);	
	}


	/**
	 * Create a single BugzillaChangeRequest via RDF/XML, XML or JSON POST
	 * @param productId
	 * @param changeRequest
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@OslcCreationFactory
	(
		 title = "Requirement Creation Factory",
		 label = "Requirement_Creation",
		 resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + PapyrusRequirementProviderConstants.PATH_REQUIREMENT},
		 resourceTypes = {PapyrusRequirementProviderConstants.TYPE_REQUIREMENT},
		 usages = {OslcConstants.OSLC_USAGE_DEFAULT}
	)
    @POST
    @Path("create")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Response createRequirement(
            @PathParam("id") final String id , 
            final Requirement aResource
        ) throws IOException, ServletException
    {
		try {
    		Requirement newResource = PapyrusRequirementProviderManager.createRequirement(httpServletRequest, aResource, id);
			httpServletResponse.setHeader("ETag", PapyrusRequirementProviderManager.getETagFromRequirement(newResource));
	        return Response.created(newResource.getAbout()).entity(aResource).build();
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new WebApplicationException(e);
    	}
    }


	/**
	 * RDF/XML, XML and JSON representation of a single change request
	 * 
	 * @param productId
	 * @param changeRequestId
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 * @throws URISyntaxException
	 */
    @GET
    @Path("{requirementId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Requirement getRequirement(
                @PathParam("id") final String id, @PathParam("requirementId") final String requirementId, @QueryParam("oslc.properties") final String properties
        ) throws IOException, ServletException, URISyntaxException
    {
		// Start of user code getResource_init
    	System.out.println(properties);
		// End of user code
    	final Requirement aRequirement = PapyrusRequirementProviderManager.getRequirement(httpServletRequest, id, requirementId);
        
        if (aRequirement != null) {
			// Start of user code getRequirement

			// End of user code
            return aRequirement;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
    
    /**
     * 
     * HTML representation for a single change request  - redirect the request directly to Bugzilla
     * 
     * @param productId
     * @param changeRequestId
     * @throws ServletException
     * @throws IOException
     * @throws URISyntaxException
     * @throws ParseException 
     */
	@GET
    @Path("{requirementId}")
	@Produces({ MediaType.TEXT_HTML })
	public Response getRequirementAsHtml(
        @PathParam("id") final String id, @PathParam("requirementId") final String requirementId, @QueryParam("oslc.properties") final String properties,
        @QueryParam("oslc.prefix") final String prefix
        ) throws ServletException, IOException, URISyntaxException
	{	
        

		// Start of user code getRequirementAsHtml_init

		// End of user code

        final Requirement aRequirement = PapyrusRequirementProviderManager.getRequirement(httpServletRequest, id, requirementId);
        if (aRequirement != null) {
        	
        	
        	httpServletRequest.setAttribute("aRequirement", aRequirement);
        	
			// Start of user code getRequirementAsHtml_setAttributes
			// End of user code

        	RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/hu/bme/mit/papyrus/oslc/adaptor/requirement.jsp");
        	rd.forward(httpServletRequest,httpServletResponse);
		}

        throw new WebApplicationException(Status.NOT_FOUND);
	}
}
