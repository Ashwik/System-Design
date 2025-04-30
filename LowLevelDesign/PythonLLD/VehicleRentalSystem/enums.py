from enum import Enum


class ReservationStatus(Enum):
    ACTIVE = 1
    PENDING = 2
    CANCELLED = 3
    COMPLETED = 4
    EXPIRED = 5

class AccountStatus(Enum):
    ACTIVE = 1
    CLOSED = 2
    CANCELED = 3
    BLACKLISTED = 4
    BLOCKED = 5

class VehicleLogType(Enum):
    CLEANING = 1
    FUELING = 2
    REPAIR = 3
    ACCIDENT = 4
    OILCHANGE = 5

class PaymentStatus(Enum):
    SUCESS = 1
    FAILURE = 2
    PENDING = 3

class CarType(Enum):
    SEDAN = 1
    SUV = 2
    HATCHBACK = 3
    CROSSOVER = 4
    CONVERTIBLE = 5

class TruckType(Enum):
    SMALL = 1
    MEDIUM = 2
    LARGE = 3

class MotorcycleType(Enum):
    SPORTS = 1
    CRUISER = 2
    DIRT = 3
    TOURING = 4

