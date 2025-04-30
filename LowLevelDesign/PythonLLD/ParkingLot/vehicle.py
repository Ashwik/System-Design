from abc import ABC, abstractmethod

class Vehicle(ABC):
    def __init__(self, license_no):
        self.__license_no = license_no
        self.__parking_ticket = None
    
    @abstractmethod
    def assign_ticket(self, ticket):
        pass


class Car(Vehicle):
    def __init__(self, license_no):
        super().__init__(license_no)
    
    def assign_ticket(self, ticket):
        self.__parking_ticket = ticket

class Bike(Vehicle):
    def __init__(self, license_no):
        super().__init__(license_no)
    
    def assign_ticket(self, ticket):
        self.__parking_ticket = ticket

class Truck(Vehicle):
    def __init__(self, license_no):
        super().__init__(license_no)
    
    def assign_ticket(self, ticket):
        self.__parking_ticket = ticket