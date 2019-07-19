package framework;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This class is the superclass of select framework classes
 * Those classes operate WebDriver directly and access PageObjects/Xpath classes and objects through Java Reflection methods implemented here
 */
public class General {

    //This variable is the name of the method that initializes PageObjects classes
    String INIT_PAGE = "initPage";

    /**
     * This method fetches a PageObjects or Xpath classes, by its name and Locator mode
     * @param className Name of the class being acquired via Reflection
     * @param mode Xpath or PageObjects
     * @return The class in question
     */
    public Class getInitializedClassFromName(String className, AvailableLocatorModes mode) throws NoSuchFieldException {
        Class pageObjectsClass = null;
        try {
            try {
                pageObjectsClass = Class.forName(mode.mode() + "." +  className).newInstance().getClass();
            } catch (InstantiationException e) {
                e.printStackTrace();
                throw new NoSuchFieldException("Class " + mode.mode() + "." +  className + " instantiated incorrectly in the framework");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new NoSuchFieldException("Class " + mode.mode() + "." +  className + " inaccessible in the framework");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new NoSuchFieldException("Class " + mode.mode() + "." +  className + " not found in the framework");
        }
        if (mode == AvailableLocatorModes.PAGE_OBJECTS) {
            invokeMethod(pageObjectsClass, INIT_PAGE);
        }
        return pageObjectsClass;
    }

    private void invokeMethod(Class pageObjectsClass, String methodName) throws NoSuchFieldException {
        try {
            Object obj = pageObjectsClass.newInstance();
            Method method = pageObjectsClass.getMethod(methodName);
            method.setAccessible(true);
            method.invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new NoSuchFieldException("Method " + methodName + " in class " + pageObjectsClass.getName() + " illegally accessed inaccessible in the framework");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new NoSuchFieldException("Method " + methodName + " in class " + pageObjectsClass.getName() + " not found in the framework");
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new NoSuchFieldException("Method " + methodName + " in class " + pageObjectsClass.getName() + " instantiated incorrectly in the framework");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new NoSuchFieldException("Method " + methodName + " in class " + pageObjectsClass.getName() + " invoked incorrectly in the framework");
        }
    }

    public WebElement getWebElementFieldFromClass(Class pageObjectsClass, String fieldName) throws NoSuchFieldException {
        WebElement pageObjectsField = null;
        try {
            Field[] fields = pageObjectsClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == WebElement.class && field.getName().equals(fieldName)) {
                    pageObjectsField = (WebElement) field.get(this);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new NoSuchFieldException("Field " + fieldName + " in class " + pageObjectsClass.getName() + " illegally accessed in the framework");
        }
        return pageObjectsField;
    }

    public String getStringFieldFromClass(Class pageObjectsClass, String fieldName) throws NoSuchFieldException {
        String stringField = null;
        try {
            Field[] fields = pageObjectsClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType() == String.class && field.getName().equals(fieldName)) {
                    stringField = (String) field.get(this);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new NoSuchFieldException("Field " + fieldName + " in class " + pageObjectsClass.getName() + " illegally accessed in the framework");
        }
        return stringField;
    }

}
