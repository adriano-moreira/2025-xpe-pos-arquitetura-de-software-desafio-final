package app.produto.api.repository;

import app.produto.api.model.ProdutoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<ProdutoEntity> {
}
