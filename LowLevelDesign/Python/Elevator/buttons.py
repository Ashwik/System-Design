from abc import ABC, abstractmethod 

from enums import ElevatorState

class Button(ABC):
    def __init__(self, status):
        self.__status = status

    def pressButton(self):
        self.__status = ElevatorState.MOVING

    @abstractmethod
    def isPressed(self):
        pass


class ElevatorButton(Button):
    def __init__(self, button_no, status):
        super.__init__(status)
        self.__button_no= button_no
    
    def isPressed(self):
        return self.__status

class HallButton(Button):
    def __init__(self, button_sign, floor_no, status):
        super.__init__(status)
        self.__button_sign = button_sign
        self.__floor_no = floor_no
    
    def isPressed(self):
        return self.__status