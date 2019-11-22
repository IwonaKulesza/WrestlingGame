import java.util.Scanner;

public class Start {

    private Scanner scanner = new Scanner(System.in);

    public Wrestler characterGenerate() throws Exception {
        System.out.println("Hello, HELLO, HELLO! Let me be first to say Hi to you at the:");
        System.out.println("INFINITE. ACTION. WRESTLING. ~supported~ CHAMPIONSHIP!");
        System.out.println("So, if I may, let me register you for your show. Are you here for the first time?\n");
        while (true) {
            System.out.println("(Y)es - let me tell you all about myself!        (N)o, my name is...");

            if (scanner.nextLine().equals("y") || scanner.nextLine().equals("Y")) {
                return createWrestler();
            }else if (scanner.nextLine().equals("n") || scanner.nextLine().equals("N")) {
                return new WrestlerGenerator().generateWrestler();
            }else {
                System.out.println("Hey, too much getting hit in that cute head of yours? This is, a yes or no question!\n" +
                        "Are. You. Here. For. A. First. Time.");
            }
        }
    }
    public Wrestler createWrestler() throws Exception {

        System.out.println("Ok, hun. Sooo... first would be, of course, a name!");
        String name = scanner.nextLine();
        System.out.println("Sounds like a name i would give to a pet Carp fish. But what do I know. Ok, focus now hotshot.");
        Wrestler.Role role;
        int strike;
        int grab;
        int dodge;

        while (true){
        System.out.println("I need some statistics to put them on your collectibles, so just give me approximates of your STRIKE, GRAB and DODGE.\n " +
                "Fit them somewhere between two and ten, okay? Makes stuff simple. Of course, low skills gives you higher fame, you know?\n" +
                "Yes, so: STRIKE, GRAB and DODGE (2-10), champ:");
        strike = scanner.nextInt();
        grab = scanner.nextInt();
        dodge = scanner.nextInt();
        if (strike<10 && strike>2&&
        dodge<10 && dodge>2&&
        grab<10 && grab>2){
            break;
        }
        }

        System.out.println("And the most important thing: Are you a Heel or a Face, sugar?");
        while (true){
        System.out.println("I'm a (F)ace!      Of course I'm a (Heel).     (N)ot really sure yet...\n" +
                            "(+2 STRIKE)           (+2 GRAB)");
        String choosenRole = scanner.nextLine();

            if (choosenRole.equals("F") || choosenRole.equals("f")) {
                role = Wrestler.Role.FACE;
                break;
            } else if (choosenRole.equals("H") || choosenRole.equals("h")) {
                role = Wrestler.Role.HEEL;
                break;
            } else if (choosenRole.equals("N") || choosenRole.equals("n")) {
                role = Wrestler.Role.NEWCOMER;
                break;
            } else {
                System.out.println("Can you hear me under that mask, lollipop? What's your role?");
            }
        }

        Wrestler wrestler = new Wrestler(name,strike,grab,dodge,role);
        System.out.println("Okay, pinkie pie. Heh. That'll be your card. Everything correct?");
        System.out.println("Name: "+wrestler.getName());
        System.out.println("Role: "+wrestler.getRole());
        System.out.println("Name: "+wrestler.getName());
        System.out.println("Name: "+wrestler.getName());
        System.out.println("Name: "+wrestler.getName());
        System.out.println("Name: "+wrestler.getName());


    }



}
