# Eclipse Formal Modeling Language - Concrete Syntax : Instructions

## Foreword
In this file, we will describe the syntax of the main EFM instructions and we will give an intuition of their symbolic evaluation semantics. Before that, we will introduce the notions of symbolic evaluation context and symbolic evaluation tree which represent all possible evaluation paths for an instruction.
The behavior of a machine is described thanks to a set of instructions. An evaluation context EC (also called an evaluation environment) contains the information necessary for the symbolic evaluation of these instructions. It is composed of 
-	a « Configuration State » CS, showing the system’s state of control: for example, the set of active states for a state-transitions machine;
-	a data part with 
  -	VD (« Variable Data »), the set of symbolic values associated with each variable, 
  -	BD (« Buffer Data »), the content of each communication buffer;
-	a set of satisfiable constraints PC (« Path Condition »): it is a conjunction of logical conditions resulting from the symbolical evaluation of decision instructions , such as guarded or conditional instructions, that have guided the evaluation until configuration;
-	information that enable a partial or global tracing of the evaluation: ET (« Evaluation Trace »);
A context EC is thus a tuple (CS, VD, BD, PC, ET). In the following, we will sometimes omit some elements of the tuple when they are not useful for the evaluation of current instruction. For any instruction stm, notation « EC -- stm --> {EC1 EC2 … ECN} » will mean that stm’s evaluation from context EC resulted in contexts EC1, …, ECN, representing all possible effects of stm on context EC. It will mean that the evaluation of stm from EC can lead whether to EC1, or to EC2, etc. The user can decide to put stm in the traces ET1, …, ETN. When the list of resulting contexts is empty, it means that the evaluation of the instruction has failed; otherwise, it terminates.
A symbolic evaluation tree is a tree built from an initial context EC0 and the evaluation of a “composite instruction”, called process. This tree will be denoted by « (EC0 {(EC1 {(ECa {…}) … (ECk {…})}) … (ECN{…})}) ». Intuitively, such a tree is built according to the following steps:
-	Creation of an initial context EC0 ;
-	Evaluation of the machine’s « @init{…} » primitive for initialisation;
-	Repeated call of its « @run{…} » primitive, using, at each step, the context resulting from previous evaluation step.
The figure below is a graphical representation for the following symbolic evaluation tree: « (EC0 {(EC1 {(EC2 {…}) (EC3 {…})})}) ».
   
![Tree][tree.jpg]

##	Block instructions
It defines a set of instructions ordered by an operator. By default, this operator is the standard sequence |;|. These block operators can be put into three categories: sequencing, scheduling and concurrency.

```fml
{  [ operator ] ( statement )+ }
operator ::=  
                 // sequencing
                |§|  |  |;|  |  |;;|  |  |.|
                 // scheduling
                 |>|  |  |xor|  |  |/\|
                 // concurrencing
                |and|  |  |or|  |  |i|  |  |,|
```
Let P and Q be two processes. We say that a process terminates when it has been totally evaluated (without being interrupted by, for example, the failure of a guarded instruction), and that it fails otherwise. 

![Evaluation possibilities][evaluation.jpg]

There are as many evaluation possibilities as there are red dots (starting states). For instance, « P |.| Q » can be reduced to P if Q does not terminate, or to P followed by Q. If P does not terminate, « P|.|Q » does not terminate either.


###	Sequencing operators

#### The standard sequence, called strong sequence here: P |;| Q
Its evaluation terminates only if both P and Q terminate. Otherwise, no effects are preserved, and we go back to the initial context.

#### The weak sequence: P |;;| Q
This is not a standard sequence: its evaluation terminates if one of the two processes P or Q terminate. We try to evaluate P. If it terminates, then Q is evaluated from the resulting context, otherwise, from the initial context. This sequence can be used to create a partial order which avoids combinatorial explosion resulting from machine interleaving.

#### Sequence with side-effect: P |.| Q
This sequence terminates only if P terminates. If Q does not terminate, the resulting context will be P‘s resulting context: P side-effects are preserved. For example, from context EC< CS, VD, BD, PC, ET >, if Q does not terminate, the evaluation of a transition labelled with « P |.| Q » will fail, but still, the result will be a new context EC’< CS, VD’, BD’, PC’, ET’ > with, at least, the same control CS as EC. The evaluation of this transition will be tried again from EC’ at the next step.

