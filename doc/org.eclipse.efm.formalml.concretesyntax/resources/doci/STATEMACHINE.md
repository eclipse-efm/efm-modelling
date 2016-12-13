# Eclipse Formal Modeling Language - Concrete Syntax : Statemachines

A statemachine models symbolic state-transition machines or, more generally, symbolic transition systems.
```fml
[ design ] [modifier] statemachine [< [ moc: ] statekind> ] aStatemachineID {
      machine_section_list
}
instance statemachine [< [ model: ] aModelID > ] anInstanceID [ params ] ;
```
##	Model of computation (moc) 

###	Statemachine « and » 

For concurrent state-transition machines whose scheduling (by default, operation « |i| ») can be defined with primitives « @schedule{…} » and « @concurrency{…} ».
NB. Initialization of such a machine ends with the synchronous initialization (operation « |and| ») of all its states.

###	Statemachine « or »

For sequential state-transition machines.
NB. Initialization of such a machine ends with the initialization of its following states:
- its only « initial » pseudo-state, if it exists ;
- its only « start » state, if it exists ;
- otherwise, all its basic and composite states (and not pseudo-states), in a non-deterministic way (operation « |/\| ») .

##### Example 3
```fml
statemachine < moc:or > myStatemachine {
@region:
	state< initial > myStateInitial {
		@transition:
			transition t0 --> mySimpleState { /*actions*/ }
	}
	state mySimpleState {
		@transition:
			transition t1 --> myFinalState { /*actions*/ }
	}
	state< final > myFinalState;

}
```
   
# States

A state is used to model of basic or composite states of composite statemachines. Here, section names can be omitted.
 
```fml
state [< [ moc: ] statekind > ] aStateID {
      machine_section_list | ( state_component )+
}
statekind ::=  ( and | or )  |  ( simple | start | final )
        |  ( initial | terminal )  |  ( junction | choice )   |  ( dhistory | shistory )

state_component ::=
       [ declaration_variable ]
       [ definition_state ]
       [ definition_transition ]
       [ impl_primitive_activity ] 
impl_primitive_activity ::=
       [ @init{ … } ]
       [ @enable{ … } ] 
       [ @disable{ … } ] 
       [ @abort{ … } ] 
       [ @irun{ … } ]
       [ @run{ … } ]
       [ @final{ … } ]
```       
 
##	Model of computation (moc) 

###	Basic states « simple | start | final |»

A basic state is the only kind of (non-composite) state in which a « statemachine<or> » can be after a computation step (i.e. evaluation or initialization step).
The « start » state is an alias for both the only « state<initial> » and the « state<simple> » in which the « statemachine<or> » will be after its initialization, i.e. after the evaluation of its initial transition.
A « final » state ends the evaluation of its container « statemachine<or> ». It has no outgoing transition. Its « @final{…} » primitive can be implemented (see Section « @final {…} »).

###	Pseudo-states « initial | terminal | junction | choice | dhistory | shistory »
They are standard pseudo-states used in state-transition machines.
NB. Only pseudo-states which kind « initial, terminal, junction, choice» are currently supported.


##	Body of a state

In a state, it is possible, in the following order:
- to declare local variables, constants, etc. (see Declarations: variables, constants, « clocks », …);
- if it is a composite state, to define sub-states or outgoing transitions; note that a transition always belongs to its source state;
- to specify activities, i.e. actions to be done at key moments of its life cycle: initialization/finalization, activation/deactivation/abortion, evaluation, etc.

##	Activity primitives
In a symbolic transition system, activity primitives define actions that will be realised at key moments during the state’s evaluation cycle. They are part of the whole set of primitives that define a machine’s model of execution which can be implemented in section « @moe: ». 
NB. Diversity analyses each specification and compiles it into “optimized pseudo code”» for its symbolic evaluation engine. It can sometimes complete the user code written in primitives. Unless specified, specification code will always be evaluated before Diversity generated code. 
  
  
###	The « @init{…} » primitive
It can naturally – but not exclusively – be implemented for any composite, « initial » or « start » state. The user can define actions to be executed in the initialisation phase of the state that is, at the very beginning of the evaluation of the system. This is where the user can, for example, set an initial value to state variables. According to the kind of state, the initialisation will follow different patterns:
- « state< initial > » :
    - execution of its initialization primitive
	- execution of its « @run{…} » primitive, ending with the evaluation of its outgoing transitions
