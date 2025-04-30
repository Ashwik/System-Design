import enum


class PaymentStatus(enum.Enum):
    SUCCESS = 1
    PENDING = 2
    FAILURE = 3
    REFUNDED = 4

class AccountStatus(enum.Enum):
    ACTIVE = 1
    BLOCKED = 2
    BANNED = 3
    COMPROMISED = 4
    ARCHIVED = 5

class Person():
    def __init__(self,name, age, address) -> None:
        self.__name = name
        self.__age = age
        self.__address = address

class Address():
    def __init__(self, line1, city, state, country, zipcode) -> None:
        self.__line1 = line1
        self.__city = city
        self.__state = state
        self.__country = country
        self.__zipcode = zipcode