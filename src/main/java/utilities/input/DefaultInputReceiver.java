package utilities.input;

import java.util.Scanner;

public class DefaultInputReceiver implements InputReceiver{

    private final Scanner in = new Scanner(System.in);

    @Override
    public String receiveLine() {
        return in.nextLine();
    }
}
