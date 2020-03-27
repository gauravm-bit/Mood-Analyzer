import org.junit.Assert;
import org.junit.Test;

public class TestCases {
    AnalyzerFactory analyzerFactory = new AnalyzerFactory();

    @Test
    public void givenMessage_whenSad_shouldReturn_sad(){
        String emotion= analyzerFactory.analyzeMood("I am sad");
        Assert.assertEquals("Sad",emotion);
    }

    @Test
    public void givenMessage_whenAnyMood_shouldReturn_sad(){
        String emotion= analyzerFactory.analyzeMood("I am in any Mood");
        Assert.assertEquals("Happy",emotion);
    }

}
