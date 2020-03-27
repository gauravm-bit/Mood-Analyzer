import org.junit.Assert;
import org.junit.Test;

public class TestCases {

    @Test
    public void givenMessage_whenSad_shouldReturn_sad() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood");
        Assert.assertEquals("Sad", moodAnalyser.analyzeMood());
    }

    @Test
    public void givenMessage_whenAnyMood_shouldReturn_Happy() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood");
        Assert.assertEquals("Happy", moodAnalyser.analyzeMood());
    }

    @Test
    public void givenMessage_whenNull_shouldReturn_Happy() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        Assert.assertEquals("Happy", moodAnalyser.analyzeMood());
    }

    @Test
    public void givenMessage_WhenNull_ThenShouldReturnNullException() {
        try {
            MoodAnalyser moodAnalyzer = new MoodAnalyser(null);
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NULL_EXCEPTION, e.userDefinedType);
        }
    }

    @Test
    public void givenMessage_WhenEmpty_ThenShouldReturnEmptyException() {
        try {
            MoodAnalyser moodAnalyzer = new MoodAnalyser("");
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.EMPTY_EXCEPTION, e.userDefinedType);
        }
    }
}


