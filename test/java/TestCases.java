import org.junit.Assert;
import org.junit.Test;

public class TestCases {

    //TC 1.1
    @Test
    public void givenMessage_whenSad_shouldReturn_sad() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood");
        Assert.assertEquals("Sad", moodAnalyser.analyzeMood());
    }

    //TC 1.2
    @Test
    public void givenMessage_whenAnyMood_shouldReturn_Happy() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood");
        Assert.assertEquals("Happy", moodAnalyser.analyzeMood());
    }

    //TC 2.1
    @Test
    public void givenMessage_whenNull_shouldReturn_Happy() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        Assert.assertEquals("Happy", moodAnalyser.analyzeMood());
    }

    //TC 3.1
    @Test
    public void givenMessage_WhenNull_ThenShouldReturnNullException() {
        try {
            MoodAnalyser moodAnalyzer = new MoodAnalyser(null);
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NULL_EXCEPTION, e.userDefinedType);
        }
    }

    //TC 3.2
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


