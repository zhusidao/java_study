package com.example.design_patterns.observer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义：观察者模式定了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新状态
 * 发布+订阅=观察者模式
 *
 * @author ZhuSiDao
 * @date 2020/11/20
 */

/**
 * 消息主题
 */
public class MessageSubject implements Subject {
    static List<Subscriber> subscriberList = new ArrayList<>();

    /**
     * 根据订阅类型自动推送消息
     */
    @Override
    public void publish(Message message) {
        subscriberList.forEach(item -> {
            Type[] types = item.getClass().getGenericInterfaces();
            for (Type type : types) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType pType = (ParameterizedType) type;
                    if (Subscriber.class.getTypeName().equals(pType.getRawType().getTypeName())) {
                        types = pType.getActualTypeArguments();
                        Class<?> clazz = (Class<?>) types[0];
                        if (clazz.isAssignableFrom(message.getClass())) {
                            item.receiver(message);
                        }
                    }
                }
            }
        });
    }

    /**
     * 订阅消息
     * @param subscriber
     */
    static void subscribe(Subscriber<? extends Message> subscriber) {
        subscriberList.add(subscriber);
    }

    /**
     * 取消订阅
     * @param subscriber
     */
    static void unsubscribe(Subscriber<? extends Message> subscriber) {
        subscriberList.remove(subscriber);
    }

    public static void main(String[] args) {
        MessageSubject messageSubject = new MessageSubject();

        // 订阅天气消息
        WeatherSubscriber concreteSubscriber = new WeatherSubscriber();
        subscribe(concreteSubscriber);
        // 订阅新闻消息
        NewsSubscriber newsSubscriber = new NewsSubscriber();
        subscribe(newsSubscriber);
        // 订阅体育新闻消息
        SportNewsSubscriber sportNewsSubscriber = new SportNewsSubscriber();
        subscribe(sportNewsSubscriber);

        // 发布天气消息
        messageSubject.publish(new Weather("Today is a good day"));

        // 发布体育新闻消息
        messageSubject.publish(new SportNews("lakers champion"));
    }
}

/**
 * 抽象主题
 */
interface Subject {
    void publish(Message message);
}

/**
 * 抽象订阅者
 * @param <T>
 */
interface Subscriber<T extends Message> {
    void receiver(T message);
}

/**
 * 抽象消息
 */
class Message {
    Object msg;

    public Message(Object msg) {
        this.msg = msg;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}

/**
 * 天气订阅者
 */
class WeatherSubscriber implements Subscriber<Weather> {
    @Override
    public void receiver(Weather event) {
        System.out.println(event.getMsg());
        System.out.println("i have subscribe weather");
    }
}

/**
 * 新闻订阅者
 */
class NewsSubscriber implements Subscriber<News> {
    @Override
    public void receiver(News event) {
        System.out.println(event.getMsg());
        System.out.println("i have subscribe News");
    }
}

/**
 * 体育新闻订阅者
 */
class SportNewsSubscriber implements Subscriber<SportNews> {
    @Override
    public void receiver(SportNews event) {
        System.out.println(event.getMsg());
        System.out.println("i have subscribe sport's News");
    }
}


/**
 * 天气消息
 */
class Weather extends Message {
    public Weather(String msg) {
        super(msg);
    }
}

/**
 * 新闻消息
 */
class News extends Message {
    public News(String msg) {
        super(msg);
    }
}

/**
 * 体育新闻消息
 */
class SportNews extends News {
    public SportNews(String msg) {
        super(msg);
    }
}