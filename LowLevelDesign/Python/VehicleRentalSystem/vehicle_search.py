from abc import ABC, abstractmethod

class VehicleSearch(ABC):
    def __init__(self) -> None:
        pass

class VehicleCatalog(VehicleSearch):
    def __init__(self) -> None:
        super().__init__()