package com.glacier.mq.pojo;

import com.glacier.bean.Student;
import com.glacier.factory.Factory;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author glacier
 * @version v1.0.0
 * @Date 2017-09-24  20:11:42
 */
public class PojoProducter {
    //ActiveMq 的默认用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMq 的默认登录密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //ActiveMQ 的链接地址
    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    AtomicInteger count = new AtomicInteger(0);
    //链接工厂
    ConnectionFactory connectionFactory;
    //链接对象
    Connection connection;
    //事务管理
    Session session;
    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();

    public void init() {
        try {
            //创建一个链接工厂
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEN_URL);
            //从工厂中创建一个链接
            connection = connectionFactory.createConnection();
            //开启链接
            connection.start();
            //创建一个事务（这里通过参数可以设置事务的级别）
            session = connection.createSession(true, Session.SESSION_TRANSACTED);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String disname) {
        try {
            //创建一个消息队列
            Queue queue = session.createQueue(disname);
            //消息生产者
            MessageProducer messageProducer = null;
            if (threadLocal.get() != null) {
                messageProducer = threadLocal.get();
            } else {
                messageProducer = session.createProducer(queue);
                // 设置持久化模式
                messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                threadLocal.set(messageProducer);
            }
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                int num = count.getAndIncrement();

                Student student = Factory.createStudent(i);
                ObjectMessage objectMessage = session.createObjectMessage(student);
                System.out.println(Thread.currentThread().getName() + "productor:\t" + student + ",count:" + num);
                messageProducer.send(objectMessage);

                //提交事务
                session.commit();
            }
            messageProducer.close();
            threadLocal.remove();
            System.out.println("messageProducer关闭！");
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
