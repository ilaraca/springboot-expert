package devmaker.com.produtosapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProdutosController {

    @GetMapping
    public String home() {
        return "API de Produtos está rodando!";
    }
}
