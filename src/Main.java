public class Main {

    public static void main(String[] args) throws Exception {

            Wrestler wrestlerA = new WrestlerGenerator().generateWrestler();
            Wrestler wrestlerB = new WrestlerGenerator().generateWrestler();




            new Ring().show(wrestlerA, wrestlerB);
    }
}
