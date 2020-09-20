
/**
 * Write a description of class Alarm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Alarm
{
    private ClockDisplay12 clockOne;
    private Boolean flag;

    /**
     * Initializes Alarm to 12:00
     */
    public Alarm()
    {
        // initialise instance variables
        clockOne = new ClockDisplay12();
        flag=false;
    }

    /**
     * Iitilizes the alarm to have a user specified time and alarm state.
     */
    public Alarm(int hours, int minutes, String amPm, Boolean setAlarm)
    {
        clockOne= new ClockDisplay12(hours, minutes, amPm);
        flag=setAlarm;
    }
    /**
     * Sets the time of the clock using the 3 variables
     */
    public void setTime(int hours, int minutes, String amPm)
    {
        clockOne.setTime(hours, minutes, amPm);
    }
    
    /**
     * Turn on the alarm
     */
    public void turnOn()
    {
        flag=true;
    }
    
    /**
     * Turn off the alarm
     *
     */
    public void turnOff()
    {
        flag=false;
    }
    
    /**
     * Gets the current alarm time
     */
    public String getTime()
    {
        return clockOne.getTime();
    }
    /**
     * Checks to see if the alarm is set
     */
    public Boolean isSet()
    {
        return flag;
    }
    
    
}