package icedemo;

//import Serialization.Person;
//import Serialization.FiveDoubles;
//import Serialization.Mixed;

import Serialization.FiveDoubles;
import Serialization.Mixed;
import Serialization.Person;
import Serialization.STest;
import com.zeroc.Ice.Current;

public class STestImp implements STest {
    @Override
    public void setDummy(Current current) {

    }

    @Override
    public void setPerson(Person p, Current current) {

    }

    @Override
    public void setPersonSequence(Person[] ps, Current current) {

    }

    @Override
    public void setFiveDoubles(FiveDoubles fd, Current current) {

    }

    @Override
    public void setFiveDoublesSequence(FiveDoubles[] fds, Current current) {

    }

    @Override
    public void setMixed(Mixed m, Current current) {

    }

    @Override
    public void setMixedSequence(Mixed[] ms, Current current) {

    }
}
