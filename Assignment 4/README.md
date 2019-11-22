The smartphone class utilizes the state pattern in order to serve up the submenu requested by the user.

The class diagram can be found below. You can find a png file of the diagram called "class diagram.png" within the same folder in this repository.                                


```puml

interface BaseInterface <<Interface>> {
    {abstract} +SetTimer(Seconds: Integer)
    {abstract} +CheckTimer()
    {abstract} +Start()
    {abstract} +Stop()
}

interface Charger <<Interface>> {
    {abstract} +CheckBatteryDischarging()
    {abstract} +CheckBatteryCharging()
    {abstract} +CheckCleaningCompletion()
}

interface Command <<Interface>> {
    {abstract} +execute()
}

interface Switch <<Interface>> {
    {abstract} +SwitchOn()
    {abstract} +SwitchOff()
}

interface Temperature <<Interface>> {
    {abstract} +SetTemperature(TemperatureInCelsius: Integer)
}

interface DishwasherState <<Interface>> {
    {abstract} +setTimer()
}

interface WashingMachineState <<Interface>> {
    {abstract} +setTimer()
}

class CleaningRobot {
    #Robot: RobotThread
    #Robotrt: Thread
    #inBaseCharging: Boolean
    +SetTimer(TimeInSeconds: Integer)
    +CheckTimer()
    +Start()
    +Stop()
    +CheckBatteryDischarging()
    +CheckBatteryCharging()
    +CheckCleaningCompletion()
}

class Dishwasher {
    -system_on: Boolean
    -timer: Integer
    -dishwasher_mythread: MyThread
    -dishwasher_thread: Thread
    -elapsedtime: Long
    -starttime: Long
    +SwitchOn()
    +SwitchOff()
    +chooseProgram(state: DishwasherState)
    +SetTimer(time: Integer)
    +CheckTimer()
    +Start()
    +Stop()
}
class WashingMachine {
    -system_on: Boolean
    -temperature: Integer
    -timer: Integer
    -washingmachine_mythread: MyThread
    -washingmachine_thread: Thread
    -elapsedtime: Long
    -starttime: Long
    +SwitchOn()
    +SwitchOff()
    +SetTemperature(TemperatureInCelsius: Integer)
    +chooseProgram(state: WashingMachineState)
    +SetTimer(time: Integer)
    +CheckTimer()
    +Start()
    +Stop()
}

class Microwave {
    +system_on: Boolean
    -timer: Integer
    -Microwavemt: MyThread
    -Microwavert: Thread
    -elapsedtime: Long
    -starttime: Long
    -temperature: Integer
    +SwitchOn()
    +SwitchOff()
    +SetTemperature(TempInCelsius: Integer)
    +SetTimer(TimeInSeconds: Integer)
    +CheckTimer()
    +Start()
    +Stop()
}

class Oven {
    +system_on: Boolean
    -timer: Integer
    -Ovenmt: MyThread
    -Ovenrt: Thread
    -elapsedtime: Long
    -starttime: Long
    -temperature: Integer
    -program: OvenProgram
    +SwitchOn()
    +SwitchOff()
    +SetTemperature(TempInCelsius: Integer)
    +SetTimer(TimeInSeconds: Integer)
    +SetProgram(DesiredProgram: OvenProgram)
    +CheckTimer()
    +Start()
    +Stop()
}

class MyThread <<Thread>> {
    -running: Boolean
    -time: Integer
    +isRunning(): Boolean
    +run()
}

class RobotThread <<Thread>> {
    #time: Integer
    #charging_state: ChargingState
    #cleaning_state: CleaningState
    #charge: Integer
    #requested_cleaning_time: Integer
    #remaining_cleaning_time: Integer
    +run()
    +SetTimer(TimeInSeconds: Integer)
    +CheckTimer()
    +Start()
    +Stop()
    +CheckBatteryDischarging()
    +CheckBatteryCharging()
    +CheckCleaningCompletion()
}

class Smartphone {
    ~oven: Oven
    ~micr: Microwave
    ~rbt: CleaningRobot
    ~washingmachine: WashingMachine
    ~dishwasher: Dishwasher
    ~Oven...: Command
    ~Micr...: Commmand
    ~Robot...: Command
    ~WM...: Command
    ~DW...: Command
    ~state: MenuState
    ~input: String
    +menu()
    {static} +main(String args[])
}

Charger <|.. CleaningRobot
BaseInterface <|.. CleaningRobot
BaseInterface <|.. Dishwasher
Switch <|.. Dishwasher
BaseInterface <|.. Microwave
Switch <|.. Microwave
Temperature <|.. Microwave
BaseInterface <|.. Oven
Switch <|.. Oven
Temperature <|.. Oven
BaseInterface <|.. WashingMachine
Switch <|.. WashingMachine
Temperature <|.. WashingMachine
Dishwasher o-- MyThread
Microwave o-- MyThread
Oven o-- MyThread
WashingMachine o-- MyThread
CleaningRobot o-- RobotThread
Dishwasher o-- DishwasherState
WashingMachine o-- WashingMachineState
Smartphone o-- Command
Smartphone o-- CleaningRobot
Smartphone o-- Dishwasher
Smartphone o-- Microwave
Smartphone o-- Oven
Smartphone o-- WashingMachine
```