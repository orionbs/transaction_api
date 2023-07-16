package fr.orionbs.transaction_manager_server.domain.exception;

public class FailedTransactionException extends Exception {
    public FailedTransactionException() {
        super("failed-transaction-exception");
    }
}
