package com.mkdlp.eshop.inventory.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 请求内存队列
 */
public class RequestQueue {

    private List<ArrayBlockingQueue<Request>> queues=new ArrayList<>();

    /**
     * 标识位map
     */
    private Map<Integer, Boolean> flagMap = new ConcurrentHashMap<Integer, Boolean>();

    /**
     * 单例有多种实现方式，在这里采用绝对线程安全的静态内部类
     */
    private static class Singleton{
        private static RequestQueue instance;

        static{
            instance=new RequestQueue();
        }

        public static RequestQueue getInstance(){
            return instance;
        }
    }

    /**
     * 利用jvm的类加载机制去保证并发安全
     * @return
     */
    public static RequestQueue getInstance(){
        return Singleton.getInstance();
    }

    /**
     * 添加一个内存队列
     */
    public void addQueue(ArrayBlockingQueue<Request> queue){
        queues.add(queue);
    }

    /**
     * 得到队列的大小
     * @return
     */
    public int queueSize(){
        return queues.size();
    }

    /**
     * 得到内存队列
     * @param index
     * @return
     */
    public ArrayBlockingQueue<Request> getQueue(int index){
        return queues.get(index);
    }

    /**
     * 得到标志位map
     * @return
     */
    public Map<Integer, Boolean> getFlagMap() {
        return flagMap;
    }
}
