// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: serialization_proto.proto

package ser.grpc;

/**
 * Protobuf type {@code stest.MixedSeq}
 */
public final class MixedSeq extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:stest.MixedSeq)
    MixedSeqOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MixedSeq.newBuilder() to construct.
  private MixedSeq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MixedSeq() {
    mixeds_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MixedSeq();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ser.grpc.STestProto.internal_static_stest_MixedSeq_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ser.grpc.STestProto.internal_static_stest_MixedSeq_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ser.grpc.MixedSeq.class, ser.grpc.MixedSeq.Builder.class);
  }

  public static final int MIXEDS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<ser.grpc.Mixed> mixeds_;
  /**
   * <code>repeated .stest.Mixed mixeds = 1;</code>
   */
  @java.lang.Override
  public java.util.List<ser.grpc.Mixed> getMixedsList() {
    return mixeds_;
  }
  /**
   * <code>repeated .stest.Mixed mixeds = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends ser.grpc.MixedOrBuilder> 
      getMixedsOrBuilderList() {
    return mixeds_;
  }
  /**
   * <code>repeated .stest.Mixed mixeds = 1;</code>
   */
  @java.lang.Override
  public int getMixedsCount() {
    return mixeds_.size();
  }
  /**
   * <code>repeated .stest.Mixed mixeds = 1;</code>
   */
  @java.lang.Override
  public ser.grpc.Mixed getMixeds(int index) {
    return mixeds_.get(index);
  }
  /**
   * <code>repeated .stest.Mixed mixeds = 1;</code>
   */
  @java.lang.Override
  public ser.grpc.MixedOrBuilder getMixedsOrBuilder(
      int index) {
    return mixeds_.get(index);
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
    for (int i = 0; i < mixeds_.size(); i++) {
      output.writeMessage(1, mixeds_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < mixeds_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, mixeds_.get(i));
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
    if (!(obj instanceof ser.grpc.MixedSeq)) {
      return super.equals(obj);
    }
    ser.grpc.MixedSeq other = (ser.grpc.MixedSeq) obj;

    if (!getMixedsList()
        .equals(other.getMixedsList())) return false;
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
    if (getMixedsCount() > 0) {
      hash = (37 * hash) + MIXEDS_FIELD_NUMBER;
      hash = (53 * hash) + getMixedsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ser.grpc.MixedSeq parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ser.grpc.MixedSeq parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ser.grpc.MixedSeq parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ser.grpc.MixedSeq parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ser.grpc.MixedSeq parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ser.grpc.MixedSeq parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ser.grpc.MixedSeq parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ser.grpc.MixedSeq parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ser.grpc.MixedSeq parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ser.grpc.MixedSeq parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ser.grpc.MixedSeq parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ser.grpc.MixedSeq parseFrom(
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
  public static Builder newBuilder(ser.grpc.MixedSeq prototype) {
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
   * Protobuf type {@code stest.MixedSeq}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:stest.MixedSeq)
      ser.grpc.MixedSeqOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ser.grpc.STestProto.internal_static_stest_MixedSeq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ser.grpc.STestProto.internal_static_stest_MixedSeq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ser.grpc.MixedSeq.class, ser.grpc.MixedSeq.Builder.class);
    }

    // Construct using ser.grpc.MixedSeq.newBuilder()
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
      if (mixedsBuilder_ == null) {
        mixeds_ = java.util.Collections.emptyList();
      } else {
        mixeds_ = null;
        mixedsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ser.grpc.STestProto.internal_static_stest_MixedSeq_descriptor;
    }

    @java.lang.Override
    public ser.grpc.MixedSeq getDefaultInstanceForType() {
      return ser.grpc.MixedSeq.getDefaultInstance();
    }

    @java.lang.Override
    public ser.grpc.MixedSeq build() {
      ser.grpc.MixedSeq result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ser.grpc.MixedSeq buildPartial() {
      ser.grpc.MixedSeq result = new ser.grpc.MixedSeq(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(ser.grpc.MixedSeq result) {
      if (mixedsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          mixeds_ = java.util.Collections.unmodifiableList(mixeds_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.mixeds_ = mixeds_;
      } else {
        result.mixeds_ = mixedsBuilder_.build();
      }
    }

    private void buildPartial0(ser.grpc.MixedSeq result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ser.grpc.MixedSeq) {
        return mergeFrom((ser.grpc.MixedSeq)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ser.grpc.MixedSeq other) {
      if (other == ser.grpc.MixedSeq.getDefaultInstance()) return this;
      if (mixedsBuilder_ == null) {
        if (!other.mixeds_.isEmpty()) {
          if (mixeds_.isEmpty()) {
            mixeds_ = other.mixeds_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMixedsIsMutable();
            mixeds_.addAll(other.mixeds_);
          }
          onChanged();
        }
      } else {
        if (!other.mixeds_.isEmpty()) {
          if (mixedsBuilder_.isEmpty()) {
            mixedsBuilder_.dispose();
            mixedsBuilder_ = null;
            mixeds_ = other.mixeds_;
            bitField0_ = (bitField0_ & ~0x00000001);
            mixedsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMixedsFieldBuilder() : null;
          } else {
            mixedsBuilder_.addAllMessages(other.mixeds_);
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
              ser.grpc.Mixed m =
                  input.readMessage(
                      ser.grpc.Mixed.parser(),
                      extensionRegistry);
              if (mixedsBuilder_ == null) {
                ensureMixedsIsMutable();
                mixeds_.add(m);
              } else {
                mixedsBuilder_.addMessage(m);
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

    private java.util.List<ser.grpc.Mixed> mixeds_ =
      java.util.Collections.emptyList();
    private void ensureMixedsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        mixeds_ = new java.util.ArrayList<ser.grpc.Mixed>(mixeds_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        ser.grpc.Mixed, ser.grpc.Mixed.Builder, ser.grpc.MixedOrBuilder> mixedsBuilder_;

    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public java.util.List<ser.grpc.Mixed> getMixedsList() {
      if (mixedsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(mixeds_);
      } else {
        return mixedsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public int getMixedsCount() {
      if (mixedsBuilder_ == null) {
        return mixeds_.size();
      } else {
        return mixedsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public ser.grpc.Mixed getMixeds(int index) {
      if (mixedsBuilder_ == null) {
        return mixeds_.get(index);
      } else {
        return mixedsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder setMixeds(
        int index, ser.grpc.Mixed value) {
      if (mixedsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMixedsIsMutable();
        mixeds_.set(index, value);
        onChanged();
      } else {
        mixedsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder setMixeds(
        int index, ser.grpc.Mixed.Builder builderForValue) {
      if (mixedsBuilder_ == null) {
        ensureMixedsIsMutable();
        mixeds_.set(index, builderForValue.build());
        onChanged();
      } else {
        mixedsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder addMixeds(ser.grpc.Mixed value) {
      if (mixedsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMixedsIsMutable();
        mixeds_.add(value);
        onChanged();
      } else {
        mixedsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder addMixeds(
        int index, ser.grpc.Mixed value) {
      if (mixedsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMixedsIsMutable();
        mixeds_.add(index, value);
        onChanged();
      } else {
        mixedsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder addMixeds(
        ser.grpc.Mixed.Builder builderForValue) {
      if (mixedsBuilder_ == null) {
        ensureMixedsIsMutable();
        mixeds_.add(builderForValue.build());
        onChanged();
      } else {
        mixedsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder addMixeds(
        int index, ser.grpc.Mixed.Builder builderForValue) {
      if (mixedsBuilder_ == null) {
        ensureMixedsIsMutable();
        mixeds_.add(index, builderForValue.build());
        onChanged();
      } else {
        mixedsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder addAllMixeds(
        java.lang.Iterable<? extends ser.grpc.Mixed> values) {
      if (mixedsBuilder_ == null) {
        ensureMixedsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, mixeds_);
        onChanged();
      } else {
        mixedsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder clearMixeds() {
      if (mixedsBuilder_ == null) {
        mixeds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        mixedsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public Builder removeMixeds(int index) {
      if (mixedsBuilder_ == null) {
        ensureMixedsIsMutable();
        mixeds_.remove(index);
        onChanged();
      } else {
        mixedsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public ser.grpc.Mixed.Builder getMixedsBuilder(
        int index) {
      return getMixedsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public ser.grpc.MixedOrBuilder getMixedsOrBuilder(
        int index) {
      if (mixedsBuilder_ == null) {
        return mixeds_.get(index);  } else {
        return mixedsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public java.util.List<? extends ser.grpc.MixedOrBuilder> 
         getMixedsOrBuilderList() {
      if (mixedsBuilder_ != null) {
        return mixedsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(mixeds_);
      }
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public ser.grpc.Mixed.Builder addMixedsBuilder() {
      return getMixedsFieldBuilder().addBuilder(
          ser.grpc.Mixed.getDefaultInstance());
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public ser.grpc.Mixed.Builder addMixedsBuilder(
        int index) {
      return getMixedsFieldBuilder().addBuilder(
          index, ser.grpc.Mixed.getDefaultInstance());
    }
    /**
     * <code>repeated .stest.Mixed mixeds = 1;</code>
     */
    public java.util.List<ser.grpc.Mixed.Builder> 
         getMixedsBuilderList() {
      return getMixedsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        ser.grpc.Mixed, ser.grpc.Mixed.Builder, ser.grpc.MixedOrBuilder> 
        getMixedsFieldBuilder() {
      if (mixedsBuilder_ == null) {
        mixedsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            ser.grpc.Mixed, ser.grpc.Mixed.Builder, ser.grpc.MixedOrBuilder>(
                mixeds_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        mixeds_ = null;
      }
      return mixedsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:stest.MixedSeq)
  }

  // @@protoc_insertion_point(class_scope:stest.MixedSeq)
  private static final ser.grpc.MixedSeq DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ser.grpc.MixedSeq();
  }

  public static ser.grpc.MixedSeq getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MixedSeq>
      PARSER = new com.google.protobuf.AbstractParser<MixedSeq>() {
    @java.lang.Override
    public MixedSeq parsePartialFrom(
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

  public static com.google.protobuf.Parser<MixedSeq> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MixedSeq> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ser.grpc.MixedSeq getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

