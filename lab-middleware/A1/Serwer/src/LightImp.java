import IHouse.Light;
import com.zeroc.Ice.Current;

public class LightImp implements Light {
    double voltage=0;
    @Override
    public boolean on(Current current) {
        if(voltage==230)return false;
        voltage=230;
        System.out.println("Włączono światło");
        return true;
    }

    @Override
    public boolean off(Current current) {
        if(voltage==0)return false;
        voltage=0;
        System.out.println("Wyłączono światło");
        return true;
    }
}
