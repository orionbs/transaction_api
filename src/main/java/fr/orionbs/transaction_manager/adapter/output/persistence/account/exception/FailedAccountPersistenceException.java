package fr.orionbs.transaction_manager.adapter.output.persistence.account.exception;

public class FailedAccountPersistenceException extends Throwable {
    public FailedAccountPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
