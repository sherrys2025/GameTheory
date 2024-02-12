import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int oneCookies = 0;
        int twoCookies = 0;

        ArrayList<Boolean> onePast = new ArrayList<>();
        ArrayList<Boolean> twoPast = new ArrayList<>();

        for (int i = 0; i < 200; i++){
            System.out.println("Round " + (i+1));
            boolean one = theSpartan(onePast, twoPast);
            boolean two = cookieDomination(twoPast, onePast);
            System.out.println("One: " + one + "\t\tTwo: " + two);
            onePast.add(one);
            twoPast.add(two);

            if (one && two) {
                oneCookies += 3;
                twoCookies += 3;
            } else if (one && !two) {
                twoCookies += 5;
            } else if (!one && two) {
                oneCookies += 5;
            } else {
                oneCookies += 1;
                twoCookies += 1;
            }
            System.out.println("One: " + oneCookies + "\t\tTwo: " + twoCookies);
            System.out.println("\n\n");
        }

    }


    private static boolean sample(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        if (oppPast.size() == 0) {return true;}
        return oppPast.get(oppPast.size()-1);
    }

    private static boolean knifeThem(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        if (oppPast.size() == 0) {return true;}
        if ((oppPast.size()+1) % 10 == 0) {return false;}
        if ((!myPast.get(myPast.size()-1)) && oppPast.get(oppPast.size()-1)) {return false;}
        return oppPast.get(oppPast.size()-1);
    }

    private static boolean foolMeTwice(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        if (oppPast.size() < 2) {return true;}
        if ((!oppPast.get(oppPast.size()-1)) && (!oppPast.get(oppPast.size()-2))) {return false;}
        return true;
    }

    private static boolean stanley(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        return false;
    }

    private static boolean watermelon(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        if (oppPast.size() == 0) {return true;}
        int countOfDefects = 0;
        for (int i = 0; i < oppPast.size(); i++){
            if (!oppPast.get(i)) {countOfDefects++;}
        }
        if ((double) countOfDefects /oppPast.size() > 0.6) {return false;}
        return true;
    }

    private static boolean tazalux(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        if (oppPast.size() < 5) {return true;}
        if (oppPast.size() < 15) {return false;}
        if (oppPast.size() < 20) {return true;}
        if (oppPast.size() == 20) {return false;}
        return oppPast.get(oppPast.size()-1);
    }

    private static boolean iansBipolar(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        if (oppPast.isEmpty()) {return false;}
        return (!oppPast.get(oppPast.size()-1));
    }

    private static boolean random(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        Random rand = new Random();
        return rand.nextBoolean();
    }

    private static boolean theSpartan(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        Random rand = new Random();
        if (oppPast.size() < 10) {return true;}
        if (oppPast.size() < 20) {return oppPast.get(oppPast.size()-1);}

        int countOfDefects = 0;
        for (int i = 0; i < oppPast.size(); i++){
            if (!oppPast.get(i)) {countOfDefects++;}
        }
        double rate = (double) countOfDefects /oppPast.size();
        if ((!oppPast.get(oppPast.size()-1)) || rate > 0.5 || rate > rand.nextDouble(0,1)) {
            return false;
        }
        return true;
    }

    private static boolean cookieDomination(ArrayList<Boolean> myPast, ArrayList<Boolean> oppPast){
        if (oppPast.size() == 0) {return true;}
        if (!oppPast.get(oppPast.size()-1)) {return true;}
        if (oppPast.size() % 4 == 0) {return true;}
        return false;
    }

}