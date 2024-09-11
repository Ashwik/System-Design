class ParkingRate:
    def __init__(self, amount, hours):
        self.__amount = amount
        self.__hours = hours

    def calculate(self):
        return self.__amount * self.__hours