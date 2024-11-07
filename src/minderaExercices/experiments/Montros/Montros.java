package minderaExercices.experiments.Montros;

public class Montros {
    public static void main(String[] args) {
        Monstro a = new Monstro("isaura"
                , 18
                , 20
                , new String[]{"mimoe"});
        Monstro habibi = new Monstro("speedy", "Zombie", 286, 99,
                new String[]{"biden", "trump"}, "TheRealZombie");
        habibi.info();
        Monstro.getNumMonsters();
    }


}
