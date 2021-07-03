package br.com.supernova.accesscontrol.exception;

public class NivelAcessoException extends Exception{

    public NivelAcessoException(Long id){
        super(String.format("It was not possible to find the Access Level entered through the ID - %d", id));
    }
}
