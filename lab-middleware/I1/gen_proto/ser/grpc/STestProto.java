// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: serialization_proto.proto

package ser.grpc;

public final class STestProto {
  private STestProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stest_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stest_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stest_PersonSeq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stest_PersonSeq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stest_FiveDoubles_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stest_FiveDoubles_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stest_FiveDoublesSeq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stest_FiveDoublesSeq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stest_Mixed_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stest_Mixed_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stest_MixedSeq_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stest_MixedSeq_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_stest_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_stest_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031serialization_proto.proto\022\005stest\":\n\006Pe" +
      "rson\022\014\n\004name\030\001 \001(\t\022\017\n\007surname\030\002 \001(\t\022\021\n\tb" +
      "irthYear\030\003 \001(\005\"+\n\tPersonSeq\022\036\n\007persons\030\001" +
      " \003(\0132\r.stest.Person\"I\n\013FiveDoubles\022\n\n\002d0" +
      "\030\001 \001(\001\022\n\n\002d1\030\002 \001(\001\022\n\n\002d2\030\003 \001(\001\022\n\n\002d3\030\004 \001" +
      "(\001\022\n\n\002d4\030\005 \001(\001\":\n\016FiveDoublesSeq\022(\n\014five" +
      "Doubless\030\001 \003(\0132\022.stest.FiveDoubles\"J\n\005Mi" +
      "xed\022\t\n\001b\030\001 \001(\r\022\t\n\001s\030\002 \001(\005\022\t\n\001i\030\003 \001(\005\022\t\n\001" +
      "f\030\004 \001(\002\022\t\n\001d\030\005 \001(\001\022\n\n\002ss\030\006 \001(\t\"(\n\010MixedS" +
      "eq\022\034\n\006mixeds\030\001 \003(\0132\014.stest.Mixed\"\007\n\005Empt" +
      "y2\352\002\n\005STest\022(\n\010setDummy\022\014.stest.Empty\032\014." +
      "stest.Empty\"\000\022*\n\tsetPerson\022\r.stest.Perso" +
      "n\032\014.stest.Empty\"\000\0225\n\021setPersonSequence\022\020" +
      ".stest.PersonSeq\032\014.stest.Empty\"\000\0224\n\016setF" +
      "iveDoubles\022\022.stest.FiveDoubles\032\014.stest.E" +
      "mpty\"\000\022?\n\026setFiveDoublesSequence\022\025.stest" +
      ".FiveDoublesSeq\032\014.stest.Empty\"\000\022(\n\010setMi" +
      "xed\022\014.stest.Mixed\032\014.stest.Empty\"\000\0223\n\020set" +
      "MixedSequence\022\017.stest.MixedSeq\032\014.stest.E" +
      "mpty\"\000B\030\n\010ser.grpcB\nSTestProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_stest_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_stest_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stest_Person_descriptor,
        new java.lang.String[] { "Name", "Surname", "BirthYear", });
    internal_static_stest_PersonSeq_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_stest_PersonSeq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stest_PersonSeq_descriptor,
        new java.lang.String[] { "Persons", });
    internal_static_stest_FiveDoubles_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_stest_FiveDoubles_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stest_FiveDoubles_descriptor,
        new java.lang.String[] { "D0", "D1", "D2", "D3", "D4", });
    internal_static_stest_FiveDoublesSeq_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_stest_FiveDoublesSeq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stest_FiveDoublesSeq_descriptor,
        new java.lang.String[] { "FiveDoubless", });
    internal_static_stest_Mixed_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_stest_Mixed_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stest_Mixed_descriptor,
        new java.lang.String[] { "B", "S", "I", "F", "D", "Ss", });
    internal_static_stest_MixedSeq_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_stest_MixedSeq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stest_MixedSeq_descriptor,
        new java.lang.String[] { "Mixeds", });
    internal_static_stest_Empty_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_stest_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_stest_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
