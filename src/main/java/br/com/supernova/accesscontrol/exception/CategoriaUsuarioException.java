package br.com.supernova.accesscontrol.exception;

public class CategoriaUsuarioException extends Exception{

    public CategoriaUsuarioException(Long id){
        super(String.format("It was not possible to find the Category User entered through the ID - %d", id));
    }
}
