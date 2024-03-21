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
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("mouse")
@Slf4j
public class MouseController {
    
    @Autowired
    MouseRepository mouseRepository;

    @GetMapping
    public List<Mouse> index(){
        return mouseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Mouse create(@RequestBody Mouse mouse){
        log.info("Cadastrando mouse {}", mouse);
        return mouseRepository.save(mouse);
    }

    @GetMapping("{id}")
    public ResponseEntity<Mouse> show(@PathVariable Long id){
        log.info("Buscando mouse com id {}", id);

        return mouseRepository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id){
        log.info("Deletando mouse com id {}", id);
        verificarSeMouseExiste(id);
        mouseRepository.deleteById(id);
    }
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


