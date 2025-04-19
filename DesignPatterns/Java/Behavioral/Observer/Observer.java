import java.util.*;

interface EventListener{
    public void update();
    public void remove();
}

class EmailEventListener implements EventListener{
    private String email;
    private NotificationService notificationService;
    public EmailEventListener(String email, NotificationService notificationService){
        this.email = email;
        this.notificationService = notificationService;
        notificationService.subscribe(this);
    }

    @Override
    public void update(){
        System.out.println("Email notification to: "+email);
    }

    @Override
    public void remove(){
        notificationService.unSubscribe(this);
    }
}

class MobileEventListener implements EventListener{
    private String username;
    private NotificationService notificationService;

    public MobileEventListener(String username, NotificationService notificationService){
        this.username = username;
        this.notificationService = notificationService;
        notificationService.subscribe(this);
    }

    @Override
    public void update(){
        System.out.println("Mobile notification to: "+username);
    }

    @Override
    public void remove(){
        notificationService.unSubscribe(this);
    }
}

class InAppEventListener implements EventListener{
    private String username;
    private NotificationService notificationService;

    public InAppEventListener(String username, NotificationService notificationService){
        this.username = username;
        this.notificationService = notificationService;
        notificationService.subscribe(this);
    }

    @Override
    public void update(){
        System.out.println("In App notification to: "+username);
    }

    @Override
    public void remove(){
        notificationService.unSubscribe(this);
    }
}

interface Notification{
    void subscribe(EventListener eventListener);
    void unSubscribe(EventListener eventListener);
    void notifyListeners();
}

class NotificationService implements Notification{
    private final List<EventListener> list;

    NotificationService(){
        list = new ArrayList<>();
    }

    @Override
    public void subscribe(EventListener eventListener){
        list.add(eventListener);
    }

    @Override
    public void unSubscribe(EventListener eventListener){
        list.remove(eventListener);
    }

    @Override
    public void notifyListeners(){
        for(EventListener eventListener: list){
            eventListener.update();
        }
    }
}


public class Observer{
    public static void main(String[] args){
        NotificationService notificationService = new NotificationService();
        
        EventListener emailEventListener1 = new EmailEventListener("person1@gmail.com",notificationService);
        EventListener emailEventListener2 = new EmailEventListener("person2@gmail.com",notificationService);
        
        EventListener mobileEventListener1 = new MobileEventListener("person1_user",notificationService);
        EventListener mobileEventListener2 = new MobileEventListener("person2_user",notificationService);

        EventListener inAppEventListener1 = new InAppEventListener("inApp_user1",notificationService);

        notificationService.notifyListeners();

        emailEventListener1.remove();
        emailEventListener2.remove();

        notificationService.notifyListeners();
        
    }
}