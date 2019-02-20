package MyProjects.Mutex;

public class Insider {
    String string;
    char aChar;

    public Insider(char aChar) {
        this.aChar = aChar;
    }

    public Insider(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }
}
