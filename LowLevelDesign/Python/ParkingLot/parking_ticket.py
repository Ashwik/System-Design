class ParkingTicket:
    def __init__(self, ticket_no, timestamp, exit_time, amount, status):
        self.__ticket_no = ticket_no
        self.__timestamp = timestamp
        self.__exit_time = exit_time
        self.__amount = amount
        self.__status = status
        self.__payment = None
    
    def assign_payment(self, payment):
        self.__payment = payment
    
    def get_ticket_no(self):
        return self.__ticket_no
    