package cn.mrcode.cache.eshop.dataaggrserver.rabbitmq;

/**
 * 维度事件
 *
 * @author : zhuqiang
 * @date : 2019/9/1 22:39
 */
public class DimEvent {
    private String dimType;
    private Long id;


    public DimEvent() {
    }

    public String getDimType() {
        return dimType;
    }

    public void setDimType(String dimType) {
        this.dimType = dimType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
