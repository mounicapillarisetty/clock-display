
/**
 * An Alarm object is made up of a ClockDisplay12 object and a 
 * boolean flag indicating whether or not the alarm is set (true 
 * means it is set; false means it isn't set)
 * 
 * The above description is taken from the assignment
 * 
 * @author Mounica Pillarisetty
 * @version September 29th, 2017
 */
public class Alarm
{
    //VAEIABLES CREATED
    private ClockDisplay12 alarmSet;
    private Boolean flag;

    /**
     * A default constructor (no parameters) 
     * that sets the clock to midnight and the alarm off.
     */
    public Alarm()
    {
        alarmSet = new ClockDisplay12();
        flag = false;
    }

    /**
     * Alarm is a constructor with 4 parameters
     * It initilaizes the alarm to specified time and alarm state from the user.
     * @param hours
     * @param minutes
     * @param AMorPM
     * @param alarmON
     */
    public Alarm(int hours, int minutes, String AMorPM, Boolean alarmON)
    {
        alarmSet = new ClockDisplay12(hours, minutes, AMorPM);
        flag = alarmON;
    }
    /**
     * Sets the alarm time with 3 parameters
     * @param hours
     * @param minutes
     * @param AMorPM 
     */
    public void setTime(int hours, int minutes, String AMorPM)
    {
        alarmSet.setTime(hours, minutes, AMorPM);
    }
    
    /**
     * Turns the alarm on
     */
    public void turnOn()
    {
        flag = true;
    }
    
    /**
     * Turns off the alarm
     */
    public void turnOff()
    {
        flag = false;
    }
  
    /**
     * Checks to see if the alarm is set
     * @return flag         
     * flag returns true if the alarm is set, false otherwise
     */
    public Boolean isSet()
    {
        if (flag == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * returns a String representing the current alarm time
     * @return alarm time
     */
    public String getTime()
    {
        return alarmSet.getTime();
    }
}