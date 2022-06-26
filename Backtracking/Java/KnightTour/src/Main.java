public class Main {
    public static void main(String[] args) {
        int size = 8;
        boolean isClosed = true;
        KnightTour knightTour = new KnightTour(size,isClosed);
        knightTour.startKnightTour(5,5);
    }
}
