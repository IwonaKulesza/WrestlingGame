import java.util.Random;

public class Ring {

    public Wrestler show(Wrestler wrestlerA, Wrestler wrestlerB){

        int rounds = 1;
        Wrestler winner = null;

        while (true) {
            System.out.println("ROUND " + rounds + "!");
            rounds++;
            if (rounds==10){
                System.out.println("Finishing round! Crowd is ready for a big face off!");
                wrestlerA.setFame(1);
                wrestlerB.setFame(1);
            }

            Wrestler.Move moveA = determinateMove(wrestlerA);
            Wrestler.Move moveB = determinateMove(wrestlerB);

            attack(wrestlerA,moveA,wrestlerB,moveB);

            if (wrestlerA.getFame()<=0){
                System.out.println(wrestlerA.getName()+" Has failed!!! Crowd is cheering name of a new champion! "+
                        wrestlerB.getName().toUpperCase()+"!!! "+wrestlerB.getName().toUpperCase()+"!!! "+wrestlerB.getName().toUpperCase()+"!!! ");
                winner = wrestlerB;
            break;
            }
            if (wrestlerB.getFame()<=0){
                System.out.println(wrestlerB.getName()+" Has failed!!! Crowd is cheering name of a new champion! "+
                        wrestlerA.getName().toUpperCase()+"!!! "+wrestlerA.getName().toUpperCase()+"!!! "+wrestlerA.getName().toUpperCase()+"!!! ");
            winner = wrestlerB;
                break;
            }
        }
        return winner;
    }

    private Wrestler.Move determinateMove(Wrestler wrestler) {
        Random random = new Random();
        Wrestler.Move determinatedMove;
        int randomAttack = random.nextInt((
                (wrestler.getStrike().getStrenghtOfMove()) +
                        (wrestler.getGrab().getStrenghtOfMove()) +
                        (wrestler.getDodge().getStrenghtOfMove())
        ));
        int firstBorderValue = wrestler.getStrike().getStrenghtOfMove();
        int secondBorderValue = firstBorderValue + wrestler.getGrab().getStrenghtOfMove();

        if (randomAttack < firstBorderValue) {
            System.out.println(wrestler.getName()+" strikees!");
            determinatedMove = wrestler.getStrike();
        } else if (randomAttack > secondBorderValue) {
            System.out.println(wrestler.getName()+" grabs!");
            determinatedMove = wrestler.getGrab();
        } else {
            determinatedMove = wrestler.getDodge();
            System.out.println(wrestler.getName()+" dodges!");
        }
        return determinatedMove;
    }

    private void attack (Wrestler wrestlerA, Wrestler.Move moveA, Wrestler wrestlerB, Wrestler.Move moveB){

        Wrestler winner;
        Wrestler loser;
        Wrestler.Move winning;

        //same move
        if (moveA.getTypeOfMove().equals(moveB.getTypeOfMove())){
            if (moveA.getTypeOfMove().equals("strike")){
                System.out.println("Wow! "+wrestlerA.getName()+" and "+wrestlerB.getName()+" both strikeed hard at the " +
                        "same time! Dear God! This is Madness!");
                getHurt(wrestlerA,moveB);
                getHurt(wrestlerB,moveA);
            }else{
                System.out.println("Well, both "+wrestlerA.getName()+" and "+wrestlerB.getName()+" tried to "
                        +moveA.getTypeOfMove()+" each other... It looks like really weird dancing, but that's all.");
            }
        }else {

            //grab<strike

            if ((moveA.getTypeOfMove().equals("grab")&&moveB.getTypeOfMove().equals("strike")||moveB.getTypeOfMove().equals("grab")&&moveA.getTypeOfMove().equals("strike"))) {
                if (moveB.getTypeOfMove().equals("grab")) {
                    winner = wrestlerA;
                    loser = wrestlerB;
                    winning = moveA;
                } else {
                    winner = wrestlerB;
                    loser = wrestlerA;
                    winning = moveB;
                }

                System.out.println("Let see, it looks like " + loser.getName() + " tried to grab " + winner.getName() + "! And i guess that " +
                        winner.getName() + " was not really into that, as " + loser.getName() + " got strikeed really hard!");
                getHurt(loser, winning);

            }

            // strike<dodge
            if ((moveA.getTypeOfMove().equals("dodge")&&moveB.getTypeOfMove().equals("strike")||moveB.getTypeOfMove().equals("dodge")&&moveA.getTypeOfMove().equals("strike"))) {
                if (moveB.getTypeOfMove().equals("strike")) {
                    winner = wrestlerA;
                    loser = wrestlerB;
                    winning = moveA;
                } else {
                    winner = wrestlerB;
                    loser = wrestlerA;
                    winning = moveB;
                }

                System.out.println("Swift strike by " + loser.getName() + "! But " + winner.getName() + " showed that nothing cant be dodged!" +
                        winner.getName() + " also took a chance to smack  " + loser.getName() + " around a little. What a show!");
                getHurt(loser, winning);
            }

            //dodge<grab
            if ((moveA.getTypeOfMove().equals("grab")&&moveB.getTypeOfMove().equals("dodge")||moveB.getTypeOfMove().equals("grab")&&moveA.getTypeOfMove().equals("dodge"))) {
                if (moveA.getTypeOfMove().equals("grab")) {
                    winner = wrestlerA;
                    loser = wrestlerB;
                    winning = moveA;
                } else {
                    winner = wrestlerB;
                    loser = wrestlerA;
                    winning = moveB;
                }
                System.out.println("Pathetic wiggling did not work, and "+loser.getName()+" got grabbed and smashed to " +
                        "the ground by "+winner.getName());
                getHurt(loser, winning);
            }
        }
        }



    private void getHurt(Wrestler loser, Wrestler.Move winning){
        loser.setFame(loser.getFame()-winning.getStrenghtOfMove());
        System.out.println(loser.getName()+" loses "+winning.getStrenghtOfMove()+" fame points ("+loser.getFame()+" fame left)");
    }


}
