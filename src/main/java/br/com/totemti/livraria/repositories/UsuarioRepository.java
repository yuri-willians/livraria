package br.com.totemti.livraria.repositories;

import org.springframework.stereotype.Repository;

import br.com.totemti.livraria.models.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.perfis WHERE u.id = :id")
    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByEmail(String email);
}
