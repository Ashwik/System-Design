from abc import ABC, abstractmethod

class Person(ABC):
    def __init__(self) -> None:
        pass

class Driver(Person):
    def __init__(self) -> None:
        super.__init__()

class Account(Person):
    def __init__(self) -> None:
         super.__init__()

    @abstractmethod
    def reset_password(self):
        pass

class Customer(Account):
    def __init__(self) -> None:
        super.__init__()

    def reset_password(self):
        pass

class Agent(Account):
    def __init__(self) -> None:
        super().__init__()
    
    def reset_password(self):
        pass