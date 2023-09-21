import IHouse.DeviceInfo;
import IHouse.Event;
import IHouse.MotionSensor;
import com.zeroc.Ice.Current;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MotionSensorImp implements MotionSensor {
    String name;
    boolean armed=false;

    List<Event> events=new ArrayList<>();

    MotionSensorImp(String name){
        this.name=name;
    }

    @Override
    public boolean arm(Current current) {
        if(armed)return false;
        armed=true;
        Event ev=new Event();
        ev.source=name;
        ev.description="armed";
        LocalDateTime ldt=LocalDateTime.now();
        ev.time.year=ldt.getYear();
        ev.time.month=ldt.getMonthValue();
        ev.time.day=ldt.getDayOfMonth();
        ev.time.hour=ldt.getHour();
        ev.time.minute=ldt.getMinute();
        ev.time.second=ldt.getSecond();
        events.add(ev);
        return true;
    }

    @Override
    public boolean disarm(Current current) {
        if(!armed)return false;
        armed=false;
        Event ev=new Event();
        ev.source=name;
        ev.description="disarmed";
        LocalDateTime ldt=LocalDateTime.now();
        ev.time.year=ldt.getYear();
        ev.time.month=ldt.getMonthValue();
        ev.time.day=ldt.getDayOfMonth();
        ev.time.hour=ldt.getHour();
        ev.time.minute=ldt.getMinute();
        ev.time.second=ldt.getSecond();
        events.add(ev);
        return true;
    }

    @Override
    public Event[] getEvents(Current current) {
        Event[] eArr = events.toArray(new Event[events.size()]);
        return eArr;
    }
}
