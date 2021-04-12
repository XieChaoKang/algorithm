import java.lang.reflect.Method;

/**
 * 看反射
 */
public class 反射 {

    public static void main(String[] args) throws Exception{
        Class<? extends person> aClass = person.class;
        Method setAdd = aClass.getMethod("setAdd", String.class);
        person person = new person();
        Object invoke = setAdd.invoke(person, "1111");
        Method getAdd = aClass.getMethod("getAdd");
        System.out.println(getAdd.invoke(person));
    }
}
