
#ifndef IHOUSE_ICE
#define IHOUSE_ICE

module IHouse
{
  struct DeviceInfo
  {
    string type;
    string name;
    string location;
    string description;
  }
  
  struct DateTime
  {
    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;
  }

  struct Event
  {
    DateTime time;
    string source;
    string description;
  }

  sequence<Event> EventSeq;
  sequence<DeviceInfo> DeviceSeq;
  
  exception InvalidArgumentValue {string reason = "invalid argument";};

  interface Discover
  {
    DeviceSeq listDevices();
  };

  interface Light
  {
    bool on();
    bool off();
  };
  
  interface DimmableLight extends Light
  {
    bool setLevel(int level) throws InvalidArgumentValue; 
  };

  interface Heating
  {
    bool on();
    bool off();
    bool setTemperature(int level) throws InvalidArgumentValue;
  };

  interface MotionSensor
  {
    bool arm();
    bool disarm();
    EventSeq getEvents();
  };

};

#endif
