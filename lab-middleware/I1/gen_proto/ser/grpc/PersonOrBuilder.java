// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: serialization_proto.proto

package ser.grpc;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:stest.Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string surname = 2;</code>
   * @return The surname.
   */
  java.lang.String getSurname();
  /**
   * <code>string surname = 2;</code>
   * @return The bytes for surname.
   */
  com.google.protobuf.ByteString
      getSurnameBytes();

  /**
   * <code>int32 birthYear = 3;</code>
   * @return The birthYear.
   */
  int getBirthYear();
}
