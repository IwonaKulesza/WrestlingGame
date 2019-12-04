import java.util.Random;

public class Ring {

    private String bigDamageReaction(Wrestler loser, Wrestler winner) {

        Random random = new Random();
        String[] reaction = {"BY GOD, JIM! HE'S BROKEN IN HALF! HE'S BROKEN IN HAAAAAAAALF!",
                "REF, STOP THIS MADNESS! HE'S ALREADY DEAD!", "JIM! JIM! IS THAT KIND OF MASSACRE EVEN LEGAL INM WRESTLING???",
                "Hahaa, right on the schnozzle!", "WHY, WHY, YOU BASTARD, TELL ME WHY???", "OH THE HUMANITY!!!",
                "TERRIBLE, TERRIBLE DAMAGE ON THE " + loser.getName().toUpperCase(),
                winner.getName()+" is unstoppable! It's like there's NO WEAKNESS!",
                "That must have hurt. "+loser.getName()+" does not look like he will stand up after this one.",
                winner.getName()+" has executed the Thunder Cross Split Attack! A perfect mixture of offense and defense!",
                "Oooch! Noone should be standing up after that!","How can he stand after taking such a blow?! "+loser.getName()
                +" seems to have inhuman strength to be withstanding such a barrage of strikes."};

        return reaction[random.nextInt(reaction.length)];
    }
    private String noDamageReaction(Wrestler loser, Wrestler winner) {

        Random random = new Random();
        String[] reaction = {"Nothing really happened but.... well you can definitely see a shift in the momentum...",
                "Pass the newspaper Jim, this may take a while.", "Well, they trying to be entertaining. I guess", "Meh",
                "WHERE'S THE SHOW???", "nice work on both sides, but I think they both need a moment to recover",
                "I hope they both step up their game, or it's going to be a boring show", "They're both eyeing each other... What's next?",
                "Bobby, im calling the pizza place, want some?","Yawn.","Boooring...","Well, lets cheer them up a little, huh?"};

        return reaction[random.nextInt(reaction.length)];
    }
    private String strikeDodgeReaction (Wrestler loser, Wrestler winner) {

        Random random = new Random();
        String[] reaction = {"Swift strike by "+loser.getName()+" but great dodge by "+winner.getName()+" and i can see that "+winner.getName()+
                " also took a chance to strike "+loser.getName()+".", loser.getName()+" should have taken Tackle on " +
                "last lvl up, as "+winner.getName()+ "dodged that attack easily and made a bone shattering return!",
                winner.getName()+" moves like a ballet dancer! "+loser.getName()+" can't land a hit! Wow! But he can sure take one! Ouch!",
                winner.getName()+" ducks under a superkick and uses the ropes for a strike back against "+loser.getName()+"!",
                winner.getName()+" Dodged and kicked back! H-he's fast!", "Good thing "+winner.getName()+" dodged that attack, " +
                "or the fight would've been over before it even started... Did "+loser.getName()+" just slipped on his own sweat?",
                "-That would be a murderous blow Jim!\n-If only it had hit anything.\n-Well, he got hit, that's still fun.",
                winner.getName()+" got out of "+loser.getName()+"'s grab! AND SMASHED BACK WITH A TABLE!!!",
        };

        return reaction[random.nextInt(reaction.length)];
    }
    private String grabStrikeReaction (Wrestler loser, Wrestler winner) {

        Random random = new Random();
        String[] reaction = {"He chucks him into the ropes!... OH MY GOD, HOW DID HE MANAGE TO TURN THIS AROUND!? Now " +
                loser.getName()+" is knocked down on the ground!","-Oh, "+loser.getName()+" grab failed spectacularly!\n" +
                "-It reminds me of the infamous \"PJ maneuver\" of 1983!\n-Ah yes, Bob, the one where PJ Punk somehow " +
                "broke his own back when trying to smash his opponent through a table?\n -That's the one, Jim! Although " +
                "this time it wasn't quite as self-destructive.",loser.getName()+" jumps from the ropes, but " +
                winner.getName()+" rolls from under his dropkick and pins him down!","What a GRAB! Is "+winner.getName()+
                " into hugging? Nope! "+loser.getName()+" gets a wonderful strike!","That was close Jim, but "+winner.getName()
                +" manged to avoid "+loser.getName()+"'s feared Magma Grab, and showed him down!","","","","",""
        };

        return reaction[random.nextInt(reaction.length)];
    }



