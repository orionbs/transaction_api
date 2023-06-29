package fr.orionbs.transaction_manager.domain.exception;

public class UnknownFrequencyException extends Exception {
    public UnknownFrequencyException() {
        super("unknown-frequency-exception");
    }
}
