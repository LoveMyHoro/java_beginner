package t7_异常.part_2;

public class AgeFormatException extends RuntimeException{
    public AgeFormatException() {
    }

    public AgeFormatException(String message) {
        super(message);
    }
}
