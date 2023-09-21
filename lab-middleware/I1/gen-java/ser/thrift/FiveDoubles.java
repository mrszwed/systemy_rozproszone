/**
 * Autogenerated by Thrift Compiler (0.18.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package ser.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.18.1)", date = "2023-05-03")
public class FiveDoubles implements org.apache.thrift.TBase<FiveDoubles, FiveDoubles._Fields>, java.io.Serializable, Cloneable, Comparable<FiveDoubles> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FiveDoubles");

  private static final org.apache.thrift.protocol.TField D0_FIELD_DESC = new org.apache.thrift.protocol.TField("d0", org.apache.thrift.protocol.TType.DOUBLE, (short)1);
  private static final org.apache.thrift.protocol.TField D1_FIELD_DESC = new org.apache.thrift.protocol.TField("d1", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField D2_FIELD_DESC = new org.apache.thrift.protocol.TField("d2", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField D3_FIELD_DESC = new org.apache.thrift.protocol.TField("d3", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField D4_FIELD_DESC = new org.apache.thrift.protocol.TField("d4", org.apache.thrift.protocol.TType.DOUBLE, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FiveDoublesStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FiveDoublesTupleSchemeFactory();

  public double d0; // required
  public double d1; // required
  public double d2; // required
  public double d3; // required
  public double d4; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    D0((short)1, "d0"),
    D1((short)2, "d1"),
    D2((short)3, "d2"),
    D3((short)4, "d3"),
    D4((short)5, "d4");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // D0
          return D0;
        case 2: // D1
          return D1;
        case 3: // D2
          return D2;
        case 4: // D3
          return D3;
        case 5: // D4
          return D4;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    @Override
    public short getThriftFieldId() {
      return _thriftId;
    }

    @Override
    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __D0_ISSET_ID = 0;
  private static final int __D1_ISSET_ID = 1;
  private static final int __D2_ISSET_ID = 2;
  private static final int __D3_ISSET_ID = 3;
  private static final int __D4_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.D0, new org.apache.thrift.meta_data.FieldMetaData("d0", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.D1, new org.apache.thrift.meta_data.FieldMetaData("d1", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.D2, new org.apache.thrift.meta_data.FieldMetaData("d2", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.D3, new org.apache.thrift.meta_data.FieldMetaData("d3", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.D4, new org.apache.thrift.meta_data.FieldMetaData("d4", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FiveDoubles.class, metaDataMap);
  }

  public FiveDoubles() {
  }

  public FiveDoubles(
    double d0,
    double d1,
    double d2,
    double d3,
    double d4)
  {
    this();
    this.d0 = d0;
    setD0IsSet(true);
    this.d1 = d1;
    setD1IsSet(true);
    this.d2 = d2;
    setD2IsSet(true);
    this.d3 = d3;
    setD3IsSet(true);
    this.d4 = d4;
    setD4IsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FiveDoubles(FiveDoubles other) {
    __isset_bitfield = other.__isset_bitfield;
    this.d0 = other.d0;
    this.d1 = other.d1;
    this.d2 = other.d2;
    this.d3 = other.d3;
    this.d4 = other.d4;
  }

  @Override
  public FiveDoubles deepCopy() {
    return new FiveDoubles(this);
  }

  @Override
  public void clear() {
    setD0IsSet(false);
    this.d0 = 0.0;
    setD1IsSet(false);
    this.d1 = 0.0;
    setD2IsSet(false);
    this.d2 = 0.0;
    setD3IsSet(false);
    this.d3 = 0.0;
    setD4IsSet(false);
    this.d4 = 0.0;
  }

  public double getD0() {
    return this.d0;
  }

  public FiveDoubles setD0(double d0) {
    this.d0 = d0;
    setD0IsSet(true);
    return this;
  }

  public void unsetD0() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __D0_ISSET_ID);
  }

  /** Returns true if field d0 is set (has been assigned a value) and false otherwise */
  public boolean isSetD0() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __D0_ISSET_ID);
  }

  public void setD0IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __D0_ISSET_ID, value);
  }

  public double getD1() {
    return this.d1;
  }

  public FiveDoubles setD1(double d1) {
    this.d1 = d1;
    setD1IsSet(true);
    return this;
  }

  public void unsetD1() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __D1_ISSET_ID);
  }

  /** Returns true if field d1 is set (has been assigned a value) and false otherwise */
  public boolean isSetD1() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __D1_ISSET_ID);
  }

  public void setD1IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __D1_ISSET_ID, value);
  }

  public double getD2() {
    return this.d2;
  }

  public FiveDoubles setD2(double d2) {
    this.d2 = d2;
    setD2IsSet(true);
    return this;
  }

  public void unsetD2() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __D2_ISSET_ID);
  }

  /** Returns true if field d2 is set (has been assigned a value) and false otherwise */
  public boolean isSetD2() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __D2_ISSET_ID);
  }

  public void setD2IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __D2_ISSET_ID, value);
  }

  public double getD3() {
    return this.d3;
  }

  public FiveDoubles setD3(double d3) {
    this.d3 = d3;
    setD3IsSet(true);
    return this;
  }

  public void unsetD3() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __D3_ISSET_ID);
  }

  /** Returns true if field d3 is set (has been assigned a value) and false otherwise */
  public boolean isSetD3() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __D3_ISSET_ID);
  }

  public void setD3IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __D3_ISSET_ID, value);
  }

  public double getD4() {
    return this.d4;
  }

  public FiveDoubles setD4(double d4) {
    this.d4 = d4;
    setD4IsSet(true);
    return this;
  }

  public void unsetD4() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __D4_ISSET_ID);
  }

  /** Returns true if field d4 is set (has been assigned a value) and false otherwise */
  public boolean isSetD4() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __D4_ISSET_ID);
  }

  public void setD4IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __D4_ISSET_ID, value);
  }

  @Override
  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case D0:
      if (value == null) {
        unsetD0();
      } else {
        setD0((java.lang.Double)value);
      }
      break;

    case D1:
      if (value == null) {
        unsetD1();
      } else {
        setD1((java.lang.Double)value);
      }
      break;

    case D2:
      if (value == null) {
        unsetD2();
      } else {
        setD2((java.lang.Double)value);
      }
      break;

    case D3:
      if (value == null) {
        unsetD3();
      } else {
        setD3((java.lang.Double)value);
      }
      break;

    case D4:
      if (value == null) {
        unsetD4();
      } else {
        setD4((java.lang.Double)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case D0:
      return getD0();

    case D1:
      return getD1();

    case D2:
      return getD2();

    case D3:
      return getD3();

    case D4:
      return getD4();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  @Override
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case D0:
      return isSetD0();
    case D1:
      return isSetD1();
    case D2:
      return isSetD2();
    case D3:
      return isSetD3();
    case D4:
      return isSetD4();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that instanceof FiveDoubles)
      return this.equals((FiveDoubles)that);
    return false;
  }

  public boolean equals(FiveDoubles that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_d0 = true;
    boolean that_present_d0 = true;
    if (this_present_d0 || that_present_d0) {
      if (!(this_present_d0 && that_present_d0))
        return false;
      if (this.d0 != that.d0)
        return false;
    }

    boolean this_present_d1 = true;
    boolean that_present_d1 = true;
    if (this_present_d1 || that_present_d1) {
      if (!(this_present_d1 && that_present_d1))
        return false;
      if (this.d1 != that.d1)
        return false;
    }

    boolean this_present_d2 = true;
    boolean that_present_d2 = true;
    if (this_present_d2 || that_present_d2) {
      if (!(this_present_d2 && that_present_d2))
        return false;
      if (this.d2 != that.d2)
        return false;
    }

    boolean this_present_d3 = true;
    boolean that_present_d3 = true;
    if (this_present_d3 || that_present_d3) {
      if (!(this_present_d3 && that_present_d3))
        return false;
      if (this.d3 != that.d3)
        return false;
    }

    boolean this_present_d4 = true;
    boolean that_present_d4 = true;
    if (this_present_d4 || that_present_d4) {
      if (!(this_present_d4 && that_present_d4))
        return false;
      if (this.d4 != that.d4)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(d0);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(d1);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(d2);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(d3);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(d4);

    return hashCode;
  }

  @Override
  public int compareTo(FiveDoubles other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.compare(isSetD0(), other.isSetD0());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetD0()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.d0, other.d0);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetD1(), other.isSetD1());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetD1()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.d1, other.d1);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetD2(), other.isSetD2());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetD2()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.d2, other.d2);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetD3(), other.isSetD3());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetD3()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.d3, other.d3);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.compare(isSetD4(), other.isSetD4());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetD4()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.d4, other.d4);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  @Override
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  @Override
  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  @Override
  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("FiveDoubles(");
    boolean first = true;

    sb.append("d0:");
    sb.append(this.d0);
    first = false;
    if (!first) sb.append(", ");
    sb.append("d1:");
    sb.append(this.d1);
    first = false;
    if (!first) sb.append(", ");
    sb.append("d2:");
    sb.append(this.d2);
    first = false;
    if (!first) sb.append(", ");
    sb.append("d3:");
    sb.append(this.d3);
    first = false;
    if (!first) sb.append(", ");
    sb.append("d4:");
    sb.append(this.d4);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FiveDoublesStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public FiveDoublesStandardScheme getScheme() {
      return new FiveDoublesStandardScheme();
    }
  }

  private static class FiveDoublesStandardScheme extends org.apache.thrift.scheme.StandardScheme<FiveDoubles> {

    @Override
    public void read(org.apache.thrift.protocol.TProtocol iprot, FiveDoubles struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // D0
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.d0 = iprot.readDouble();
              struct.setD0IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // D1
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.d1 = iprot.readDouble();
              struct.setD1IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // D2
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.d2 = iprot.readDouble();
              struct.setD2IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // D3
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.d3 = iprot.readDouble();
              struct.setD3IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // D4
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.d4 = iprot.readDouble();
              struct.setD4IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot, FiveDoubles struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(D0_FIELD_DESC);
      oprot.writeDouble(struct.d0);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(D1_FIELD_DESC);
      oprot.writeDouble(struct.d1);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(D2_FIELD_DESC);
      oprot.writeDouble(struct.d2);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(D3_FIELD_DESC);
      oprot.writeDouble(struct.d3);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(D4_FIELD_DESC);
      oprot.writeDouble(struct.d4);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FiveDoublesTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
    public FiveDoublesTupleScheme getScheme() {
      return new FiveDoublesTupleScheme();
    }
  }

  private static class FiveDoublesTupleScheme extends org.apache.thrift.scheme.TupleScheme<FiveDoubles> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FiveDoubles struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetD0()) {
        optionals.set(0);
      }
      if (struct.isSetD1()) {
        optionals.set(1);
      }
      if (struct.isSetD2()) {
        optionals.set(2);
      }
      if (struct.isSetD3()) {
        optionals.set(3);
      }
      if (struct.isSetD4()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetD0()) {
        oprot.writeDouble(struct.d0);
      }
      if (struct.isSetD1()) {
        oprot.writeDouble(struct.d1);
      }
      if (struct.isSetD2()) {
        oprot.writeDouble(struct.d2);
      }
      if (struct.isSetD3()) {
        oprot.writeDouble(struct.d3);
      }
      if (struct.isSetD4()) {
        oprot.writeDouble(struct.d4);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FiveDoubles struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.d0 = iprot.readDouble();
        struct.setD0IsSet(true);
      }
      if (incoming.get(1)) {
        struct.d1 = iprot.readDouble();
        struct.setD1IsSet(true);
      }
      if (incoming.get(2)) {
        struct.d2 = iprot.readDouble();
        struct.setD2IsSet(true);
      }
      if (incoming.get(3)) {
        struct.d3 = iprot.readDouble();
        struct.setD3IsSet(true);
      }
      if (incoming.get(4)) {
        struct.d4 = iprot.readDouble();
        struct.setD4IsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

