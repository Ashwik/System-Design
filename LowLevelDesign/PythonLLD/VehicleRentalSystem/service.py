from abc import ABC, abstractmethod

class Service(ABC):
    def __init__(self) -> None:
        pass

class RoadSideAssistance(Service):
    def __init__(self) -> None:
        super.__init__()

class Insurance(Service):
    def __init__(self) -> None:
        super().__init__()
