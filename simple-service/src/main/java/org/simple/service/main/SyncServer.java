package org.simple.service.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.container.Main;


/**
 * 
 * @author John
 *
 */
public class SyncServer {

    private final AbstractApplicationContext springContext;

    public SyncServer() {
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
        SyncServer server = new SyncServer();
        Runtime.getRuntime().addShutdownHook(new ShutdownThread(server));
        synchronized (SyncServer.class) {
            while (true) {
                try {
                    Main.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

    private static class ShutdownThread extends Thread {

        private final SyncServer server;

        public ShutdownThread(SyncServer server) {
            this.server = server;
        }

        @Override
        public void run() {
            server.stop();
        }
    }
    
}
