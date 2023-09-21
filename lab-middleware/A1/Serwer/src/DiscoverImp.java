import IHouse.DeviceInfo;
import IHouse.Discover;
import IHouse.Event;
import com.zeroc.Ice.Current;

import java.util.List;

public class DiscoverImp implements Discover {
    List<DeviceInfo> devices;
    DiscoverImp(List<DeviceInfo> devices){
        this.devices=devices;
    }

    @Override
    public DeviceInfo[] listDevices(Current current) {
        DeviceInfo[] dArr = devices.toArray(new DeviceInfo[devices.size()]);
        return dArr;
    }
}
