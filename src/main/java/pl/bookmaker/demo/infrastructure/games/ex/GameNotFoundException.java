package pl.bookmaker.demo.infrastructure.games.ex;


public class GameNotFoundException extends NotFoundException {

    public GameNotFoundException(String message) {
        super(message);
    }
}
