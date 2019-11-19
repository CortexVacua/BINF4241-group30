public interface Charger {
    public void ReturnToDock ();
    public void LeaveDock ();
    public int CheckBattery ();
    public int CheckBatteryCharging();
}
