package br.com.fiap.clickconnect.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Mouse {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @NotBlank
    String nome;
    @NotBlank
    String descricao;
    @NotNull
    double preco;
    }

