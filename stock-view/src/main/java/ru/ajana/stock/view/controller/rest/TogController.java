package ru.ajana.stock.view.controller.rest;

import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.jboss.resteasy.api.validation.ResteasyViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ajana.stock.core.service.TogService;
import ru.ajana.stok.model.Tog;

/**
 * REST-контроллер одежды магазина.
 *
 * @author Andrey Kharintsev on 11.04.2018
 */
@Path("/togs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class TogController {

  private static final Logger LOG = LoggerFactory.getLogger(TogController.class);

  @Inject
  private TogService togService;

  @Context
  private UriInfo uriInfo;

  @GET
  public Response getAllTogs() {
    return Response.ok(togService.getAllTogs()).build();
  }

  @POST
  public Response createTog(Tog tog) {
    if (tog == null) {
      throw new BadRequestException();
    }
    tog = togService.saveTog(tog);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(tog.getId())).build();
    return Response.created(bookUri).build();
  }

  @GET
  @Path("{id}")
  public Response getTog(@PathParam("id") Long id) throws NotFoundException {
    Tog tog = togService.getTog(id);
    if (tog == null) {
      throw new NotFoundException("Продукт не найден");
    }
    return Response.ok(tog).build();
  }

  @PUT
  public Response updateTog(Tog tog) {
    tog = togService.saveTog(tog);
    return Response.ok(tog).build();
  }

  @Path("{id}")
  @DELETE
  public Response deleteTog(@PathParam("id") Long id) {
    togService.deleteTog(id);
    return Response.noContent().build();
  }
}
