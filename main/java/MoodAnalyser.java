import java.util.Objects;

public class MoodAnalyser<analyseMood> {
    String message;

    public static void main(String[] args) {
        System.out.println("Welcome to MoodAnalyzer");
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser<?> that = (MoodAnalyser<?>) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }
}