package minderaExercices.experiments.Montros;

import java.util.Arrays;

public class Monstro {
	String name;
	String type;
	int age;
	String[] famousVitims;
	int damage;
	int life;
	String instagram;
	private static int numMonsters = 0;

	public Monstro(String name, int age, int damage) {
		this.name = name;
		this.age = age;
		this.damage = damage;
		numMonsters ++;
	}

	public Monstro(String name, int age, int damage, String[] famouseVitims) {
		this.name = name;
		this.age = age;
		this.damage = damage;
		this.famousVitims = famouseVitims;
		numMonsters ++;
	}

	public Monstro(String name, int age, int damage, String[] famouseVitims, String instagram) {
		this.name = name;
		this.age = age;
		this.damage = damage;
		this.famousVitims = famouseVitims;
		this.instagram = instagram;
		numMonsters ++;
	}

	public Monstro(String name, String type, int age, int damage, String[] famouseVitims, String instagram) {
		this.name = name;
		this.type = type;
		this.age = age;
		this.damage = damage;
		this.famousVitims = famouseVitims;
		this.instagram = instagram;
		numMonsters ++;
	}


	public int attack(boolean superAttack) {
		return superAttack ? this.damage * 2 : this.damage;
	}
	public void info() {
		System.out.println(
				"\u001b[36m My name is " +this.name
						+ "\n" +
						"\u001b[34m My type is " + this.type
						+ "\n" +
						" \u001b[35mI am "+this.age+" years old"
						+ "\n" +
						"\u001b[33m I make "+this.damage+ " of damage"
						+
						"\n" +
						"\u001b[32m I have killed "+ Arrays.toString(famousVitims)
						+ "\n" +
						"\u001b[31m Follow me on instragram " +this.instagram);
	}
	public static void getNumMonsters(){
		System.out.println("\u001b[44m \u001b[38m There are " + numMonsters + " monsters" +
				"!!");
	}
}