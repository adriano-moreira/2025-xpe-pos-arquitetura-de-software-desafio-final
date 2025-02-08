package app.produto.api.controller;

import app.produto.api.model.ProdutoEntity;
import app.produto.api.service.ProdutoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @POST
    public ProdutoEntity create(ProdutoEntity produto) {
        return produtoService.create(produto);
    }

    @Path("/{id}")
    @GET
    public ProdutoEntity read(@PathParam("id") Long id) {
        return produtoService.findById(id);
    }

    @PUT
    public ProdutoEntity update(ProdutoEntity produto) {
        return produtoService.update(produto);
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") Long id) {
        produtoService.delete(id);
        return Response.ok().build();
    }

    @GET
    public List<ProdutoEntity> findAll() {
        return produtoService.findAll();
    }

    @Path("/count")
    @GET
    public Long count() {
        return produtoService.count();
    }

}
