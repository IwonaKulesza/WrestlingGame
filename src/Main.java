public class Main {

    public static void main(String[] args) throws Exception {

            Wrestler wrestlerA = new WrestlerCreator().newWrestler();
            Wrestler wrestlerB = new WrestlerCreator().newWrestler();

            new Ring().show(wrestlerA,wrestlerB);
    }
}
