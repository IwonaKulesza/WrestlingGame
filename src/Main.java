public class Main {

    public static void main(String[] args) throws Exception {



        int higherFameWon = 0;

        for (int a = 0; a<1000; a++) {
            Wrestler wrestler;
            Wrestler wrestlerA = new WrestlerGenerator().generateWrestler();
            Wrestler wrestlerB = new WrestlerGenerator().generateWrestler();
            if (wrestlerA.getFame()>wrestlerB.getFame()){
                 wrestler = wrestlerA;
            }else wrestler = wrestlerB;
            System.out.println("Ladies and Gentlemans!  Welcome to our Wrestling championship! Today, our fighters are:");
            System.out.println(wrestlerA.getName()+", "+wrestlerA.getRole()+" (Fame: "+wrestlerA.getFame()+", Strike: " +
                    ""+wrestlerA.getStrike().getStrenghtOfMove()+", Dodge: "+wrestlerA.getDodge().getStrenghtOfMove()+", " +
                    "Grab: "+wrestlerA.getGrab().getStrenghtOfMove()+")");
            System.out.println("VS.");
            System.out.println(wrestlerB.getName()+", "+wrestlerB.getRole()+" (Fame: "+wrestlerB.getFame()+", Strike: " +
                    ""+wrestlerB.getStrike().getStrenghtOfMove()+", Dodge: "+wrestlerB.getDodge().getStrenghtOfMove()+"," +
                    " Grab: "+wrestlerB.getGrab().getStrenghtOfMove()+")");
            Wrestler win = new Ring().show(wrestlerA, wrestlerB);
            if (wrestler.getName().equals(win.getName())){higherFameWon++;}
            System.out.println(higherFameWon);
            System.out.println(a);
            System.out.println(a/higherFameWon);
        }
    }
}
