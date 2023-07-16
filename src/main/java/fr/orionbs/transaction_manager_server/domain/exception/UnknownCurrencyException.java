package fr.orionbs.transaction_manager_server.domain.exception;

public class UnknownCurrencyException extends Exception {
    public UnknownCurrencyException() {
        super("unknown-currency-exception");
    }
}
