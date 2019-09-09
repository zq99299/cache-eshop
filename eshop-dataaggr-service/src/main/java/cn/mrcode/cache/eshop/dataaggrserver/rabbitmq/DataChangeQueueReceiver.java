package cn.mrcode.cache.eshop.dataaggrserver.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RabbitListener(queues = "aggr-data-change-queue") // 前面的队列也统一成这种横线写法
public class DataChangeQueueReceiver {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RabbitHandler
    public void process(String message) {
        DimEvent event = JSON.parseObject(message, DimEvent.class);
        String dimType = event.getDimType();
        switch (dimType) {
            case "brand":
                processBrandDimDataChangeMessage(event);
                break;
            case "category":
                processCategoryDimDataChangeMessage(event);
                break;
            case "product":
                processProductDimDataChangeMessage(event);
                break;
            case "product_intro":
                processProductIntroDimDataChangeMessage(event);
                break;
        }
    }

    /**
     * <pre>
     * 只看这里觉得可能是多此一举，这里说明下：
     *  1. 业务数据简化了
     *  2. 实际业务中，每个维度都不可能只有一个原子数据
     *  3. 比如品牌：结构多变，复杂，有很多不同的表，不同的原子数据，这里需要将一个品牌对应的多个原子数据都从 redis 中读取出来，聚合后写入 redis
     * </pre>
     */
    private void processBrandDimDataChangeMessage(DimEvent event) {
        String key = "brand_" + event.getId();
        String jsonStr = redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(jsonStr)) {
            redisTemplate.delete(key);
        } else {
            redisTemplate.opsForValue().set("dim_" + key, jsonStr);
        }
    }


    private void processCategoryDimDataChangeMessage(DimEvent event) {
        String key = "category_" + event.getId();
        String jsonStr = redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(jsonStr)) {
            redisTemplate.delete(key);
        } else {
            redisTemplate.opsForValue().set("dim_" + key, jsonStr);
        }
    }

    private void processProductDimDataChangeMessage(DimEvent event) {
        System.out.println("商品聚合：" + event);
        Long productId = event.getId();
        String productKey = "product_" + productId;
        String productJsonStr = redisTemplate.opsForValue().get(productKey);
        if (StringUtils.isBlank(productJsonStr)) {
            // 主商品数据都没有的话，就直接删除这个聚合数据
            redisTemplate.delete(productKey);
        } else {
            JSONObject product = JSON.parseObject(productJsonStr);
            String productPropertyJsonStr = redisTemplate.opsForValue().get("product_property_" + productId);
            if (StringUtils.isNotBlank(productPropertyJsonStr)) {
                product.put("productProperty", JSON.parseObject(productPropertyJsonStr));
            }
            String productSpecificationJsonStr = redisTemplate.opsForValue().get("product_specification_" + productId);
            if (StringUtils.isNotBlank(productSpecificationJsonStr)) {
                product.put("productSpecification", JSON.parseObject(productSpecificationJsonStr));
            }
            redisTemplate.opsForValue().set("dim_" + productKey, product.toJSONString());
        }
    }

    private void processProductDimDataChangeMessageBatch(DimEvent event) {
        System.out.println("商品聚合：" + event);
        Long productId = event.getId();
        String productKey = "product_" + productId;
        String productPropertyKey = "product_property_" + productId;
        String productSpecificationKey = "product_specification_" + productId;
        List<String> items = redisTemplate.opsForValue().multiGet(Arrays.asList(productKey, productPropertyKey, productSpecificationKey));

        String productJsonStr = items.get(0);
        if (StringUtils.isBlank(productJsonStr)) {
            // 主商品数据都没有的话，就直接删除这个聚合数据
            redisTemplate.delete(productKey);
        } else {
            JSONObject product = JSON.parseObject(productJsonStr);
            String productPropertyJsonStr = items.get(1);
            if (StringUtils.isNotBlank(productPropertyJsonStr)) {
                product.put("productProperty", JSON.parseObject(productPropertyJsonStr));
            }
            String productSpecificationJsonStr = items.get(2);
            if (StringUtils.isNotBlank(productSpecificationJsonStr)) {
                product.put("productSpecification", JSON.parseObject(productSpecificationJsonStr));
            }
            redisTemplate.opsForValue().set("dim_" + productKey, product.toJSONString());
        }
    }

    private void processProductIntroDimDataChangeMessage(DimEvent event) {
        String key = "product_intro" + event.getId();
        String jsonStr = redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(jsonStr)) {
            redisTemplate.delete(key);
        } else {
            redisTemplate.opsForValue().set("product_intro" + key, jsonStr);
        }
    }

}  