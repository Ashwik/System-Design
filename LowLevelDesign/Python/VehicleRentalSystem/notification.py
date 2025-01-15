from abc import ABC, abstractmethod

class Notification(ABC):
    def __init__(self) -> None:
        pass

    @abstractmethod
    def send_notification(self):
        pass

class SmsNotification(Notification):
    def __init__(self) -> None:
        super.__init__()

    def send_notification(self):
        pass

class EmailNotification(Notification):
    def __init__(self) -> None:
        super().__init__()
    
    def send_notification(self):
        pass