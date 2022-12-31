public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Betrieb currentBetrieb = Betrieb.A;
        if(Betrieb.A.equals(currentBetrieb)){
            System.out.println("A");
        }
        // ... etc.
        currentBetrieb.execute.run();
    }
    private enum Betrieb{
        A(() -> System.out.println("STAATLICH")),
        B(() -> System.out.println("STAATLICH")),
        C(() -> {}),
        D(() -> {});
        private Runnable execute;
        private Betrieb(Runnable execute){
            this.execute = execute;
        }
    }
//    private enum BetriebKategorie{
//        STAATLICH,
//        ANDERE
//    }
}