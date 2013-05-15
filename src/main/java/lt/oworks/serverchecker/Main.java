package lt.oworks.serverchecker;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Need settings file path");
        } else {
            System.out.println("Starting");
        }
    }
}
