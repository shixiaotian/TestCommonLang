package bean;

/**
 *
 * cat bean
 *
 * Created by shixiaotian on 16/3/23.
 */
public class Cat {

    // 构造方法
    public Cat(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // 主键
    private Long id;

    // 名字
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
