from abc import abstractmethod, ABC
from enum import Enum

class LogLevel(Enum):
    DEBUG = 1
    ERROR = 2
    INFO = 3


class Logger(ABC):
    def __init__(self, next_logger=None) -> None:
        self.__next_logger = next_logger
    
    def get_next_logger(self):
        return self.__next_logger

    @abstractmethod
    def log(self, loglevel, info):
        pass


class DebugLogger(Logger):   
    def log(self, loglevel, message):
        if(loglevel == LogLevel.DEBUG):
            print("DEBUG: ", message)
        elif self.get_next_logger():
            self.get_next_logger().log(loglevel, message)


class InfoLogger(Logger):
    def log(self, loglevel, message):
        if(loglevel == LogLevel.INFO):
            print("INFO: ", message)
        elif self.get_next_logger():
            self.get_next_logger().log(loglevel, message)

class ErrorLogger(Logger):
    def log(self, loglevel, message):
        if(loglevel == LogLevel.ERROR):
            print("ERROR: ", message)
        elif self.get_next_logger():
            self.get_next_logger().log(loglevel, message)


if __name__ == "__main__":
    logger = DebugLogger(InfoLogger(ErrorLogger()))
    logger.log(LogLevel.DEBUG, "this is a debug")
    logger.log(LogLevel.ERROR, "exception")
    logger.log(LogLevel.INFO, "important message")