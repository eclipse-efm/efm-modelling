# Eclipse Formal Modeling Language - Concrete Syntax : The body of a machine - Sections

A machine is defined by its sections. The sections order is important for ease of syntactical and semantical analysis:
- first, parameter declarations, state data (variables, buffers), and interaction points (ports, …);
- then, components (submachines);
- and finally, the model of execution and the model of communication.

##	The « @parameter: » section
When instantiated, a machine can receive parameters, that is data denoted by variables. These parameters must be declared in the « @parameter: » section.

##### Example 5
```fml
machine aMachineID{
@parameter:
	var int p1;
	var bool p2;
}
```
   
##	The « @returns: » section

A machine can also send data – denoted by variables, at the end of a computation step. These variables must be declared in the « @returns: » section.

##### Example 6
```fml
machine aMachineID{
@returns:
	var int v;
}
```

##	The « @declaration: » section
As usual, a machine can also be defined thanks to specific data, in addition to parameters. These data must be defined in the « @declaration: » section. 
Each data in this section is associated with a visibility « modifier », which is « private » by default. For public data, the modifier must be explicitly set to « public ». 

##### Example 7
```fml
machine aMachineID{
@declaration:
	var bool u;
	public var bool b;
}
```

The user can define several declaration sections, in which all declarations have the same visibility « modifier »: « private » or « public ». In that case, @declaration can be replaced by the name of the modifier.

##### Example 8
```fml
machine myMachine{
@private:
    const integer TMIN = 20;
    const integer TMAX = 25;
@public:
    var integer v1;
    var integer v2;
@public:
    port input p1;
    port output p2;
}
```

###	Type definition
It is the association of an alias (a type name) with an existing type.
```fml
@declaration:
[modifier]  type  aNewTypeID   aPrimitiveTypeDefinition ;

[modifier]  type  aNewTypeID   aTypeID ;

[modifier]  type  aNewTypeID  anArrayTypeDefinition ;
[modifier]  type  aNewTypeID  aCollectionTypeDefinition ;
[modifier]  type  aNewTypeID  aQueueTypeDefinition ;

[modifier]  type  aNewTypeID  anEnumerationTypeDefinition
[modifier]  type  aNewTypeID  aStructureTypeDefinition
[modifier]  type  aNewTypeID  aUnionTypeDefinition
modifier ::=  public
```

#### Primitive types 
They are standard predefined types, signed or not, which represent Booleans (boolean | bool), characters (char), strings (string), integers (integer | int | uinteger | uint), rationals (rationnal | rat | urationnal | urat), floats (float | ufloat | double | udouble), reals, etc.

By default, calculations on numbers are performed with arbitrary precision, according to « gnu/gmp ». But it is possible to give limits to types by defining an interval thanks to powers of two:
- \[ 0 , 2N  \] for unsigned types,
- \[ -2N - 1 , 2N - 1 - 1 \] for signed types.

```fml
numeric_type < [ bit: ]  integer<positive>  >
numeric_type :  integer<positive> 
 ```
 
Thus,
- int\<bit:8\> is the set of all integer values between -128 and 127.
- urat:9 is the set of all rational values between 0 and 512.
Less symmetrical intervals can be defined via the « interval » type.


