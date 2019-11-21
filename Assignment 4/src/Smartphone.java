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

    Command MicrSwitchOn= new MicrSwitchOn(micr);
    Command MicrSwitchOff= new MicrSwitchOff(micr);
    Command MicrSetTimer= new MicrSetTimer(micr);
    Command MicrCheckTimer= new MicrCheckTimer(micr);
    Command MicrStart=new MicrStart(micr);
    Command MicrStop=new MicrStop(micr);
    Command MicrSetTemperature=new MicrSetTemperature(micr);

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
                if (oven.system_on==true) {
                    System.out.println("Please select action for device or type in -r to return to main menu:\n" +
                            "to switch off the oven type in -swoff,\nto set a timer type in -sti" +
                            "\nto check timer type in -ct,\nto set program type in -sp,\nto set temperature type in -ste,\n" +
                            "to start cooking type in -sta,\nto interrupt the oven type in -i:\n");
                    Scanner myObj = new Scanner(System.in);
                    if (myObj.hasNextLine()) {
                        input = myObj.nextLine();
                        if (input.equals("-r")) state = MenuState.MAINMENU;
                        else if (input.equals("-swoff")) OvenSwitchOff.execute();
                        else if (input.equals("-sti")) OvenSetTimer.execute();
                        else if (input.equals("-ct")) OvenCheckTimer.execute();
                        else if (input.equals("-ste")) OvenSetTemperature.execute();
                        else if (input.equals("-sp")) OvenSetProgram.execute();
                        else if (input.equals("-sta")) OvenStart.execute();
                        else if (input.equals("-i")) OvenStop.execute();
                        else {
                            System.out.println("Invalid Input! Try again. \n");
                        }
                    } else System.out.println("Invalid Input! Try again. \n");
                }
                else {
                    System.out.println("Please select action for device or type in -r to return to main menu:\n"+
                            "to switch on the oven type in -swon,\n");
                    Scanner myObj = new Scanner(System.in);
                    if (myObj.hasNextLine()) {
                        input = myObj.nextLine();
                        if (input.equals("-r")) state = MenuState.MAINMENU;
                        else if (input.equals("-swon")) OvenSwitchOn.execute();
                        else System.out.println("Invalid Input! Try again. \n");
                    }
                    else System.out.println("Invalid Input! Try again. \n");
                }
            }

//            Microwave
            else if (state==MenuState.MICROWAVE){
                if (micr.system_on==true) {
                    System.out.println("Please select action for device or type in -r to return to main menu:\n" +
                            "to switch off the microwave type in -swoff,\nto set a timer type in -sti" +
                            "\nto check timer type in -ct,\nto set temperature type in -ste,\n" +
                            "to start baking type in -sta,\nto interrupt the oven type in -i:\n");
                    Scanner myObj = new Scanner(System.in);
                    if (myObj.hasNextLine()) {
                        input = myObj.nextLine();
                        if (input.equals("-r")) state = MenuState.MAINMENU;
                        else if (input.equals("-swon")) MicrSwitchOn.execute();
                        else if (input.equals("-swoff")) MicrSwitchOff.execute();
                        else if (input.equals("-sti")) MicrSetTimer.execute();
                        else if (input.equals("-ct")) MicrCheckTimer.execute();
                        else if (input.equals("-ste")) MicrSetTemperature.execute();
                        else if (input.equals("-sta")) MicrStart.execute();
                        else if (input.equals("-i")) MicrStop.execute();
                        else {
                            System.out.println("Invalid Input! Try again. \n");
                        }
                    } else System.out.println("Invalid Input! Try again. \n");
                }
                else {
                    System.out.println("Please select action for device or type in -r to return to main menu:\n" +
                            "to switch on the microwave type in -swon,\n");
                    Scanner myObj = new Scanner(System.in);
                    if (myObj.hasNextLine()) {
                        input = myObj.nextLine();
                        if (input.equals("-r")) state = MenuState.MAINMENU;
                        else if (input.equals("-swon")) MicrSwitchOn.execute();
                        else System.out.println("Invalid Input! Try again. \n");
                    } else System.out.println("Invalid Input! Try again. \n");
                }
            }
    }
    public static void main (String[] args){
        Smartphone S=new Smartphone();
        while (true){
            S.menu();
        }

    }

}
