from abc import ABC, abstractmethod

class ParkingSpot(ABC):
    def __init__(self, id, is_free):
        self.__id = id
        self.__is_free = is_free

    @abstractmethod
    def assign_vehicle(self, vehicle):
        pass

    def remove_vehicle(self):
        self.__is_free = True
    
    def get_is_free(self):
        return self.__is_free


class LargeParkingSpot(ParkingSpot):
    def __init__(self, id, is_free):
        super().__init__(id, is_free)

    def assign_vehicle(self, vehicle):
        self.__vehicle = vehicle
        self.__is_free = False

class CompactParkingSpot(ParkingSpot):
    def __init__(self, id, is_free):
        super().__init__(id, is_free)

    def assign_vehicle(self, vehicle):
        self.__vehicle = vehicle
        self.__is_free = False

class HandiCappedParkingSpot(ParkingSpot):
    def __init__(self, id, is_free):
        super().__init__(id, is_free)

    def assign_vehicle(self, vehicle):
        self.__vehicle = vehicle
        self.__is_free = False