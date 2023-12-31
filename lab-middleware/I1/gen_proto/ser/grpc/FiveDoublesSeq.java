// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: serialization_proto.proto

package ser.grpc;

/**
 * Protobuf type {@code stest.FiveDoublesSeq}
 */
public final class FiveDoublesSeq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:stest.FiveDoublesSeq)
    FiveDoublesSeqOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FiveDoublesSeq.newBuilder() to construct.
  private FiveDoublesSeq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FiveDoublesSeq() {
    fiveDoubless_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FiveDoublesSeq();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ser.grpc.STestProto.internal_static_stest_FiveDoublesSeq_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ser.grpc.STestProto.internal_static_stest_FiveDoublesSeq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ser.grpc.FiveDoublesSeq.class, ser.grpc.FiveDoublesSeq.Builder.class);
  }

  public static final int FIVEDOUBLESS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<ser.grpc.FiveDoubles> fiveDoubless_;
  /**
   * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
   */
  @java.lang.Override
  public java.util.List<ser.grpc.FiveDoubles> getFiveDoublessList() {
    return fiveDoubless_;
  }
  /**
   * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends ser.grpc.FiveDoublesOrBuilder> 
      getFiveDoublessOrBuilderList() {
    return fiveDoubless_;
  }
  /**
   * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
   */
  @java.lang.Override
  public int getFiveDoublessCount() {
    return fiveDoubless_.size();
  }
  /**
   * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
   */
  @java.lang.Override
  public ser.grpc.FiveDoubles getFiveDoubless(int index) {
    return fiveDoubless_.get(index);
  }
  /**
   * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
   */
  @java.lang.Override
  public ser.grpc.FiveDoublesOrBuilder getFiveDoublessOrBuilder(
      int index) {
    return fiveDoubless_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < fiveDoubless_.size(); i++) {
      output.writeMessage(1, fiveDoubless_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < fiveDoubless_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, fiveDoubless_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ser.grpc.FiveDoublesSeq)) {
      return super.equals(obj);
    }
    ser.grpc.FiveDoublesSeq other = (ser.grpc.FiveDoublesSeq) obj;

    if (!getFiveDoublessList()
        .equals(other.getFiveDoublessList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getFiveDoublessCount() > 0) {
      hash = (37 * hash) + FIVEDOUBLESS_FIELD_NUMBER;
      hash = (53 * hash) + getFiveDoublessList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ser.grpc.FiveDoublesSeq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ser.grpc.FiveDoublesSeq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ser.grpc.FiveDoublesSeq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ser.grpc.FiveDoublesSeq parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ser.grpc.FiveDoublesSeq prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code stest.FiveDoublesSeq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:stest.FiveDoublesSeq)
      ser.grpc.FiveDoublesSeqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ser.grpc.STestProto.internal_static_stest_FiveDoublesSeq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ser.grpc.STestProto.internal_static_stest_FiveDoublesSeq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ser.grpc.FiveDoublesSeq.class, ser.grpc.FiveDoublesSeq.Builder.class);
    }

    // Construct using ser.grpc.FiveDoublesSeq.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (fiveDoublessBuilder_ == null) {
        fiveDoubless_ = java.util.Collections.emptyList();
      } else {
        fiveDoubless_ = null;
        fiveDoublessBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ser.grpc.STestProto.internal_static_stest_FiveDoublesSeq_descriptor;
    }

    @java.lang.Override
    public ser.grpc.FiveDoublesSeq getDefaultInstanceForType() {
      return ser.grpc.FiveDoublesSeq.getDefaultInstance();
    }

    @java.lang.Override
    public ser.grpc.FiveDoublesSeq build() {
      ser.grpc.FiveDoublesSeq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ser.grpc.FiveDoublesSeq buildPartial() {
      ser.grpc.FiveDoublesSeq result = new ser.grpc.FiveDoublesSeq(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(ser.grpc.FiveDoublesSeq result) {
      if (fiveDoublessBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          fiveDoubless_ = java.util.Collections.unmodifiableList(fiveDoubless_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.fiveDoubless_ = fiveDoubless_;
      } else {
        result.fiveDoubless_ = fiveDoublessBuilder_.build();
      }
    }

    private void buildPartial0(ser.grpc.FiveDoublesSeq result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ser.grpc.FiveDoublesSeq) {
        return mergeFrom((ser.grpc.FiveDoublesSeq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ser.grpc.FiveDoublesSeq other) {
      if (other == ser.grpc.FiveDoublesSeq.getDefaultInstance()) return this;
      if (fiveDoublessBuilder_ == null) {
        if (!other.fiveDoubless_.isEmpty()) {
          if (fiveDoubless_.isEmpty()) {
            fiveDoubless_ = other.fiveDoubless_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureFiveDoublessIsMutable();
            fiveDoubless_.addAll(other.fiveDoubless_);
          }
          onChanged();
        }
      } else {
        if (!other.fiveDoubless_.isEmpty()) {
          if (fiveDoublessBuilder_.isEmpty()) {
            fiveDoublessBuilder_.dispose();
            fiveDoublessBuilder_ = null;
            fiveDoubless_ = other.fiveDoubless_;
            bitField0_ = (bitField0_ & ~0x00000001);
            fiveDoublessBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getFiveDoublessFieldBuilder() : null;
          } else {
            fiveDoublessBuilder_.addAllMessages(other.fiveDoubless_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              ser.grpc.FiveDoubles m =
                  input.readMessage(
                      ser.grpc.FiveDoubles.parser(),
                      extensionRegistry);
              if (fiveDoublessBuilder_ == null) {
                ensureFiveDoublessIsMutable();
                fiveDoubless_.add(m);
              } else {
                fiveDoublessBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<ser.grpc.FiveDoubles> fiveDoubless_ =
      java.util.Collections.emptyList();
    private void ensureFiveDoublessIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        fiveDoubless_ = new java.util.ArrayList<ser.grpc.FiveDoubles>(fiveDoubless_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        ser.grpc.FiveDoubles, ser.grpc.FiveDoubles.Builder, ser.grpc.FiveDoublesOrBuilder> fiveDoublessBuilder_;

    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public java.util.List<ser.grpc.FiveDoubles> getFiveDoublessList() {
      if (fiveDoublessBuilder_ == null) {
        return java.util.Collections.unmodifiableList(fiveDoubless_);
      } else {
        return fiveDoublessBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public int getFiveDoublessCount() {
      if (fiveDoublessBuilder_ == null) {
        return fiveDoubless_.size();
      } else {
        return fiveDoublessBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public ser.grpc.FiveDoubles getFiveDoubless(int index) {
      if (fiveDoublessBuilder_ == null) {
        return fiveDoubless_.get(index);
      } else {
        return fiveDoublessBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder setFiveDoubless(
        int index, ser.grpc.FiveDoubles value) {
      if (fiveDoublessBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFiveDoublessIsMutable();
        fiveDoubless_.set(index, value);
        onChanged();
      } else {
        fiveDoublessBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder setFiveDoubless(
        int index, ser.grpc.FiveDoubles.Builder builderForValue) {
      if (fiveDoublessBuilder_ == null) {
        ensureFiveDoublessIsMutable();
        fiveDoubless_.set(index, builderForValue.build());
        onChanged();
      } else {
        fiveDoublessBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder addFiveDoubless(ser.grpc.FiveDoubles value) {
      if (fiveDoublessBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFiveDoublessIsMutable();
        fiveDoubless_.add(value);
        onChanged();
      } else {
        fiveDoublessBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder addFiveDoubless(
        int index, ser.grpc.FiveDoubles value) {
      if (fiveDoublessBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFiveDoublessIsMutable();
        fiveDoubless_.add(index, value);
        onChanged();
      } else {
        fiveDoublessBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder addFiveDoubless(
        ser.grpc.FiveDoubles.Builder builderForValue) {
      if (fiveDoublessBuilder_ == null) {
        ensureFiveDoublessIsMutable();
        fiveDoubless_.add(builderForValue.build());
        onChanged();
      } else {
        fiveDoublessBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder addFiveDoubless(
        int index, ser.grpc.FiveDoubles.Builder builderForValue) {
      if (fiveDoublessBuilder_ == null) {
        ensureFiveDoublessIsMutable();
        fiveDoubless_.add(index, builderForValue.build());
        onChanged();
      } else {
        fiveDoublessBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder addAllFiveDoubless(
        java.lang.Iterable<? extends ser.grpc.FiveDoubles> values) {
      if (fiveDoublessBuilder_ == null) {
        ensureFiveDoublessIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, fiveDoubless_);
        onChanged();
      } else {
        fiveDoublessBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder clearFiveDoubless() {
      if (fiveDoublessBuilder_ == null) {
        fiveDoubless_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        fiveDoublessBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public Builder removeFiveDoubless(int index) {
      if (fiveDoublessBuilder_ == null) {
        ensureFiveDoublessIsMutable();
        fiveDoubless_.remove(index);
        onChanged();
      } else {
        fiveDoublessBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public ser.grpc.FiveDoubles.Builder getFiveDoublessBuilder(
        int index) {
      return getFiveDoublessFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public ser.grpc.FiveDoublesOrBuilder getFiveDoublessOrBuilder(
        int index) {
      if (fiveDoublessBuilder_ == null) {
        return fiveDoubless_.get(index);  } else {
        return fiveDoublessBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public java.util.List<? extends ser.grpc.FiveDoublesOrBuilder> 
         getFiveDoublessOrBuilderList() {
      if (fiveDoublessBuilder_ != null) {
        return fiveDoublessBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(fiveDoubless_);
      }
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public ser.grpc.FiveDoubles.Builder addFiveDoublessBuilder() {
      return getFiveDoublessFieldBuilder().addBuilder(
          ser.grpc.FiveDoubles.getDefaultInstance());
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public ser.grpc.FiveDoubles.Builder addFiveDoublessBuilder(
        int index) {
      return getFiveDoublessFieldBuilder().addBuilder(
          index, ser.grpc.FiveDoubles.getDefaultInstance());
    }
    /**
     * <code>repeated .stest.FiveDoubles fiveDoubless = 1;</code>
     */
    public java.util.List<ser.grpc.FiveDoubles.Builder> 
         getFiveDoublessBuilderList() {
      return getFiveDoublessFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        ser.grpc.FiveDoubles, ser.grpc.FiveDoubles.Builder, ser.grpc.FiveDoublesOrBuilder> 
        getFiveDoublessFieldBuilder() {
      if (fiveDoublessBuilder_ == null) {
        fiveDoublessBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            ser.grpc.FiveDoubles, ser.grpc.FiveDoubles.Builder, ser.grpc.FiveDoublesOrBuilder>(
                fiveDoubless_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        fiveDoubless_ = null;
      }
      return fiveDoublessBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:stest.FiveDoublesSeq)
  }

  // @@protoc_insertion_point(class_scope:stest.FiveDoublesSeq)
  private static final ser.grpc.FiveDoublesSeq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ser.grpc.FiveDoublesSeq();
  }

  public static ser.grpc.FiveDoublesSeq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FiveDoublesSeq>
      PARSER = new com.google.protobuf.AbstractParser<FiveDoublesSeq>() {
    @java.lang.Override
    public FiveDoublesSeq parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<FiveDoublesSeq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FiveDoublesSeq> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ser.grpc.FiveDoublesSeq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

