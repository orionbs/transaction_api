package fr.orionbs.transaction_manager.domain.exception;

public class UnknownCurrencyException extends Exception {
    public UnknownCurrencyException() {
        super("unknown-currency-exception");
    }
}
