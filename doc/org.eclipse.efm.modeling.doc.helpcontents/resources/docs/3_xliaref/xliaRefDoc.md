# XLIA Reference Documentation
(proposition de plan)  

## General Introduction  
### Overview of Diversity 
### Overview of XLIA Language
BNF syntax  
conventions du language   
notions de superstructure et d'infrastructure  

## XLIA Superstructure Concepts  
### Machine concept
_(supprimer tous les modifiers de la commande machine du Help d'Erwan)_  
#### Model-instance-prototype paradigm  
#### Superstructure hierarchy  
    Context (=system)  
      Hierarchic Block  
        Atomic block (=statemachine)  
          One or more region(s)
#### Machines within machine
How to modelize composite, hierarchic, parallel and/or multi-state system
#### Interaction
@com
#### Scheduling 
@moe
#### Model 
@composite
#### Instance 
@instance
### Machine Types 
#### System   
#### State Machine  
@region
#### State  
@enable, @disable, @irun, @init, @final,  @abort

## XLIA Infrastructure Concepts
### Properties
#### Variable
##### Variable Modifiers
##### Variable Behaviors
#### Ports
#### Types
##### Bounded numbers and Intervals
##### Collections
Array, Vector, RVector List, Set, Multiset _(tous ?)_  
##### Queue
##### Enumerations
##### Structures
### Signals
### Transition
### Instructions
#### Order Operators
_ (Tous ? cf. doc Erwan)_
	





