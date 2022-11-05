package br.com.galvao.viagens.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.galvao.viagens.entidades.Cargo;

public interface CargoRepositorio extends JpaRepository<Cargo, Long> {
    
}
