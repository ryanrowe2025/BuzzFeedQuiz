package BuzzFeedQuiz;

import java.util.Scanner; 

public class Question {
    // Fields 
    String label;
    Answer[] possibleAnswers = new Answer[4];
    Question(String label) {
        this.label = label; 
    } 

    // ask a question, and return the category of the answer
    Category ask(Scanner sc) {
        // choose an index 
        System.out.println(this.label);
        for(int i = 0; i<possibleAnswers.length; i++) {
            String choice = Integer.toString(i+1);
            System.out.println("[" + choice + "]:" +
                this.possibleAnswers[i].label);
        }
        int ans = sc.nextInt();

        return possibleAnswers[ans - 1].cat;
    } 

}