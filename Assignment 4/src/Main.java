/**
 * This is a test class. Basically, two threads can be created by the user. The first thread always wait 10 seconds,
 * the second one 20. This class also provide and example of how manage the time without a thread but with the
 * default java method System.currentTimeMillis(). This method returns the current timestamp of the System in
 * millisecond as a long output.
 * */

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Oven O=new Oven();
        O.SwitchOn();
        O.SetTimer(200);
        O.SetTemperature(200);
        O.SetProgram(OvenProgram.GRILLED);
        O.Start();

        System.out.print("\n");

        Dishwasher DW = new Dishwasher();
        DW.SwitchOn();
        DW.chooseProgram(DW.glassesState);
        DW.Start();

        WashingMachine WM = new WashingMachine();
        WM.SwitchOn();
        WM.chooseProgram(WM.quickState);
        WM.SetTemperature(40);
        WM.Start();

        O.CheckTimer();
        DW.CheckTimer();
        WM.CheckTimer();

        O.Stop();
        DW.Stop();
        WM.Stop();

    }
}