####	Interval types
Intervals are defined upon a « support », which must be a primitive numerical type. The standard ISO notation will be used to tell if the interval is open or closed, i.e. if its limits are included or not:
- left : open « \] »,  closed « \[ »
- right :   open « \[ »,  closed « \] »
interval< aPrimitiveTypeID  isoIntervalDef >
isoIntervalDef \[ :\< aPrimitiveTypeID \> \]	

In absence of any precision, the support will be deduced from the infimum and supremum type.
	
#### Array types
``` fml
aTypeID [ integer<positive> ]
```

####	Collection types
A collection is a container for items of a given type. An optional maximal size can be given with a positive integer (« * » for infinite).
```fml
( array |  vector |  rvector |  list |  set |  multiset ) < aTypeID [ , ( integer<positive> | * ) ] >
```

##### Example 9
```fml
var vector<UserEntry> userDataBase;
```

####	Queue types
Queues are ordered collections with specific addition and removal policies.
```fml
( fifo |  lifo ) < aTypeID [ , ( integer<positive> | * ) ] >
```

####	Enumerated types
Enumerated types are sets of named values that usually behave as constants in the language.
```fml
enum  {
    aSymbolID_1  [  =  expression<numeric > ]  ,
    …
    aSymbolID_N [  =  expression<numeric > ]
}
```
 
##### Example 10
```fml
type PhoneOperation enum {CALL, TERMINATE_CALL, ACCEPT_CALL}
type CallReject enum {LINE_BUSY, UNKNOWN_NUMBER}
```

####	Structure types
They are standard record types. 
```fml
struct  {
    aVariableDeclaration_1 ;
    …
    aVariableDeclaration_N ;
}
```

##### Example 11
```fml
type PhoneCallAction struct {
     var int callerID;
     var PhoneOperation op;
}
```

###	Declarations: variables, constants,  clocks, …
Every variable used in a machine must be previously declared, and it can be initialised with an expression. Several declarations sharing the same attributes can be grouped.

```fml
[modifier]  var  aTypeID  aVariableID [ =  initial_value  ]   (  ;  |  {  rw_action  }  )
     modifier ::=  public | static | final | macro | volatile | unsafe
initial_value ::=  (  =  rvalue  |  (  rvalue  )  )
      rvalue  ::=  expression  |  {  ( expression ,)+  }
    rw_action ::=  @on_write( aTypeID   newVal )   block_statement
```

It is possible to combine several declarations:
```fml
[modifier]  var  {  (  aTypeID  aVariableID  [ =  initial_value  ]   (  ;  |  {  rw_action  }  )  )+  } 
[modifier]  var<  aTypeID >  {  (  aVariableID  [ =  initial_value  ]   (  ;  |  {  rw_action  }  )  )+  }
```

For the sake of simplification, aliases can be used to replace some groups of « modifier var »:
-	« final var » can be replaced by « const » when defining constants
-	« macro var » can be replaced by « macro » 
-	« clock var » can be replaced by « clock »
The « modifiers » attributes of a variable are described in the following:

####	Constants: « final »
A constant is a variable which can be initialized but never modified. It can never be the left member of an assignment nor be used for data reception.

####	Macros: « macro »
A macro is a typed « variable-function » that can be used as any variable of the same type. When it is used, it must always have a value, which is a function of other variables, so that it can be valuated as a function. For example:

##### Example 12
```fml
var int { x ; y ; z ; }  // grouped declaration 
macro int F = (x + y) ;
…
z = F ;  // literally equivalent to z = x + y ;
F ::= z – y ; // to syntactically reassign a macro 
X = F ; // literally equivalent to z - y ;
```   

####	The « volatile» attribute
This attribute indicates that the value of a public variable can be modified outside its normal visibility scope, for example by a parallel machine.

####	The « transient » attribute
This attribute indicates that a variable can only be used in computations, and never as a state variable of the machine. This information is used by heuristics such as those which try to anticipate redundant symbolic evaluations.

####	The « unsafe » attribute
This information is used by the XLIA compiler: if the variable is of a ranged type, the compiler will check all its uses and possibly generate a monitor to put constraints on expressions which are assigned to it. 



##### Example 13
```fml 
unsafe var  int:6  temperature;
```
is equivalent to
```fml
var  int:6  temperature; {
	@on_write( val ) {
		guard( (-32 < val) and (val < 31) );
	}
}    
```

###	Buffers declarations
A buffer is a queue where messages are stored. A maximal size can be affected to each buffer.

```fml
[modifier]  buffer  buffer_def  aBufferID ;
  modifier ::=  public | 
buffer_def ::=  ( fifo | lifo | set| multiset | ram ) [ < ( integer<positive> | * ) > ]
```
Combined declarations:
```fml
// buffers with different types
[modifier]  buffer {  (  buffer_def  aBufferID ;  )+  }
// buffers of the same type
 [modifier]  buffer< buffer_def  > {  (  aBufferID ;  )+  }
```

###	Interaction points declaration 
An interaction point – called « port » in XLIA, enables data transmission during communication operations. It can be a one-way point (input or output), or a two-way point (inout) for bidirectional communications. Every data type going through a port must be specified when declaring the port:
-	they can be given a name,
-	they can be associated with an expression to be sent by default, such as a macro, which is evaluated before transmission,
-	they can be associated, by default, with the left part of an assignment, which will be evaluated during the reception operation, and used to store the data.
The « @bind » attribute binds these parameter-expressions to the port, and forbids any substitution in communication statements.
N.B. Signals must be declared in a machine containing the machines where it is used, and they are always inout. 

```fml
[modifier]  (port | signal | message)  port_io  aPortID [ params ] ;
modifier ::=  public  
port_io  ::=  input | output | inout
 params  ::=  ( ( param ,)+ )
  param  ::=  aTypeID [ paramID ]
                 |  aTypeID [ @bind ]  [ paramID : ]  expression<macro>
```
Combined declarations:
```fml
// ports with different signatures 
[modifier]  (port | signal | message)  {  (  port_io  aPortID [ params ] ;  )+  }
// ports with the same direction
[modifier]  (port | signal | message)  < port_io >  {  (  aPortID [ params ] ;  )+  }
// ports of the same signature
[modifier]  (port | signal | message)  < port_io [ params ]  > {  (  aPortID ;  )+  }
```


##	The « @transition: » section

Transitions describe operational behaviours in peculiar machines, called symbolic state-transition machines.
This section can be included in a statemachine in order to gather output transition definitions. 
```fml
[modifier] statemachine [< [ moc: ] statekind > ] aStatemachineID {
…
@transition:
…
}
```

But for the sake of simplicity, in a « state », the name of the « @transition: » section can be avoided.
```fml
[modifier]  transition [< ( moc4trans ,)+ > ]   aTransitionID  moe4trans
   modifier ::=  transient | …
  moc4trans ::=  [ moc: ] transkind  |  [ prior: ] integer<positive>  
transkind   ::=   ( simple | abort | final )   [ [  & ] else ] 
        
  moe4trans ::=  block_statement  [ --> ]  ( aTargetStateID  ,)+  ;
                        | -->  ( aTargetStateID  ,)+  (  block_statement  |  ;  )
```
The « modifier » attributes of a transition are described in the following.

###	The « transient » modifier
The specificity of a « transient » transition is that its evaluation is followed by the evaluation of its target state, whatever state it is, stable or not.



###	The model of computation

####	The « simple » attribute
By default, and as usual, a transition type is « simple ». 

####	L’attribut : « abort »
A transition with the abort attribute is called an « abortion transition ». When the source state is composite, the abortion transition has priority on the state’s internal transitions. Moreover, its evaluation will trigger the @abort primitive instead of the @disable primitive, as mentioned in Section State, Chapter @abort{…} .

####	The « final » attribute
It indicates finalisation transitions. Their evaluation starts when their source state, which is necessarily composite, has all its « state< final > » activated (see chapter on the « @final {…} » primitive). 

####	The « [&] else » attribute
It indicates the transition(s) with the lowest priority d’une classe donnée. It is used when one wants to give a deterministic evaluation of a state’s output transitions, using logical constraints or explicit priorities (see following section). 
The expression « transition< else > » is an alias for « transition< simple & else> ».

####	Priorities	
They schedule transitions of the same kind (simple, abort, final, etc.) and coming from the same source state. Usually, the highest priority is 0, and the transition with the lowest priority will be assigned the highest number of all transitions. Two transitions with the same priority will be evaluated in a non-deterministic way.

##### Example 15
```fml
state mySimpleState {
    transition t0 --> targetState0 { /*actions*/ }
    transition< prior:1 > t1 --> targetState1 { /*actions*/ }
    transition< prior:2 > t2 --> targetState2 { /*actions*/ }
    
    transition< else >    t3 --> targetState3 { /*actions*/ }
}
```
Priority order is t1, then t2, then t3.

##### Example 16
```fml
state < moc:or > myCompositeState {
	state< initial > myStateInitial { /*transitions*/ }

	state mySimpleState { /* transitions */ }

	state< final > myFinalState{
	    // simple transition
        transition t --> nalState { /*actions*/ }
    
        // final transition
        transition< final > t_final --> targetState1 { /*actions*/ }
    }
}
```
Transition t_final is triggered by the activation of “myFinalState”. 
The choice between transtition t and myCompositeState’s (active state’s) internal transitions is nondeterministic. But setting the attribute “abort” makes transition t prioritary:

##### Example 17
```fml
state < moc:or > myCompositeState {
	state< initial > myStateInitial { /*transitions*/ }
	
	state mySimpleState { /* transitions */ }

	state< final > myFinalState;

	// a transition 
	transition<abort> t --> externalState1 { /*actions*/ }
    
	// a final transition
	transition< final > t_final --> externalState2 { /*actions*/ }
}
```

##	The « @moe: » section

Most of this section’s primitives are already described in the Statemachines decription : « @init»  and « @final»,  « @enable», « @disable», « @abort», « @irun».

###	The « @run{…} » primitive
It is the main primitive of XLIA machines, describing the evaluation model of machines in the system. It is called at each execution step of the system in a « top-down » manner: in the @run primitive, a machine calls (directly or not) the execution of its components via the instructions run or schedule.
In a model with state-transition machines, this primitive can be completely generated by Diversity’s compiler according to semantical information given by the user (e.g. transition priorities).
Let us have a look at the following system:

![System][system.jpg]

The following XLIA code describes this system:
```fml
System@run{ |;;|
   run MachineA ;
   { |,|
       run MachineB ;
       run MachineC ;
   }
}
```

A system’s behaviour is given by the evaluation of its @run primitive, which calls the sub-machine @run primitives. The scheduling operators are described further, in Section « block instructions ».
Such as in “dataflow” systems, input parameters « @param » can be given when calling a @run primitive, and output data « @returns » can be collected. Let’s suppose that ports described above are associated with variables with the same name. Then, the above code can be refined into the following one:
```fml
System@run{ |;;|
   run  MachineA (inA1) --> (outA1, outA2) ;
   { |,|
       run  MachineB (outA1) --> (outB1) ;
       run  MachineC (inC1, outA2) --> (outC1)  ;
   }
}

@run [ ( ( input ,)+ ) ]  [ --> (  ( output ,)+ ) ]  block_statement
input  ::=  aTypeID  paramID  [ =  expression ]
              |  varID [ =  expression ]
output  ::=  aTypeID  paramID  [ =  expression ]
```
Input parameters of the @run primitive will be declared as « transient » variables of the machine (i.e. computation variables, instead of state variables). But any variable that has the primitive in its scope can be declared as an input parameter for the primitive, provided the varID is declared in the primitive type.

###	The « @schedule{…} » and « @concurrency{…} » primitives
These primitives are syntactic sugar to describe the scheduling of a machine’s executable components:  
- the « @schedule{…} » primitive will contain the evaluation politics for some (or all) of these components, 
- the « @concurrency{…} » primitive will contain the scheduling operator for the remaining components (that are not in « @schedule{…} » nor in « @run{…} ») ; if this primitive is empty, the default operator is the interleaving operator « |i| ».
The link between policies described with these two primitives will be the weak sequence « |;;| ».
For example, suppose we have a machine M containing four executable components A, B, C and D, with primitives « @schedule{ |,| run A ; run C ; } » and « @concurrency{ |;;| } ».
Its implicit scheduling policy, triggered by primitive « @run{…} », will be 
>{ |;;|  { |,| run A ; run C ; }  { |;;| run B ; run D ; } }

which is equivalent, by transitivity of operator « |;;| », to
```fml
{ |;;|  { |,| run A ; run C ; }  run B ; run D ; }.
```

##	The « @com: » section

It describes interactions between machines, or between a machine and the environment, via ports and according to a given protocol.
```fml
@com[<  protocol >]    : 
	connect[< protocol >] {  ( com_bus |  com_port  )+  }
	route[< protocol >] {  (com_port )+  }

protocol  ::=  
   env   |  rdv  |  (  multirdv  [ , cast ]  )
   buffer [ <  type_buffer > | : bufferID ] 

cast   ::=   unicast  |  multicast  |  broadcast

com_bus ::=  (  input  |  output  )  [< ( cast | type_buffer ) >]{  ( com_port )+  }
com_port  ::=  portID [ type_buffer ] ;
```

###	The communication protocol
The protocol tells whether the communication is between a machine and the environment (env), or between two machines (rdv). When several input/outputs are possible (multirdv), constraints can be added via the cast option:
- unicast implies that, at any time, there can only be one sender and one receiver,
- multicast implies that all outputs must be emissions, and all inputs must be receptions,
- broadcast implies that there are at least one sender and one receiver. 

N.B. If there are several senders, messages should be without parameters: otherwise, it would not be possible to know which parameter is collected by a receiver.
The buffer keyword indicates that a message or signal must be stored in a buffer.
A default protocol can be given just after the section name.

###	Communication means
The connect keyword connects two ports or buses, possibly via a buffer. A com_bus a group of ports sharing some attributes, e.g. the cast option or a buffer.

##### Example 18
```fml
connect< env >{
		input Machine1->portA;
		output Machine2->portB;
		output Machine2->portC;
	}
					
	connect< rdv >{
		output Machine1->portD;
		input Machine2->portE;

	}
```	
In this example, the input port portA of Machine1 and the output port portB of Machine2 are connected to the environment. The output port portC of Machine1 is connected to the input port portD of Machine2, using the « rendez-vous » protocol.

The route keyword indicates where to store information in the case of a signal. 

##### Example 19
```fml
machine aMachineID{
@declaration:
    buffer fifo b;
@com:
route <buffer:b1> {*}
```
In this example, all output data will be stored in buffer b, and all input data taken from b, unless if the target state (resp. the source state) is given in the output (resp. input) instruction: in that case, the route of the target (resp. the source) state has priority, if it exists. 

N.B. The rdv mode is not implemented for signals, thus it is not compatible with keyword route.



