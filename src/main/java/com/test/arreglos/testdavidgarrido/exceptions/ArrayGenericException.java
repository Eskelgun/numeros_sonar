package com.test.arreglos.testdavidgarrido.exceptions;

public class ArrayGenericException extends RuntimeException {

  public ArrayGenericException(String message) {
    super(message.concat(" | Intente nuevamente."));
  }
}
