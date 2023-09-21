
#ifndef SERIALIZATION_ICE
#define SERIALIZATION_ICE

module Serialization
{
  struct Person
  {
    string name;
    string surname;
    int birthYear;
  }
  
  struct FiveDoubles
  {
    double d0;
    double d1;
    double d2;
    double d3;
    double d4; 
  }
  
  struct Mixed
  {
    byte b;
    short s;
    int i;
    float f;
    double d;
    string ss; 
  } 
  
  sequence<Person> PersonSeq;
  sequence<FiveDoubles> FiveDoublesSeq;
  sequence<Mixed> MixedSeq; 

  interface STest
  {
    void setDummy();
    void setPerson(Person p);
    void setPersonSequence(PersonSeq ps);
    void setFiveDoubles(FiveDoubles fd);
    void setFiveDoublesSequence(FiveDoublesSeq fds);
    void setMixed(Mixed m);
    void setMixedSequence(MixedSeq ms);    
  };

};

#endif
