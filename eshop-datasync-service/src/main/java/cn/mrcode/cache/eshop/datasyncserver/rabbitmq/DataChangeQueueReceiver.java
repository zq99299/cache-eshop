package cn.mrcode.cache.eshop.datasyncserver.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import cn.mrcode.cache.eshop.datasyncserver.service.EshopProductService;

@Component
@RabbitListener(queues = "data-change-queue") // 前面的队列也统一成这种横线写法
public class DataChangeQueueReceiver {
    @Autowired
    private EshopProductService eshopProductService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    /**
     * 数据聚合队列
     */
    final static String AGGR_DATA_CHANGE_QUEUE = "aggr-data-change-queue";

    @RabbitHandler
    public void process(String message) {
        ProductEvent productEvent = JSON.parseObject(message, ProductEvent.class);
        // 先获取data_type
        String dataType = productEvent.getDataType();
        switch (dataType) {
            case "brand":
                processBrandDataChangeMessage(productEvent);
                break;
            case "category":
                processCategoryDataChangeMessage(productEvent);
                break;
            case "product":
                processProductDataChangeMessage(productEvent);
                break;
            case "product_intro":
                processProductIntroDataChangeMessage(productEvent);
                break;
            case "product_property":
                processProductPropertyDataChangeMessage(productEvent);
                break;
            case "product_specification":
                processProductSpecificationDataChangeMessage(productEvent);
                break;
        }
    }

    private void processBrandDataChangeMessage(ProductEvent productEvent) {
        Long id = productEvent.getId();
        String eventType = productEvent.getEventType();

        if ("add".equals(eventType) || "update".equals(eventType)) {
            JSONObject dataJSONObject = JSONObject.parseObject(eshopProductService.findBrandById(id));
            redisTemplate.opsForValue().set("brand_" + dataJSONObject.getLong("id"), dataJSONObject.toJSONString());
        } else if ("delete".equals(eventType)) {
            redisTemplate.delete("brand_" + id);
        }
        DimEvent dimEvent = new DimEvent("brand", id);
        rabbitMQSender.send(AGGR_DATA_CHANGE_QUEUE, JSON.toJSONString(dimEvent));
    }

    private void processCategoryDataChangeMessage(ProductEvent productEvent) {
        Long id = productEvent.getId();
        String eventType = productEvent.getEventType();

        if ("add".equals(eventType) || "update".equals(eventType)) {
            JSONObject dataJSONObject = JSONObject.parseObject(eshopProductService.findCategoryById(id));
            redisTemplate.opsForValue().set("category_" + dataJSONObject.getLong("id"), dataJSONObject.toJSONString());
        } else if ("delete".equals(eventType)) {
            redisTemplate.delete("category_" + id);
        }
        DimEvent dimEvent = new DimEvent("category", id);
        rabbitMQSender.send(AGGR_DATA_CHANGE_QUEUE, JSON.toJSONString(dimEvent));
    }

    private void processProductDataChangeMessage(ProductEvent productEvent) {
        Long id = productEvent.getId();
        String eventType = productEvent.getEventType();

        if ("add".equals(eventType) || "update".equals(eventType)) {
            JSONObject dataJSONObject = JSONObject.parseObject(eshopProductService.findProductById(id));
            redisTemplate.opsForValue().set("product_" + dataJSONObject.getLong("id"), dataJSONObject.toJSONString());
        } else if ("delete".equals(eventType)) {
            redisTemplate.delete("product_" + id);
        }
        DimEvent dimEvent = new DimEvent("product", id);
        rabbitMQSender.send(AGGR_DATA_CHANGE_QUEUE, JSON.toJSONString(dimEvent));
    }

    private void processProductIntroDataChangeMessage(ProductEvent productEvent) {
        Long id = productEvent.getId();
        String eventType = productEvent.getEventType();
        // 注意这里，产品有关联的几个维度数据都使用产品 id 进行放置，在数据聚合里面都是通过 productId 对产品完整数据聚合
        // 那么与之对应发送事件的 eshop-product-service 服务中就要加上这个属性
        Long productId = productEvent.getProductId();

        if ("add".equals(eventType) || "update".equals(eventType)) {
            JSONObject dataJSONObject = JSONObject.parseObject(eshopProductService.findProductIntroById(id));
            redisTemplate.opsForValue().set("product_intro_" + productId, dataJSONObject.toJSONString());
        } else if ("delete".equals(eventType)) {
            redisTemplate.delete("product_intro_" + id);
        }
        // 这里暂时还不知道为什么要用 product 事件，而不是具体的对象事件，只能后面再来补坑了
        DimEvent dimEvent = new DimEvent("product_intro", productId);
        rabbitMQSender.send(AGGR_DATA_CHANGE_QUEUE, JSON.toJSONString(dimEvent));
    }

    private void processProductPropertyDataChangeMessage(ProductEvent productEvent) {
        Long id = productEvent.getId();
        String eventType = productEvent.getEventType();
        Long productId = productEvent.getProductId();

        if ("add".equals(eventType) || "update".equals(eventType)) {
            JSONObject dataJSONObject = JSONObject.parseObject(eshopProductService.findProductPropertyById(id));
            redisTemplate.opsForValue().set("product_property_" + productId, dataJSONObject.toJSONString());
        } else if ("delete".equals(eventType)) {
            redisTemplate.delete("product_property_" + id);
        }
        // 这里暂时还不知道为什么要用 product 事件，而不是具体的对象事件，只能后面再来补坑了
        DimEvent dimEvent = new DimEvent("product", productId);
        rabbitMQSender.send(AGGR_DATA_CHANGE_QUEUE, JSON.toJSONString(dimEvent));
    }

    private void processProductSpecificationDataChangeMessage(ProductEvent productEvent) {
        Long id = productEvent.getId();
        String eventType = productEvent.getEventType();
        Long productId = productEvent.getProductId();

        if ("add".equals(eventType) || "update".equals(eventType)) {
            JSONObject dataJSONObject = JSONObject.parseObject(eshopProductService.findProductSpecificationById(id));
            redisTemplate.opsForValue().set("product_specification_" + productId, dataJSONObject.toJSONString());
        } else if ("delete".equals(eventType)) {
            redisTemplate.delete("product_specification_" + id);
        }
        // 这里暂时还不知道为什么要用 product 事件，而不是具体的对象事件，只能后面再来补坑了
        DimEvent dimEvent = new DimEvent("product", productId);
        rabbitMQSender.send(AGGR_DATA_CHANGE_QUEUE, JSON.toJSONString(dimEvent));
    }
}  