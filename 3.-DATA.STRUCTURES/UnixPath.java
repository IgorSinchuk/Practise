import java.nio.file.Paths;

public class UnixPath {
    public String simplify(String input) {
        return Paths.get(input).normalize().toString();
    }
}