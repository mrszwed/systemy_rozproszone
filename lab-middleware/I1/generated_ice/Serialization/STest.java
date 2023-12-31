//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `serialization.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Serialization;

public interface STest extends com.zeroc.Ice.Object
{
    void setDummy(com.zeroc.Ice.Current current);

    void setPerson(Person p, com.zeroc.Ice.Current current);

    void setPersonSequence(Person[] ps, com.zeroc.Ice.Current current);

    void setFiveDoubles(FiveDoubles fd, com.zeroc.Ice.Current current);

    void setFiveDoublesSequence(FiveDoubles[] fds, com.zeroc.Ice.Current current);

    void setMixed(Mixed m, com.zeroc.Ice.Current current);

    void setMixedSequence(Mixed[] ms, com.zeroc.Ice.Current current);

    /** @hidden */
    static final String[] _iceIds =
    {
        "::Ice::Object",
        "::Serialization::STest"
    };

    @Override
    default String[] ice_ids(com.zeroc.Ice.Current current)
    {
        return _iceIds;
    }

    @Override
    default String ice_id(com.zeroc.Ice.Current current)
    {
        return ice_staticId();
    }

    static String ice_staticId()
    {
        return "::Serialization::STest";
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setDummy(STest obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        inS.readEmptyParams();
        obj.setDummy(current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setPerson(STest obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Person iceP_p;
        iceP_p = Person.ice_read(istr);
        inS.endReadParams();
        obj.setPerson(iceP_p, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setPersonSequence(STest obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Person[] iceP_ps;
        iceP_ps = PersonSeqHelper.read(istr);
        inS.endReadParams();
        obj.setPersonSequence(iceP_ps, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setFiveDoubles(STest obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        FiveDoubles iceP_fd;
        iceP_fd = FiveDoubles.ice_read(istr);
        inS.endReadParams();
        obj.setFiveDoubles(iceP_fd, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setFiveDoublesSequence(STest obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        FiveDoubles[] iceP_fds;
        iceP_fds = FiveDoublesSeqHelper.read(istr);
        inS.endReadParams();
        obj.setFiveDoublesSequence(iceP_fds, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setMixed(STest obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Mixed iceP_m;
        iceP_m = Mixed.ice_read(istr);
        inS.endReadParams();
        obj.setMixed(iceP_m, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /**
     * @hidden
     * @param obj -
     * @param inS -
     * @param current -
     * @return -
    **/
    static java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceD_setMixedSequence(STest obj, final com.zeroc.IceInternal.Incoming inS, com.zeroc.Ice.Current current)
    {
        com.zeroc.Ice.Object._iceCheckMode(null, current.mode);
        com.zeroc.Ice.InputStream istr = inS.startReadParams();
        Mixed[] iceP_ms;
        iceP_ms = MixedSeqHelper.read(istr);
        inS.endReadParams();
        obj.setMixedSequence(iceP_ms, current);
        return inS.setResult(inS.writeEmptyParams());
    }

    /** @hidden */
    final static String[] _iceOps =
    {
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "setDummy",
        "setFiveDoubles",
        "setFiveDoublesSequence",
        "setMixed",
        "setMixedSequence",
        "setPerson",
        "setPersonSequence"
    };

    /** @hidden */
    @Override
    default java.util.concurrent.CompletionStage<com.zeroc.Ice.OutputStream> _iceDispatch(com.zeroc.IceInternal.Incoming in, com.zeroc.Ice.Current current)
        throws com.zeroc.Ice.UserException
    {
        int pos = java.util.Arrays.binarySearch(_iceOps, current.operation);
        if(pos < 0)
        {
            throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return com.zeroc.Ice.Object._iceD_ice_id(this, in, current);
            }
            case 1:
            {
                return com.zeroc.Ice.Object._iceD_ice_ids(this, in, current);
            }
            case 2:
            {
                return com.zeroc.Ice.Object._iceD_ice_isA(this, in, current);
            }
            case 3:
            {
                return com.zeroc.Ice.Object._iceD_ice_ping(this, in, current);
            }
            case 4:
            {
                return _iceD_setDummy(this, in, current);
            }
            case 5:
            {
                return _iceD_setFiveDoubles(this, in, current);
            }
            case 6:
            {
                return _iceD_setFiveDoublesSequence(this, in, current);
            }
            case 7:
            {
                return _iceD_setMixed(this, in, current);
            }
            case 8:
            {
                return _iceD_setMixedSequence(this, in, current);
            }
            case 9:
            {
                return _iceD_setPerson(this, in, current);
            }
            case 10:
            {
                return _iceD_setPersonSequence(this, in, current);
            }
        }

        assert(false);
        throw new com.zeroc.Ice.OperationNotExistException(current.id, current.facet, current.operation);
    }
}
