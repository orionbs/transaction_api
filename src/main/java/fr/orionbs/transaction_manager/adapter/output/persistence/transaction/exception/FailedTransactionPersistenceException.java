package fr.orionbs.transaction_manager.adapter.output.persistence.transaction.exception;

public class FailedTransactionPersistenceException extends Throwable {
    public FailedTransactionPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
