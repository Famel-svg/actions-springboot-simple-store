package br.com.famel.springboot_simple_store.service.exceptions;
public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public DatabaseException(String msg) { super(msg); }
}
