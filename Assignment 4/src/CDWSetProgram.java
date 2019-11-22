import java.util.Scanner;

public class CDWSetProgram implements Command {

    Dishwasher dishwasher;
    String program;

    public CDWSetProgram(Dishwasher dw) { dishwasher = dw; }

    @Override
    public void execute() {
        System.out.println("Please set your program: \n" +
                "for washing glasses type in -gl \n" +
                "for washing pans type in -pa \n" +
                "for washing plate type in -pl \n" +
                "for mashing mixed dished type in -mi \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextLine()) {
            program = myObj.nextLine();
            if (program.equals("-gl")) dishwasher.chooseProgram(dishwasher.glassesState);
            else if (program.equals("-pa")) dishwasher.chooseProgram(dishwasher.pansState);
            else if (program.equals("-pl")) dishwasher.chooseProgram(dishwasher.platesState);
            else if (program.equals("-mi")) dishwasher.chooseProgram(dishwasher.mixedState);
            else {
                System.out.println("Invalid Input! Try again. \n");
                this.execute();
            }
        } else {
            System.out.println("Invalid Input! Try again. \n");
            this.execute();
        }
    }
}
