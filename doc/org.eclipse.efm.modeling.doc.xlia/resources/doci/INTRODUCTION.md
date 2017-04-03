# Eclipse Formal Modeling Language - Concrete Syntax : Introduction

We describe a language, formerly known as XLIA, (eXecutable Language for Interaction and Assembly), used for specification of component-based system behaviors. We call these components « machines ». They are communicating, hierarchical and heterogeneous, and their evaluation semantics is customizable. *
Machines are described in more details in MACHINES.md


Each component is defined by a set of **sections** taken among the following:

- « param », where you can declare variables to be initialized when instantiating the machine,
- « returns », where you can declare variables containing return values, when dealing with procedures,
- « declaration », which can contain 
	- user-type definitions: 
		- structures, enumerations, arrays,
		- type aliases, etc.
	- typed variable declarations with their « modifier », constants, clocks, etc.
	- buffer declarations, for communication,
	- interaction point declarations, gathering “ports, signals and messages”,
- « machine », where submachines can be defined, in particular “statemachine” states,
- « transition », where can be defined transitions towards « submachines », when modeling transition systems,
- « moe », where can be implemented « machine » behaviors via primitives (init, run, enable, disable, etc…) that are usually automatically generated after compiling (e.g. with « statemachines »),
- « com », to specify interactions/communications via « route » connections between machine ports.

Sections are described in more details in SECTIONS.md

##	Legend 
In our documentation, we take inspiration from the BNF to present the grammar.
Symbols for the grammar meta-language are in orange: brackets surround \[ optional \] elements, + means that the preceding expression \(possibly between parentheses\) can be repeated one or several times, \* that it can be repeated any number of times (including none). Terminal symbols - that is language keywords, are in red, and non-terminals in green. In black are variable names and standard non-terminals (e.g. statement, expression) that will not be recalled in this document. 


##	Prologue 

The EFM language version used for the specification is given here: 
@xlia< system ,  1.0 > :   


