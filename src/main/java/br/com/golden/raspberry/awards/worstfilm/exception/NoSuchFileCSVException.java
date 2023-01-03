package br.com.golden.raspberry.awards.worstfilm.exception;

public class NoSuchFileCSVException extends Throwable{
 public NoSuchFileCSVException(){
     super("Please verify the cvs file is present or the path is correct");
 }

    public NoSuchFileCSVException(String message){
        super(message);
    }

    public NoSuchFileCSVException(String message, Throwable causeOfError){
        super(message, causeOfError);
    }
}
