package cn.mrcode.cache.eshop.datasyncserver.rabbitmq;

/**
 * 维度事件
 *
 * @author : zhuqiang
 * @date : 2019/9/1 22:39
 */
public class DimEvent {
    private String dimType;
    private Long id;

    public DimEvent(String dimType, Long id) {
        this.dimType = dimType;
        this.id = id;
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
