import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalysisFactory {
    public static Constructor getConstructor(String className,Class<?>... param) throws MoodAnalysisException {
        try {
            Class<?> moodClass = Class.forName(className);
            return moodClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("class not found",MoodAnalysisException.UserDefinedType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Method not found",MoodAnalysisException.UserDefinedType.NO_SUCH_METHOD);
        }
    }

    public static MoodAnalyser createMoodAnalyserObject(Constructor constructor, Object ... objects) throws MoodAnalysisException{
        try {
            return (MoodAnalyser) constructor.newInstance(objects);
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
