import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class TestCases {
    MoodAnalyser moodAnalyser;

    //TC 1.1
    @Test
    public void givenMessage_whenSad_shouldReturn_sad() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in sad mood");
        Assert.assertEquals("Sad", moodAnalyser.analyzeMood());
    }

    //TC 1.2
    @Test
    public void givenMessage_whenAnyMood_shouldReturn_Happy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser("I am in any mood");
        Assert.assertEquals("Happy", moodAnalyser.analyzeMood());
    }

    //TC 2.1
    @Test
    public void givenMessage_whenNull_shouldReturn_Happy() throws MoodAnalysisException {
        moodAnalyser = new MoodAnalyser(null);
        Assert.assertEquals("Happy", moodAnalyser.analyzeMood());
    }

    //TC 3.1
    @Test
    public void givenMessage_WhenNull_ThenShouldReturnNullException() {
        try {
            moodAnalyser = new MoodAnalyser(null);
            moodAnalyser.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NULL_EXCEPTION, e.userDefinedType);
        }
    }

    //TC 3.2
    @Test
    public void givenMessage_WhenEmpty_ThenShouldReturnEmptyException() {
        try {
            moodAnalyser = new MoodAnalyser("");
            moodAnalyser.analyzeMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.EMPTY_EXCEPTION, e.userDefinedType);
        }
    }

    //TC 4.1
    @Test
    public void givenObject_WhenEquals_ThenReturnTrue() throws MoodAnalysisException{
        moodAnalyser=new MoodAnalyser();
        Constructor constructor=MoodAnalysisFactory.getConstructor("MoodAnalyser");
        MoodAnalyser moodAnalyserObject = MoodAnalysisFactory.createMoodAnalyserObject(constructor);
        boolean result = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    //TC 4.2
    @Test
    public void givenClass_WhenWrong_ThenShouldReturnClassNotFound() {
        try {
            MoodAnalysisFactory.getConstructor("Measdsda");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS,e.userDefinedType);
        }
    }

    //4.3
    @Test
    public void givenMethod_WhenWrong_ThenShouldReturnNoSuchMethod() {
        try {
            MoodAnalysisFactory.getConstructor("MoodAnalyser",Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD,e.userDefinedType);
        }
    }

    //TC 5.1
    @Test
    public void givenObject_WhenEqualsWithParamConstructor_ThenReturnTrue() throws MoodAnalysisException {
        moodAnalyser=new MoodAnalyser("Hello");
        Constructor constructor=MoodAnalysisFactory.getConstructor("MoodAnalyser",String.class);
        MoodAnalyser moodAnalyserObject = MoodAnalysisFactory.createMoodAnalyserObject(constructor,"Hello");
        boolean result=moodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    //TC 5.2
    @Test
    public void givenClassNameWithParamConstructor_WhenWrong_ThenShouldReturnClassNotFound() {
        try {
            MoodAnalysisFactory.getConstructor("Measdsda",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS,e.userDefinedType);
        }
    }

    //TC 5.3
    @Test
    public void givenParamConstructor_WhenWrong_ThenShouldReturnNoSuchMethod() {
        try {
            MoodAnalysisFactory.getConstructor("MoodAnalyser",String.class,Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD,e.userDefinedType);
        }
    }






}


