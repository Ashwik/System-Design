class Building:
    __instance = None

    def __new__(cls):
        if cls.__instance is None:
            cls.__instance = super().__new__(cls)
        return cls.__instance


    def __init__(self, elevator_car, floors) -> None:
        self.__elevator_car = elevator_car
        self.__floors = floors
        pass