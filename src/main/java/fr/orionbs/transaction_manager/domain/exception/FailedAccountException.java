package fr.orionbs.transaction_manager.domain.exception;

public class FailedAccountException extends Exception {
    public FailedAccountException() {
        super("failed-account-exception");
    }
}
