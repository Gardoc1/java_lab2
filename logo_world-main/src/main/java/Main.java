import game.Game;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, mafaka");
//        Size s = new Size(5,10);
//        Field f = null;
//        try {
//            f = new Field(s);
//        } catch (CustomException e) {
//            e.printStackTrace();
//        }
//        try {
//            f.setCell(new Coords(3,6), true);
//        } catch (CustomException e) {
//            e.printStackTrace();
//        }
//        Environment e = new Environment();
//        try {
//            e.init(s , new Coords(1,1));
//        } catch (CustomException ex) {
//            ex.printStackTrace();
//        }
//        System.out.println(e.getIsInitialized());
//
//        View nw = new View(e);
//        nw.drawField();

        Game game = new Game();
        game.start();
    }
}
