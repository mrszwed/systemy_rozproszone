namespace java ser.thrift

struct Person {
  1: string name,
  2: string surname,
  3: i32 birthYear,
}

struct FiveDoubles {
  1: double d0,
  2: double d1,
  3: double d2,
  4: double d3,
  5: double d4,
}

struct Mixed {
  1: i8 b,
  2: i16 s,
  3: i32 i,
  4: i32 f,
  5: double d,
  6: string ss,
}
    
 
service STest{
   void setDummy(),
   void setPerson(1: Person p),
   void setPersonSequence(1: list<Person> ps),
   void setFiveDoubles(1: FiveDoubles fd),
   void setFiveDoublesSequence(1: list<FiveDoubles> fds),
   void setMixed(1: Mixed m),
   void setMixedSequence(1: list<Mixed> ms),	
}