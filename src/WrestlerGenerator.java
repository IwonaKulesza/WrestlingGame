import java.util.Random;

public class WrestlerGenerator {

    public Wrestler generateWrestler() throws Exception {

        Random random = new Random();

        Wrestler.Role role = Wrestler.Role.NEWCOMER;
        int randomNum = random.nextInt(3);

        switch (randomNum){
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

       return new Wrestler(getRandomName(),(2+random.nextInt(8)),(2+random.nextInt(8)),(2+random.nextInt(8)),role);
    }

    private String[]firstName = {"Mighty","Grand","Primal","Maveric","Bad News","Dirk","Diamond","Ginny","Johny","Cerebral","Shocker",
            "Gunner","Butch","Outlaw","Brooklyn","Prince","Bunkhouse","Titanic","Bionic","Doctor","Fusion","Rocky",
            "Sunshine Yellow","Nero","Beefy","Crazy","Italian","Phantom","Bloody","Starlight","Unbreakable",
            "Golden","Stone","Steel","Double","Crash Test","Pillar","Green","Red","Silver","Crazy"};

    private String[]lastName = {"Shadow","Hellfire","Mask","Basher","Swagger","Spider","Snake","Hamon","Twink","Viper","Spike","Magnum",
            "Hercules","Spawn","Bride","Warior","Sniper","Nurse","Tiger","Swarm","Champion","Show","Ninja","Gentleman",
            "Master","Man","Woman","Crusader","Star","Magician","Bishop","Executioner","Cowboy","Assasin","Slate",
            "Tank", "Gunslinger","Gem","Leone"};

    private String getRandomName(){

        Random random = new Random();
        return new String(firstName[random.nextInt(firstName.length)]+" "+lastName[random.nextInt(lastName.length)]);
    }
}
