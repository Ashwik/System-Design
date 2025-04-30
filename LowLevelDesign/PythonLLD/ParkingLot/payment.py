from abc import ABC, abstractmethod

class Payment(ABC):
    def __init__(self, amount, payment_status):
        self.__amount = amount
        self.__payment_status = payment_status
    
    @abstractmethod
    def initiate_transaction(self):
        pass


class Cash(Payment):
    def __init__(self, amount, payment_status):
        super().__init__(amount, payment_status)
    
    def initiate_transaction(self):
        #logic for cash payment 
        pass

class Card(Payment):
    def __init__(self, amount, payment_status):
        super().__init__(amount, payment_status)
    
    def initiate_transaction(self):
        #logic for card payment 
        pass