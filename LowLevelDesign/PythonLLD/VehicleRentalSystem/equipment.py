from abc import ABC, abstractmethod

class Equipement(ABC):
    def __init__(self) -> None:
        pass

class ChildSeat(Equipement):
    def __init__(self) -> None:
        super.__init__()

class SkiRack(Equipement):
    def __init__(self) -> None:
        super().__init__()
