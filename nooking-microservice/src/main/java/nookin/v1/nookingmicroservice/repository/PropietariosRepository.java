package nookin.v1.nookingmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nookin.v1.nookingmicroservice.model.Propietarios;

@Repository
public interface PropietariosRepository extends JpaRepository<Propietarios,Long> {
    
}
