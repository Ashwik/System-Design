class DisplayBoard:
    def __init__(self, board_id):
        self.__board_id = board_id
        self.__parking_spots = {}
    
    def add_parking_spot(self, spot_type, spots):
        self.__parking_spots[spot_type] = spots

    def show_free_slots(self):
        for spot_type, spots in self.__parking_spots.items():
            free_spots = [spot for spot in spots if spot.get_is_free()]
            print(f"{spot_type} free spots: {len(free_spots)}")