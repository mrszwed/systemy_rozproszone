import IHouse.Heating;
import IHouse.InvalidArgumentValue;
import com.zeroc.Ice.Current;

public class HeatingImp implements Heating {
    boolean heating=false;
    double currentTemperature=20;
    double desiredTemperature=20;
    @Override
    public boolean on(Current current) {
        if(heating==true)return false;
        heating=true;
        System.out.println("Włączono ogrzewanie");
        return true;
    }

    @Override
    public boolean off(Current current) {
        if(heating==false)return false;
        heating=false;
        System.out.println("Wyłączono ogrzewanie");
        return true;
    }

    @Override
    public boolean setTemperature(int level, Current current) throws InvalidArgumentValue {
        if(level<5 || level>35) throw new InvalidArgumentValue("Wartości muszą być większe niż 5 i mniejsze niż 35");
        desiredTemperature=level;
        System.out.println("Ustawiono nową temperaturę");
        return true;
    }
}
