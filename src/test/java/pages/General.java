package pages;

import pageobjects.GeneralPage;
import pageobjects.LoginPage;

import java.lang.reflect.Method;

public class General {

    private GeneralPage generalPage = new GeneralPage();

    public General() {
        generalPage = generalPage.initPage();
    }

    public void navigateToUrl(String url) {
        generalPage.navigateToUrl(url);
    }

    public void reopenBrowser() {
        generalPage.reopenBrowser();
    }

    public void clickButton(String button, String page) {
        try {
            Class pageObjectsClass = Class.forName(page);
            Method method = pageObjectsClass.getClass().getMethod()
            pageObjectsClass.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public <T> T instantiate(final String className, final Class<T> type){
        try{
            return type.cast(Class.forName(className).newInstance());
        } catch(InstantiationException
                | IllegalAccessException
                | ClassNotFoundException e){
            throw new IllegalStateException(e);
        }
    }
}
