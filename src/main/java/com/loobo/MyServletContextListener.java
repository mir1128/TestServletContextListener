package com.loobo;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Enumeration;

public class MyServletContextListener implements ServletContextListener {

    private static Logger logger = Logger.getLogger(MyServletContextListener.class);

    public void contextInitialized(ServletContextEvent event) {
        logger.info("contextInitialized is called.");

        Enumeration<String> parameterNames = event.getServletContext().getInitParameterNames();

        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            logger.info(s + ":" + event.getServletContext().getInitParameter(s));
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        logger.info("contextDestroyed is called.");
    }
}


