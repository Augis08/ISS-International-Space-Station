package controller.entry;

import controller.Controller;
import utilities.input.InputReceiver;
import utilities.output.OutputProducer;

public class EntryController implements Controller {

    private final Controller issPassTimesController;
    private final Controller issSpeedController;
    private final Controller peopleInSpaceController;
    private final InputReceiver receiver;
    private final OutputProducer output;

    public EntryController(Controller issPassTimesController,
                           Controller issSpeedController,
                           Controller peopleInSpaceController,
                           InputReceiver receiver,
                           OutputProducer output) {
        this.issPassTimesController = issPassTimesController;
        this.issSpeedController = issSpeedController;
        this.peopleInSpaceController = peopleInSpaceController;
        this.receiver = receiver;
        this.output = output;
    }

    @Override
    public void run() {
        output.produce("***** Welcome *****");
        printInstructions();
        receiveInputAndAct();
    }

    private void printInstructions() {
        output.produce("S - Calculate ISS speed");
        output.produce("R - Get a list of upcoming ISS runs for a specific location");
        output.produce("P - Show the number of people in space within the ISS");
        output.produce("X - Exit");
    }

    private void receiveInputAndAct() {
        String input = receiver.receiveLine().toUpperCase();
        switch (input){
            case "S":
                issSpeedController.run();
                break;
            case "R":
                issPassTimesController.run();
                break;
            case "P":
                peopleInSpaceController.run();
                break;
            case "X":
                return;
            default:
                output.produce("Unrecognised action!");
                printInstructions();
        }
        receiveInputAndAct();
    }
}
