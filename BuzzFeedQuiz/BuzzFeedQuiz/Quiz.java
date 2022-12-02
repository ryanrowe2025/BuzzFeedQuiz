package BuzzFeedQuiz;

import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) throws Exception {
        // Create Categories
        Category Basketball = new Category("Basketball ", "You would make a great basketball player.");
        Category Golf = new Category("Golf", "I see you being a golfer in the future.");
        Category Tennis = new Category("Tennis", "You are a tennis player");
        Category Cricket = new Category("Cricket", "Do you play cricket?");
        Category Football = new Category("Football", "You belong on the field.");
        Category Fútbol = new Category("Fútbol", "Cristaino Ronaldo" + "Suuuuuuuuuiiiiiiiiiiiiiii");
        // Create Questions
        Question q1 = new Question("Who won the first two Super Bowls?");
        // Attach Answers to Questions
        q1.possibleAnswers[0] = new Answer("Green Bay Packers", Golf);
        q1.possibleAnswers[1] = new Answer("New York Jets", Basketball);
        q1.possibleAnswers[2] = new Answer("Oakland Raders", Tennis);
        q1.possibleAnswers[3] = new Answer("Orlando Magic", Football);

        Question q2 = new Question("How many dimples are on a golf ball?");
        q2.possibleAnswers[0] = new Answer("35", Football);
        q2.possibleAnswers[1] = new Answer("250", Basketball);
        q2.possibleAnswers[2] = new Answer("336", Golf);
        q2.possibleAnswers[3] = new Answer("412", Fútbol);

        Question q3 = new Question("What color underwear are MLB umpires mandated to wear?");
        q3.possibleAnswers[0] = new Answer("Purple", Golf);
        q3.possibleAnswers[1] = new Answer("White", Cricket);
        q3.possibleAnswers[2] = new Answer("Grey", Basketball);
        q3.possibleAnswers[3] = new Answer("Black", Tennis);

        Question q4 = new Question("What city had three sprots teams that wear the same colors?");
        q4.possibleAnswers[0] = new Answer("Pittsburgh", Golf);
        q4.possibleAnswers[1] = new Answer("Los Angles", Football);
        q4.possibleAnswers[2] = new Answer("Chicago", Tennis);
        q4.possibleAnswers[3] = new Answer("Washington D.C.", Cricket);

        Question q5 = new Question("YHow long was the longest recored tennis match?");
        q5.possibleAnswers[0] = new Answer("5 hours", Tennis);
        q5.possibleAnswers[1] = new Answer("8 hours", Golf);
        q5.possibleAnswers[2] = new Answer("11 hours", Cricket);
        q5.possibleAnswers[3] = new Answer("12 hours", Basketball);

        // For each question, ask, read input, store answer.
        Scanner sc = new Scanner(System.in);
        gameIntro(sc);
        Question[] qList = { q1, q2, q3, q4, q5 };
        for (Question q : qList) {
            Category c = q.ask(sc);
            c.points++;
            // System.out.println("category " + c.cat + " points "+
            // Integer.toString(c.points));
        }
        // Get most common category from the questions asked
        // Return Category
        Category[] cList = { Basketball, Tennis, Golf, Cricket, Football, Tennis };
        int[] counts = { Basketball.points, Tennis.points, Golf.points, Cricket.points, Football.points,
                Tennis.points };
        // these need to be in the same order or the points will be incorrect!
        int index = getMostPopularCatIndex(counts);
        System.out.println("If you were a professional athlete, you would be a " + cList[index].cat + " player. ");
        System.out.println(cList[index].description);

    }

    public static void gameIntro(Scanner sc) {
        // requires 1 to keep going
        System.out.println("If you were a professional athlete what sport would you be a professional at?");
        System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
        int play = sc.nextInt();
        if (play != 1) {
            System.out.println("Unidentifiable input. Please enter 'Y' to play");
            gameIntro(sc);
        }
    }

    public static int getMostPopularCatIndex(int[] counts) {
        // returns the index that is the max
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
