package priv.kimking.base.designpattern.b1adapter;

import cn.hutool.json.JSONUtil;
import priv.kimking.base.designpattern.b1adapter.mq.CreateAccount;
import priv.kimking.base.designpattern.b1adapter.mq.OrderMq;
import priv.kimking.base.designpattern.b1adapter.service.MQAdapter;
import priv.kimking.base.designpattern.b1adapter.service.OrderAdapterService;
import priv.kimking.base.designpattern.b1adapter.service.RebateInfo;
import priv.kimking.base.designpattern.b1adapter.service.impl.InsideOrderService;
import priv.kimking.base.designpattern.b1adapter.service.impl.POPOrderAdapterServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

/**
 * 适配器模式的主要作用就是把原本不兼容的接口，通过适配修改做到统一。
 * <p>
 * 适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。
 *
 * @author kim
 * @date 2021/12/1
 */
public class AdapterPatternDemo {

    public static void main(String[] args) {
        // try {
        //     test_MQAdapter();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        test_itfAdapter();
    }


    public static void test_MQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        CreateAccount create_account = new CreateAccount();
        create_account.setNumber("100001");
        create_account.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        create_account.setAccountDate(new Date());
        create_account.setDesc("在校开户");

        HashMap<String, String> link01 = new HashMap<String, String>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(JSONUtil.toJsonStr(create_account), link01);
        System.out.println("mq.create_account(适配前)" + create_account.toString());
        System.out.println("mq.create_account(适配后)" + JSONUtil.toJsonStr(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(new Date());

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(JSONUtil.toJsonStr(orderMq), link02);

        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSONUtil.toJsonStr(rebateInfo02));
    }

    public static void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderService();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }


}
