from enums import DoorState, ElevatorState

class ElevatorCar:
    def __init__(self, id, state, elevator_panel, display, door):
        self.__id = id
        self.__state = state
        self.__elevator_panel = elevator_panel
        self.__dispaly = display
        self.__door = door
        self.__current_floor = -1
    
    def move(self, target_floor):
        self.__state = ElevatorState.MOVING
        self.__current_floor = target_floor
        self.__state = ElevatorState.STOPPED

    def stop(self):
        self.__state = ElevatorState.STOPPED

    def open(self):
        self.__door.open_door()

    def close(self):
        self.__door.close_door()

class Door:
    def __init__(self, door_state):
        self.__door_state = door_state

    def is_open(self):
        return self.__door_state == DoorState.OPEN
    
    def open_door(self):
        self.__door_state = DoorState.OPEN
    
    def close_door(self):
        self.__door_state = DoorState.CLOSED

class ElevatorPanel:
    def __init__(self, open_button, close_button, floor_buttons):
        self.__open_button = open_button
        self.__close_button = close_button
        self.__floor_buttons = floor_buttons