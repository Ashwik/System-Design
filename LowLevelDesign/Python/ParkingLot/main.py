
from parking_lot import ParkingLot
from account import Admin, ParkingAgent
from parking_spot import CompactParkingSpot, LargeParkingSpot
from display_board import DisplayBoard
from entrance_exit import Entrance, Exit
from vehicle import Car
from parking_rate import ParkingRate

if __name__ == "__main__":
    parking_rate = ParkingRate(5, 10)
    parking_lot = ParkingLot(1, "Central Parking", "123 Main St",parking_rate)
    
    # Create an admin
    admin = Admin("admin1", "password", "active", "Person","9999999")
    
    # Create parking spots and add to the parking lot using Admin
    spot1 = CompactParkingSpot(101, True)
    spot2 = LargeParkingSpot(102, True)
    
    admin.add_parking_spot(parking_lot, spot1)
    admin.add_parking_spot(parking_lot, spot2)
    
    # Create and add a display board
    display_board = DisplayBoard(1)
    admin.add_display_board(parking_lot, display_board)
    
    # Show free slots using display board
    display_board.add_parking_spot('Compact', [spot1])
    display_board.add_parking_spot('Large', [spot2])
    display_board.show_free_slots()
    
    # Add entrance and exit
    entrance = Entrance(1)
    exit_gate = Exit(1)
    
    admin.add_entrance(parking_lot, entrance)
    admin.add_exit(parking_lot, exit_gate)
    
    # Vehicle arrives
    car = Car("AB123CD")
    
    # Assign ticket via the entrance
    ticket = entrance.get_ticket(parking_lot)
    car.assign_ticket(ticket)
    
    # Parking agent processes ticket
    agent = ParkingAgent("agent1", "password", "active", "Person","999")
    agent.process_ticket(ticket)