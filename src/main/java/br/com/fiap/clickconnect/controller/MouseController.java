package br.com.fiap.clickconnect.controller;

import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.clickconnect.model.Mouse;


@RestController
@RequestMapping("mouse")
public class MouseController {

    
    Logger log = LoggerFactory.getLogger(getClass());

    List<Mouse> mouseRepository = new ArrayList<>();

    @GetMapping
    public List<Mouse> index(){
        return mouseRepository;
    }

    @PostMapping
    public ResponseEntity<Mouse> create(@RequestBody Mouse mouse){
        log.info("Cadastrando mouse {}", mouse);
        mouseRepository.add(mouse);
        return ResponseEntity.status(HttpStatus.CREATED).body(mouse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mouse> show(@PathVariable Long id){
        log.info("Buscando mouse com id {}", id);

        for(Mouse mouse: mouseRepository){
            if (mouse.id().equals(id))
                return ResponseEntity.status(HttpStatus.OK).body(mouse);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mouse> delete(@PathVariable Long id){
        log.info("Deletando mouse com id {}");

        for(Mouse mouse:mouseRepository){
            if (mouse.id().equals(id)) {
                mouseRepository.remove(mouse);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(mouse);
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mouse> update(@PathVariable Long id){
        log.info("Atualizando mouse com id{}");

        for(Mouse mouse:mouseRepository){
            if (mouse.id().equals(id))
                return ResponseEntity.status(HttpStatus.OK).body(mouse);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}