    public void show(Wrestler wrestlerA, Wrestler wrestlerB){

        int rounds = 1;
        Wrestler winner = null;

        while (true) {
            System.out.println("\n:::ROUND " + rounds + "!:::");
            rounds++;
            if (rounds == 11) {
                System.out.println("Crowd heated up and ready for a big face off! Each round will now take 10% wrestlers fame! Let's hope that will move things along");
            }

            Wrestler.Move moveA = determinateMove(wrestlerA);
            Wrestler.Move moveB = determinateMove(wrestlerB);

            attack(wrestlerA,moveA,wrestlerB,moveB);

            if (wrestlerLostAllFame(wrestlerA,wrestlerB)){
                break;
            }


            if (rounds>=11) {

                int percentA = (wrestlerA.getFame()/10);
                int percentB = (wrestlerB.getFame()/10);
                System.out.println(wrestlerA.getName()+" lost "+percentA+" points of fame! ("+wrestlerA.getFame()+")");
                System.out.println(wrestlerB.getName()+" lost "+percentB+" points of fame! ("+wrestlerB.getFame()+")");

                wrestlerA.setFame(wrestlerA.getFame()-percentA);
                wrestlerB.setFame(wrestlerB.getFame()-percentB);
                if (wrestlerLostAllFame(wrestlerA,wrestlerB)){
                    break;
                }
            }

        }
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
                getHurt(wrestlerA,wrestlerB,moveB);
                getHurt(wrestlerB,wrestlerA,moveA);
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

                System.out.println(grabStrike(winner,loser));
                getHurt(loser,winner, winning);

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
                System.out.println(strikeDodge(winner,loser));
                getHurt(loser,winner, winning);
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
                System.out.println(dodgeGrab(winner,loser));
                getHurt(loser,winner, winning);
            }
        }
        }

    private String grabStrike(Wrestler winner,Wrestler loser){
        Random random = new Random();
        String[] reactionsLibrary = {
        "Let see, it looks like " + loser.getName() + " tried to grab " + winner.getName() + "! And i guess that " +
        winner.getName() + " was not really into that, as " + loser.getName() + " got strike really hard!",
        };
        return reactionsLibrary[random.nextInt(reactionsLibrary.length)];
    }

    private String strikeDodge(Wrestler winner,Wrestler loser){
        Random random = new Random();
        String[] reactionsLibrary = {
        "Swift strike by " + loser.getName() + "! But " + winner.getName() + " showed that nothing cant be dodged!" +
        winner.getName() + " also took a chance to smack  " + loser.getName() + " around a little. What a show!",
        };
        return reactionsLibrary[random.nextInt(reactionsLibrary.length)];
    }

    private String dodgeGrab(Wrestler winner,Wrestler loser){
        Random random = new Random();
        String[] reactionsLibrary = {
        "Pathetic wiggling did not work, and "+loser.getName()+" got grabbed and smashed to " +
        "the ground by "+winner.getName(),
        };
        return reactionsLibrary[random.nextInt(reactionsLibrary.length)];
    }

    private void getHurt(Wrestler loser, Wrestler winner, Wrestler.Move winning){
        if (winning.getStrenghtOfMove()>(loser.getFame()/2)) System.out.println(bigDamageReaction(loser,winner));
        loser.setFame(loser.getFame()-winning.getStrenghtOfMove());
        System.out.println(loser.getName()+" loses "+winning.getStrenghtOfMove()+" fame points ("+loser.getFame()+" fame left)");
    }

    private boolean wrestlerLostAllFame(Wrestler wrestlerA, Wrestler wrestlerB){

        if (wrestlerA.getFame()>0&&wrestlerB.getFame()>0){
            return false;
        }
        else if (wrestlerA.getFame()<=0&&wrestlerB.getFame()<=0){
            System.out.println("BY THE GODS OF WRESTLING!!! IS THIS EVEN POSSIBLE? DEAR LORD, THEY KO'D EACH OTHER! OH! MY! GOOOOOOD!");
            return true;
        }
        else if (wrestlerA.getFame()<=0){
            System.out.println(wrestlerA.getName()+" Has failed!!! Crowd is cheering name of a new champion! "+
                    wrestlerB.getName().toUpperCase()+"!!! "+wrestlerB.getName().toUpperCase()+"!!! "+wrestlerB.getName().toUpperCase()+"!!! ");
            return true;
        }else if(wrestlerB.getFame()<=0){
            System.out.println(wrestlerB.getName()+" Has failed!!! Crowd is cheering name of a new champion! "+
                    wrestlerA.getName().toUpperCase()+"!!! "+wrestlerA.getName().toUpperCase()+"!!! "+wrestlerA.getName().toUpperCase()+"!!! ");
            return true;
        }
        else return false;

    }

}
