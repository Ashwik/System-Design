from parking_ticket import ParkingTicket
from enums import PaymentStatus


class ParkingLot:
    def __init__(self, lot_id, name, address, parking_rate):
        self.__lot_id = lot_id
        self.__name = name
        self.__address = address
        self.__parking_rate = parking_rate
        
        self.__entrances = []
        self.__exits = []
        self.__parking_spots = []
        self.__display_boards = []

        self.__ticket_counter = 0
    
    def add_parking_spot(self, spot):
        self.__parking_spots.append(spot)
    
    def add_entrance(self, entrance):
        self.__entrances.append(entrance)
    
    def add_exit(self, exit): 
        self.__exits.append(exit)
    
    def add_display_boards(self, display_board):
        self.__display_boards.append(display_board)
    
    def is_full(self):
        return all(not spot.get_is_free() for spot in self.__parking_spots)

    def get_parking_ticket(self):
        if self.is_full():
            print("Parking lot is full. No tickets available.")
            return None
        
        # Increment ticket counter for unique ticket number
        self.__ticket_counter += 1
        timestamp = '2024-09-11 10:00 AM'
        ticket = ParkingTicket(ticket_no=self.__ticket_counter, timestamp=timestamp, exit_time=None, amount=0, status=PaymentStatus.PENDING)
        
        print(f"Ticket generated:", ticket.get_ticket_no())
        return ticket
    
