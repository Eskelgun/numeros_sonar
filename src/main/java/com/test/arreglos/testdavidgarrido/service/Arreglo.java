package com.test.arreglos.testdavidgarrido.service;

import com.test.arreglos.testdavidgarrido.exceptions.ArrayGenericException;
import com.test.arreglos.testdavidgarrido.exceptions.BadParamException;
import com.test.arreglos.testdavidgarrido.exceptions.WrongItemArrayException;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Arreglo {

  public Integer numeroConcurrencia(List arreglo, Integer numero) throws ArrayGenericException {
//    Validar parametros
    if (arreglo == null || arreglo.isEmpty() || numero == null) {
      System.err.println("La lista y/o el número a buscar no son validos");
      throw new BadParamException("La lista y/o el número a buscar no son validos");

    } else {
//      Validar arreglo sólo contenga números

      Matcher matcher;
      Pattern pattern = Pattern.compile("^[^0-9]$");

      for (Object item : arreglo) {
        matcher = pattern.matcher(String.valueOf(item));
        if (matcher.find()) {
          System.err.println("Sólo se permiten números en el arreglo | Valor incorrecto: " + item.toString());
          throw new WrongItemArrayException("Sólo se permiten números en el arreglo | Valor incorrecto: " + item.toString());
        }
      }
//      Contar concurrencia
      return Collections.frequency(arreglo, numero);
    }
  }

}
