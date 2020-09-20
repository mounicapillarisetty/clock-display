
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
 * issues: - adds the time onto first 
 *          (using already created classes) - 6 to 12:59
 *         - changes the time to pm to am - 5:59 to 6:00 - roll over - done
 *          
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String amPm;
    private static final String AM = "a.m.";
    private static final String PM = "p.m.";
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        amPm = AM;
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay12(int hour, int minute, String AMPM)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        if (!(AMPM.equals(PM) || AMPM.equals(AM))){
                AMPM = AM;
                setTime(hour, minute, AMPM);
            }
        if(AMPM.equals(AM) || AMPM.equals(PM)){
            if(hour == 0){
                setTime(12, minute, AMPM);
            }
            else if (hour > 12 || hour < 0 || minute > 59 || minute < 0){
                setTime(12, 0, AM);
            }
            else {
                setTime(hour, minute, AMPM);
            }
            
        }
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if (!(amPm.equals(PM) || amPm.equals(AM))){
               amPm = AM;
            }
            if (hours.getValue() == 0){
                if(amPm.equals(AM)){
                    amPm = PM;
                }
                if(amPm.equals(PM)){
                    amPm = AM;
                }
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String AMPM)
    {
        if (AMPM.equals(AM) || AMPM.equals(PM)){
            if(hour >= 12 || minute >=  60){
                setTime(12,0,AM);
            }
            // hours.setValue(hour);
            // minutes.setValue(minute);
            //amPm = AMPM;
            else{
                hours.setValue(hour);
                minutes.setValue(minute);
                amPm = AMPM;
            }
            
        /*else{
            if(hour >= 12 || minute >= 60){
                setTime (12,0,AM);
            }
            hours.setValue(hour);
            minutes.setValue(minute);
            amPm = AM;
          **/  
        }   
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
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
        if(hours.getValue() == 0){
            displayString = "12" + ":" +  
            minutes.getDisplayValue()+ amPm;
        }
        else{
            displayString = hours.getValue() + ":" + 
             minutes.getDisplayValue() + amPm;
        }
    }
}
