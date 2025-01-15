class Display:
    def __init__(self, capacity, floor_no, direction):
        self.__capacity = capacity
        self.__floor_no = floor_no
        self.__direction = direction

    def show_elevator_display():
        print("Elevator at floor - {self.floor} and moving {self.direction.name} with capacity:{self.capacity}")

    def show_hall_display():
        print("Elevator at floor - {self.floor} and moving {self.direction.name}")