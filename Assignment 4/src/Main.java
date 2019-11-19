/**
 * This is a test class. Basically, two threads can be created by the user. The first thread always wait 10 seconds,
 * the second one 20. This class also provide and example of how manage the time without a thread but with the
 * default java method System.currentTimeMillis(). This method returns the current timestamp of the System in
 * millisecond as a long output.
 * */

import java.util.*;

public class Main {

    public static void main(String args[]) {

        Oven O=new Oven();
        O.SetTimer(200);
        O.SetTemperature(200);
        O.Start();

        while (true){
            O.CheckTimer();
        }
    }
}