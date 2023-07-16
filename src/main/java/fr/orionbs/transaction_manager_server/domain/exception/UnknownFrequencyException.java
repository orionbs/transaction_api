package fr.orionbs.transaction_manager_server.domain.exception;

public class UnknownFrequencyException extends Exception {
    public UnknownFrequencyException() {
        super("unknown-frequency-exception");
    }
}
