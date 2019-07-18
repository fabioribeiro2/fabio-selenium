package framework;

import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class General {

    String INIT_PAGE = "initPage";

    public Class getInitializedClassFromName(String className, AvailableLocatorModes mode) {
        Class pageObjectsClass = null;
        try {
            try {
                pageObjectsClass = Class.forName(mode.mode() + "." +  className).newInstance().getClass();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (mode == AvailableLocatorModes.PAGE_OBJECTS) {
            invokeMethod(pageObjectsClass, INIT_PAGE);
        }
        return pageObjectsClass;
    }

    private void invokeMethod(Class pageObjectsClass, String methodName) {
        try {
            Object obj = pageObjectsClass.newInstance();
            Method method = pageObjectsClass.getMethod(methodName);
            method.setAccessible(true);
            method.invoke(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public WebElement getWebElementFieldFromClass(Class pageObjectsClass, String fieldName) {
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
        }
        return pageObjectsField;
    }

    public String getStringFieldFromClass(Class pageObjectsClass, String fieldName) {
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
        }
        return stringField;
    }

}
