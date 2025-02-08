package app.produto.api.service;

import app.produto.api.model.ProdutoEntity;
import app.produto.api.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity findById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<ProdutoEntity> findAll() {
        return produtoRepository.listAll();
    }

    @Transactional
    public ProdutoEntity create(ProdutoEntity produto) {
        produto.setDataAtualizacao(LocalDateTime.now());
        produtoRepository.persist(produto);
        return produto;
    }

    public Long count() {
        return produtoRepository.count();
    }

    @Transactional
    public ProdutoEntity update(ProdutoEntity produto) {
        ProdutoEntity byId = produtoRepository.findById(produto.getId());
        if (byId != null) {
            produtoRepository.persist(byId);
            byId.setNome(produto.getNome());
            byId.setDescricao(produto.getDescricao());
            byId.setDataAtualizacao(LocalDateTime.now());
            return byId;
        }
        return null;
    }

    public ProdutoEntity findByNome(String nome) {
        return produtoRepository.list("nome", nome).getFirst();
    }

    @Transactional
    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
