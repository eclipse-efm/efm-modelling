# Eclipse Formal Modeling Language - Concrete Syntax : Machines

The machine is the basic component on which the EFM language relies. 
It is defined by its sections, which are described in file SECTIONS.md  
A specification could be totally defined with machines but, for the sake of simplicity, the EFM language provides several types of high-level machines:

- « system », the main machine representing the system, 
- « statemachine », for a native (à la DSL) representation of symbolic state-transition machines,
- « procedure », for a simplified representation of standard procedures,
- « state », for a native and simplified representation of basic or composite statemachine states.
  
```fml
[ design ] [modifier] machine [ < [ moc: ] statekind > ] aMachineID {
      machine_section_list
}
design ::=  model | prototype 
modifier ::=  input_enabled | timed 
statekind ::=  and | or  
machine_section_list ::=
       [ @parameter: … ]
       [ @declaration: … ]
       [ @machine: … ] 
       [ @transition: … ]
       [ @moe: … ]
       [ @com: … ]

instance machine [< [ model: ] aModelID > ] anInstanceID [ params ] ;
params  ::=  ( ([ paramID : ]  expression ,)+ )
```

##	The « design » attribute

The EFM language supports the « model-instance » paradigm: a machine can either be

- a « model », which can be instantiated, one or several times, such as in object-oriented programming,
- a model « instance », in which the model parameters can be fully or partially initialized, such as class builders in object-oriented programming,
- a « prototype », which is an alias for the declaration of a model and its first instance at the same time, and whose parameters can be initialized during its declaration.

By default, for the sake of simplicity, any machine will be a « prototype ».


##	The « modifier » attribute

Several kinds of machines can be defined thanks to the « modifier » attribute.

###	The « input_enabled » attribute

This attribute enables the definition of a communicating machine that can react to any incoming event, at any time. For example, an « input-enabled » statemachine must be able to react to any input in any of its states. The use of this attribute can have strong semantical consequences. For example, in the case of asynchronous communication via buffers, if a transition receives a message that is not expected at that moment, this message is simply lost.

###	The « timed » attribute

For a machine with the « timed » attribute, Diversity adds elements that enable handling of symbolic time. 


##	Model of computation (moc) 

For every composite machine, the « moc: » attribute can be used to define concurrency when evaluating its components (in the « @machine » section):
- « and » means that its components are concurrent with each other, such as orthogonal states in statecharts that is, at any time, all components are active ; by default, concurrency will be simulated by using « interleaving ».
- « or » means that, at any time, of all components at the same level, at least one is active.

By default, the model of computation of a machine is « or ». Atomic machines (i.e. non-composite) are not concerned.

##### Example 1
``` fml
model machine < moc:or > myModelMachine {
@parameter:
	var int u;

@machine:
	machine myPrototypeSubmachine1 { ... }
	machine myPrototypeSubmachine2 { ... }
@moe:
	@run{
		if u == 42 {
			run myPrototypeSubmachine1;
		}
		else
			run myPrototypeSubmachine2;
		}
	}
...
}

instance machine < model:myModelMachine > myInstanceMachine( u:42 );
```

## System

In a EFM specification, the main machine is called a « system ». 

```fml
[modifier] system [ < [ moc: ] statekind > ] aSystemID {
      machine_section_list
}
```
Attributes « modifier » and « moc » can still be used with a system. 

##### Example 2
```fml
System< and > mySystem {
@machine:
	model machine< or > myModelMachine { ... }

	instance machine< myModelMachine > myInstanceMachine42( 42 );
	instance machine< myModelMachine > myInstanceMachine18( 18 );
}
```
Unlike in Example 1, here, labels such as “moc:” or “model:” are omitted.

