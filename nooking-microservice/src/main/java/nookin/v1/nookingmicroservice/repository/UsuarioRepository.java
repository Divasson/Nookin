package nookin.v1.nookingmicroservice.repository;


import nookin.v1.nookingmicroservice.model.Usuario;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    
    @Query("SELECT TOP 1 * FROM CLIENTES WHERE NOMBRE= :nombre")
    Usuario getUsuarioByNombre(@Param("nombre") String nombre);
}
