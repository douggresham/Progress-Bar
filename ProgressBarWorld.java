import greenfoot.*;
import java.util.ArrayList;
/**
 * A very primitive loading screen. Just wanted experience with timers, arrays, and object images
 * 
 * @author Doug Gresham 
 * @version April 10, 2015
 */
public class ProgressBarWorld extends World
{
    
    private Meter m = new Meter();
    private final int METER_SIZE = 752;
    private MeterPart[] meterWhole = new MeterPart[METER_SIZE];
    private int count=0;
    private Loading l = new Loading();
    private Period p1 = new Period();
    private Period p2 = new Period();
    private Period p3 = new Period();
    private int pCount=0;
    private Done d = new Done();
    private LoadDot[] lD = new LoadDot[6];
    private int lCount=0;
    public ProgressBarWorld()
    {  
        super(900, 600, 1); 
        for(int i=0;i<METER_SIZE;i++)
        {
            meterWhole[i]=new MeterPart();
        }
        for(int i=0;i<lD.length;i++)
        {
            lD[i]=new LoadDot();
        }
        addObject(m,450,300);
        addObject(l,147,191);
        addObject(lD[0],789,131);
        addObject(lD[1],812,173);
        addObject(lD[2],789,209);
        addObject(lD[3],740,209);
        addObject(lD[4],714,173);
        addObject(lD[5],738,131);
    }
    public void act()
    {
        if(lCount<6)
        {
            lD[5].setImage("blackLoad.png");
            lD[0].setImage("greenLoad.png");
        }
        else if(lCount<12)
        {
            lD[0].setImage("blackLoad.png");
            lD[1].setImage("greenLoad.png");
        }
        else if(lCount<18)
        {
            lD[1].setImage("blackLoad.png");
            lD[2].setImage("greenLoad.png");
        }
        else if(lCount<24)
        {
            lD[2].setImage("blackLoad.png");
            lD[3].setImage("greenLoad.png");
        }
        else if(lCount<30)
        {
            lD[3].setImage("blackLoad.png");
            lD[4].setImage("greenLoad.png");
        }
        else if(lCount<36)
        {
            lD[4].setImage("blackLoad.png");
            lD[5].setImage("greenLoad.png");
        }
        if(lCount==36)
        {
          lCount=0;  
        }
        if(pCount<5)
        {
         removeObject(p1);
         removeObject(p2);
         removeObject(p3);
        }
        else if(pCount<10)
         addObject(p1,236,202);
        else if(pCount<15)
         addObject(p2,248,202);
        else if(pCount<20)
         addObject(p3,260,202);
        if(pCount==20)
         pCount=0;
        if(count<METER_SIZE)
        {
          addObject(meterWhole[count],77+count,299);
          count++;
          pCount++;
          lCount++;
        }
        if(count==752)
        {
            pCount=0;
            lCount=0;
            lD[5].setImage("blackLoad.png");
            lD[0].setImage("blackLoad.png");
            removeObject(l);
            addObject(d,127,192);
        }
    }
}
