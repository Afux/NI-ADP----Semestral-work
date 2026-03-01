# ADP – Semester Project

2D game inspired by Angry Birds, implemented in Java as a semester project for the NI-ADP course at CTU FIT.

The project was focused on applying common programming principles and design patterns.

The game follows the MVC architecture and incorporates a wide range of GoF design patterns.

![image](/niadp-mvcgame-b241-java/demo.png)

## Testing
- Unit tests were implemented for selected components.  
- Object mocking was used when testing the Memento pattern to isolate dependencies.


## Features & Used Patterns

### Creational Patterns

- **Abstract Factory**
    - Used to create all game objects.  

- **Builder**
    - Used to configure predefined levels.

### Structural Patterns

- **Bridge**
    - Separates view abstraction from its JavaFX implementation.

- **Decorator**
    - Adds power-ups to missiles.

- **Proxy**
    - Adds validation before command execution.


### Behavioral Patterns

- **Command**
  - Registers player actions and enables undo functionality.

- **Interpreter**
    - Used to interpret predefined command sequences (cheat codes).

- **Memento**
    - Enables undo functionality.
    - Creates snapshots of game progress.
    - Extended to store snapshots in files using a circular buffer.

- **State**
    - Changes shooting behavior based on the current state.

- **Strategy**
    - Changes missile movement behavior based on the current strategy.

---

### Additional Features

- **Collision System**
    - Implemented using Double Dispatch for flexible collision handling.

- **Snapshot Storage**
    - Snapshots are stored as files in the `snapshot` folder.
    - The game stores up to 3 snapshots; older snapshots are overwritten (circular buffer).


## Controls

- W / S $-$ move cannon up/down
- A / D $-$ change cannon angle
- SPACE $-$ shoot
- M $-$ switch shooting mode
- N $-$ switch missile movement mode
- U $-$ undo last command
- Y $-$ save snapshot
- X $-$ load last snapshot

## How to Run

```
gradlew run
//Windows
gradlew.bat run
```
### Notes

The game resolution is configurable in ```MvcGameConfig.java``` (default 1920x1080).

