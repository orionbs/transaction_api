package fr.orionbs.transaction_manager_server.domain.exception;

public class FailedAccountException extends Exception {
    public FailedAccountException() {
        super("failed-account-exception");
    }
}
