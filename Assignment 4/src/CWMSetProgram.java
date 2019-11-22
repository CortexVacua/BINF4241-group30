import java.util.Scanner;

public class CWMSetProgram implements Command {

    WashingMachine washingmachine;
    String program;

    public CWMSetProgram(WashingMachine wm) { washingmachine = wm;}

    @Override
    public void execute() {
        System.out.println("Please set your program: \n" +
                "to double rinse type in -dr \n" +
                "to wash by spinning type in -ws \n" +
                "to wash intensively type in -wi \n" +
                "to wash quickly type in -wq \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextLine()) {
            program = myObj.nextLine();
            if (program.equals("-dr")) washingmachine.chooseProgram(washingmachine.doubleRinseState);
            else if (program.equals("-ws")) washingmachine.chooseProgram(washingmachine.spinState);
            else if (program.equals("-wi")) washingmachine.chooseProgram(washingmachine.intenseState);
            else if (program.equals("-wq")) washingmachine.chooseProgram(washingmachine.quickState);
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
