package mk.ukim.finki.wp.rentscoot.model.exceptions;

public class InvalidPromotionException extends RuntimeException {
    public InvalidPromotionException(String message) {
        super(message);
    }

    public InvalidPromotionException() {
    }
}
