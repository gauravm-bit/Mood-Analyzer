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

    public String analyzeMood() throws MoodAnalysisException {
        try {
            if(message.length()==0)
                throw new MoodAnalysisException("Message should not empty",MoodAnalysisException.UserDefinedType.EMPTY_EXCEPTION);
            else if (message.contains("sad"))
                return "Sad";
            else
                return "Happy";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException("Message should not be null",MoodAnalysisException.UserDefinedType.NULL_EXCEPTION);
        }

    }
}