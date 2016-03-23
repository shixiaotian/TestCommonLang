package event;

import org.apache.commons.lang3.event.EventListenerSupport;

/**
 *
 * 事件类
 * 接口了包里原生的时间监听支持
 *
 * Created by shixiaotian on 16/3/23.
 * s
 */
public class CatEvent extends EventListenerSupport<Listener> {

    public CatEvent(Class<Listener> listenerInterface) {
        super(listenerInterface);
    }

    // 重写了添加监听的方法
    public void addListener(CatListener catListener) {

        System.out.println("cat in " + catListener);

    }
}
