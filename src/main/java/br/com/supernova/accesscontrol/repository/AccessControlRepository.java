package br.com.supernova.accesscontrol.repository;

import br.com.supernova.accesscontrol.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessControlRepository extends JpaRepository<JornadaTrabalho, Long> {
}
