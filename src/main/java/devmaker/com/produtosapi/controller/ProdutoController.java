package devmaker.com.produtosapi.controller;

import devmaker.com.produtosapi.model.Produto;
import devmaker.com.produtosapi.repository.ProdutoRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        var id = UUID.randomUUID().toString();

        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }
    
    @GetMapping("{id}")
    public Produto obterPorID(@PathVariable("id") String id){
//        Optional<Produto> produto = produtoRepository.findById(id);
//        return produto.isPresent() ? produto.get() : null;
        return  produtoRepository.findById(id).orElse(null);

    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);

        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listarProduto(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }

}
