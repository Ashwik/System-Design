from abc import ABC, abstractmethod

class Vehicle(ABC):
    def __init__(self) -> None:
        pass

class Car(Vehicle):
    def __init__(self) -> None:
        super().__init__()

class Truck(Vehicle):
    def __init__(self) -> None:
        super().__init__()

class MotorCycle(Vehicle):
    def __init__(self) -> None:
        super().__init__()



class VehicleLog:
    def __init__(self) -> None:
        pass