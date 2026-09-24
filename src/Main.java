public class Main {
    public static void main(String[] args) {
        GewinnView view = new GewinnView();
        new GewinnController(new GewinnModel(), view);
        view.setVisible(true);
    }
}
