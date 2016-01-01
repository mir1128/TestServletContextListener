在web.xml中，

	<servlet>
		<param-name>adminEmail</param-name>
		<param-value>likewecare@qq.com</param-value>
	</servlet>
	
在对应的servlet中可以
	
	getServletConfig().getInitParameter("adminEmail");
	
如果是全部应用都会用到的参数就放到`<context-param>`中

	<context-param>
		<param-name>adminEmail</param-name>
		<param-value>likewecare@qq.com</param-value>
	</context-param>			
	
在servlet代码中

	getServletContext().getInitParameter("adminEmail");
	

每个Servlet一个ServletConfig
每个web应用一个ContextConfig


`ServletContextListener`可以在应用初始化得到通知，在应用撤销的时候也得到通知

	
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
	
对应的web.xml

	<listener>
        <listener-class>com.loobo.MyServletContextListener</listener-class>
    </listener>
    















	


	