/**
 * This is a test class. Basically, two threads can be created by the user. The first thread always wait 10 seconds,
 * the second one 20. This class also provide and example of how manage the time without a thread but with the
 * default java method System.currentTimeMillis(). This method returns the current timestamp of the System in
 * millisecond as a long output.
 * */

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String args[]) throws InterruptedException {

        Oven O=new Oven();
        O.SwitchOn();
        O.SetTimer(30);
        O.SetTemperature(200);
        O.SetProgram(OvenProgram.GRILLED);
        O.Start();

        Microwave M=new Microwave();
        M.SwitchOn();
        M.SetTimer(30);
        M.SetTemperature(200);
        M.Start();

        while (true){
            TimeUnit.SECONDS.sleep(5);
            M.CheckTimer();
            O.CheckTimer();
        }



    }
}