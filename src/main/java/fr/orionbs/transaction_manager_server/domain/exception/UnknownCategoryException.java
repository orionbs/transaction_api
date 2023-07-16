package fr.orionbs.transaction_manager_server.domain.exception;

public class UnknownCategoryException extends Exception {
    public UnknownCategoryException() {
        super("unknown-category-exception");
    }
}
