public class User implements Observer {
    private String name;
    private boolean email;
    private boolean sms;
    private boolean app;

    public User(String name, boolean email, boolean sms, boolean app) {
        this.name = name;
        this.email = email;
        this.sms = sms;
        this.app = app;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String message) {
        if (email) {
            System.out.println("Email sent to " + name + ": " + message);
        }
        if (sms) {
            System.out.println("SMS sent to " + name + ": " + message);
        }
        if (app) {
            System.out.println("App notification sent to " + name + ": " + message);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}