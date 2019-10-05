package ash.patz.learning.patterns.adapter;

public class Client {

    public static void main(String[] args) {
        RoundHole roundHole = new RoundHole(5);

        RoundPeg roundPeg = new RoundPeg(5);

        System.out.println(roundHole.fits(roundPeg)); //should be true


        SquarePeg squarePeg = new SquarePeg(4);

        //roundHole.fits(squarePeg); // Incompatible

        SquarePegAdapter squarePegAdapter = new SquarePegAdapter(squarePeg);
        System.out.println(roundHole.fits(squarePegAdapter)); // should return true
    }
}
