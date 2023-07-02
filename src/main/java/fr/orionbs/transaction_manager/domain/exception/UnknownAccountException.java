package fr.orionbs.transaction_manager.domain.exception;

public class UnknownAccountException extends Exception {
    public UnknownAccountException() {
        super("unknown-account-exception");
    }
}