###	Scheduling operators

#### Priority: P |>| Q
Process P is evaluated in the initial context. Process Q is evaluated in the initial context with in addition, if P terminates, the Boolean negation of conditions resulting from P’s evaluation. Thus, if both P and Q terminate, there are two possible resulting contexts 

#### Indeterminism: P |/\| Q
Both processes P and Q are evaluated from the initial context. If both terminate, there will be at least two execution paths, showing the indeterminism.

###	Concurrency operators

####	Strong synchronous: P |and| Q
Both processes are evaluated from the initial context. If they both terminate, both contexts of resulting sets will be merged, providing that there are no concurrent accesses and the merge of their reachability constraints is satisfiable. Thus, we will simulate their strict simultaneous evaluation, i.e. their synchronous evaluation. Otherwise, the evaluation fails.

####	Interleaving: P |i| Q
Both processes are sequentially evaluated, considering every possibility: here P followed by Q and Q followed by P. Warning: this operator easily leads to an explosion of the number of execution paths.

####	Simple parallelism: P |,| Q
If both processes terminate, they are evaluated simultaneously if possible (for example, there must be no concurrent acces), otherwise the evaluation fails. If one of the processes does not terminate, the other one will be evaluated alone.

##	Assignment instructions

A « rvalue » expression is evaluated and assigned to the variable resulting of the evaluation of a « lvalue ». This variable is:
-	the evaluation of the « lvalue », if it is itself an expression (for example, an access to an element in a collection), 
-	the « lvalue » itself if it is a simple variable – it cannot be a constant.
>lvalue  (  = |  :=  )  rvalue ;

###	Macro assignment
An expression « rvalue » is assigned to a « macro » without being evaluated.
```fml
lvalue<macro>  ::=  rvalue ;
```

###	Increment and decrement operations

```fml
[ ++ | -- ]  lvalue  ;
lvalue  [ ++ | -- ] ;
```

##	Guarded instructions

The guard instruction evaluates a symbolic expression, checks whether it is satisfiable, and adds the result to Path Condition. 
The event instruction evaluates an expression to true or false without using any solver. If it is not possible, the expression is evaluated to false.

```fml
guard expression< boolean >;
event expression< boolean >;
```

##### Example 20
```fml
guard patient_connected && (! Error) ;
guard timer != 0;
		
event bad_connection;		
event x>x_Max;	
```
##	Communication instructions

```fml
input     portID  [ (  ( expression ) +<,>  ) ]  [ <--  machine ] ;
output    portID  [ (  ( expression ) +<,>  ) ]  [ -->  machine ] ;
present   portID
absent    portID
```
Input and output instructions enable the sending and reception of messages or signals that might contain parameters. The sending machine – in the case of an input, or the receiving machine – in the case of an output, can be specified.
Keywords present and absent check whether a message is present or absent on a given port.

##### Example 21
```fml
@declaration{
   public port input p1;
   public port input p2(boolean);
   public port output p3;
   public port output p4(integer);
}
…
input  p1; 	
input  p2(x);
output p3 --> m2; 
output p4(6,25); 
```

##	Conditional instructions 
They are standard conditional instructions.
```fml
if  expression< boolean > { statement }
( elseif  expression< boolean > { statement } )*
[ else { statement } ]
```
##### Example 22
```fml
if cond1 {x = x+1;}	
elseif cond2 {x = x+2;}
else {x = y;}
```

##	Iteration instructions
They are standard for, while and do instructions.
```fml
for 
( statement < assign > ; expression< boolean >  )
{ statement }  
while  expression< boolean>  { statement }  
do  { statement }  while  expression< boolean > ;
```
##### Example 23
```fml
for x=1 ; x<x_Max ; x=x+1; {…}

while (x < x_Max) {x=x+1;}

do {x=x+1;} while (x < x_Max);
```

##	Control and loop instructions
They are standard control and loop instructions. 
```fml
break ;
continue ;
```



