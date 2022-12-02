package BuzzFeedQuiz;

public class Category {

    String cat;
    String description; // after user is done and gets this category, will output description.
    int points = 0;

    Category(String c, String description) {
        this.cat = c;
        this.description = description;}
    }