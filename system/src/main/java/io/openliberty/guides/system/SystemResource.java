// tag::copyright[]
/*******************************************************************************
 * Copyright (c) 2017, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - Initial implementation
 *******************************************************************************/
// end::copyright[]
package io.openliberty.guides.system;

import java.util.Properties;

// CDI
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
// JAX-RS
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import io.opentelemetry.api.trace.Tracer;

import io.opentelemetry.api.trace.Span;

@RequestScoped
@Path("properties")
public class SystemResource {

  @Inject
  Tracer tracer;

  @Inject
  Span span;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Properties getProperties() {
    span.setAttribute("Event number",1);
    span.addEvent("Returning properties");
    return System.getProperties();
  }
}
