package se.jensen.caws21.CodeAdventure2;

import java.util.Random;

import java.util.Scanner;

public class CodeAdventure2 {
        public static void main(String[] argv) {

            Scanner userKeyboard = new Scanner(System.in);


            Random random = new Random();


            boolean programRunning = true;

            int points = 0;

            new Scanner(String.valueOf(userKeyboard));

            // ----------------------------------------------------------------------------------
            // UPPGIFT DEL 1/3
            // * Be användaren skriva in sitt namn
            // * Skriv ut användarens namn i menyn
            // * Tips: Använd userKeyboard.next() och INTE userKeyboard.nextLine() (från lektionen i torsdags)
            // ----------------------------------------------------------------------------------

            // Kör allting inom kodblocket while tills användaren väljer att avsluta programmet
            // Spelet går ut på att få så många poäng som möjligt - men om du får en etta nollställs poängen
            while (programRunning) {
                // Här deklarerar vi två variabler för att styra koden längre ner
                // Dessa sätts till false varje gång while-loopen körs
                boolean menuThrowDice = false;
                boolean menuQuitProgram = false;

                System.out.println("Hej. Vad vill du göra?");
                System.out.println("1. Kasta tärning");
                System.out.println("2. Avsluta programmet");

                // Skriv ut en liten pil för att göra tydligt var användaren kan skriva in något
                // Notera ".print()" istället för ".println()" för att inte ha med radbrytning
                System.out.print("> ");
                int menuChoice = userKeyboard.nextInt();

                // ------------------------------------------------
                // UPPGIFT DEL 2/3:
                // Byt ut hela den här if-satsen mot en switch-sats
                // ------------------------------------------------

                if (menuChoice == 1) {
                    menuThrowDice = true;
                } else if (menuChoice == 2) {
                    menuQuitProgram = true;
                } else {
                    System.out.println("Felaktigt menyval. Försök igen.");
                }

                // Kasta tärning och räkna poäng
                // ------------------------------------------------------------------------------------
                // UPPGIFT DEL 3/3
                // Om tärningen visar 6:
                // * Lägg till den första 6:an till poängen
                // * Kasta tärningen igen och lägg till det resultatet till poängen
                // * Om den omkastade tärningen landar på 1 så nollställs inte poängen, utan
                //   den 1:an läggs också till som poäng
                // * Lös detta med en while-loop (för vi vet ju inte hur många 6:or som kommer på rad)
                // Exempel:
                // * 6 -> 1 = 7 poäng
                // * 6 -> 5 = 11 poäng
                // * 6 -> 6 -> 2 = 14 poäng
                // * 6 -> 6 -> 6 -> 6 -> 4 = 28 poäng
                // ------------------------------------------------------------------------------------
                if (menuThrowDice) {
                    // Ge diceRoll ett värde mellan 1 och 6
                    int diceRoll = random.nextInt(6) + 1;

                    if (diceRoll != 1) {
                        points += diceRoll;
                        System.out.println("Tärningen visar " + diceRoll + "!");
                    } else {
                        points = 0;
                        System.out.println("Tärningen landade på en etta. Din poäng har nollställts. Förlåt.");
                    }

                    System.out.println("Du har nu " + points + " poäng.");
                }

                if (menuQuitProgram) {
                    // Här sätter vi programRunning till false, vilket gör att while-loopen inte körs igen
                    programRunning = false;
                    System.out.println("Du har valt att sluta spela.");
                }
            }

            System.out.println("Programmet har avslutats. Tack för att du spelade!");
            System.out.println("Du fick totalt " + points + " poäng. Grattis! Det är säkert ett rekord.");
        }
    }

// ------------------------------------------------------------------------------------
// LEVEL UP - gör en eller flera av dessa om du är klar med de andra uppgifterna:
// * Lägg till ett "hemligt menyval" - ett menyval som inte skrivs ut i menyn
//   men som en som vet vad det är kommer åt genom att skriva in en speciell siffra
// * Gör så att spelaren kan byta namn under spelets gång
// * Gör en for-loop och skriv ut hur många poäng spelaren har - en "*" för varje poäng
//   Var du vill skriva ut det här (exempelvis varje gång tärningen kastats eller efter
//   att programmet avslutats) är upp till dig.
// -------------------------------------------------------------------------------------



