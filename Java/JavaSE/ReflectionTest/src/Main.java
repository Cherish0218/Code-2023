import java.util.*;
import java.lang.reflect.*;


public class Main {
    public static void main(String[] args)
        throws ReflectiveOperationException
    {
        // read class name from command line args or user input
        String name;
        if (args.length > 0) name = args[0];
        else{
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date):");
            name = in.next();
        }

        // print class modifiers, name, and superclass name (if != Object)
        // 打印类修饰符、名称和超类名
        Class cl = Class.forName(name);
        String modifierrs = Modifier.toString(cl.getModifiers());
        if (modifierrs.length() > 0) System.out.println(modifierrs + " ");
        if (cl.isSealed()) System.out.println("seald ");

        if (cl.isEnum()) System.out.println("enum " + name);
        else if (cl.isRecord()) {
            System.out.println("record " + name);
        }
        else if (cl.isInterface()) {
            System.out.println("interface" + name);
        }
        else
            System.out.println("class" + name);

        Class supercl = cl.getSuperclass();
        if (supercl != null && supercl != Object.class)
            System.out.println(" extends " + supercl.getName());

        printINterfaces(cl);
        printPermittedSubclasses(cl);

        System.out.println("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");

    }


    // print all constructors of a class
    public  static void printConstructors(Class cl)
    {
        Constructor[] constructors = cl.getDeclaredConstructors();

        for (Constructor c : constructors){
            String name = c.getName();
            System.out.println("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.println(modifiers + " ");
            System.out.println(name + "(");

            //print parameter types 打印参数类型
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0) System.out.println(", ");
                System.out.println(paramTypes[j].getName());
            }
            System.out.println("); ");

        }
    }

    // print all methods of a class
    public  static void printMethods(Class cl)
    {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods)
        {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.println("   ");
            // print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.println(modifiers = " ");
            System.out.println(retType.getName() + " " + name + "(");

            // print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++){
                if ( j > 0) System.out.println(", ");
                System.out.println(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    // print all field of a class
    // 打印类的所有字段
    public static void printFields(Class cl)
    {
        Field[] fields = cl.getDeclaredFields();

        for (Field f : fields)
        {
            Class type = f.getType();
            String name = f.getName();
            System.out.println("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.println(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    // print all permitted subtypes of a sealed class
    // 打印密封类的所有允许的子类型
    public static void printPermittedSubclasses(Class cl){
        if (cl.isSealed()){
            Class<?>[] permittedSubclasses = cl.getPermittedSubclasses();
            for (int i = 0; i < permittedSubclasses.length; i++)
            {
                if ( i == 0)
                {
                    System.out.println(" permits ");
                }
                else {
                    System.out.println(", ");
                }
                System.out.println(permittedSubclasses[i].getName());
            }
        }
    }

    // print all directly implemented interfaces of a class
    // 打印类的所有直接实现的接口
    public static void printINterfaces(Class cl)
    {
        Class<?>[] interfaces = cl.getInterfaces();
        for (int i = 0; i < interfaces.length; i++)
        {
            if (i == 0)
            {
                System.out.println(cl.isInterface() ? "extends " :"implements ");
            }
            else {
                System.out.println(", ");
            }
            System.out.println(interfaces[i].getName());
        }
    }
}