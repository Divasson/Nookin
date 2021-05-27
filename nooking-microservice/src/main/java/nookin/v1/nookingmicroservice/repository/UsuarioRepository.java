package nookin.v1.nookingmicroservice.repository;


import nookin.v1.nookingmicroservice.model.Usuario;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    @Query(value = "SELECT TOP 1 * FROM USUARIOS WHERE EMAIL= :email",nativeQuery = true)
    Usuario getUsuarioByEmail(@Param("email") String email);

}
