class Entrance:
    def __init__(self, id):
        self.__id = id
    
    def get_ticket(self, parking_lot):
        if parking_lot.is_full():
            print("Parking lot is full")
            return None

        return parking_lot.get_parking_ticket()

class Exit:
    def __init__(self, exit_id):
        self.__exit_id = exit_id
        pass

    def validate_ticket(self, ticket):
        #validation logic
        pass