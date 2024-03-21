package br.com.fiap.clickconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.clickconnect.model.Mouse;

public interface MouseRepository extends JpaRepository<Mouse, Long> {
    
}
