import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalysisFactory {
    public static MoodAnalyser createMoodAnalyserObject(){
        try {
            Class<?> moodAnalyserClass = Class.forName("MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            Object moodObject = moodConstructor.newInstance();
            return (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
