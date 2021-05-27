package nookin.v1.nookingmicroservice.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import nookin.v1.nookingmicroservice.model.JwtRequest;
import nookin.v1.nookingmicroservice.model.Usuario;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.BDDAssertions.then;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UsuariosControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Transactional
    @Test
    public void given_app_when_call_login_good_password_then_ok() {

        //Given
        Usuario santi = new Usuario("Santiago","A1b2c3d4","642578958","santi@hotmail.com",18);
        santi.setId(3L);
        santi.setReservas(null);

        //When
        String address = "http://localhost:" + port + "/api/comprobarUsuarios";

        HttpHeaders headers = new HttpHeaders();


        JwtRequest jwtRequest =
                new JwtRequest(
                        "santi@hotmail.com",
                        "A1b2c3d4");
        HttpEntity<JwtRequest> request = new HttpEntity<>(jwtRequest, headers);
        ResponseEntity<Usuario> response = restTemplate.postForEntity(address, request, Usuario.class);

        //Then
        then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(response.getBody()).isEqualTo(santi);
    }
    @Transactional
    @Test
    public void given_app_when_call_login_bad_password_then_ok() {

        //Given


        //When
        String address = "http://localhost:" + port + "/api/comprobarUsuarios";

        HttpHeaders headers = new HttpHeaders();


        JwtRequest jwtRequest =
                new JwtRequest(
                        "santi@hotmail.com",
                        "tonto");
        HttpEntity<JwtRequest> request = new HttpEntity<>(jwtRequest, headers);
        ResponseEntity<Usuario> response = restTemplate.postForEntity(address, request, Usuario.class);

        //Then
        then(response.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);

    }

    public static String asJsonString(Object obj) {
        try
        {
            return new ObjectMapper().writeValueAsString(obj);
        }
        catch (Exception e)
        { throw new RuntimeException(e);
        }
    }


}
