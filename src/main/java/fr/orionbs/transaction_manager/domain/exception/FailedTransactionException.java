package fr.orionbs.transaction_manager.domain.exception;

public class FailedTransactionException extends Exception {
    public FailedTransactionException() {
        super("failed-transaction-exception");
    }
}
