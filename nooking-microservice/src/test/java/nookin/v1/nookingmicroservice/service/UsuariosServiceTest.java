package nookin.v1.nookingmicroservice.service;

import lombok.extern.slf4j.Slf4j;
import nookin.v1.nookingmicroservice.model.Direccion;
import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.model.Usuario;
import nookin.v1.nookingmicroservice.service.Impl.UsuariosServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.BDDAssertions.then;

@Transactional
@SpringBootTest
public class UsuariosServiceTest {

    @Autowired
    UsuariosService usuariosService;

    @Transactional
    @Test
    public void given_service_when_call_getUsuarioEmail_then_Ok() {

        //Given
        Usuario santi = new Usuario("Santiago","A1b2c3d4","642578958","santi@hotmail.com",18);
        santi.setId(2L);
        //When
        Usuario result = usuariosService.getUsuarioEmail("santi@hotmail.com");

        //Then

        then(result).isEqualTo(santi);
    }
    @Transactional
    @Test
    public void given_service_when_call_isUsuarioEmail_existe_then_Ok() {

        //Given
        Usuario santi = new Usuario("Santiago","A1b2c3d4","642578958","santi@hotmail.com",18);
        //When
         boolean result = usuariosService.isUsuarioEmail("santi@hotmail.com");

        //Then

        then(result).isEqualTo(true);
    }
    @Transactional
    @Test
    public void given_service_when_call_isUsuarioEmail_no_then_Ok() {

        //Given
        Usuario santi = new Usuario("Santiago","A1b2c3d4","642578958","santi@hotmail.com",18);
        //When
        boolean result = usuariosService.isUsuarioEmail("gonfuso@gmail.com");

        //Then

        then(result).isEqualTo(false);
    }

}
