import java.util.Scanner;

public class Smartphone {
    Oven oven=new Oven();
    Microwave micr= new Microwave();
    CleaningRobot rbt = new CleaningRobot();
    Dishwasher dishwasher = new Dishwasher();
    WashingMachine washingmachine = new WashingMachine();

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

    Command RobotCheckBattery = new RobotCheckBattery(rbt);
    Command RobotCheckCompletion = new RobotCheckCompletion(rbt);
    Command RobotCheckTimer = new RobotCheckTimer(rbt);
    Command RobotCompleteCleaning = new RobotCompleteCleaning(rbt);
    Command RobotSetTimer = new RobotSetTimer(rbt);
    Command RobotStart = new RobotStart(rbt);
    Command RobotStop = new RobotStop(rbt);

    Command DWSwitchOn = new CDWSwitchOn(dishwasher);
    Command DWSwitchOff = new CDWSwitchOff(dishwasher);
    Command DWSetProgram = new CDWSetProgram(dishwasher);
    Command DWCheckTimer = new CDWCheckTimer(dishwasher);
    Command DWStart = new CDWStart(dishwasher);
    Command DWStop = new CDWStop(dishwasher);

    Command WMSwitchOn = new CWMSwitchOn(washingmachine);
    Command WMSwitchOff = new CWMSwitchOff(washingmachine);
    Command WMSetProgram = new CWMSetProgram(washingmachine);
    Command WMSetTemperature = new CWMSetTemperature(washingmachine);
    Command WMStart = new CWMStart(washingmachine);
    Command WMStop = new CWMStop(washingmachine);
//    Command WMCheckTimer = new CWMCheckTimer(washingmachine);

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
                    System.out.println("Please select an action for the device or type in -r to return to main menu:\n" +
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

//            Dishwasher
            else if (state == MenuState.DISHWASHER){
                if (dishwasher.is_on() == true){
                    System.out.println("Please select an action for the device or return to main menu:\n\n" +
                            "to set a program type in -sp , \n" +
                            "to check the timer type in -ct , \n" +
                            "to start the dishwasher type in -sta , \n" +
                            "to stop the dishwasher type in -sto , \n" +
                            "to switch off the dishwasher type in -swoff , \n" +
                            "to return to the main menu type in -r : \n");
                    Scanner myObj = new Scanner(System.in);
                    if (myObj.hasNextLine()) {
                        input = myObj.nextLine();
                        if (input.equals("-r")) state = MenuState.MAINMENU;
                        else if (input.equals("-sp")) DWSetProgram.execute();
                        else if (input.equals("-ct")) DWCheckTimer.execute();
                        else if (input.equals("-sta")) DWStart.execute();
                        else if (input.equals("-sto")) DWStop.execute();
                        else if (input.equals("-swoff")) DWSwitchOff.execute();
                        else System.out.println("Invalid Input! Try again. \n");
                    } else System.out.println("Invalid Input! Try again. \n");
                }
                else {
                    System.out.println("Please select an action for the device or return to main menu:\n\n" +
                            "to switch on the dishwasher type in -swon , \n" +
                            "to return to the main menu type in -r : \n");
                    Scanner myObj = new Scanner(System.in);
                    if (myObj.hasNextLine()) {
                        input = myObj.nextLine();
                        if (input.equals("-r")) state = MenuState.MAINMENU;
                        else if (input.equals("-swon")) DWSwitchOn.execute();
                        else System.out.println("Invalid Input! Try again. \n");
                    } else System.out.println("Invalid Input! Try again. \n");
                }
            }

//            Washing Machine

            //Cleaning robot
            else if (state==MenuState.CLEANINGROBOT){
                System.out.println("Please select action for device or type in -r to return to main menu:\n" +
                        "to set a timer type in -sti," +
                        "\nto check timer type in -ct,\nto start the cleaning robot type in -sc,\nto check cleaning completion in % type in -ccc,\n" +
                        "to check battery status type in -sta,\nto end cleaning type in -ec,\nto complete outstanding cleaning type in -c:\n");
                Scanner myObj = new Scanner(System.in);
                if (myObj.hasNextLine()) {
                    input = myObj.nextLine();
                    if (input.equals("-r")) state = MenuState.MAINMENU;
                    else if (input.equals("-sti")) RobotSetTimer.execute();
                    else if (input.equals("-ct")) RobotCheckTimer.execute();
                    else if (input.equals("-sc")) RobotStart.execute();
                    else if (input.equals("-ccc")) RobotCheckCompletion.execute();
                    else if (input.equals("-sta")) RobotCheckBattery.execute();
                    else if (input.equals("-ec")) RobotStop.execute();
                    else if (input.equals("-c")) RobotCompleteCleaning.execute();
                    else {
                        System.out.println("Invalid Input! Try again. \n");
                    }
                } else System.out.println("Invalid Input! Try again. \n");
        }
    }
    public static void main (String[] args){
        Smartphone S=new Smartphone();
        while (true){
            S.menu();
        }

    }

}
