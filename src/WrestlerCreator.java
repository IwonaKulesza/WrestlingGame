import java.util.Random;
import java.util.Scanner;

public class WrestlerCreator {

    private Scanner scanner = new Scanner(System.in);

    Wrestler newWrestler() throws Exception {
        System.out.println("Hello there, masked one! Yes, yes, you, captain. Let me be first to say Hi to you at the:");
        System.out.println("INFINITE. ACTION. WRESTLING. ~supported~ AMATEUR CHAMPIONSHIP! \nWoah! A mouthful. Ok, I " +
                "can see this suit is little tight in your delicates, so let's make it snippy, you razor burned dumpling, you!");
        System.out.println("So, if I may, let me register you for your show. Are you here for the first time, sugar cube?\n");

        System.out.println("(Y)es - let me tell you all about myself!        (N)o, my name is...");
        if (yesOrNoAnswer(
                "Great! Fresh meat! Let me help you with your registration form! \n" +
                        "I suppose you cant really see that much through this mask, so it'll be quicker that way.",
                "Ach, do not tell! I remember you!",
                "Hey, too much getting hit in that cute head of yours? This is a" +
                        " \"yes\" or \"no\" question!\nAre. You. Here. For. A. First. Time.")) {
            return createWrestler();
        } else {
            while (true) {
                Wrestler wrestler = generateWrestler();
                if (meetAndAcceptWrestler(wrestler))
                    return wrestler;
            }
        }
    }


    private Wrestler generateWrestler() throws Exception {

        Random random = new Random();

        Wrestler.Role role = Wrestler.Role.NEWCOMER;
        int randomNum = random.nextInt(3);

        switch (randomNum) {
            case 1:
                role = Wrestler.Role.FACE;
                break;
            case 2:
                role = Wrestler.Role.HEEL;
                break;
            case 3:
                role = Wrestler.Role.NEWCOMER;
                break;
        }

        return new Wrestler(getRandomName(), (2 + random.nextInt(8)), (2 + random.nextInt(8)), (2 + random.nextInt(8)), role);
    }

    private String[] firstName = {"Mighty", "Grand", "Primal", "Maveric", "Bad News", "Dirk", "Diamond", "Ginny", "Johny", "Cerebral", "Shocker",
            "Gunner", "Butch", "Outlaw", "Brooklyn", "Prince", "Bunkhouse", "Titanic", "Bionic", "Doctor", "Fusion", "Rocky",
            "Sunshine Yellow", "Nero", "Beefy", "Crazy", "Italian", "Phantom", "Bloody", "Starlight", "Unbreakable",
            "Golden", "Stone", "Steel", "Double", "Crash Test", "Pillar", "Green", "Red", "Silver", "Crazy"};

    private String[] lastName = {"Shadow", "Hellfire", "Mask", "Basher", "Swagger", "Spider", "Snake", "Hamon", "Twink", "Viper", "Spike", "Magnum",
            "Hercules", "Spawn", "Bride", "Warior", "Sniper", "Nurse", "Tiger", "Swarm", "Champion", "Show", "Ninja", "Gentleman",
            "Master", "Man", "Woman", "Crusader", "Star", "Magician", "Bishop", "Executioner", "Cowboy", "Assasin", "Slate",
            "Tank", "Gunslinger", "Gem", "Leone"};

    private String getRandomName() {

        Random random = new Random();
        return new String(firstName[random.nextInt(firstName.length)] + " " + lastName[random.nextInt(lastName.length)]);
    }

    private Wrestler createWrestler() throws Exception {

        String name;
        int strike;
        int dodge;
        int grab;
        Wrestler.Role role;

        while (true) {
            System.out.println("Ok, hun. Sooo... first would be, of course, a name!");
            name = scanner.nextLine();
            System.out.println("Sounds like a name i would give to a pet Carp fish. But what do I know. Ok, focus now hotshot.");
            System.out.println("I need some statistics to put them on your collectibles, so just give me approximates of your STRIKE, GRAB and DODGE.\n" +
                    "Fit them somewhere between two and ten, okay? Makes stuff simple. Of course, low skills gives you higher fame, you know?");

            System.out.println("Lets start with STRIKE");
            strike = chooseStatistic();
            System.out.println("Now, GRAB");
            grab = chooseStatistic();
            System.out.println("Finally, sugar, DODGE");
            dodge = chooseStatistic();

            role = chooseRole();

            System.out.println("Okay, pinkie pie. Heh. That'll be your card. Everything correct?");

            Wrestler wrestler = new Wrestler(name, strike, grab, dodge, role);

            if (meetAndAcceptWrestler(wrestler)) {
                return wrestler;
            }

        }
    }

    private boolean meetAndAcceptWrestler(Wrestler wrestler) {

            System.out.println("Name: " + wrestler.getName());
            System.out.println("Role: " + wrestler.getRole());
            System.out.println("Strike: " + wrestler.getStrike().getStrenghtOfMove());
            System.out.println("Dodge: " + wrestler.getDodge().getStrenghtOfMove());
            System.out.println("Grab: " + wrestler.getGrab().getStrenghtOfMove());
            System.out.println("Fame: " + wrestler.getFame());

            System.out.println("Dat ya, homie? \n(Y)es   (N)o");


            return (yesOrNoAnswer(
                    "Then this is your entrance pass. Now. Skedaddle, you little spandex wrapped rascal!\n oh how I adoooore those bright-eyed punchbags. NEXT!\n\n",
                    "Sure, no problem, i love getting my time wasted. Let me grab a new form, kill some more trees...",
                    "Pumpkin, i beg you... Are those your stats?"));

        }

    private Wrestler.Role chooseRole() {
        System.out.println("And the most important thing: Are you a Heel or a Face, sugar?");
        Wrestler.Role role;
        while (true) {
            System.out.println("I'm a (F)ace!      Of course I'm a (H)eel.     (N)ot really sure yet...\n" +
                    "(+2 STRIKE)           (+2 GRAB)");
            String choosenRole = scanner.next().toUpperCase();

            switch (choosenRole) {
                case "F":
                    return role = Wrestler.Role.FACE;
                case "H":
                    return role = Wrestler.Role.HEEL;
                case "N":
                    return role = Wrestler.Role.NEWCOMER;
                default:
                    System.out.println("Can you hear me under that mask, lollipop? What's your role?");
                    break;
            }
        }
    }

    private int chooseStatistic() {
        System.out.println("so, remember! 2-10!");
        while (true) {
            try {
                int stat = scanner.nextInt();

                if (stat >= 2 && stat <= 10) {

                    System.out.println("I see, " + stat + ". Did i heard that correctly?" +
                                        "\n      (Y)es   (N)o");

                    if (yesOrNoAnswer(
                            "noted!",
                            "oh, sorry, then repeat your stat for me, please.",
                            "...err? Sweetie, i think this mask is blocking your airflow... Focus please. Is your stat " + stat + "?\n       (Y)es    (N)o")
                    ) {
                        return stat;
                    }
                }
            }catch (java.lang.NumberFormatException e) {
                System.out.println("Dearest, i need a 2-10 number, ok? Try again.");
            }
        }
    }

    private boolean yesOrNoAnswer(String yes, String no, String other) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            String scannedAnswer = scan.nextLine().toUpperCase();

            switch (scannedAnswer){
                case "Y":
                    System.out.println(yes);
                    return true;
                case "N":
                    System.out.println(no);
                    return false;
                    default:
                        System.out.println(other);
            }
        }


    }
}
