package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna Lista de Produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Produto produtoUnico(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }


    @PostMapping("/produto")
    @ApiOperation(value="Salva um Produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }


    @DeleteMapping("/produto")
    @ApiOperation(value="Deleta um Produtos")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }


    @PutMapping("/produto")
    @ApiOperation(value="Atualiza um Produtos")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }




}
