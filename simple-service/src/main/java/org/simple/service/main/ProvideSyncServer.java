package org.simple.service.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;


/**
 * 
 * @author John
 *
 */
public class ProvideSyncServer {

    private final AbstractApplicationContext springContext;

    public ProvideSyncServer() {
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
        ProvideSyncServer server = new ProvideSyncServer();
        Runtime.getRuntime().addShutdownHook(new ShutdownThread(server));
        synchronized (ProvideSyncServer.class) {
            while (true) {
                try {
                	ProvideSyncServer.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

    private static class ShutdownThread extends Thread {

        private final ProvideSyncServer server;

        public ShutdownThread(ProvideSyncServer server) {
            this.server = server;
        }

        @Override
        public void run() {
            server.stop();
        }
    }
    
}
