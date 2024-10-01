public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Фрукт с id = " + id + " не найден");
    }
}