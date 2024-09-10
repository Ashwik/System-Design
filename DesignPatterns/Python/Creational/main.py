
#Basic Implementation
class Singleton:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
        return cls._instance

singleInstance1 = Singleton()
singleInstance2 = Singleton()

print(singleInstance1)  
print(singleInstance2) 

# Thread Safe Implementation
# The thread-safe implementation of the Singleton pattern uses a lock to prevent
# multiple threads from instantiating the Singleton class at the same time.
import threading

class SingletonThreadSafe:
    _instance = None
    _lock = threading.Lock()

    def __new__(cls):
        with cls._lock:
            if cls._instance is None:
                cls._instance = super().__new__(cls)
        return cls._instance

singleInstance1 = SingletonThreadSafe()
singleInstance2 = SingletonThreadSafe()

print(singleInstance1)  
print(singleInstance2) 

# Meta class Implementation
# Using a metaclass with a dictionary allows you to generalize the singleton pattern across multiple classes. 
# The dictionary _instances keeps track of instances for each class that uses the metaclass. This way, the metaclass can ensure that each class has only one instance.
class SingletonMeta(type):
    _instances = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            instance = super().__call__(*args, **kwargs)
            cls._instances[cls] = instance
        return cls._instances[cls]

class SingletonMetaClass(metaclass=SingletonMeta):
    print("SingletonMetaClass instance is created")
    pass
singleInstance1 = SingletonMetaClass()
singleInstance2 = SingletonMetaClass()

print(singleInstance1)  
print(singleInstance2) 