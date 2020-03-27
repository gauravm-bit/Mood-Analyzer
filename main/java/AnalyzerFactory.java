public class AnalyzerFactory {
    public static void main(String[] args) {
        AnalyzerFactory MoodAnalyser = new AnalyzerFactory();
        MoodAnalyser.analyzeMood("sad");
        System.out.println("Welcome to MoodAnalyzer");

    }
    public String analyzeMood(String emotion){
        if (emotion.contains("sad"))
            return "Sad";
        else
            return "Happy";
    }



}