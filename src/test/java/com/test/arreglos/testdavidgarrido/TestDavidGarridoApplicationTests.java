package com.test.arreglos.testdavidgarrido;

import com.test.arreglos.testdavidgarrido.exceptions.ArrayGenericException;
import com.test.arreglos.testdavidgarrido.exceptions.BadParamException;
import com.test.arreglos.testdavidgarrido.exceptions.WrongItemArrayException;
import com.test.arreglos.testdavidgarrido.service.Arreglo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TestDavidGarridoApplicationTests {

  private Arreglo arregloIn;

  @BeforeEach
  void setUp() {
    arregloIn = new Arreglo();
  }

  @Test
  void validarParametrosValidos() {
//    ARRANGE
    String mensajeEx = "La lista y/o el número a buscar no son validos | Intente nuevamente.";


//  ACT
    Exception exception = assertThrows(BadParamException.class, () ->
            arregloIn.numeroConcurrencia(new ArrayList<>(), null));

//    Assert
    Assertions.assertEquals(mensajeEx, exception.getMessage());

  }

  @Test
  void validarValoresDelArreglo() {
//    ARRANGE
    List valores = List.of(10, 5.1, "a");
    Integer numero = 10;
    Integer valorEsperado = -1;

    String mensajeEx = "Sólo se permiten números en el arreglo | Valor incorrecto: a | Intente nuevamente.";

//  ACT
    Exception exception = assertThrows(WrongItemArrayException.class, () ->
            arregloIn.numeroConcurrencia(valores, numero));

//    Assert
    Assertions.assertEquals(mensajeEx, exception.getMessage());

  }

  @Test
  void valorEsperadoOk() {
//    ARRANGE
    List valores = List.of(10, 5.1, 10);
    Integer numero = 10;
    Integer valorEsperado = 2;

//  ACT
    Integer value = arregloIn.numeroConcurrencia(valores, numero);

//    Assert
    Assertions.assertEquals(valorEsperado, value);

  }

}
