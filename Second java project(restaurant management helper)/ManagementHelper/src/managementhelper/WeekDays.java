/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementhelper;

/**
 *
 * @author Mark
 */
public class WeekDays   {
    protected String day;
    
    protected double shiftStart;
    protected double shiftEnd;
    public WeekDays(double shiftStart, double shiftEnd ,String day ){
       this.shiftStart = shiftStart;
       this.shiftEnd = shiftEnd;
       this.day= day;
        
    }
    
    

    public double getShiftStart() {
        return this.shiftStart;
    }

    public void setShiftStart(double shiftStart) {
        this.shiftStart = shiftStart;
    }

    public double getShiftEnd() {
        return this.shiftEnd;
    }

    public void setShiftEnd(double shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

  

   
    
    @Override
    public String toString(){
     return day +" from " +shiftStart +" until "+ shiftEnd;   
    }
}