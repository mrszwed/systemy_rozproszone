import IHouse.DimmableLight;
import IHouse.InvalidArgumentValue;
import com.zeroc.Ice.Current;

public class DimmableLightImp extends LightImp implements DimmableLight{
    int level;

    @Override
    public boolean setLevel(int level, Current current) throws InvalidArgumentValue {
        if(level<0 || level>100) throw new InvalidArgumentValue("Wartości muszą być większe niż 0 i mniejsze niż 100");
        this.level=level;
        this.voltage=2.3*level;
        System.out.println("Zmieniono jasność");
        return true;
    }
}
