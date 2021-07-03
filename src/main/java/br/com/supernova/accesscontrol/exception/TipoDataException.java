package br.com.supernova.accesscontrol.exception;

public class TipoDataException extends Exception{

    public TipoDataException(Long id){
        super(String.format("It was not possible to find the Date entered through the ID - %d", id));
    }
}
