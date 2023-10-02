package br.com.tech4me.pastelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.tech4me.pastelaria.model.Pastel;

public interface RepositoryPastel extends JpaRepository<Pastel,String > {
    
}
