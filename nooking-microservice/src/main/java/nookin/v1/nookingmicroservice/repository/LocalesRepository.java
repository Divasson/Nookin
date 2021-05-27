package nookin.v1.nookingmicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nookin.v1.nookingmicroservice.model.Local;

@Repository
public interface LocalesRepository extends JpaRepository<Local,Long>{
    
}
