/**
 * An AlarmClock object is made up of a ClockDisplay12 object, 
 * representing the current time, and an Alarm object
 * represting the alarm (time and whether or not it's set).
 * 
 * The above description is taken from the assignment
 * 
 * @author Mounica Pillarisetty
 * @version September 29th, 2017
 * (2:21pm)
 */
public class AlarmClock
{
    // instance variables
    private ClockDisplay12 clockTime;
    private Alarm alarm;

    /**
     * A default constructor (no parameters) that sets the 
     * clock to midnight, the alarm to midnight, 
     * and the alarm off. (using Alaram class)
     */
    public AlarmClock()
    {
        alarm = new Alarm();
    }
    
    /**
     * A constructor with 7 parameters
     * @param hours
     * @param minutes
     * @param AMorPM
     * @param alarmHour
     * @param alarmMinute
     * @param alarmAMorPM
     * @param alarmIsON
     */
    public AlarmClock(int hours, int minutes, String AMorPM, 
                      int alarmHour, int alarmMinute, 
                      String alarmAMorPM, boolean alarmIsON)
    {
        clockTime = new ClockDisplay12(hours, minutes, AMorPM);
        alarm = new Alarm(alarmHour, alarmMinute, alarmAMorPM, 
                          alarmIsON);
        
    }
    
    /**
     * A constructor with 3 parameters that sets the clock time
     * @param hours
     * @param minutes
     * @param AMorPM
     */
    public void setTime(int hours, int minutes, String AMorPM)
    {
        clockTime.setTime(hours,minutes,AMorPM);
    }
    
    /**
     * A constructor with 3 parameters that sets the alarm time.
     * @param hours
     * @param minutes
     * @param AMorPM
     */
    public void setAlarmTime(int hours, int minutes, String AMorPM)
    {
        alarm.setTime(hours, minutes, AMorPM);
    }
    
    /**
     * A method that makes the clock tick (moves the minutes ahead by 1),
     * and, if appropriate, rings the alarm, and turns it off.
     */
    public void clockTick()
    {
        clockTime.timeTick();
        
        if(clockTime.getTime().equals(alarm.getTime()))
        {
            System.out.println("RING RING RING");
            alarm.turnOff();
        }
    }
    
    /**
     * A method that turns the alarm on
     */
    public void setAlarm()
    {
        alarm.turnOn();
        // if(clockTime.getTime().equals(alarm.getTime()))
        // {
            // System.out.println("RING RING RING");
            // alarm.turnOff();
        // }
    }
    
    /**
     * A method that turns the alarm off
     */
    public void unsetAlarm()
    {
        alarm.turnOff();
    }
    
    /**
     * A method that returns a String representing 
     * the current clock time.
     * @return clock time
     */
    public String getTime()
    {
        return clockTime.getTime();
    }
    
    /**
     * A method that returns a String representing 
     * the current alarm time.
     * @return alarm time
     */
    public String getAlarmTime()
    {
        return alarm.getTime();
    }
    
    /**
     * isAlarmSet is method that returns true if the alarm is set,
     * false otherwise.
     * @return  alarm set
     */
    public boolean isAlarmSet()
    {
        if(alarm.isSet() == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
