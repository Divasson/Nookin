package nookin.v1.nookingmicroservice.service;


import lombok.extern.slf4j.Slf4j;
import nookin.v1.nookingmicroservice.model.Direccion;
import nookin.v1.nookingmicroservice.model.Local;
import nookin.v1.nookingmicroservice.service.Impl.LocalesServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@Transactional
@SpringBootTest
public class LocalServiceTest {

    @Autowired
    LocalesService localesService = new LocalesServiceImpl() ;

    @Transactional
    @Test
    public void given_service_when_call_getTodosLocales_then_Ok() {

        //Given
        List<Local> expectedList= new ArrayList<Local>();


        Direccion dirCoventGarden = new Direccion("Calle del Dr. Fleming, 31, 28036 Madrid",40.4609,-3.6880,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12142.587875978732!2d-3.688023!3d40.46095!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x4828644e3e4f6af!2sCovent%20Garden%20English%20Pub!5e0!3m2!1sen!2ses!4v1622121196852!5m2!1sen!2ses");
        Local coventGarden = new Local("Covent Garden",dirCoventGarden,"http://coventgarden.es/covent-garden/","913450392",100);
        expectedList.add(coventGarden);


        Direccion dirIrishRover = new Direccion("Av. de Brasil, 7, 28020 Madrid",40.4547,-3.6940,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12143.7124923661!2d-3.6939592!3d40.4547278!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xac5dccb9e6db0dd5!2sThe%20Irish%20Rover!5e0!3m2!1sen!2ses!4v1622121253527!5m2!1sen!2ses");
        Local irishRover = new Local("Irish Rover",dirIrishRover,"https://www.theirishrover.com/","915974811",100);
        expectedList.add(irishRover);



        Direccion dirBarcelo= new Direccion("C. de Barceló, 11, 28004 Madrid",40.4269,-3.6998,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12148.735169352476!2d-3.699822!3d40.426929!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x7a731def889d4532!2sBarcel%C3%B3%20Theatre!5e0!3m2!1sen!2ses!4v1622121552862!5m2!1sen!2ses");
        Local teatroBarcelo = new Local("Teatro Barcelo",dirBarcelo,"https://teatrobarcelo.com/en/","913450392",500);

        expectedList.add(teatroBarcelo);


        //expectedList.add();


        //expectedList.add();
        //When
        List<Local> result = localesService.getTodosLocales();

        //Then

        then(result).isEqualTo(expectedList);
    }
    @Transactional
    @Test
    public void given_service_when_call_getLocalesId_then_Ok() {

        //Given
        Direccion dirIrishRover = new Direccion("Av. de Brasil, 7, 28020 Madrid",40.4547,-3.6940,"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12143.7124923661!2d-3.6939592!3d40.4547278!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xac5dccb9e6db0dd5!2sThe%20Irish%20Rover!5e0!3m2!1sen!2ses!4v1622121253527!5m2!1sen!2ses");
        Local irishRover = new Local("Irish Rover",dirIrishRover,"https://www.theirishrover.com/","915974811",100);
        irishRover.setId(2L);
        //When
        Local result = localesService.getLocalId2(2L);

        //Then

        then(result).isEqualTo(irishRover);
    }
}