-  « state< start > » :
	- execution of its initialization primitive 
 N.B. The « @run {…} » primitive, and thus outgoing transitions, are not evaluated, unlike with initial states. So we stay in the start state after initialization. It is also the case with « simple » states.
- « statemachine< or > »:
	- execution of its initialization primitive 
	- initialisation of its unique « state< initial > », or its unique « state< start > », or, if they do not exist, of its « state< simple > » or composite states in a non-deterministic way.
- « statemachine< and > » :
	- execution of its initialisation primitive
	- simultaneous initialisation of all its states (i.e. synchronous parallelism); if the initialisation of one state fails, then the whole system’s evaluation fails.
N.B. The user must make sure that all initialisations terminate. Otherwise, its symbolic transition system might get blocked and not evaluable later on. 

For this reason, it is highly recommended to use mainly assignment statements in this phase;
- communication statements are not recommended,
- guarded statements are to be used with parsimony (the user must make sure that the logical condition is satisfiable).
  
  
###	The « @enable{…} » and @disable{…} » primitives
They correspond to Entry and Exit activities from UML Statemachines. They are evaluated, respectively, when activating and deactivating any state. The evaluation of a transition will follow this pattern: source state deactivation, action evaluation and then target state activation. Other scheduling possibilities will be available in further XLIA versions.

###	The « @abort{…} » primitive
It is triggered by abortion transitions (cf. Section « @transition: », the « abort » attribute) when deactivating the container state (instead of the @disable primitive triggered by other outgoing transitions). It is dedicated to composite states. 

###	The « @irun{…} » and « @run{…} primitives
Usually, the user implements the « @irun{…} » code, whereas the « @run{…} » code is generated by Diversity’s compiler.
The « @irun{…} » primitive corresponds to the Do activity of UML Statemachines: every attempt to evaluate a state starts with the evaluation of the « @irun{…} » if it is implemented, and goes on with the evaluation of the « @run{…} ». The effects of the « @irun{…} » evaluation are preserved even if the evaluation of the « @run{…} » fails. For instance, in the « @irun{…} » can be declared a clock counting the number of evaluation attempts of the state.
The « @run{…} » primitive evaluates outgoing transitions of its container state, according to the associated semantics. But the expert user can add code to be evaluated before outgoing transitions.
       

###	The « @final{…} » primitive
It is dedicated to:
-  « statemachine< or > » with at least one « state< final > »; the activation of one of these « state< final > » will trigger the evaluation of the statemachine’s « @final{…} » primitive; 
- « statemachine < and > » whose sub-states, which are necessarily composite, all have at least one « state< final > »; when all the sub-states’ « state< final > » are activated, then the statemachine’s « @final{…} » primitive is evaluated; 
- « state< final > » ; the state activation ends with the evaluation of the « @final{…} » primitive (just after the end of the « @enable{…} » primitive).

N.B. In composite states, the evaluation of « < final > » outgoing transitions is done as soon as their « @final{...} » primitive has been evaluated.

##### Example 4
```fml
// long version
state mySimpleState {
    @transition:
        transition t1 --> myFinalState { /*actions*/ }
    @moe:
    @enable{ /*entry-action, declenchée par les incoming transition*/ }
    @disable{ /*exit-action declenchée par les outgoing transition */ }	
}

// short version
state mySimpleState {
    transition t1 --> myFinalState { /*actions*/ }
    
    @enable{ /*entry-action, declenchée par les incoming transition*/ }
    @disable{ /*exit-action declenchée par les outgoing transition */ }	
}
```

In other documentation files, we will use the short way for state definition, that is, without section names such as @transition or @moe.       
       
       