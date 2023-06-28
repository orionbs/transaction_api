package fr.orionbs.transaction_manager.domain.exception;

public class UnknownCategoryException extends Exception {
    public UnknownCategoryException() {
        super("unknown-category-exception");
    }
}
