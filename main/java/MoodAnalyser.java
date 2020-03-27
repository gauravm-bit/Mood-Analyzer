public class MoodAnalyser {
    String message;

    public static void main(String[] args) {
        System.out.println("Welcome to MoodAnalyzer");
    }

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyzeMood() {
        try {
            if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException e) {
            return "Happy";
        }

    }
}