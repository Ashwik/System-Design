from abc import ABC, abstractmethod

class Payment(ABC):
    def __init__(self) -> None:
        pass

    @abstractmethod
    def make_payment(self):
        pass

class CardPayment(Payment):
    def __init__(self) -> None:
        super.__init__()

    def make_payment(self):
        pass

class CashPayment(Payment):
    def __init__(self) -> None:
        super().__init__()
    
    def make_payment(self):
        pass

class Fine():
    def __init__(self, amount, current_date, due_date) -> None:
        self.__amount = amount
        self.__current_date = current_date
        self.__due_date = due_date

    def calculateFine(self):
        return self.__amount*(self.__current_date - self.__due_date)
