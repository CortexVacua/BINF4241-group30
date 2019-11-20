    public class Microwave implements BaseInterface, Switch, Temperature{
        private MyThread Microwavemt;
        private Thread Microwavert;
        private boolean system_on = false;
        private int timer;
        private int temperature;
        private long elapsedtime;
        private long starttime;


        public void SetTimer(int TimeInSeconds) {
            if (system_on==true) {
                if (TimeInSeconds <= 0) System.out.println("Timer cannot be set to 0 or to a negative value.\n");
                else {
                    timer = TimeInSeconds * 1000;
                }
            }
            else System.out.println("Microwave is switched off.\n");
        }

        public void CheckTimer() {
            if (system_on==true) {
                if (Microwavemt == null)
                    System.out.println("Set timer is: " + timer / 1000 + "\n");
                else {
                    if (Microwavemt.isRunning()) {
                        elapsedtime = System.currentTimeMillis() - starttime;
                        System.out.println("Time remaining: " + (timer - elapsedtime) / 1000 + "\n");
                    }
                    else System.out.println("Set timer is: " + timer / 1000 + "\n");
                }
            }
            else System.out.println("Microwave is switched off.\n");
        }

        public void SetTemperature(int TempInCelsius){
            if (system_on==true) {
                if (TempInCelsius <= 0) System.out.println("Temperature cannot be set to 0 or to a negative value.\n");
                else {
                    temperature = TempInCelsius;
                }
            }
            else System.out.println("Microwave is switched off.\n");
        }

        public void Start() {
            if (system_on==true) {
                if (Microwavemt == null) {
                    if (timer == 0) System.out.println("No timer set!\n");
                    if (temperature == 0) System.out.println("Temperature has not been set.\n");
                    else if (timer!=0 && temperature !=0){
                        Microwavemt = new MyThread(timer);
                        Microwavert = new Thread(Microwavemt, "microwave");
                        Microwavert.start();
                        starttime = System.currentTimeMillis();
                        System.out.println("The microwave is running.\n");
                    }
                } else System.out.println("Microwave already running.\n");
            }
            else System.out.println("Microwave is switched off.\n");
        }

        public void Stop() {
            if (system_on==true) {
                if(Microwavemt!=null && Microwavemt.isRunning()) {
                    Microwavemt = null;
                    Microwavert = null;
                    timer = 0;
                    temperature = 0;
                    elapsedtime = 0;
                    starttime = 0;
                }
                else System.out.println("The microwave does not seem to be running any program you could stop.\n");
            }
            else System.out.println("Microwave is switched off.\n");
        }


        public void SwitchOn() {
            if (system_on==true) System.out.println("Microwave is already switched on.\n");
            else {
                system_on=true;
                System.out.println("Microwave has been switched on.\n");
            }

        }


        public void SwitchOff() {
            if (system_on == true) {
                system_on = false;
                System.out.println("Microwave has been switched off.\n");
            }
            else System.out.println("Microwave is already switched off.\n");
        }
    }


