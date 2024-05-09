package br.com.fiap.clickconnect.controller;

import org.slf4j.LoggerFactory;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.clickconnect.model.Mouse;
import br.com.fiap.clickconnect.repository.MouseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("mouse")
@Slf4j
@Tag(name = "mouse")
public class MouseController {
    
    @Autowired
    MouseRepository mouseRepository;

    @Operation(
        summary = "Listar todos os mouses",
        description = "Retorna um array com todos os mouses"
    )
    @GetMapping
    public List<Mouse> index(){
        return mouseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    @Operation(
        summary = "Cadastrar mouse",
        description = "Cria uma novo mouse com os dados enviados no corpo da requisição."
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201",description = "Mouse cadastrado com sucesso"),
            @ApiResponse(responseCode = "400",description = "Dados enviados são inválidos. Verifique o corpo da requisição", useReturnTypeSchema = false)
        }
    )
    public Mouse create(@RequestBody Mouse mouse){
        log.info("Cadastrando mouse {}", mouse);
        return mouseRepository.save(mouse);
    }

    @Operation(
        summary = "Listar mouse por ID",
        description = "Retorna um array com o ID do mouse"
    )
    @GetMapping("{id}")
    public ResponseEntity<Mouse> show(@PathVariable Long id){
        log.info("Buscando mouse com id {}", id);

        return mouseRepository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Excluir um mouse",
        description = "Exclui um mouse com base no ID fornecido"
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "204",description = "Mouse excluido com sucesso"),
            @ApiResponse(responseCode = "404",description = "Mouse não encontrado.", useReturnTypeSchema = false)
        }
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Deletando mouse com id {}", id);
        verificarSeMouseExiste(id);
        mouseRepository.deleteById(id);
    }

    @Operation(
        summary = "Atualizar um mouse",
        description = "Atualiza um mouse com base no ID fornecido"
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200",description = "Mouse atualizado com sucesso"),
            @ApiResponse(responseCode = "404",description = "Mouse não encontrado.", useReturnTypeSchema = false)
        }
    )
    @PutMapping("{id}")
    public Mouse update(@PathVariable Long id, @RequestBody Mouse mouse) {
        log.info("atualizar Mouse {} para {}", id, mouse);

        verificarSeMouseExiste(id);
        mouse.setId(id);
        return mouseRepository.save(mouse);
    }

    private void verificarSeMouseExiste(Long id) {
        mouseRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        NOT_FOUND,
                        "Não existe mouse com o id informado"));
    }


}


