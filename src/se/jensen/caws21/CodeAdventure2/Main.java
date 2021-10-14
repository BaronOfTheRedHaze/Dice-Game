package se.jensen.caws21.CodeAdventure2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        // Vi skapar objektet Scanner userKeyboard en gång här uppe och återanvänder den längre ner
        Scanner userKeyboard = new Scanner(System.in);

        // Vi skapar objektet Random diceRoll här och återanvänder den längre ner
        Random random = new Random();

        // programRunning använder vi för att köra huvuddelen av
        // programmet tills användaren vill avsluta det
        boolean programRunning = true;

        // Vår poängräknare måste deklareras här för att kunna vara tillgänglig efter while-loopen
        int points = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Var vänlig och skriv ditt namn");
        System.out.print("> ");
        String name = myScanner.nextLine();

        System.out.println("namn: " + name);

        while (programRunning) {
            boolean menuHidden = false;
            boolean menuThrowDice = false;
            boolean menuQuitProgram = false;
            boolean menuNewName = false;

            System.out.println("Hej. Vad vill du göra?");
            System.out.println("1. Kasta tärning");
            System.out.println("2. Avsluta programmet");
            System.out.println("3: Byt namn");
            System.out.print("> ");
            int menuChoice = userKeyboard.nextInt();


            switch (menuChoice) {
                case 1 -> menuThrowDice = true;
                case 2 -> menuQuitProgram = true;
                case 1337 -> menuHidden =true;
                case 3 -> menuNewName =true;
                default -> throw new IllegalStateException("Unexpected value: " + menuChoice);
            }




            if (menuThrowDice) {
                // Ge diceRoll ett värde mellan 1 och 6
                int diceRoll = random.nextInt(6) + 1;


                while (diceRoll == 6) {

                    points += diceRoll;
                    System.out.println("Tärningen visar " + diceRoll + "!");
                    System.out.println("Du har nu " + points + " poäng");

                    diceRoll = random.nextInt(6) + 1;

                }
                points += diceRoll;
                System.out.println("Du har nu " + points + " poäng");


            }

            if (menuQuitProgram) {
                // Här sätter vi programRunning till false, vilket gör att while-loopen inte körs igen
                programRunning = false;
                System.out.println("Du har valt att sluta spela.");
                System.out.println("Programmet har avslutats. Tack för att du spelade!");
                System.out.println("Du fick totalt " + points + " poäng. Grattis! Det är säkert ett rekord.");

                String star = "";
                for (int i = 0; i < points; i++){
                    star += "*";

                }
                System.out.println(star);


            }
            if (menuHidden) {

                programRunning = false;
                System.out.println("Hackare >:( ");

            }


            if (menuNewName) {

               Scanner myScannerNew = new Scanner(System.in);
                System.out.println("Välj ett nytt namn");
                name = myScannerNew.nextLine();
                System.out.println("Hej "+ name);
            }


        }
    }
}


