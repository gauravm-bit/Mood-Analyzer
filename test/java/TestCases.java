import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestCases {
    MoodAnalyser moodAnalyser;

    @Test
    public void givenMessage_whenSad_shouldReturn_sad() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in sad mood");
        Assert.assertEquals("Sad", moodAnalyser.analyzeMood());
    }

    @Test
    public void givenMessage_whenAnyMood_shouldReturn_Happy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in any mood");
        Assert.assertEquals("Happy", moodAnalyser.analyzeMood());
    }

    @Test
    public void givenMessage_whenNull_shouldReturn_Happy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser(null);
        Assert.assertEquals("Happy", moodAnalyser.analyzeMood());
    }

    @Test
    public void givenMessage_WhenNull_ThenShouldReturnNullException() {
        try {
            moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NULL_EXCEPTION, e.userDefinedType);
        }
    }

    @Test
    public void givenMessage_WhenEmpty_ThenShouldReturnEmptyException() {
        try {
            moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.EMPTY_EXCEPTION, e.userDefinedType);
        }
    }

    @Test
    public void givenObject_WhenEquals_ThenReturnTrue() throws MoodAnalysisException{
        moodAnalyser=new MoodAnalyser();
        Constructor constructor=MoodAnalysisFactory.getConstructor("MoodAnalyser");
        MoodAnalyser moodAnalyserObject = MoodAnalysisFactory.createMoodAnalyserObject(constructor);
        boolean result = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    @Test
    public void givenClass_WhenWrong_ThenShouldReturnClassNotFound() {
        try {
            MoodAnalysisFactory.getConstructor("MoodAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS,e.userDefinedType);
        }
    }

    @Test
    public void givenMethod_WhenWrong_ThenShouldReturnNoSuchMethod() {
        try {
            MoodAnalysisFactory.getConstructor("MoodAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD,e.userDefinedType);
        }
    }



}


