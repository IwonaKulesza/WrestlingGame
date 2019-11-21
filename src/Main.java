public class Main {

    public static void main(String[] args) throws Exception {

            Wrestler wrestlerA = new WrestlerGenerator().generateWrestler();
            Wrestler wrestlerB = new WrestlerGenerator().generateWrestler();
            System.out.println("Ladies and Gentlemans!  Welcome to our Wrestling championship! Today, our fighters are:");
            System.out.println(wrestlerA.getName()+", "+wrestlerA.getRole()+" (Fame: "+wrestlerA.getFame()+", Strike: " +
                    ""+wrestlerA.getStrike().getStrenghtOfMove()+", Dodge: "+wrestlerA.getDodge().getStrenghtOfMove()+", " +
                    "Grab: "+wrestlerA.getGrab().getStrenghtOfMove()+")");
            System.out.println("VS.");
            System.out.println(wrestlerB.getName()+", "+wrestlerB.getRole()+" (Fame: "+wrestlerB.getFame()+", Strike: " +
                    ""+wrestlerB.getStrike().getStrenghtOfMove()+", Dodge: "+wrestlerB.getDodge().getStrenghtOfMove()+"," +
                    " Grab: "+wrestlerB.getGrab().getStrenghtOfMove()+")");
            new Ring().show(wrestlerA, wrestlerB);

    }
}
