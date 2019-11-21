import java.util.Scanner;

public class OvenSetProgram implements Command {
    Oven oven;
    String prog;

    public OvenSetProgram(Oven o) {
        oven = o;
    }

//    sets program
    public void execute() {
        System.out.println("Please set your program: \n" +
                "for grilled type in -g,\nfor ventilated type in -v,\nfor bottom heat type in -b,\nfor top heat type in -t,\n" +
                "for bottom and top heat type in -bt: \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextLine()) {
            prog = myObj.nextLine();
            if (prog.equals("-g")) oven.SetProgram(OvenProgram.GRILLED);
            else if (prog.equals("-v")) oven.SetProgram((OvenProgram.VENTILATED));
            else if (prog.equals("-b")) oven.SetProgram((OvenProgram.BOTTOMHEAT));
            else if (prog.equals("-t")) oven.SetProgram((OvenProgram.TOPHEAT));
            else if (prog.equals("-bt")) oven.SetProgram((OvenProgram.TOPANDBOTTOMHEAT));
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
