/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-9-17")
public class BookingRoom implements org.apache.thrift.TBase<BookingRoom, BookingRoom._Fields>, java.io.Serializable, Cloneable, Comparable<BookingRoom> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BookingRoom");

  private static final org.apache.thrift.protocol.TField ROOM_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("roomType", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField BOOKING_FIELD_DESC = new org.apache.thrift.protocol.TField("booking", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField GUEST_FIELD_DESC = new org.apache.thrift.protocol.TField("guest", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new BookingRoomStandardSchemeFactory());
    schemes.put(TupleScheme.class, new BookingRoomTupleSchemeFactory());
  }

  public RoomType roomType; // required
  public Booking booking; // required
  public Guest guest; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ROOM_TYPE((short)1, "roomType"),
    BOOKING((short)2, "booking"),
    GUEST((short)3, "guest");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ROOM_TYPE
          return ROOM_TYPE;
        case 2: // BOOKING
          return BOOKING;
        case 3: // GUEST
          return GUEST;
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
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROOM_TYPE, new org.apache.thrift.meta_data.FieldMetaData("roomType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "RoomType")));
    tmpMap.put(_Fields.BOOKING, new org.apache.thrift.meta_data.FieldMetaData("booking", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Booking.class)));
    tmpMap.put(_Fields.GUEST, new org.apache.thrift.meta_data.FieldMetaData("guest", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "Guest")));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BookingRoom.class, metaDataMap);
  }

  public BookingRoom() {
  }

  public BookingRoom(
    RoomType roomType,
    Booking booking,
    Guest guest)
  {
    this();
    this.roomType = roomType;
    this.booking = booking;
    this.guest = guest;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BookingRoom(BookingRoom other) {
    if (other.isSetRoomType()) {
      this.roomType = other.roomType;
    }
    if (other.isSetBooking()) {
      this.booking = new Booking(other.booking);
    }
    if (other.isSetGuest()) {
      this.guest = other.guest;
    }
  }

  public BookingRoom deepCopy() {
    return new BookingRoom(this);
  }

  @Override
  public void clear() {
    this.roomType = null;
    this.booking = null;
    this.guest = null;
  }

  public RoomType getRoomType() {
    return this.roomType;
  }

  public BookingRoom setRoomType(RoomType roomType) {
    this.roomType = roomType;
    return this;
  }

  public void unsetRoomType() {
    this.roomType = null;
  }

  /** Returns true if field roomType is set (has been assigned a value) and false otherwise */
  public boolean isSetRoomType() {
    return this.roomType != null;
  }

  public void setRoomTypeIsSet(boolean value) {
    if (!value) {
      this.roomType = null;
    }
  }

  public Booking getBooking() {
    return this.booking;
  }

  public BookingRoom setBooking(Booking booking) {
    this.booking = booking;
    return this;
  }

  public void unsetBooking() {
    this.booking = null;
  }

  /** Returns true if field booking is set (has been assigned a value) and false otherwise */
  public boolean isSetBooking() {
    return this.booking != null;
  }

  public void setBookingIsSet(boolean value) {
    if (!value) {
      this.booking = null;
    }
  }

  public Guest getGuest() {
    return this.guest;
  }

  public BookingRoom setGuest(Guest guest) {
    this.guest = guest;
    return this;
  }

  public void unsetGuest() {
    this.guest = null;
  }

  /** Returns true if field guest is set (has been assigned a value) and false otherwise */
  public boolean isSetGuest() {
    return this.guest != null;
  }

  public void setGuestIsSet(boolean value) {
    if (!value) {
      this.guest = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ROOM_TYPE:
      if (value == null) {
        unsetRoomType();
      } else {
        setRoomType((RoomType)value);
      }
      break;

    case BOOKING:
      if (value == null) {
        unsetBooking();
      } else {
        setBooking((Booking)value);
      }
      break;

    case GUEST:
      if (value == null) {
        unsetGuest();
      } else {
        setGuest((Guest)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ROOM_TYPE:
      return getRoomType();

    case BOOKING:
      return getBooking();

    case GUEST:
      return getGuest();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ROOM_TYPE:
      return isSetRoomType();
    case BOOKING:
      return isSetBooking();
    case GUEST:
      return isSetGuest();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof BookingRoom)
      return this.equals((BookingRoom)that);
    return false;
  }

  public boolean equals(BookingRoom that) {
    if (that == null)
      return false;

    boolean this_present_roomType = true && this.isSetRoomType();
    boolean that_present_roomType = true && that.isSetRoomType();
    if (this_present_roomType || that_present_roomType) {
      if (!(this_present_roomType && that_present_roomType))
        return false;
      if (!this.roomType.equals(that.roomType))
        return false;
    }

    boolean this_present_booking = true && this.isSetBooking();
    boolean that_present_booking = true && that.isSetBooking();
    if (this_present_booking || that_present_booking) {
      if (!(this_present_booking && that_present_booking))
        return false;
      if (!this.booking.equals(that.booking))
        return false;
    }

    boolean this_present_guest = true && this.isSetGuest();
    boolean that_present_guest = true && that.isSetGuest();
    if (this_present_guest || that_present_guest) {
      if (!(this_present_guest && that_present_guest))
        return false;
      if (!this.guest.equals(that.guest))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_roomType = true && (isSetRoomType());
    list.add(present_roomType);
    if (present_roomType)
      list.add(roomType);

    boolean present_booking = true && (isSetBooking());
    list.add(present_booking);
    if (present_booking)
      list.add(booking);

    boolean present_guest = true && (isSetGuest());
    list.add(present_guest);
    if (present_guest)
      list.add(guest);

    return list.hashCode();
  }

  @Override
  public int compareTo(BookingRoom other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetRoomType()).compareTo(other.isSetRoomType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRoomType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.roomType, other.roomType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetBooking()).compareTo(other.isSetBooking());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBooking()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.booking, other.booking);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGuest()).compareTo(other.isSetGuest());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGuest()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.guest, other.guest);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("BookingRoom(");
    boolean first = true;

    sb.append("roomType:");
    if (this.roomType == null) {
      sb.append("null");
    } else {
      sb.append(this.roomType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("booking:");
    if (this.booking == null) {
      sb.append("null");
    } else {
      sb.append(this.booking);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("guest:");
    if (this.guest == null) {
      sb.append("null");
    } else {
      sb.append(this.guest);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (roomType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'roomType' was not present! Struct: " + toString());
    }
    if (booking == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'booking' was not present! Struct: " + toString());
    }
    if (guest == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'guest' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (booking != null) {
      booking.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BookingRoomStandardSchemeFactory implements SchemeFactory {
    public BookingRoomStandardScheme getScheme() {
      return new BookingRoomStandardScheme();
    }
  }

  private static class BookingRoomStandardScheme extends StandardScheme<BookingRoom> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BookingRoom struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ROOM_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.roomType = new RoomType();
              struct.roomType.read(iprot);
              struct.setRoomTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BOOKING
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.booking = new Booking();
              struct.booking.read(iprot);
              struct.setBookingIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // GUEST
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.guest = new Guest();
              struct.guest.read(iprot);
              struct.setGuestIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, BookingRoom struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.roomType != null) {
        oprot.writeFieldBegin(ROOM_TYPE_FIELD_DESC);
        struct.roomType.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.booking != null) {
        oprot.writeFieldBegin(BOOKING_FIELD_DESC);
        struct.booking.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.guest != null) {
        oprot.writeFieldBegin(GUEST_FIELD_DESC);
        struct.guest.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BookingRoomTupleSchemeFactory implements SchemeFactory {
    public BookingRoomTupleScheme getScheme() {
      return new BookingRoomTupleScheme();
    }
  }

  private static class BookingRoomTupleScheme extends TupleScheme<BookingRoom> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BookingRoom struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      struct.roomType.write(oprot);
      struct.booking.write(oprot);
      struct.guest.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BookingRoom struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.roomType = new RoomType();
      struct.roomType.read(iprot);
      struct.setRoomTypeIsSet(true);
      struct.booking = new Booking();
      struct.booking.read(iprot);
      struct.setBookingIsSet(true);
      struct.guest = new Guest();
      struct.guest.read(iprot);
      struct.setGuestIsSet(true);
    }
  }

}

