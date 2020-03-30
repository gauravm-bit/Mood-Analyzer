import org.junit.Assert;
import org.junit.Test;

public class TestCases {

    //TC1.1
    @Test
    public void givenMessage_whenSad_shouldReturn_sad(){
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in sad mood");
        Assert.assertEquals("Sad",moodAnalyser.analyzeMood());
    }

    //TC1.2
    @Test
    public void givenMessage_whenAnyMood_shouldReturn_Happy(){
        MoodAnalyser moodAnalyser=new MoodAnalyser("I am in happy mood");
        Assert.assertEquals("Happy",moodAnalyser.analyzeMood());
    }

    //TC2.1
    @Test
    public void givenMessage_whenNull_shouldReturn_Happy(){
        MoodAnalyser moodAnalyser=new MoodAnalyser(null);
        Assert.assertEquals("Happy",moodAnalyser.analyzeMood());
    }

}
