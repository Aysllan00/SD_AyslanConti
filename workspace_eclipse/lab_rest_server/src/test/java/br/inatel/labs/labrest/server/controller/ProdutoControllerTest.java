package br.inatel.labs.labrest.server.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.labs.labrest.server.model.Produto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProdutoControllerTest{

    @Autowired
    private WebTestClient webTestClient;

    @Test 
    void deveListarProdutos(){

        webTestClient.get()
            .uri("/produto")
            .exchange()
            .expectStatus()
                .isOk()
            .expectBody()
                .returnResult();    
    }
    
    @Test
    void dadoProdutoIdValido_quandoGetProdutoPeloId_entaoRespondeComProdutoValido(){

        Long produtoIdValido = 1L;

        Produto produtoRespondido = webTestClient.get()
            .uri("/produto/" + produtoIdValido)
            .exchange()
            .expectStatus().isOk()
            .expectBody(Produto.class)
                .returnResult()
                .getResponseBody();

        assertNotNull(produtoRespondido);        
        assertEquals(produtoRespondido.getId(), produtoIdValido);
    }
    
    @Test
    void dadoProdutoIdValido_quandoGetProdutoPeloId_entaoRespondeComStatusNotFound(){

        Long idInvalido = 99L;

        webTestClient.get()
            .uri("/produto/"+idInvalido)
            .exchange()
            .expectStatus().isNotFound();
    }
    
    @Test
    void dadoNovoProduto_quandoPostProduto_entaorespondeComStatusCreatedEProdutoValido(){

        Produto novoProduto = new Produto();
        novoProduto.setDescricao("Tupia de Mesa");
        novoProduto.setPreco(new BigDecimal(9000.0));

        Produto produtoRespondido = webTestClient.post()
            .uri("/produto")
            .bodyValue(novoProduto)
            .exchange()
            .expectStatus()
                .isCreated()
            .expectBody(Produto.class)    
                .returnResult()
                .getResponseBody();

        assertThat(produtoRespondido).isNotNull();
        assertThat(produtoRespondido.getId()).isNotNull();
    }
    
    
    @Test
    void dadoProdutoExistente_quandoPutProduto_entaorespondeComStatusNoContent(){

        Produto produtoExistente = new Produto();
        produtoExistente.setId(1L);
        produtoExistente.setDescricao("Furadeira a bateria");
        produtoExistente.setPreco(new BigDecimal(800.00));
        

        webTestClient.put()
            .uri("/produto")
            .bodyValue(produtoExistente)
            .exchange()
            .expectStatus()
                .isNoContent();
            
    }
    
    
    @Test
    void dadoProdutoIdValido_quandoDeleteProdutoPeloId_entaoRespondeComStatusNoContent(){
        Long produtoIdValido = 2L;

        webTestClient.delete()
            .uri("/produto/"+produtoIdValido)
            .exchange()
            .expectStatus()
                .isNoContent();
            
    }
    
    @Test
    void dadoProdutoIdInValido_quandoDeleteProdutoPeloId_entaoRespondeComStatusNotFound(){
        Long produtoIdInValido = 99L;

        webTestClient.delete()
            .uri("/produto/"+produtoIdInValido)
            .exchange()
            .expectStatus()
                .isNoContent();
            
    }
    
}
