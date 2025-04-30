from abc import ABC, abstractmethod

class Account(ABC):
    def __init__(self, name, email, password, address, phone_number):
        self.__name = name
        self.__email = email
        self.__password = password
        self.__address = address
        self.__phone_number = phone_number

    @abstractmethod
    def reset_password(self):
        pass


class Admin(Account):
    def __init__(self, name, email, password, address, phone_number):
        super().__init__(name, email, password, address, phone_number)

    def reset_password(self):
        pass

    def add_parking_spot(self, parking_lot, spot):
        parking_lot.add_parking_spot(spot)

    def add_display_board(self, parking_lot, display_board):
        parking_lot.add_display_boards(display_board)

    def add_entrance(self, parking_lot, entrance):
        parking_lot.add_entrance(entrance)

    def add_exit(self, parking_lot, exit):
        parking_lot.add_exit(exit)


class ParkingAgent(Account):
    def __init__(self, name, email, password, address, phone_number):
        super().__init__(name, email, password, address, phone_number)

    def reset_password(self):
        pass

    def process_ticket(self, ticket):
        pass