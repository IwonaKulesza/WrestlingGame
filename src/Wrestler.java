import java.util.Random;

public class Wrestler {


    protected enum Role {
        HEEL, FACE, NEWCOMER
    }

    protected class Move{
        private String typeOfMove;
        private int strenghtOfMove;

        public String getTypeOfMove() {
            return typeOfMove;
        }

        public int getStrenghtOfMove() {
            return strenghtOfMove;
        }

        public void setStrenghtOfMove(int strenghtOfMove) {
            this.strenghtOfMove = strenghtOfMove;
        }

        public Move(String typeOfMove, int strenghtOfMove){
            this.typeOfMove = typeOfMove;
            this.strenghtOfMove = strenghtOfMove;

        }
    }

    private int fame;
    private Role role;
    private String name;
    private Move strike;
    private Move grab;
    private Move dodge;

    public Wrestler(String name, int strenghtOfStrike, int strenghtOfGrab, int strenghtOfDodge, Role role) throws Exception {

        this.strike = new Move("strike",strenghtOfStrike);
        this.grab = new Move("grab",strenghtOfGrab);
        this.dodge = new Move("dodge",strenghtOfDodge);

        if (strike.strenghtOfMove<2||strike.strenghtOfMove>10){
            throw new Exception("Strike parameter should be 2-10, found "+strike.getStrenghtOfMove());
        }
        if (grab.strenghtOfMove<2||grab.strenghtOfMove>10){
            throw new Exception("Grab parameter should be 2-10, found "+grab.getStrenghtOfMove());
        }
        if (dodge.strenghtOfMove<2||dodge.strenghtOfMove>10){
            throw new Exception("Dodge parameter should be 2-10, found "+dodge.getStrenghtOfMove());
        }

        int characterPoint = 30 -(strike.strenghtOfMove+grab.strenghtOfMove+dodge.strenghtOfMove);
        this.fame = 10+(characterPoint*2);

        if (role == Role.FACE) {
            strike.setStrenghtOfMove(strike.getStrenghtOfMove()+2);
        }

        if (role == Role.HEEL) {
            grab.setStrenghtOfMove(grab.getStrenghtOfMove()+2);
        }

        this.name =name;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public int getFame() {
        return fame;
    }

    public String getName() {
        return name;
    }

    public void setFame(int fame) {
        this.fame = fame;
    }

    public Move getStrike() {
        return strike;
    }

    public Move getGrab() {
        return grab;
    }

    public Move getDodge() {
        return dodge;
    }
}
