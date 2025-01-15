from enum import Enum

class Direction(Enum):
    UP = 1
    DOWN = 2

class ElevatorState(Enum):
    IDLE = 1
    MOVING = 2
    STOPPED = 3

class DoorState(Enum):
    OPEN = 1
    CLOSED = 2