package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {
    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private boolean stop;
    private ExecutorService threadPool; // Thread pool

    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        this.threadPool = Executors.newFixedThreadPool(Integer.parseInt(Configurations.getInstance().getThreadPoolSize()));
    }
    public void start() {
        new Thread(this::startHelper).start();
    }
    private void startHelper(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);
            while(!stop){
                try{
                    Socket clientSocket = serverSocket.accept();
                    threadPool.submit(() -> {
                        handleClient(clientSocket);
                    });
                }
                catch (SocketTimeoutException e){
                    //do nothing
                }
            }
            serverSocket.close();
            threadPool.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void stop(){
        stop = true;
    }
    private void handleClient(Socket clientSocket){
        try{
            strategy.applyStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            clientSocket.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
