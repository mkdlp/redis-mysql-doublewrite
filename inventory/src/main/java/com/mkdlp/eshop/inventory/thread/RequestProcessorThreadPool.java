package com.mkdlp.eshop.inventory.thread;

import com.mkdlp.eshop.inventory.request.Request;
import com.mkdlp.eshop.inventory.request.RequestQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 请求处理线程池：单例
 */
public class  RequestProcessorThreadPool{

    /**
     * 这里线程池的大小先写死了，正常应该在配置文件中配好
     */
    private ExecutorService threadPool= Executors.newFixedThreadPool(10);

    public RequestProcessorThreadPool() {
        RequestQueue requestQueue=RequestQueue.getInstance();

        for(int i=0;i<10;i++){
            ArrayBlockingQueue<Request> queue=new ArrayBlockingQueue<Request>(100);
            requestQueue.addQueue(queue);
            threadPool.submit(new RequestProcessorThread(queue));
        }
    }

    /**
     * 静态内部类实现的单例，保证线程并发安全
     */
    private static class Singleton{

        private static RequestProcessorThreadPool instance;

        static{
            instance=new RequestProcessorThreadPool();
        }

        public static RequestProcessorThreadPool getInstance(){
            return instance;
        }
    }

    /**
     * jvm的类加载机制去保证多线程并发安全
     *
     * @return
     */
    public static RequestProcessorThreadPool getInstance() {
        return Singleton.getInstance();
    }

    public static void init(){
        getInstance();
    }
}
