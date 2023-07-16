package fr.orionbs.transaction_manager_server.domain.exception;

public class UnknownAccountException extends Exception {
    public UnknownAccountException() {
        super("unknown-account-exception");
    }
}
