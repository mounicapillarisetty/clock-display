
/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * @author Mounica Pillarisetty
 * @version September 29th, 2017
 * 
 */
public class ClockDisplay12
{
    private NumberDisplay hours; // Time hours(s)
    private NumberDisplay minutes; // Time minute(s)
    private String displayString;// simulates the actual display
    //NEW VAEIABLES CREATED
    private static final String AM = "a.m."; // variable storing am
    private static final String PM = "p.m."; // variable storing pm
    private String amPm; // variable storing am or pm from user
    
    /**
     * Constructor for ClockDisplay12 objects. 
     * This constructor creates a new clock set at 12:00a.m.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        amPm = AM;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay12 objects. 
     * This constructor creates a new clock set at the time 
     * specified by its parameters.
     * @param hour
     * @param minute
     * @param AMorPM
     */
    public ClockDisplay12(int hour, int minute, String AMorPM)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, AMorPM);
    }

    /**
     * This method gets called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        if(hours.getValue() == 11 && minutes.getValue() == 59)
        {
            if(amPm == AM)
            {
                amPm = PM;
            }
            else
            {
                amPm = AM;
            }
        }
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the hour and
     * minute specified.
     * @param hour
     * @param minute
     * @param AMorPM
     */
    public void setTime(int hour, int minute, String AMorPM)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        
        if(AMorPM.equals(AM) && (hour <= 12 && hour >= 0))
        {
            amPm = AM;
        }
        else if(AMorPM.equals(PM) && (hour <= 12 && hour >= 0))
        {
            amPm = PM;
        }
        else
        {
            amPm = AM;
            if(hour > 12 || hour < 0)
            {
                hour = 12;
                setTime(hour,minute,amPm);
            }
            if(minute < 0 || minute > 59)
            {
                setTime(hour,minute,amPm);
        }
            if (!(amPm.equals(PM)) && !(amPm.equals(AM)))
            {
                amPm = AM;
                setTime(hour,minute,amPm);   
            }
        }
        updateDisplay();
    }

    /**
     * Returns the current time of this display in the format HH:MM.
     * @return time
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if(hours.getValue() == 0)
        
        {
            displayString = "12" + ":" +  
            minutes.getDisplayValue()+ amPm;
        }
        else
        {
            displayString = hours.getValue() + ":" + 
             minutes.getDisplayValue() + amPm;
        }
    }
}