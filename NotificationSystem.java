import java.util.*;

public class NotificationSystem implements Subject {
    private List<Observer> users = new ArrayList<>();

    @Override
    public void subscribe(Observer o) {
        users.add(o);
        System.out.println("User subscribed");
    }

    @Override
    public void unsubscribe(Observer o) {
        users.remove(o);
        System.out.println("User unsubscribed");
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : users) {
            o.update(message);
        }
    }
}