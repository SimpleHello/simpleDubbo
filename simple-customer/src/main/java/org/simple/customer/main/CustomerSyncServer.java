package org.simple.customer.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @author John
 *
 */
public class CustomerSyncServer {

    private final AbstractApplicationContext springContext;

    public CustomerSyncServer() {
        springContext = new ClassPathXmlApplicationContext("classpath:conf/applicationContext.xml");
    }

    public void stop() {
    	springContext.stop();
        springContext.close();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomerSyncServer server = new CustomerSyncServer();
        Runtime.getRuntime().addShutdownHook(new ShutdownThread(server));
        synchronized (CustomerSyncServer.class) {
            while (true) {
                try {
                	CustomerSyncServer.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

    private static class ShutdownThread extends Thread {

        private final CustomerSyncServer server;

        public ShutdownThread(CustomerSyncServer server) {
            this.server = server;
        }

        @Override
        public void run() {
            server.stop();
        }
    }
    
}
