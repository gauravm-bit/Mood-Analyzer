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

    @Test
    public void givenObject_WhenEqualsWithParamConstructor_ThenReturnTrue() throws MoodAnalysisException {
        moodAnalyser=new MoodAnalyser("Hello");
        Constructor constructor=MoodAnalysisFactory.getConstructor("MoodAnalyser",String.class);
        MoodAnalyser moodAnalyserObject = MoodAnalysisFactory.createMoodAnalyserObject(constructor,"Hello");
        boolean result=moodAnalyser.equals(moodAnalyserObject);
        Assert.assertTrue("true",result);
    }

    @Test
    public void givenClassNameWithParamConstructor_WhenWrong_ThenShouldReturnClassNotFound() {
        try {
            MoodAnalysisFactory.getConstructor("MoodAnalyzer",String.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS,e.userDefinedType);
        }
    }

    @Test
    public void givenParamConstructor_WhenWrong_ThenShouldReturnNoSuchMethod() {
        try {
            MoodAnalysisFactory.getConstructor("MoodAnalyser",String.class,Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD,e.userDefinedType);
        }
    }

    @Test
    public void givenHappyMessage_WhenProper_ShouldReturnHappy() {
        try {
            Constructor constructor = MoodAnalysisFactory.getConstructor("MoodAnalyser",String.class);
            Object moodAnalyserObject = MoodAnalysisFactory.createMoodAnalyserObject(constructor,"I am in Happy mood");
            Object mood = MoodAnalysisFactory.invokeMethod(moodAnalyserObject, "analyzer");
            Assert.assertEquals("Happy",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy() {
        try {
            Constructor moodConstructor = MoodAnalysisFactory.getConstructor("MoodAnalyzer");
            MoodAnalyser moodAnalyzerObject = MoodAnalysisFactory.createMoodAnalyserObject(moodConstructor);
            MoodAnalysisFactory.setFieldValue(moodAnalyzerObject, "message", "I am in happy mood");
            Object mood = MoodAnalysisFactory.invokeMethod(moodAnalyzerObject, "analyzer");
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFieldName_WithDefaultConstructorWhenImproper_ShouldThrowMoodAnalysisException(){
        try {
            Constructor moodConstructor = MoodAnalysisFactory.getConstructor("MoodAnalyser");
            MoodAnalyser moodAnalyzerObject = MoodAnalysisFactory.createMoodAnalyserObject(moodConstructor);
            MoodAnalysisFactory.setFieldValue(moodAnalyzerObject,"Message","I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.UserDefinedType.NO_SUCH_FIELD,e.userDefinedType);
        }
    }
}


