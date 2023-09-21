package thriftdemo;

import org.apache.thrift.TException;
import ser.thrift.FiveDoubles;
import ser.thrift.Mixed;
import ser.thrift.Person;
import ser.thrift.STest;

import java.util.List;

public class STestHandler implements STest.Iface{
    @Override
    public void setDummy() throws TException {

    }

    @Override
    public void setPerson(Person p) throws TException {

    }

    @Override
    public void setPersonSequence(List<Person> ps) throws TException {

    }

    @Override
    public void setFiveDoubles(FiveDoubles fd) throws TException {

    }

    @Override
    public void setFiveDoublesSequence(List<FiveDoubles> fds) throws TException {

    }

    @Override
    public void setMixed(Mixed m) throws TException {

    }

    @Override
    public void setMixedSequence(List<Mixed> ms) throws TException {

    }
}
