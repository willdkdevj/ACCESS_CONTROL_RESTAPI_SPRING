package br.com.supernova.accesscontrol.exception;

public class JornadaTrabalhoException extends Exception{

    public JornadaTrabalhoException(Long id){
        super(String.format("It was not possible to find the Workday entered through the ID - %d", id));
    }
}
