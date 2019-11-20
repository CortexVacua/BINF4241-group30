import java.util.Scanner;

public class Smartphone {
    Oven oven=new Oven();
    Microwave micr= new Microwave();

    Command OvenSwitchOn=new OvenSwitchOn(oven);
    Command OvenSwitchOff=new OvenSwitchOff(oven);
    Command OvenSetTimer=new OvenSetTimer(oven);
    Command OvenCheckTimer=new OvenCheckTimer(oven);
    Command OvenStart= new OvenStart(oven);
    Command OvenStop=new OvenStop(oven);
    Command OvenSetProgram=new OvenSetProgram(oven);
    Command OvenSetTemperature=new OvenSetTemperature(oven);

    MenuState state=MenuState.MAINMENU;

    String input;

    public void menu(){
//        MainMenu
            if (state==MenuState.MAINMENU){
                System.out.println("Please chose the device you want to control:\n"+
                        "for the oven type -o,\nfor the microwave type in -m,\nfor the dishwasher type in -d,\nfor washing machine type in -w,\n" +
                        "for cleaning robot type in -c: \n");
                Scanner myObj = new Scanner(System.in);
                if (myObj.hasNextLine()) {
                    input = myObj.nextLine();
                    if (input.equals("-o")) state=MenuState.OVEN;
                    else if (input.equals("-m")) state=MenuState.MICROWAVE;
                    else if (input.equals("-d")) state=MenuState.DISHWASHER;
                    else if (input.equals("-w")) state=MenuState.WASHINGMACHINE;
                    else if (input.equals("-c")) state=MenuState.CLEANINGROBOT;
                    else {
                        System.out.println("Invalid Input! Try again. \n");
                    }
                }
                else System.out.println("Invalid Input! Try again. \n");
            }

//            Oven
            else if (state==MenuState.OVEN){
                System.out.println("Please select action for device or type in -r to return to main menu:\n"+
                        "to switch on the oven type in -swon,\nto switch off the oven type in -swoff,\nto set a timer type in -sti" +
                        "\nto check timer type in -ct,\nto set program type in -sp,\nto set temperature type in -ste,\n" +
                        "to start device type in -sta,\nto stop device type in -sto:\n");
                Scanner myObj = new Scanner(System.in);
                if (myObj.hasNextLine()) {
                    input = myObj.nextLine();
                    if (input.equals("-r")) state=MenuState.MAINMENU;
                    else if (input.equals("-swon")) OvenSwitchOn.execute();
                    else if (input.equals("-swoff")) OvenSwitchOff.execute();
                    else if (input.equals("-sti")) OvenSetTimer.execute();
                    else if (input.equals("-ct")) OvenCheckTimer.execute();
                    else if (input.equals("-ste")) OvenSetTemperature.execute();
                    else if (input.equals("-sp")) OvenSetProgram.execute();
                    else if (input.equals("-sta")) OvenStart.execute();
                    else if (input.equals("-sto")) OvenStop.execute();
                    else {
                        System.out.println("Invalid Input! Try again. \n");
                    }
                }
                else System.out.println("Invalid Input! Try again. \n");
            }
    }
    public static void main (String[] args){
        Smartphone S=new Smartphone();
        while (true){
            S.menu();
        }

    }

}
