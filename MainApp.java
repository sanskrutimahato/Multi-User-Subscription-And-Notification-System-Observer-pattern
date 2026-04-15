public class MainApp {
    public static void main(String[] args) {
        NotificationSystem system = new NotificationSystem();

        new UserGUI(system);
        new AdminGUI(system);
    }
}